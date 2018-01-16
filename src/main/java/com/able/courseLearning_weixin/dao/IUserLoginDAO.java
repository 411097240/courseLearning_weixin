package com.able.courseLearning_weixin.dao;

import com.able.courseLearning_weixin.pojo.User;

public interface IUserLoginDAO {
	//通过用户名看密码是否存在
	String selectPassByName(String userName);
	//注册用户
	int insert(User userlogin);
	//通过用户名查找用户权限
	int selectGradeByName(String userName);
	//判断用户名是否存在
	String findUserName(String userName);
	
}
