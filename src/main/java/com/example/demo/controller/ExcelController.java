package com.example.demo.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.util.ExcelUtil;

@Controller
public class ExcelController {
	@Autowired
	private ExcelUtil excelUtil;
	
	@GetMapping(value = "/toexcel")
	public String downloadExcel(Model model) throws IOException{
		String restring = excelUtil.outputExcel();
		if(restring=="success"){
		
		model.addAttribute("msg","success");
		}else{
		model.addAttribute("msg","erro");
		}
		System.out.println(restring);	
		
		return "redirect:/scores";
		
	}
}
