package com.ktdsuniversity.edu.oop.interfaces.tv;

public interface Remote {

	void turnOn(TV tv);
	void turnOff(TV tv);
	
	void increaseVolume(TV tv);
	void decreaseVolume(TV tv);
	
	void increaseChannel(TV tv);
	void decreaseChannel(TV tv);
	
	void changeInputSource(TV tv);
	
	void runApps(TV tv);
	
	void runAI(TV tv);
	
	void controlShoppingButtons(TV tv);
	
	void inputChannelNumber(TV tv,int number);
	
	void mute(TV tv);
	
	void changeTvSettings(TV tv); 
}
