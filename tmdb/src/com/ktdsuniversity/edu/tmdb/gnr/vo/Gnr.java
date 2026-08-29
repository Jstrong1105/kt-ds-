package com.ktdsuniversity.edu.tmdb.gnr.vo;

public class Gnr {
	
	/** 장르 아이디 */
	private String gnrId;
	
	/** 이름 */
	private String nm;

	public String getGnrId() {
		return this.gnrId;
	}

	public void setGnrId(String gnrId) {
		this.gnrId = gnrId;
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
		builder.append("Gnr [gnrId=");
		builder.append(gnrId);
		builder.append(", nm=");
		builder.append(nm);
		builder.append("]");
		return builder.toString();
	}
}
