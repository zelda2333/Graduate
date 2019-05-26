package com.example.demo.entity;

import java.util.List;

public class Classroom {
	//班级Id
	private Integer cId;
	//班级名
	
	private String cName;

	private Teacher teacher;
	private List<StudentInfo> stuinfo;
	

	public List<StudentInfo> getStuinfo() {
		return stuinfo;
	}

	public void setStuinfo(List<StudentInfo> stuinfo) {
		this.stuinfo = stuinfo;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Classroom [cId=" + cId + ", cName=" + cName + ", teacher=" + teacher + ", stuinfo=" + stuinfo + "]";
	}
	
}
