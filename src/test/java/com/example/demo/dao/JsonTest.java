package com.example.demo.dao;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.GithubRepos;

public class JsonTest {
	public static void main(String[] args) {
        /**
         * json字符串转化为对象
         */
        String jsonString = "{id:'12',name:'Antony'}";
        GithubRepos repos = JSON.parseObject(jsonString, GithubRepos.class);
        System.out.println(repos);
 
        /**
         * 对象转化为json字符串
         */
        String jsonStr = JSON.toJSONString(repos);
        System.out.println(jsonStr);
    }

}
