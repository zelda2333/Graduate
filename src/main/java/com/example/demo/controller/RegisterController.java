package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
//import com.mchange.lang.StringUtils;

@Controller
public class RegisterController {
	@Autowired
    private UserService userService;

    /**
     * 添加注册新用户的信息
     */
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String toRegister(){
        return  "register";
    }
	//@ResponseBody
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String addUser(User user, Map<String, Object> map, HttpSession session){
		//userService.addUser(user);
        if(StringUtils.isEmpty(user.getuName()) || StringUtils.isEmpty(user.getPassword())){
            map.put("msg1", "其他填充区域不能为空，请重新填写");
            return "register";
        }else{
            session.setAttribute("uname", user.getuName());
            session.setAttribute("users", user);
            userService.addUser(user);
            return "index";
        }
    }
}
