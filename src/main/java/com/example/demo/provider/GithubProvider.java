package com.example.demo.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.example.demo.dto.GithubMember;
import com.example.demo.dto.GithubRepos;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.alibaba.fastjson.*;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@Component
public class GithubProvider {
	public String getMembers(String username,String password){
		OkHttpClient client = new OkHttpClient.Builder()
			    .addInterceptor(new BasicAuthInterceptor(username, password))
			    .build();
				
			   OkHttpClient okHttpClient  = new OkHttpClient.Builder()
			                    .connectTimeout(10, TimeUnit.SECONDS)
			                    .writeTimeout(10,TimeUnit.SECONDS)
			                    .readTimeout(20, TimeUnit.SECONDS)
			                    .build();

			            final Request request = new Request.Builder()
			                    .url("https://api.github.com/orgs/gradupro/members")//请求的url
			                    .get()//设置请求方式，get()/post()  查看Builder()方法知，在构建时默认设置请求方式为GET
			                    .build(); //构建一个请求Request对象

			            try {
							  Response response = client.newCall(request).execute();
							  String string = response.body().string();
							  /*ObjectMapper mapper = new ObjectMapper();
							  List<GithubMember> memberList = mapper.readValue(string, mapper.getTypeFactory().constructCollectionType(List.class,  GithubMember.class));
							  GithubMember githubMember=(GithubMember) memberList;
								*/
							  List<GithubMember> memberList = JSON.parseArray(string, GithubMember.class);
							  
							  for(GithubMember gm:memberList){
								  System.out.println(gm.getId());
							  }
							  System.out.println("githubMember:  " + memberList);
							  // List<GithubMember> memberList=new ArrayList<>();
							  
							  
							  
							 //List<ArrayList> memberList = JSONArray.parseArray(string).toJavaList(ArrayList.class);
							/*JSONObject userJson =JSONObject.parseObject(string);
							GithubMember githubMember=JSON.toJavaObject(userJson, GithubMember.class);*/
							  //GithubMember githubMember = JSON.parseObject(string, GithubMember.class);
							
							  return string;
						  }catch(IOException e){
							  
						  }
						  return null;
			           
				
	}
	public List<GithubRepos> getRepos(){
		OkHttpClient client = new OkHttpClient();
		 Request request = new Request.Builder()
			      .url("https://api.github.com/orgs/gradupro/repos")
			      .build();

			  try {
				  Response response = client.newCall(request).execute();
				  String string = response.body().string();
				  List<GithubRepos> githubRepos = JSON.parseArray(string, GithubRepos.class);
				  //System.out.println("Strings: " + githubRepos);
				  return githubRepos;
			  }catch(IOException e){
				  
			  }
			  return null;
	}
}
