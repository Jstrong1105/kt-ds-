package com.ktdsuniversity.edu.oop.interfaces;

/**
 * MemberService 인터페이스를 구현한 클래스
 */
public class NormalMemberService implements MemberService {

	@Override
	public void join() {
		System.out.println("회원가입 기능 실행");
	}

	@Override
	public void login() {
		System.out.println("로그인 기능 실행");
	}

	@Override
	public void deleteMe() {
		System.out.println("회원탈퇴 기능 실행");
	}

	@Override
	public void logout() {
		System.out.println("로그아웃 기능 수행");
	}
}
