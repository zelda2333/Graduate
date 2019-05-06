package com.example.demo.dto;

public class GithubRepos {
	
	private Long id;
	//仓库名
	private String name;
	private String ssh_url;
	
	public String getSsh_url() {
		return ssh_url;
	}
	public void setSsh_url(String ssh_url) {
		this.ssh_url = ssh_url;
	}
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
	
	@Override
	public String toString() {
		return "GithubRepos [id=" + id + ", name=" + name + ", ssh_url=" + ssh_url + "]";
	}
}
