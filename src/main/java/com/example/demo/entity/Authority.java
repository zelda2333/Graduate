package com.example.demo.entity;

import java.util.List;

public class Authority {
	//权限id
		private Integer authorId;
		//权限名称
		
		private String authorType;
		//一个权限对象对应多个用户
		private List<User> users;
		
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public Integer getAuthorId() {
			return authorId;
		}
		public void setAuthorId(Integer authorId) {
			this.authorId = authorId;
		}
		public String getAuthorType() {
			return authorType;
		}
		public void setAuthorType(String authorType) {
			this.authorType = authorType;
		}
		@Override
		public String toString() {
			return "Authority [authorId=" + authorId + ", authorType=" + authorType + ", users=" + users + "]";
		}
		
}
