package com.example.demo.entity;

public class StudentInfo {
	//主键id
	private Integer sId;
	//学生姓名
	private String sName;
	//学号
	private String sNumber;
	
	private Repos repos;
	public Repos getRepos() {
		return repos;
	}
	public void setRepos(Repos repos) {
		this.repos = repos;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsNumber() {
		return sNumber;
	}
	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}
	@Override
	public String toString() {
		return "StudentInfo [sId=" + sId + ", sName=" + sName + ", sNumber=" + sNumber + ", repos=" + repos + "]";
	}
	
}
