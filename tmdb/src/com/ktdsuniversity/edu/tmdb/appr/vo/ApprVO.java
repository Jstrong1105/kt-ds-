package com.ktdsuniversity.edu.tmdb.appr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class ApprVO {
	
	/** 출연 아이디 */
	private String apprId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 참여자 아이디 */
	private String invlvdId;
	
	/** 배역 */
	private String rl;

	// 출연자 한명이 하나의 영화에 출연했다.
	private MvVO mvVO;
	
	// 출연자의 정보
	private InvlvdVO invlvdVO;
	
	public String getApprId() {
		return this.apprId;
	}

	public void setApprId(String apprId) {
		this.apprId = apprId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getInvlvdId() {
		return this.invlvdId;
	}

	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}

	public String getRl() {
		return this.rl;
	}

	public void setRl(String rl) {
		this.rl = rl;
	}
	
	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	public InvlvdVO getInvlvdVO() {
		return this.invlvdVO;
	}

	public void setInvlvdVO(InvlvdVO invlvdVO) {
		this.invlvdVO = invlvdVO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Appr [apprId=");
		builder.append(apprId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", invlvdId=");
		builder.append(invlvdId);
		builder.append(", rl=");
		builder.append(rl);
		builder.append("]");
		return builder.toString();
	}
	
}
