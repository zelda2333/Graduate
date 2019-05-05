package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthorityDao;
import com.example.demo.entity.Authority;

@Service
public class AuthorityService {

	 @Autowired
	    private AuthorityDao authorityDao;

	    /**
	     *查询用户的权限信息
	     */
	    public List<Authority> ListAuthority(){
	        return authorityDao.ListAuthority();
	    }

	   
}
