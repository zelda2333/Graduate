package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.GithubIssue;
import com.example.demo.entity.ScoresAndInfo;
import com.example.demo.entity.StudentInfo;
import com.example.demo.provider.GithubProvider;

@Controller
public class IssueController {
	@Autowired
	private GithubProvider githubProvider;
	@Value("${github.repos.user}")
    private String loginer;
	
	//显示当前仓库信息，在页面回显
	
		@RequestMapping(value = "/issue/{repos}",method={RequestMethod.GET})
		 public String ListStuBysId(@PathVariable("repos") String repos, Model model){
			 		 
			 model.addAttribute("reposName",repos);
			 System.out.println("reposName: " + repos);
				
			//去添加issue and score
		    //return "redirect:/issue";
		    return "issue";
			//return model;
		 }
	
	
	
	
	
	
	@PostMapping(value="/postissue")
	public String postIssue(@RequestParam("rName") String rname,
							@RequestParam("title") String title,
							GithubIssue issue,Model model){
			
		String uri="https://api.github.com/repos/"+loginer+"/"+rname+"/issues";
		System.out.println(uri);
		String retitle=githubProvider.postIssue(issue, uri,"zelda2333", "964544758dzx1");
		if(title==retitle){
			model.addAttribute("msg", "添加成功");
		}
		
		return "redirect:/addscores";
	}
	
	
	//查看某条成绩对应的issue
	@RequestMapping(value = "/listoneissue/{repoName}/{issueNum}",method={RequestMethod.GET})
	 public String toUpdateScoresPage(@PathVariable("repoName") String reposName, 
			 						  @PathVariable("issueNum") int number, 
			 						  Model model){
		String uri="https://api.github.com/repos/gradupro/"+reposName+"/issues/"+number;
		
		GithubIssue issue = githubProvider.getAnIssue(uri);
		
		model.addAttribute("issue", issue);
		
	    return "oneissue";
		//return model;
	 }
	
	
	
	
	
}
