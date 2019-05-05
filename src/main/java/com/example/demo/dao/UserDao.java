package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;

public interface UserDao {
	List<UserAndAuthor> ListUserAndAuthor();
	
	User login(String uname,String password);
	 List<User> findByUsername(String uname);
	int userIsExist(String uname);
	List<User> ListUser();
	User ListUserById(int uId);
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(int uId);
}
