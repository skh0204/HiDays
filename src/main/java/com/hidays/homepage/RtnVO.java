package com.hidays.homepage;

public class RtnVO {
	
	private String rtnCd;
	private String rtnMsg;
	
	public RtnVO(String rtnCd, String rtnMsg) {
		super();
		this.rtnCd = rtnCd;
		this.rtnMsg = rtnMsg;
	}
	
	public String getRtnCd() {
		return rtnCd;
	}
	public void setRtnCd(String rtnCd) {
		this.rtnCd = rtnCd;
	}
	public String getRtnMsg() {
		return rtnMsg;
	}
	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}
	
	public void setData(String rtnCd, String rtnMsg) {
		this.rtnCd = rtnCd;
		this.rtnMsg = rtnMsg;
	}

}
