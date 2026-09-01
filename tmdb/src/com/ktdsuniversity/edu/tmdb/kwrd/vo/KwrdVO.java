package com.ktdsuniversity.edu.tmdb.kwrd.vo;

import java.util.List;

import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class KwrdVO {
	
	/** 키워드 아이디 */
	private String kwrdId;
	
	/** 이름 */
	private String nm;

	// 하나의 키워드에는 여러 개의 영화가 있다.
	private List<MvVO> mvList; 
	
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

	public List<MvVO> getMvList() {
		return this.mvList;
	}

	public void setMvList(List<MvVO> mvList) {
		this.mvList = mvList;
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
