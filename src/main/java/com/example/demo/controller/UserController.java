package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.GithubMember;
import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller

public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/usermanage", method = RequestMethod.GET)
	private Model listUser(Model model) {
		//Map<String, Object> modelMap = new HashMap<String, Object>();
		//List<User> list = new ArrayList<User>();
		//list = userService.ListUser();
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
/*	@RequestMapping("/login")
    public String login(){
        return "login";
    }
 
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
	
	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	private Map<String, Object> listUser() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		// 获取已注册的用户列表
		list = userService.queryAllInfo();
		modelMap.put("areaList", list);
		return modelMap;
	}
	
	@RequestMapping(value = "/doregister", method = RequestMethod.POST)
	private Map<String, Object> addUser(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 注册用户
		modelMap.put("success", userService.addUser(user));
		return modelMap;
	}
	
	
	
	 //验证用户登录是否正确
    @PostMapping(value = "/login")
    public String login(@RequestParam("uname") String uname,
                      @RequestParam("password") String password,
                      Map<String, Object> map,
                      HttpSession session){
        List<User> list = userService.queryByName(uname);
        if(uname==null || password==null){
            //提醒用户输入完整登陆信息
            map.put("msg", "提醒用户输入完整登陆信息");
            return "login";
        }else if(list.size()==0){
            //提醒登陆出错的信息原因
            map.put("msg", "用户不存在，请重新输入");
            //返回登陆界面
            return "login";
        }else if(!list.get(0).getPassword().equals(password)){
            //提醒用户输入的密码不正确
            map.put("msg", "提醒用户输入的密码不正确");
            return "login";
        }else{
            session.setAttribute("uname",uname);
            return "redirect:/index";
        }
    }
	*/
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	private Map<String, Object> updateUser(@RequestBody User user)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改用户信息，设置权限
		modelMap.put("success", userDao.updateUser(user));
		return modelMap;
	}
	
	@GetMapping(value = "/deleteuser/{id}")
	//@ResponseBody
	private String deleteUser(@PathVariable("id") Integer uId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		// 删除用户
		if(userDao.deleteUser(uId)==1){
		modelMap.put("msg", "删除成功");}
		//modelMap.put("success", userDao.deleteUser(uId));
		return "redirect:/usermanage";
	}

}
