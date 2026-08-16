package com.ktdsuniversity.edu.homework0815;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * 편성표 애플리케이션
 */
public class Homework1 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		List<TVShow> tvShows = new ArrayList<>();
		
		tvShows.add(new TVShow("프로그램1", LocalTime.of(3, 0), LocalTime.of(5, 0)));
		tvShows.add(new TVShow("프로그램2", LocalTime.of(5, 1), LocalTime.of(6, 30)));
		tvShows.add(new TVShow("프로그램3", LocalTime.of(6, 31), LocalTime.of(8, 0)));
		tvShows.add(new TVShow("프로그램4", LocalTime.of(8, 1), LocalTime.of(9, 0)));
		tvShows.add(new TVShow("프로그램5", LocalTime.of(9, 1), LocalTime.of(10, 0)));
		tvShows.add(new TVShow("프로그램6", LocalTime.of(10, 1), LocalTime.of(12, 0)));
		tvShows.add(new TVShow("프로그램7", LocalTime.of(12, 1), LocalTime.of(13, 30)));
		tvShows.add(new TVShow("프로그램8", LocalTime.of(13, 31), LocalTime.of(15, 0)));
		tvShows.add(new TVShow("프로그램9", LocalTime.of(15, 1), LocalTime.of(17, 0)));
		tvShows.add(new TVShow("프로그램10", LocalTime.of(17, 1), LocalTime.of(18, 0)));
		tvShows.add(new TVShow("프로그램11", LocalTime.of(18, 1), LocalTime.of(21, 0)));
		tvShows.add(new TVShow("프로그램12", LocalTime.of(21, 1), LocalTime.of(23, 0)));
		tvShows.add(new TVShow("프로그램13", LocalTime.of(23, 1), LocalTime.of(23, 59)));
		
		Optional<String> tvShow = getShow(tvShows, LocalTime.now());
		
		if (tvShow.isPresent()) {
			System.out.println(tvShow.get());
		} else {
			System.out.println("방영중인 시간이 아닙니다.");
		}
	}
	
	public static Optional<String> getShow(List<TVShow> tvShows ,LocalTime now) {
		
		return 
		tvShows.stream()
			   .filter(r -> r.getStartTime().isBefore(now))
			   .filter(r -> r.getEndTime().isAfter(now))
			   .map(TVShow::getName)
			   .findFirst()
			   ;
	}
}
