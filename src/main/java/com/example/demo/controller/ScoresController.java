package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.example.demo.dao.ScoresDao;
import com.example.demo.dao.StudentInfoDao;
import com.example.demo.entity.ScoresAndInfo;
import com.example.demo.entity.StudentInfo;
import com.example.demo.entity.StudentInfoAndRepos;
import com.example.demo.entity.StudentScores;
import com.example.demo.entity.User;

@Controller
public class ScoresController {
	@Autowired
	private ScoresDao scoresDao;
	@Autowired
	private StudentInfoDao stuinfoDao;
	 
	//查看成绩页面
	@GetMapping(value = "/scores")
	public Model getScores(Model model){
		List<ScoresAndInfo> list =	scoresDao.ListScoresAndInfo();
		model.addAttribute("scoresinfo",list);
		System.out.println(list);	
		
		return model;
		
	}
	
	//跳转添加成绩页面
	 @GetMapping(value = "/addscores")
	 public Model toAddScoresPage(Model model){
		
		 List<StudentInfoAndRepos> list = stuinfoDao.ListStudentInfoAndRepos();
			model.addAttribute("stusinfo",list);
			System.out.println("scores:" + list);
	        return model;
	 }
	 
	 //显示当前学生信息，在页面回显
	
	@RequestMapping(value = "/issue/{sId}",method={RequestMethod.GET})
	 public String ListStuBysId(@PathVariable("sId") int sId, Model model){
		 
		 StudentInfo stuinfo = stuinfoDao.findByStuId(sId);
		 
		 model.addAttribute("stu",stuinfo);
		 System.out.println("stu: " + stuinfo);
			
		//去添加issue and score
	    //return "redirect:/issue";
	    return "issue";
		//return model;
	 }
	 
	
	@RequestMapping(value="/insertscore",method={RequestMethod.POST})
	    public String addScores(StudentScores stuscores,Model model){
		//根据s_id获取学生信息，提交成绩
		if( scoresDao.addScores(stuscores)==1){
		
		model.addAttribute("msg", "添加成绩成功");
		}
		 return "issue";
	    }
	 
	
	@RequestMapping(value = "/upscores/{scoreId}",method={RequestMethod.GET})
	 public String toUpdateScoresPage(@PathVariable("scoreId") int scoreId, Model model){
		ScoresAndInfo scoreAndInfo = scoresDao.FindScoresAndInfoByScoreId(scoreId);
		 
		 
		 model.addAttribute("stu",scoreAndInfo);
		 System.out.println("scoreAndInfo: " + scoreAndInfo);
			
		//去添加issue and score
	    //return "redirect:/issue";
	    return "upscores";
		//return model;
	 }
	
	
	@RequestMapping(value="/updatescore",method={RequestMethod.PUT})
    public String updateScores(StudentScores stuscores,Model model){
	//根据score_id，修改成绩
	if( scoresDao.updateScores(stuscores)==1){
	
	model.addAttribute("msg", "修改成绩成功");
	}
	 return "redirect:/scores";
    }
 
	 
}
