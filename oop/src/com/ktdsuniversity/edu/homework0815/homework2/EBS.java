package com.ktdsuniversity.edu.homework0815.homework2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ktdsuniversity.edu.homework0815.TVShow;

public class EBS {
	
	private final List<TVShow> tvShows;
	
	public EBS() {
		this.tvShows = new ArrayList<>();
		this.tvShows.add(new TVShow("EBS1", LocalTime.of(0, 1), LocalTime.of(6, 0)));
		this.tvShows.add(new TVShow("EBS2", LocalTime.of(6, 1), LocalTime.of(12, 0)));
		this.tvShows.add(new TVShow("EBS3", LocalTime.of(12, 1), LocalTime.of(18, 0)));
		this.tvShows.add(new TVShow("EBS4", LocalTime.of(18, 1), LocalTime.of(0, 0)));
	}
	
	public Optional<String> getShow(LocalTime now) {
		
		return 
		this.tvShows.stream()
					.filter(r -> r.getStartTime().isBefore(now))
					.filter(r -> r.getEndTime().isAfter(now))
					.map(TVShow::getName)
					.findFirst()
					;
	}
}
