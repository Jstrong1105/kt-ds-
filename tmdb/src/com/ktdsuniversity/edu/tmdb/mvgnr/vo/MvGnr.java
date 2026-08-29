package com.ktdsuniversity.edu.tmdb.mvgnr.vo;

public class MvGnr {
	
	/** 영화 장르 아이디 */
	private String mvGnrId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 장르 아이디 */
	private String gnrId;

	public String getMvGnrId() {
		return this.mvGnrId;
	}

	public void setMvGnrId(String mvGnrId) {
		this.mvGnrId = mvGnrId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getGnrId() {
		return this.gnrId;
	}

	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MvGnr [mvGnrId=");
		builder.append(mvGnrId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", gnrId=");
		builder.append(gnrId);
		builder.append("]");
		return builder.toString();
	}
}
