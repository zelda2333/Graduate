package com.example.demo.entity;

public class Repos {
	private Integer rId;
	//权限名称
	
	private String rName;
	private String sshUrl;
	private String owner;
	
	public String getSshUrl() {
		return sshUrl;
	}

	public void setSshUrl(String sshUrl) {
		this.sshUrl = sshUrl;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	@Override
	public String toString() {
		return "Repos [rId=" + rId + ", rName=" + rName + ", sshUrl=" + sshUrl + ", owner=" + owner + "]";
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
