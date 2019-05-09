package com.example.demo.provider;

import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.GithubIssue;
import com.example.demo.dto.GithubRepos;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubProviderTest {
	
	@Test
	@Ignore
	public void getRepos(){
		OkHttpClient client = new OkHttpClient();
		 Request request = new Request.Builder()
			      .url("https://api.github.com/orgs/gradupro/repos")
			      .build();

			  try {
				  Response response = client.newCall(request).execute();
				  String string = response.body().string();
				  List<GithubRepos> githubRepos = JSON.parseArray(string, GithubRepos.class);
				  System.out.println("Strings: " + githubRepos);
				 // return githubRepos;
			  }catch(IOException e){
				  
			  }
			 // return null;
	}
	@Test
	public void getAnIssueTest(){
		OkHttpClient client = new OkHttpClient();
		 Request request = new Request.Builder()
			      .url("https://api.github.com/repos/gradupro/6103115139/issues/1")
			      .build();

			  try {
				  Response response = client.newCall(request).execute();
				  String string = response.body().string();
				  GithubIssue githubIssue = JSON.parseObject(string, GithubIssue.class);
				 
				  
				 System.out.println("Strings: " + githubIssue.getBody() +  githubIssue.getTitle());
				 
			  }catch(IOException e){
				  
			  }
			  
		
	}
	
}
