package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.util.GitUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloneControllerTest {
	@Value("${github.downLoad.localPath}")
	private String localPath;
	
	@Autowired
	private GitUtil gitUtil;
	
	@Test	
	public void TestcloneHomework() {
		String path = localPath+"\\6103115145";
	String cloneResult = gitUtil.cloneRepository("git@github.com:zelda2333/test.git", path);
		
		System.out.println(cloneResult);
		
		
		
	}
}
