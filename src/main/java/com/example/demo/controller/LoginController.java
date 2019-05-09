package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	
	
	 //验证用户登录是否正确
    @PostMapping(value = "/dologin")
    public String login(@RequestParam("uname") String uname,
                      @RequestParam("password") String password,
                      Map<String, Object> map,
                      HttpSession session){
        User list = userService.queryByName(uname);
        int authorId = list.getAuthorId();
        if(uname==null || password==null){
            //提醒用户输入完整登陆信息
            map.put("msg", "提醒用户输入完整登陆信息");
            return "index";
        }else if(list.getuId()==null
        		/*.size()==0*/){
            //提醒登陆出错的信息原因
            map.put("msg", "用户不存在，请重新输入");
            //返回登陆界面
            return "index";
        }else if(!list.getPassword().equals(password)){
            //提醒用户输入的密码不正确
            map.put("msg", "提醒用户输入的密码不正确");
            return "index";
        }else{
        	session.setAttribute("uname",uname);
        	System.out.println(authorId);
            session.setAttribute("author",authorId);
            return "redirect:/stuinfo";
        }
    }
}
