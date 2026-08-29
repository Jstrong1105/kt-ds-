package com.ktdsuniversity.edu.tmdb.mvkwrd.vo;

public class MvKwrd {
	
	/** 영화 키워드 아이디 */
	private String mvKwrdId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 이름 */
	private String nm;

	public String getMvKwrdId() {
		return this.mvKwrdId;
	}

	public void setMvKwrdId(String mvKwrdId) {
		this.mvKwrdId = mvKwrdId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
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
		builder.append("MvKwrd [mvKwrdId=");
		builder.append(mvKwrdId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", nm=");
		builder.append(nm);
		builder.append("]");
		return builder.toString();
	}
}
