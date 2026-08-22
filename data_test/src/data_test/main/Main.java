package data_test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args)
	{
		Cell[][] board = new Cell[10][10];
		
		Random rd = new Random();
		
		int mineCount = 10; // 지뢰 배치 비율
		
		List<Long> data = new ArrayList<Long>();
		
		List<Integer> order;
		
		for(int k = 0; k < 100000; k++)
		{
			// 보드판 초기화
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					board[i][j] = new Cell();
				}
			}
			
			long startTime = System.nanoTime();
			
			// 랜덤 선택 방식 
			for(int i = 0; i < mineCount; i++) {
				while(true) { 
					int x = rd.nextInt(10);
					int y = rd.nextInt(10);
					  
					if(!board[x][y].getMine()) {
						board[x][y].setMine(true); 
						break; 
						} 
					} 
				}
			
			/*
			order = new ArrayList<>();
			
			for(int j = 0; j < 100; j++)
			{
				order.add(j);
			}
			
			Collections.shuffle(order);
			
			// 리스트 뽑기 방식
			order.stream()
			     .limit(mineCount)
			     .forEach(num -> board[num/10][num%10]
			     .setMine(true));
			*/
			
			long endTime = System.nanoTime();
			
			long time = endTime - startTime;
			
			data.add(time);
		}
		
		double min = data.stream()
						 .mapToLong(Long::longValue)
						 .min()
						 .orElseThrow();
		
		double max = data.stream()
				 .mapToLong(Long::longValue)
				 .max()
				 .orElseThrow();
		
		double avg = data.stream()
		                 .mapToLong(Long::longValue)
		                 .average()
		                 .orElseThrow();
		
		System.out.println("최소 소요 시간 : " + min);
		System.out.println("최대 소요 시간 : " + max);
		System.out.println("평균 소요 시간 : " + avg);
	}
}
