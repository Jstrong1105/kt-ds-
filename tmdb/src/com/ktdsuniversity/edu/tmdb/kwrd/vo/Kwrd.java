package com.ktdsuniversity.edu.tmdb.kwrd.vo;

public class Kwrd {
	
	/** 키워드 아이디 */
	private String kwrdId;
	
	/** 이름 */
	private String nm;

	public String getKwrdId() {
		return this.kwrdId;
	}

	public void setKwrdId(String kwrdId) {
		this.kwrdId = kwrdId;
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
		builder.append("Kwrd [kwrdId=");
		builder.append(kwrdId);
		builder.append(", nm=");
		builder.append(nm);
		builder.append("]");
		return builder.toString();
	}
}
