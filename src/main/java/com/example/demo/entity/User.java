package com.example.demo.entity;



public class User {
	//主键id
	private Integer uId;
	//用户名
	private String uName;
	//密码
	private String password;
	private Integer authorId;
	
	private Authority authority;

	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", password=" + password + ", authorId=" + authorId
				+ ", authority=" + authority + "]";
	}
	
}
