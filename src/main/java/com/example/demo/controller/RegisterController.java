package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
//import com.mchange.lang.StringUtils;

@Controller
public class RegisterController {
	@Autowired
    private UserService userService;
	@Autowired
    private UserDao userDao;
    /**
     * 添加注册新用户的信息
     */
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String toRegister(){
        return  "register";
    }
	//@ResponseBody
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
    public Model addUser(User user, Model model, HttpSession session){
		//userService.addUser(user);
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
            model.addAttribute("msg1","注册成功");
            return model;
           // return "index";
        }
		return model;
    }
}
