package com.ktdsuniversity.edu.tmdb.bckgrnd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class BckgrndVO {
	
	/** 배경 아이디 */
	private String bckdgndId;
	
	/** 영화 아아디 */
	private String mvId;
	
	/** 배경 URL */
	private String bckgrndUrl;

	// 하나의 배경은 하나의 영화를 위한 것이다.
	private MvVO mvVO;
	
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

	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
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
