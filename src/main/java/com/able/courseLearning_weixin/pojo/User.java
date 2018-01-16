package com.able.courseLearning_weixin.pojo;



public class User {
	private Integer id;
	private String userName;
	private String passWord;
	private Integer grade;  //用户权限 1:普通用户   2:管理员  3:超级管理员
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	

}
