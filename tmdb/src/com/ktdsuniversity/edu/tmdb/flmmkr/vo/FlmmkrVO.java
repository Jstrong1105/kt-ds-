package com.ktdsuniversity.edu.tmdb.flmmkr.vo;

import com.ktdsuniversity.edu.tmdb.invlvd.vo.InvlvdVO;
import com.ktdsuniversity.edu.tmdb.mv.vo.MvVO;

public class FlmmkrVO {
	
	/** 제작 아이디 */
	private String flmmkrId;
	
	/** 영화 아이디 */
	private String mvId;
	
	/** 참여자 아이디 */
	private String invlvdId;
	
	/** 역할 */
	private String rl;
	
	/** 파트 */
	private String prt;

	// 한명의 참여자가 하나의 영화를 제작했다.
	private MvVO mvVO;
	
	// 제작자 한명에 대한 참여자 정보
	private InvlvdVO invlvdVO;
	
	public String getFlmmkrId() {
		return this.flmmkrId;
	}

	public void setFlmmkrId(String flmmkrId) {
		this.flmmkrId = flmmkrId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getInvlvdId() {
		return this.invlvdId;
	}

	public void setInvlvdId(String invlvdId) {
		this.invlvdId = invlvdId;
	}

	public String getRl() {
		return this.rl;
	}

	public void setRl(String rl) {
		this.rl = rl;
	}

	public String getPrt() {
		return this.prt;
	}

	public void setPrt(String prt) {
		this.prt = prt;
	}
	
	public MvVO getMvVO() {
		return this.mvVO;
	}

	public void setMvVO(MvVO mvVO) {
		this.mvVO = mvVO;
	}

	public InvlvdVO getInvlvdVO() {
		return this.invlvdVO;
	}

	public void setInvlvdVO(InvlvdVO invlvdVO) {
		this.invlvdVO = invlvdVO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flmmkr [flmmkrId=");
		builder.append(flmmkrId);
		builder.append(", mvId=");
		builder.append(mvId);
		builder.append(", invlvdId=");
		builder.append(invlvdId);
		builder.append(", rl=");
		builder.append(rl);
		builder.append(", prt=");
		builder.append(prt);
		builder.append("]");
		return builder.toString();
	}
	
	
}
