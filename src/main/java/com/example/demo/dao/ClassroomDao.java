package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Classroom;
import com.example.demo.entity.User;

public interface ClassroomDao {
	//查看班级
	List<Classroom> classRoomList();
	//添加班级
	int addClass(Classroom aclass);
	//修改班级信息
	int updateClass(Classroom aclass);
	int deleteClass(int cId);
	Classroom findByClassname(String cname);

}
