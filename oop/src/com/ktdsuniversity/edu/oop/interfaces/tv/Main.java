package com.ktdsuniversity.edu.oop.interfaces.tv;

public class Main {
	
	public static void main(String[] args) {
		TV smartTV = new SmartTV();
		
		Remote smartRemote = new SmartRemote();
		smartRemote.turnOn(smartTV);
		smartRemote.turnOff(smartTV);
		smartRemote.turnOn(smartTV);
		smartRemote.mute(smartTV);
		smartRemote.increaseVolume(smartTV);
		smartRemote.increaseVolume(smartTV);
		smartRemote.increaseVolume(smartTV);
		smartRemote.increaseVolume(smartTV);
		smartRemote.increaseVolume(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.changeInputSource(smartTV);
		smartRemote.inputChannelNumber(smartTV, 13);
	}
}

