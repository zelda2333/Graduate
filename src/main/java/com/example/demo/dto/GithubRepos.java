package com.example.demo.dto;

public class GithubRepos {
	
	private Long id;
	//仓库名
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*public String toString() {
		return "GithubRepos [id=" + id + ", name=" + name + "]";
	}*/
	@Override
	public String toString() {
		return "GithubRepos{" +
                "id='" + id + 
                ", name=" + name +'\'' +
                '}';
	}
}
