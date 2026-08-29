package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

public class Bckgrnd {
	
	/** 배경 아이디 */
	private String bckdgndId;
	
	/** 영화 아아디 */
	private String mvId;
	
	/** 배경 URL */
	private String bckgrndUrl;

	public String getBckdgndId() {
		return this.bckdgndId;
	}

	public void setBckdgndId(String bckdgndId) {
		this.bckdgndId = bckdgndId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getBckgrndUrl() {
		return this.bckgrndUrl;
	}

	public void setBckgrndUrl(String bckgrndUrl) {
		this.bckgrndUrl = bckgrndUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bckgrnd [bckdgndId=");
		builder.append(bckdgndId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", bckgrndUrl=");
		builder.append(bckgrndUrl);
		builder.append("]");
		return builder.toString();
	}
	
	
}
