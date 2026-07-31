package com.ktdsuniversity.edu.oop.file;

import java.io.File;
import java.util.Date;

public class FileMetaData {
	
	public static void main(String[] args) {
		
		File file = new File("C:/Java Exam", "Java Exam.txt");
		System.out.println(file.exists()); // 파일이 존재하는지 여부 확인
		System.out.println(file.isFile()); // 파일 객체인지 확인
		System.out.println(file.isDirectory()); // 폴더 객체인지 확인
		System.out.println(file.getAbsolutePath()); // 파일의 절대경로 확인
		System.out.println(file.getName()); // 파일의 이름 확인
		System.out.println(file.length()); // 파일의 크기(byte) 확인
		System.out.println(file.lastModified()); // 파일이 마지막으로 수정된 시간
		Date date = new Date(file.lastModified());
		System.out.println(date);
		System.out.println(file.getParent()); // 파일이 존재하는 경로
		// 객체가 폴더일 경우, 폴더내에 존재하는 모든 항목의 목록
		System.out.println(file.listFiles()); 

	}
}
