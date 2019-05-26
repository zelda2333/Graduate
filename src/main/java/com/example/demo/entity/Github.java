package com.example.demo.entity;

public class Github {
	private Integer gId;
	private Integer tId;
	
	private String gUname;
	private String gPassword;
	public Integer getgId() {
		return gId;
	}
	public void setgId(Integer gId) {
		this.gId = gId;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getgUname() {
		return gUname;
	}
	public void setgUname(String gUname) {
		this.gUname = gUname;
	}
	public String getgPassword() {
		return gPassword;
	}
	public void setgPassword(String gPassword) {
		this.gPassword = gPassword;
	}
	@Override
	public String toString() {
		return "Github [gId=" + gId + ", tId=" + tId + ", gUname=" + gUname + ", gPassword=" + gPassword + "]";
	}
	
}
