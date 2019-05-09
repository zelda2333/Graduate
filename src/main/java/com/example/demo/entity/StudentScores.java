package com.example.demo.entity;

public class StudentScores {
	//成绩id
	private Integer scoreId;
	//学生id
	private Integer sId;
	
	//成绩
	private String score;
	
	private String number;
	//一对一 学生信息
	private StudentInfo stuInfo;
	
	public Integer getScoreId() {
		return scoreId;
	}
	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public StudentInfo getStuInfo() {
		return stuInfo;
	}
	public void setStuInfo(StudentInfo stuInfo) {
		this.stuInfo = stuInfo;
	}
	@Override
	public String toString() {
		return "StudentScores [scoreId=" + scoreId + ", sId=" + sId + ", score=" + score + ", number=" + number
				+ ", stuInfo=" + stuInfo + "]";
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
