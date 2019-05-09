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

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.service.UserService;

@Controller

public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/usermanage", method = RequestMethod.GET)
	private Model listUser(Model model) {
		// 获取已注册的用户列表
		
		List<UserAndAuthor> list = userDao.ListUserAndAuthor();
		
		for(UserAndAuthor authinfo:list){
			model.addAttribute("authorsinfo",authinfo);
			System.out.println(authinfo);
			List<User> users = authinfo.getUsers();
			model.addAttribute("usersinfo",users);
			
			for(User userinfo:users){
//				model.addAttribute("usersinfo",userinfo);
				System.out.println(userinfo);	
			}
		}
		
		return model;
	}
//添加管理员
	@RequestMapping(value = "/postuser" , method = RequestMethod.POST)
    public Model addUser(User user, Model model, HttpSession session){
		User users1 =userDao.findByUsername(user.getuName());
        if(StringUtils.isEmpty(user.getuName()) || StringUtils.isEmpty(user.getPassword())){
           model.addAttribute("msg1", "其他填充区域不能为空，请重新填写");
            //return "register";
            return model;
        }else if(users1!=null){
        	if(users1!=null){
        		model.addAttribute("msg1","用户名已经存在,请试试别的!");
                return model;
            }
        }else{
            session.setAttribute("uname", user.getuName());
            session.setAttribute("users", user);
            userService.addUser(user);
            model.addAttribute("msg1","添加成功");
            return model;
           // return "index";
        }
		return model;
    }
	
	
	// 删除用户
	@GetMapping(value = "/deleteuser/{id}")
	//@ResponseBody
	private String deleteUser(@PathVariable("id") Integer uId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		if(userDao.deleteUser(uId)==1){
		modelMap.put("msg", "删除成功");}
		//modelMap.put("success", userDao.deleteUser(uId));
		return "redirect:/usermanage";
	}
	
	
	//显示当前用户，在页面回显
	
	@RequestMapping(value = "/upuser/{uname}",method={RequestMethod.GET})
		 public String ListUserByuName(@PathVariable("uname") String uname, Model model){
			User usernow = userDao.findByUsername(uname);
			 model.addAttribute("usernow",usernow);
			 System.out.println("usernow: " + usernow);
			 return "upuser";
			//return model;
		 }
	
	@RequestMapping(value="/updateuser",method={RequestMethod.PUT})
    public String updateUser(User user,Model model){
	//根据u_id，修改密码
	if( userDao.updateUser(user)==1){
	
	model.addAttribute("msg", "修改密码成功，请重新登录");
	}
	 return "index";
    }	 
	
	
	//显示当前用户，在页面回显
	
		@RequestMapping(value = "/upadmin/{uname}",method={RequestMethod.GET})
			 public String ListAdminByuName(@PathVariable("uname") String uname, Model model){
				User usernow = userDao.findByUsername(uname);
				 model.addAttribute("usernow",usernow);
				 System.out.println("usernow: " + usernow);
				 return "upadmin";
				//return model;
			 }
		
		@RequestMapping(value="/updateadmin",method={RequestMethod.PUT})
	    public String updateAdmin(User user,Model model){
		//根据u_id，修改密码
		if( userDao.updateUser(user)==1){
		
		model.addAttribute("msg", "修改密码成功");
		}
		 return "redirect:/usermanage";
	    }	 
}
