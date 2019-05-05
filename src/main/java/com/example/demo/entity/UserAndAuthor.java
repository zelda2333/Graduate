package com.example.demo.entity;

import java.util.List;

public class UserAndAuthor {
	
	private Integer authorId;
	private String authorType;
//	private Integer uId;
//	private String uName;
//	private String password;
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthorType() {
		return authorType;
	}
	public void setAuthorType(String authorType) {
		this.authorType = authorType;
	}
	/*public Integer getuId() {
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
	@Override
	public String toString() {
		return "UserAndAuthor [authorId=" + authorId + ", authorType=" + authorType + ", uId=" + uId + ", uName="
				+ uName + ", password=" + password + "]";
	}*/
	@Override
	public String toString() {
		return "UserAndAuthor [authorId=" + authorId + ", authorType=" + authorType + ", users=" + users + "]";
	}
	

}

