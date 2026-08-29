package com.ktdsuniversity.edu.tmdb.mv.vo;

public class MV {

	/** 영화 아이디 */
	private String mvId;
	
	/** 제목 */
	private String ttl;
	
	/** 심의 등급 */
	private String mvRtng;
	
	/** 러닝 타임 (단위: 분) */
	private int rnngTm;
	
	/** 개봉일 */
	private String rlsDt;
	
	/** 개요 */
	private String smmr;
	
	/** 메인 포스터 URL */
	private String mainPstlUrl;
	
	/** 페이스북 URL */
	private String fbUrl;
	
	/** X URL */
	private String xUrl;
	
	/** 인스타 URL */
	private String instaUrl;
	
	/** 한 줄 소개 */
	private String tgln;
	
	/** 원제 */
	private String orgnlTtl;
	
	/** 상태 */
	private String plyng;
	
	/** 원어 */
	private String orgnlLngg;
	
	/** 제작비 */
	private String bdgt;
	
	/** 수익 */
	private String bxOffcRvn;

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getTtl() {
		return this.ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getMvRtng() {
		return this.mvRtng;
	}

	public void setMvRtng(String mvRtng) {
		this.mvRtng = mvRtng;
	}

	public int getRnngTm() {
		return this.rnngTm;
	}

	public void setRnngTm(int rnngTm) {
		this.rnngTm = rnngTm;
	}

	public String getRlsDt() {
		return this.rlsDt;
	}

	public void setRlsDt(String rlsDt) {
		this.rlsDt = rlsDt;
	}

	public String getSmmr() {
		return this.smmr;
	}

	public void setSmmr(String smmr) {
		this.smmr = smmr;
	}

	public String getMainPstlUrl() {
		return this.mainPstlUrl;
	}

	public void setMainPstlUrl(String mainPstlUrl) {
		this.mainPstlUrl = mainPstlUrl;
	}

	public String getFbUrl() {
		return this.fbUrl;
	}

	public void setFbUrl(String fbUrl) {
		this.fbUrl = fbUrl;
	}

	public String getxUrl() {
		return this.xUrl;
	}

	public void setxUrl(String xUrl) {
		this.xUrl = xUrl;
	}

	public String getInstaUrl() {
		return this.instaUrl;
	}

	public void setInstaUrl(String instaUrl) {
		this.instaUrl = instaUrl;
	}

	public String getTgln() {
		return this.tgln;
	}

	public void setTgln(String tgln) {
		this.tgln = tgln;
	}

	public String getOrgnlTtl() {
		return this.orgnlTtl;
	}

	public void setOrgnlTtl(String orgnlTtl) {
		this.orgnlTtl = orgnlTtl;
	}

	public String getPlyng() {
		return this.plyng;
	}

	public void setPlyng(String plyng) {
		this.plyng = plyng;
	}

	public String getOrgnlLngg() {
		return this.orgnlLngg;
	}

	public void setOrgnlLngg(String orgnlLngg) {
		this.orgnlLngg = orgnlLngg;
	}

	public String getBdgt() {
		return this.bdgt;
	}

	public void setBdgt(String bdgt) {
		this.bdgt = bdgt;
	}

	public String getBxOffcRvn() {
		return this.bxOffcRvn;
	}

	public void setBxOffcRvn(String bxOffcRvn) {
		this.bxOffcRvn = bxOffcRvn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MV [mvId=");
		builder.append(mvId);
		builder.append(", ttl=");
		builder.append(ttl);
		builder.append(", mvRtng=");
		builder.append(mvRtng);
		builder.append(", rnngTm=");
		builder.append(rnngTm);
		builder.append(", rlsDt=");
		builder.append(rlsDt);
		builder.append(", smmr=");
		builder.append(smmr);
		builder.append(", mainPstlUrl=");
		builder.append(mainPstlUrl);
		builder.append(", fbUrl=");
		builder.append(fbUrl);
		builder.append(", xUrl=");
		builder.append(xUrl);
		builder.append(", instaUrl=");
		builder.append(instaUrl);
		builder.append(", tgln=");
		builder.append(tgln);
		builder.append(", orgnlTtl=");
		builder.append(orgnlTtl);
		builder.append(", plyng=");
		builder.append(plyng);
		builder.append(", orgnlLngg=");
		builder.append(orgnlLngg);
		builder.append(", bdgt=");
		builder.append(bdgt);
		builder.append(", bxOffcRvn=");
		builder.append(bxOffcRvn);
		builder.append("]");
		return builder.toString();
	}
}
