package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.example.demo.dao.TeacherDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.service.UserService;

@Controller
public class TeacherController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TeacherDao teacherDao;
	
	@RequestMapping(value = "/teachermanage", method = RequestMethod.GET)
	private Model listTeacher(Model model) {
		// 获取已注册的用户列表
		
		List<User> teacher = userDao.findByAuthorId(1);
		model.addAttribute("usersinfo",teacher);
		return model;
	}
	
	//添加老师
		@RequestMapping(value = "/postteacher" , method = RequestMethod.POST)
	    public Model addTeacher(User user, Model model){
			
			User user1=userDao.findByUsername(user.getuName());		
	        if(StringUtils.isEmpty(user.getuName()) || StringUtils.isEmpty(user.getPassword())){
	           model.addAttribute("msg1", "用户名称或密码不能为空，请重新填写");
	            //return "register";
	            return model;
	        }else if(user1!=null){
	        	if(user1!=null){
	        		model.addAttribute("msg1","用户名已经存在,请试试别的!");
	                return model;
	            }
	        }else{
	        	userDao.addUser(user);
	        	//System.out.print(user.getuId());
	        	
	        	
	        	
	            model.addAttribute("msg1","添加成功");
	            return model;
	           // return "index";
	        }
			return model;
	    }
	
	
	// 删除老师
	@GetMapping(value = "/deleteteacher/{id}")
	private String deleteTeacher(@PathVariable("id") Integer uId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		if(userDao.deleteUser(uId)==1 && teacherDao.deleteTeacher(uId)==1){
		modelMap.put("msg", "删除成功");}
		//modelMap.put("success", userDao.deleteUser(uId));
		return "redirect:/teachermanage";
	}
	
	//超级管理员修改自己的密码
	@RequestMapping(value = "/upsuper/{uname}",method={RequestMethod.GET})
	 public String ListSuperUserByuName(@PathVariable("uname") String uname, Model model){
		User usernow = userDao.findByUsername(uname);
		 model.addAttribute("usernow",usernow);
		 System.out.println("usernow: " + usernow);
		 return "upsuper";
		//return model;
	 }

	@RequestMapping(value="/updatesuper",method={RequestMethod.PUT})
	public String updateSuper(User user,Model model){
		//根据u_id，修改密码
		if( userDao.updateUser(user)==1){

			model.addAttribute("msg", "修改密码成功，请重新登录");
		}
		return "index";
	}	
	
	//显示当前老师，在页面回显
	
		@RequestMapping(value = "/upteacher/{uname}",method={RequestMethod.GET})
			 public String ListAdminByuName(@PathVariable("uname") String uname, Model model){
				User usernow = userDao.findByUsername(uname);
				 model.addAttribute("usernow",usernow);
				 System.out.println("usernow: " + usernow);
				 return "upteacher";
				//return model;
			 }
			
		@RequestMapping(value="/updateteacher",method={RequestMethod.PUT})
		    public String updateTeacher(User user,Model model){
			//根据u_id，修改密码老师
			
			if( userDao.updateUser(user)==1){
			
			model.addAttribute("msg", "修改密码成功");
			}
			 return "redirect:/teachermanage";
		    }	
	
	
}
