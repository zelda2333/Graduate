package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.util.GitUtil;

@Controller
public class CloneController {
	@Value("${github.downLoad.localPath}")
    private String local;
	
	@Autowired
	private GitUtil gitUtil;
	
	@GetMapping(value = "/clone")
	private String cloneHomework(Model model, HttpServletRequest request) {
			
		String path = request.getParameter("path");
		String url = request.getParameter("url");
		String localPath = local + "\\" + path;
		System.out.println(url);
		System.out.println(localPath);
		String cloneResult = gitUtil.cloneRepository(url, localPath);
		// 下载
		model.addAttribute("test", "cs154");
		model.addAttribute("msg", "正在下载，请稍等");
		if(cloneResult=="success"){
			model.addAttribute("msg", "下载完成");
		}else{
			model.addAttribute("msg", "下载失败");
		}
		
		return "stuinfo";
	}
}
