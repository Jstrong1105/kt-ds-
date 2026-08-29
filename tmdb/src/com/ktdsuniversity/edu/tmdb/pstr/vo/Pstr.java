package com.ktdsuniversity.edu.tmdb.pstr.vo;

public class Pstr {
	
	/** 포스터 아이디 */
	private String pstrId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 포스터 URL */
	private String pstrUrl;

	public String getPstrId() {
		return this.pstrId;
	}

	public void setPstrId(String pstrId) {
		this.pstrId = pstrId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getPstrUrl() {
		return this.pstrUrl;
	}

	public void setPstrUrl(String pstrUrl) {
		this.pstrUrl = pstrUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pstr [pstrId=");
		builder.append(pstrId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", pstrUrl=");
		builder.append(pstrUrl);
		builder.append("]");
		return builder.toString();
	}
	
	
}
