package com.genture.onlineplatform.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/30.
 */
@Configuration
public class RabbitMQConfig {

	@Bean
	public ConnectionFactory connectionFactory(@Value("${rabbitmq.connectionFactory.host}")String host,
											   @Value("${rabbitmq.connectionFactory.port}")int port,
											   @Value("${rabbitmq.connectionFactory.username}")String username,
											   @Value("${rabbitmq.connectionFactory.password}")String password){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		factory.setUsername(username);
		factory.setPassword(password);
		return factory;
	}
}
