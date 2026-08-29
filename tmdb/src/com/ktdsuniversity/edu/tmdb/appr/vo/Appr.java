package com.ktdsuniversity.edu.tmdb.appr.vo;

public class Appr {
	
	/** 출연 아이디 */
	private String apprId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 참여자 아이디 */
	private String invlvdId;
	
	/** 배역 */
	private String rl;

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
