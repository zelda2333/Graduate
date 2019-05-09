package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;

public interface UserDao {
	List<UserAndAuthor> ListUserAndAuthor();
	
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
