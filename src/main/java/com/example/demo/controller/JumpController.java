package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class JumpController {
	//前往添加成绩界面
	//前往发布帖子界面
    @GetMapping(value = "/issue")
    public String toIssuePage(){
        return "issue";
    }  
}
