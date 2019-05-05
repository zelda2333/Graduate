package com.example.demo.dto;

public class GithubMember {
	private Long id;
	private String login;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		//return "GithubMember [id=" + id + ", login=" + login + "]";
		/*return "GithubMember{" +
        "id='" + id + +'\'' +
        ", login=" + login +'\'' +
        '}';*/
		return "{" +
        "id='" + id + "', login='" + login +"'}";
	}
	
}
