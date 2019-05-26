package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.entity.UserAndTeacher;
import com.example.demo.entity.UserAndTeacherAndClassroom;

public interface UserDao {
	List<UserAndAuthor> ListUserAndAuthor();
	
	//查询权限为老师用户信息
	List<User> findByAuthorId(int authorId);
	
	//查询老师们负责的班级
	List<UserAndTeacherAndClassroom> ListTeacherAndClass();
	
	//查看某老师负责的某级
	UserAndTeacherAndClassroom FindTeachClassBytcId(int tcId);
	
	//查询老师的姓名
	List<UserAndTeacher> ListTeacherName();
	
	User login(String uname,String password);
	User findByUsername(String uname);
	List<User> userList();
	//int existsByUserName(String uname);
	
	User ListUserById(int uId);
	int addUser(User user);
	//修改密码
	int updateUser(User user);
	int deleteUser(int uId);
}
