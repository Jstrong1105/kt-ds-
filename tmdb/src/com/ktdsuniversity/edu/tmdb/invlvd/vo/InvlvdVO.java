package com.ktdsuniversity.edu.tmdb.invlvd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.appr.vo.ApprVO;
import com.ktdsuniversity.edu.tmdb.flmmkr.vo.FlmmkrVO;

public class InvlvdVO {
	
	/** 참여자 아이디 */
	private String invlvdId;
	
	/** 참여자 프로필 URL */
	private String invlvdPrflUrl;
	
	/** 이름 */
	private String nm;

	// 참여자 한 명이 여러 개의 영화를 제작했다.
	private List<FlmmkrVO> flmmkrList;
	
	// 참여자 한 명이 여러 개의 영화에 출연했다.
	private List<ApprVO> apprList;
	
	public String getInvlvdId() {
		return this.invlvdId;
	}

	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}

	public String getInvlvdPrflUrl() {
		return this.invlvdPrflUrl;
	}

	public void setInvlvdPrflUrl(String invlvdPrflUrl) {
		this.invlvdPrflUrl = invlvdPrflUrl;
	}

	public String getNm() {
		return this.nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}
	
	public List<FlmmkrVO> getFlmmkrList() {
		return this.flmmkrList;
	}

	public void setFlmmkrList(List<FlmmkrVO> flmmkrList) {
		this.flmmkrList = flmmkrList;
	}

	public List<ApprVO> getApprList() {
		return this.apprList;
	}

	public void setApprList(List<ApprVO> apprList) {
		this.apprList = apprList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invlvd [invlvdId=");
		builder.append(invlvdId);
		builder.append(", invlvdPrflUrl=");
		builder.append(invlvdPrflUrl);
		builder.append(", nm=");
		builder.append(nm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
