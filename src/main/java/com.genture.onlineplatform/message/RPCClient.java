package com.genture.onlineplatform.message;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.connection.ConnectionSpecConnectionFactoryAdapter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2018/7/23.
 */
@Component
public class RPCClient {

	@Autowired
	private ConnectionFactory factory;

	public String call(String message, String queueName){

		try {
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			String replyQueueName = channel.queueDeclare().getQueue();

			String corrId = UUID.randomUUID().toString();
			AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName)
					.build();
			channel.basicPublish("", queueName, props, message.getBytes("UTF-8"));

			BlockingQueue<String> response = new ArrayBlockingQueue<String>(10);
			channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel){
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties props, byte[] body){
					if(props.getCorrelationId().equals(corrId)){
						try {
							response.offer(new String(body, "UTF-8"));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
			});
			return response.take();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		return "";
	}
}
