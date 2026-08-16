package com.ktdsuniversity.edu.homework0815.homework2;

import java.time.LocalTime;
import java.util.Optional;

public class Homework2 {
	
	public static void main(String[] args) {
		
		SBS sbs = new SBS();
		KBS1 kbs1 = new KBS1();
		KBS2 kbs2 = new KBS2();
		MBC mbc = new MBC();
		EBS ebs = new EBS();
		TVN tvn = new TVN();
		
		printShow("SBS", sbs.getShow(LocalTime.now()));
		printShow("KBS1", kbs1.getShow(LocalTime.now()));
		printShow("KBS2", kbs2.getShow(LocalTime.now()));
		printShow("MBC", mbc.getShow(LocalTime.now()));
		printShow("EBS", ebs.getShow(LocalTime.now()));
		printShow("TVN", tvn.getShow(LocalTime.now()));
	}
	
	public static void printShow(String radio, Optional<String> str) {
		
		String show = "";
		
		if (str.isPresent()) {
			show = "\"" + str.get() + "\"" + "이(가) 방영중입니다.";
		} else {
			show = "방영 중인 시간이 아닙니다.";
		}
		
		System.out.println(radio + " " + show);
	}
}
