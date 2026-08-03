package com.ktdsuniversity.edu.board.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.board.data.Article;
import com.ktdsuniversity.edu.board.data.Comment;

/**
 * FileIo 인터페이스를 구현한 클래스
 */
public class DefaultFileIo implements FileIO {
	
	private static final String FILE_PATH = "C:/board_data";
	private static final String FILE_NAME = "board_data.txt";
	
	@Override
	public List<Article> loadData() {
		
		File file = new File(FILE_PATH, FILE_NAME);
		
		List<Article> load = new ArrayList<>();
		
		if (file.exists() && file.isFile()) {
			
			List<String> data = null;
			
			try {
				data = Files.readAllLines(file.toPath());	
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			for (String s : data) {
				
				// 댓글이 있는 게시글
				if (s.contains("@")) {
					String[] datas = s.split("@");
					
					String[] artString = datas[0].split(",");

					// 게시글 데이터 불러오기
					Article art = new Article(artString[0], artString[1], artString[2],Integer.parseInt(artString[3]),artString[4]);
					
					// 댓글 추가하기
					for (int i = 1; i < datas.length; i++) {
						String[] comString = datas[i].split(",");
						art.addComment(new Comment(comString[0], comString[1], comString[2], Integer.parseInt(comString[3])));
					}
					load.add(art);
				}
				// 댓글이 없는 게시글
				else {
					String[] art = s.split(",");
					load.add(new Article(art[0], art[1], art[2], Integer.parseInt(art[3]), art[4]));
				}
			}
		}
		
		return load; 
	}
	
	@Override
	public void saveData(List<Article> board) {
		
		File file = new File(FILE_PATH, FILE_NAME);
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		List<String> data = new ArrayList<>();
		
		for (Article art : board) {
			data.add(art.toSaveString());
		}
		
		try {
			Files.write(file.toPath(), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
