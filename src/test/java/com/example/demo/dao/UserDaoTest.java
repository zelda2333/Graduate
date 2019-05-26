package com.example.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Classroom;
import com.example.demo.entity.StudentInfoAndRepos;
import com.example.demo.entity.TeacherAndClassroom;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.entity.UserAndTeacherAndClassroom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	/*
	@Test
	@Ignore
	public void TestListUser() {
		List<User> userlist=userDao.ListUser();
		System.out.println(userlist.toString()+"123");
		assertNotNull(userlist);
	}*/
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
	
	@Test
	@Ignore
	public void existsByUserName() {
		
		User effectedNum = userDao.findByUsername("123");
		//assertEquals(1,effectedNum);
	}
	
	
	@Test
	public void ListTeacherAndClass() {
		List<UserAndTeacherAndClassroom> listTeacherAndClass = userDao.ListTeacherAndClass();
		for(UserAndTeacherAndClassroom teacher:listTeacherAndClass){
//			model.addAttribute("stusinfo",stuinfo);
			System.out.println(teacher);
			
			List<Classroom> classroom = teacher.getTeacherandclassroom().getClassroom();
			for(Classroom className:classroom){
				System.out.println(className);
			}
			
		}
		
		
		System.out.println(listTeacherAndClass);
	}
	
	
	
}






















