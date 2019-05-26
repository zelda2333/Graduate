package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.StudentInfo;
import com.example.demo.entity.StudentInfoAndRepos;
import com.example.demo.entity.User;

public interface StudentInfoDao {
	List<StudentInfoAndRepos> ListStudentInfoAndRepos();
	StudentInfo findByStuId(int sId);
	//查出班里的学生信息
	List<StudentInfo> ListStuByClassroom(int cId);
}
