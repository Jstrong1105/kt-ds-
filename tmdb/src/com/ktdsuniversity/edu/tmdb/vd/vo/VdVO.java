package com.ktdsuniversity.edu.tmdb.vd.vo;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class VdVO {
	
	/** 동영상 아이디 */
	private String vdId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 동영상 URL */
	private String vdUrl;

	// 하나의 영상은 하나의 영화를 위한 것이다.
	private MvVO mvVO;
	
	public String getVdId() {
		return this.vdId;
	}

	public void setVdId(String vdId) {
		this.vdId = vdId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getVdUrl() {
		return this.vdUrl;
	}

	public void setVdUrl(String vdUrl) {
		this.vdUrl = vdUrl;
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
		builder.append("Vd [vdId=");
		builder.append(vdId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", vdUrl=");
		builder.append(vdUrl);
		builder.append("]");
		return builder.toString();
	}
	
	
}
