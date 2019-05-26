package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.TeacherDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Classroom;
import com.example.demo.entity.StudentInfo;
import com.example.demo.entity.StudentInfoAndRepos;
import com.example.demo.entity.StudentScores;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.TeacherAndClassroom;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndTeacherAndClassroom;

@Controller
public class TeachClassController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private TeacherDao teacherDao;
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	private Model listTeachClass(Model model) {
		// 班级列表
		
		List<UserAndTeacherAndClassroom> list1 = userDao.ListTeacherAndClass();
		model.addAttribute("userinfo",list1);
		System.out.println(list1);
		for(UserAndTeacherAndClassroom userinfo:list1){
			
			TeacherAndClassroom teachClass = userinfo.getTeacherandclassroom();
			model.addAttribute("teachClass",teachClass);
			
			List<Classroom> classroom = teachClass.getClassroom();
			model.addAttribute("classroom",classroom);
			//List<String> list=new ArrayList<String>();
			for(Classroom classname:classroom){
				String cname = classname.getcName();
				model.addAttribute("cname",cname);
				//list.add(cname);
			}
			
			System.out.println(classroom);
		}
		
		return model;
	}
	
	// 删除老师负责的班级
		@GetMapping(value = "/deleteteacherclass/{id}")
		//@ResponseBody
		private String deleteUser(@PathVariable("id") Integer tcId) {
			Map<String, Object> modelMap = new HashMap<String, Object>();	
			
			if(teacherDao.deleteTeachClass(tcId)==1){
			modelMap.put("msg", "删除成功");}
			//modelMap.put("success", userDao.deleteUser(uId));
			return "redirect:/teacher";
		}
		
		//显示当前老师责任班级，在页面回显
		
		@RequestMapping(value = "/upteacherclass/{tcid}",method={RequestMethod.GET})
			 public String ListTeachClassBytcId(@PathVariable("tcid") int tcId, Model model){
			UserAndTeacherAndClassroom teachClass = userDao.FindTeachClassBytcId(tcId);	
			
				 model.addAttribute("classnow",teachClass);
				 System.out.println("classnow: " + teachClass);
				 return "upteachclass";
				//return model;
			 }
		
		@RequestMapping(value="/updateteachclass",method={RequestMethod.PUT})
	    public String updateClass(Teacher teacher,Model model){
		//根据c_id，修改班级名称
		if( teacherDao.addTeachClass(teacher)==1){
		
		model.addAttribute("msg", "修改责任班级成功");
		}
		 return "redirect:/teacher";
	    }	 		
		
		//跳转分配班级
		 @GetMapping(value = "/addteachclass")
		 public Model toAddTeachClassPage(Model model){
			
			 List<User> list = userDao.findByAuthorId(1);
				model.addAttribute("teacherinfo",list);
				
		        return model;
		 }
		 
		 //显示当前老师信息，在页面回显
		
		@RequestMapping(value = "/inserteachclass/{uId}",method={RequestMethod.GET})
		 public String ListStuBysId(@PathVariable("uId") int uId, Model model){
			 User user = userDao.ListUserById(uId);
			 
			 model.addAttribute("teacher",user);
		    return "inserteachclass";
			//return model;
		 }
		 
		
		@RequestMapping(value="/insertteachclass",method={RequestMethod.PUT})
		    public String addTeachClass(Teacher teacher,Model model){
			//根据u_id获取老师信息，分配班级
			if( teacherDao.insertTeachClass(teacher)==1){
			
			model.addAttribute("msg", "分配班级成功");
			}
			 return "redirect:/teacher";
		    }
		 
	
}
