package com.ktdsuniversity.edu.tmdb.invlvd.vo;

public class Invlvd {
	
	/** 참여자 아이디 */
	private String invlvdId;
	
	/** 참여자 프로필 URL */
	private String invlvdPrflUrl;
	
	/** 이름 */
	private String nm;

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
