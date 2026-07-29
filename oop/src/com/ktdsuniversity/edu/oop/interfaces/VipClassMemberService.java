package com.ktdsuniversity.edu.oop.interfaces;

/**
 * VipMemberService 인터페이스를 구현한 클래스
 */
public class VipClassMemberService extends NormalMemberService implements VipMemberService {
	
	@Override
	public void addPoint(int point) {
		System.out.println(point + " 포인트 적립");
	}
}
