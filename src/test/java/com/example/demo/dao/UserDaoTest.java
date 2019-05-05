package com.example.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	
	public void TestListUser() {
		List<User> userlist=userDao.ListUser();
		System.out.println(userlist.toString()+"123");
		assertNotNull(userlist);
	}
	@Test
	@Ignore
	public void ListUserById() {
		User user = userDao.ListUserById(4);
		assertEquals("157977",user.getPassword());
	}
	@Test
	@Ignore
	public void addUser() {
		User user = new User();
		user.setuName("zeldaT");
		user.setPassword("157977");
		user.setAuthorId(1);
		int effectedNum = userDao.addUser(user);
		assertEquals(1,effectedNum);
	}
	@Test
	@Ignore
	public void updateUser() {
		
		User user = new User();
		user.setuName("hi1");
		user.setuId(3);
		
		int effectedNum = userDao.updateUser(user);
		assertEquals(1,effectedNum);
	}
	@Test
	@Ignore
	public void deleteUser() {
		int effectedNum = userDao.deleteUser(4);
		assertEquals(1,effectedNum);
	}
}






















