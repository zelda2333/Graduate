package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
@Service
public class UserService {
	 @Autowired
	    private UserDao userDao;

	    /**
	     * 添加注册新用户的信息
	     */
	    public void addUser(User user){
	        userDao.addUser(user);
	    }

	    /**
	     * 通过名字查询用户信息
	     */
	    public List<User> queryByName(String uname){
	        return userDao.findByUsername(uname);
	    }

	    /**
	     *管理员查询当前的所有用户
	     */
	    public List<User> ListUser(){
	        return userDao.ListUser();
	    }

	    /**
	     * 修改用户信息
	     */
	    public void updateUser(User user){
	        userDao.updateUser(user);
	    }

	    /**
	     * 管理员拥有删除普通用户的权限
	     */
	    public void deleteUser(int uid){
	        userDao.deleteUser(uid);
	    }
}
