package com.ktdsuniversity.edu.oop.interfaces;

public class Main {
	
	public static void main(String[] args) {
		
		ArticleService articleService = new ArticleSystem();
		articleService.write();
		articleService.view();
		articleService.delete();
		
		ReplyService replyService = new ArticleSystem();
		replyService.addReply();
		replyService.recommendReply();
		replyService.deleteReply();
		
		// MemberService, VipMemberService 인스턴스 생성
		// VipMemberService is a MemberService
		MemberService ms = new NormalMemberService();
		VipMemberService vms = new VipClassMemberService(); 
		
		// SomeInterface 의 인스턴스 생성
		// SomeInterface inf = new SomeInterface();
		// Interface 는 인스턴스로 생성할 수 없다.
		// Java 의 인스턴스는 모든 메소드가 구현이 되어 있어야 한다.
		SomeInterface inf = new SomeClass();
		inf.doSomething1();
		inf.doSomething2();
		inf.doSomething3();
		int value = inf.getSomething();
		System.out.println(value);
		String str = inf.getString();
		System.out.println(str);
		
		inf = new SomeClass2();
		inf.doSomething1();
		inf.doSomething2();
		inf.doSomething3();
		value = inf.getSomething();
		System.out.println(value);
		str = inf.getString();
		System.out.println(str);
	}
}
