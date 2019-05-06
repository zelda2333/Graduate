package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
	 //前往成绩页面
    @GetMapping(value = "/scores")
    public String toScoresPage(){
        return "scores";
    }
   /* @GetMapping(value = "/stuinfo")
    public String toInfosPage(){
        return "stuinfo";
    }*/
  /*//用户管理页面
    @GetMapping(value = "/usermanage")
    public String toUserManagePage(){
        return "usermanage";
    }*/
}
