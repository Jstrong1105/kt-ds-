package com.ktdsuniversity.edu.oop.interfaces;

/**
 * ArticleService 와 ReplyService 두 개의 인터페이스를 구현한 클래스
 * 
 * ArticleSystem is a ArticleService, ReplyService
 */
public class ArticleSystem implements ArticleService, ReplyService {

	@Override
	public void addReply() {
		System.out.println("addReply");
	}

	@Override
	public void recommendReply() {
		System.out.println("recommendReply");
	}

	@Override
	public void deleteReply() {
		System.out.println("deleteReply");
	}

	@Override
	public void write() {
		System.out.println("write");
	}

	@Override
	public void view() {
		System.out.println("view");
	}

	@Override
	public void delete() {
		System.out.println("delete");
	}
	
}
