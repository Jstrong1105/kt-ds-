package com.ktdsuniversity.edu.homework0815;

import java.time.LocalTime;

/**
 * 하나의 TV 프로그램
 */
public class TVShow {
	
	/** 프로그램명 */
	private final String name;
	
	/** 시작시간 */
	private final LocalTime startTime;
	
	/** 종료시간 */
	private final LocalTime endTime;
	
	public TVShow(String name, LocalTime startTime, LocalTime endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
}
