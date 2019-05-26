package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class JumpController {
	//前往添加成绩界面
	//前往发布帖子界面
	@GetMapping(value = "/adminrepos")
    public String toadminListReposPage(){
        return "adminrepos";
    } 
	@GetMapping(value = "/infodaoru")
    public String toDaoruPage(){
        return "infodaoru";
    } 
	
    @GetMapping(value = "/gitmanage")
    public String togitManagePage(){
        return "gitmanage";
    } 
    @GetMapping(value = "/issue")
    public String toIssuePage(){
        return "issue";
    } 
    @GetMapping(value = "/gitauth")
    public String toGitAuthPage(){
        return "gitauth";
    }
    /*@GetMapping(value = "/githubauth")
    public String toGithubAuthPage(){
        return "githubauth";
    }*/
    @GetMapping(value = "/postuser")
    public String toAddUserPage(){
        return "postuser";
    }
    @GetMapping(value = "/postclass")
    public String toAddClassRoomPage(){
        return "postclass";
    }
    @GetMapping(value = "/postteacher")
    public String toAddTeacherPage(){
        return "postteacher";
    }
    @GetMapping(value = "/postrepos")
    public String toAddReposPage(){
        return "postrepos";
    }
}
