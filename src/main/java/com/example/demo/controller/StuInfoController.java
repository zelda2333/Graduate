package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.ReposDao;
import com.example.demo.dao.StudentInfoDao;
import com.example.demo.dto.GithubMember;
import com.example.demo.dto.GithubRepos;
import com.example.demo.entity.Authority;
import com.example.demo.entity.Repos;
import com.example.demo.entity.StudentInfoAndRepos;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAndAuthor;
import com.example.demo.provider.GithubProvider;

@Controller
public class StuInfoController {
	@Autowired
	private GithubProvider githubProvider;
	@Autowired
	private ReposDao reposDao;
	@Autowired
	private StudentInfoDao stuinfoDao;
	
	@GetMapping("/stuinfo")
	public Model getInfo(Model model){
		//Map<String, Object> modelMap = new HashMap<String, Object>();
		List<GithubRepos> githubRepos = githubProvider.getRepos();
		
		for(GithubRepos gRepos:githubRepos){
			Repos repos = new Repos();
			repos.setrName(gRepos.getName());
			repos.setSshUrl(gRepos.getSsh_url());
			repos.setOwner(gRepos.getOwner().getLogin());
			reposDao.insertRepos(repos);
		  }
		
		List<StudentInfoAndRepos> list = stuinfoDao.ListStudentInfoAndRepos();
		model.addAttribute("stusinfo",list);
//		
		
		for(StudentInfoAndRepos stuinfo:list){
//			model.addAttribute("stusinfo",stuinfo);
			System.out.println(stuinfo);	
			
		}
		
		return model;
	}
	
	
	@GetMapping("/stuinfos")
	public String getMember(Map<String, Object> map, HttpSession session){
		//String githubRepos = githubProvider.getRepos(); 
		//List<ArrayList> member= new ArrayList<>();
		//member = githubProvider.getMembers("zelda2333", "964544758dzx1");
		//map.put("member",member);
		githubProvider.getRepos();
		//System.out.println( "hello " + githubProvider.getMembers("zelda2333", "964544758dzx1"));
		return "redirect:/stuinfo";
	}
	
	
	
	
}
