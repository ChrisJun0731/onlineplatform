package com.genture.onlineplatform.params.info;

/**
 * Created by Administrator on 2018/7/17.
 */
public class VmsState {

	private String date;
	private int doorState;
	private int power;
	private int mark;
	private int tempSymbol;
	private int temper;
	private int brightness;
	private int brightControl;
	private int brightLevel;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDoorState() {
		return doorState;
	}

	public void setDoorState(int doorState) {
		this.doorState = doorState;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getTempSymbol() {
		return tempSymbol;
	}

	public void setTempSymbol(int tempSymbol) {
		this.tempSymbol = tempSymbol;
	}

	public int getTemper() {
		return temper;
	}

	public void setTemper(int temper) {
		this.temper = temper;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public int getBrightControl() {
		return brightControl;
	}

	public void setBrightControl(int brightControl) {
		this.brightControl = brightControl;
	}

	public int getBrightLevel() {
		return brightLevel;
	}

	public void setBrightLevel(int brightLevel) {
		this.brightLevel = brightLevel;
	}
}
