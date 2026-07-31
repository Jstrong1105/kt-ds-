package com.ktdsuniversity.edu.oop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class NIOReadTest {
	
	public static void main(String[] args) {
		
		File file = new File("C:/Java Exam", "Java Exam.txt");
		
		// 파일을 읽어서 출력한다.
		if (file.exists() && file.isFile()) {
			
			List<String> lines = null;
			
			// 파일을 읽어서 List 에 저장해라.
			try {
				lines = Files.readAllLines(file.toPath());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			if (lines != null) {
				for (String s: lines) {
					System.out.println(s);
				}
			}
		}
	}
}
