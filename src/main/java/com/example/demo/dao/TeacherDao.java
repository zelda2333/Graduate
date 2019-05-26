package com.example.demo.dao;

import com.example.demo.entity.Teacher;

public interface TeacherDao {
	//给老师分配班级，插入teacher表
	int insertTeachClass(Teacher teacher);
	int deleteTeacher(int tId);
	//更新teachClass信息
	int addTeachClass(Teacher teacher);
	int deleteTeachClass(int tcId);
	
}
