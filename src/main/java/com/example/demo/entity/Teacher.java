package com.example.demo.entity;

import java.util.List;

//老师负责班级表
public class Teacher {
	//id
	private Integer tcId;
	//老师id，即u_id
	private Integer tId;
	
	//责任班级id
	private Integer cId;
	private List<Classroom> classroom;
	
	public List<Classroom> getClassroom() {
		return classroom;
	}
	public void setClassroom(List<Classroom> classroom) {
		this.classroom = classroom;
	}
	public Integer getTcId() {
		return tcId;
	}
	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	@Override
	public String toString() {
		return "Teacher [tcId=" + tcId + ", tId=" + tId + ", cId=" + cId + ", classroom=" + classroom + "]";
	}

	
}
