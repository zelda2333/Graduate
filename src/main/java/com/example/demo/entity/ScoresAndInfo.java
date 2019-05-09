package com.example.demo.entity;

public class ScoresAndInfo {

	//成绩id
	private Integer scoreId;
	//学生id
	private Integer sId;
	
	//成绩
	private String score;
	//提交的第几次成绩
	private String number;
	
	//一对一 学生信息
	private StudentInfo stuinfo;
	
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
	
	@Override
	public String toString() {
		return "ScoresAndInfo [scoreId=" + scoreId + ", sId=" + sId + ", score=" + score + ", number=" + number
				+ ", stuinfo=" + stuinfo + "]";
	}
	public StudentInfo getStuinfo() {
		return stuinfo;
	}
	public void setStuinfo(StudentInfo stuinfo) {
		this.stuinfo = stuinfo;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
