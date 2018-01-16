package com.able.courseLearning_weixin.service;

import com.able.courseLearning_weixin.pojo.User;

public interface IUserLoginService {
	//判断账号密码是否正确
	boolean isCheck(String userName,String passWord);
	//判断是否注册成功
	boolean isRegister(User user);
	//判断注册时用户名是否存在
	boolean isUserExist(String userName);
	//得到用户权限
	int selectGradeByName(String userName);
}
