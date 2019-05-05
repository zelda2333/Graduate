package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.GithubMember;
import com.example.demo.dto.GithubRepos;
import com.example.demo.entity.Authority;
import com.example.demo.entity.User;
import com.example.demo.provider.GithubProvider;

@Controller
public class StuInfoController {
	@Autowired
	private GithubProvider githubProvider;
	@GetMapping("/stuinfos")
	public String getInfo(){
		//String githubRepos = githubProvider.getRepos();
		
		
		System.out.println(githubProvider.getRepos());
		return "redirect:/stuinfo";
	}
	//@GetMapping("/stuinfos")
	public String getMember(Map<String, Object> map, HttpSession session){
		//String githubRepos = githubProvider.getRepos(); 
		//List<ArrayList> member= new ArrayList<>();
		//member = githubProvider.getMembers("zelda2333", "964544758dzx1");
		//map.put("member",member);
		System.out.println( "hello " + githubProvider.getMembers("zelda2333", "964544758dzx1"));
		return "redirect:/stuinfo";
	}
	
	
	
	
}
