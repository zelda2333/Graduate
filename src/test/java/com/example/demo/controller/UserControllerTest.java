package com.example.demo.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	private UserDao userDao;
	@Test	
	public void TestListUser() {
		List<UserAndAuthor> list = userDao.ListUserAndAuthor();
		for(UserAndAuthor authinfo:list){
			System.out.println(authinfo);	
			for(User userinfo:authinfo.getUsers()){
			
				System.out.println(userinfo);	
			}
		}
	
	}
	
	
}
