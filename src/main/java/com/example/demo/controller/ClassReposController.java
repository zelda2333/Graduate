package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.dao.GithubDao;
import com.example.demo.entity.Github;

@Controller
public class ClassReposController {
	//gitHub授权认证
	@Autowired
	private GithubDao githubDao;
	
	@RequestMapping(value = "/githubauth" , method = RequestMethod.POST)
	public String addClass(Github github, Model model){
		if(githubDao.addGitubRepos(github)==1){
	           model.addAttribute("msg1","成功授权");
		}
		return "gitmanage";
	}
}
