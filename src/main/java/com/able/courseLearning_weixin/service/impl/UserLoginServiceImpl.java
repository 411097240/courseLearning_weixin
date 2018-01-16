package com.able.courseLearning_weixin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.able.courseLearning_weixin.dao.IUserLoginDAO;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IUserLoginService;
@Service
public class UserLoginServiceImpl implements IUserLoginService{
	@Resource
	private IUserLoginDAO logindao;

	@Override
	//验证密码和用户名
	public boolean isCheck(String userName,String passWord){
		boolean flag = true;
		String pass = logindao.selectPassByName(userName);
		if(null==pass){
			flag = false;
			return flag;
		}else if(!(pass.equals(passWord))){
			flag = false;
			return flag;
		}
		return flag;
	}

	@Override
	//判断用户注册是否成功
	public  boolean isRegister(User user) {
		if("".equals(user.getUserName())||"".equals(user.getPassWord())){
			return false;
		}else{
			int row = logindao.insert(user);
			if(row!=0){
				return true;
			}
			return false;
		}
		
	}

	@Override
	//注册时判断用户名是否存在
	public boolean isUserExist(String userName) {
		String name = logindao.findUserName(userName);
		if("".equals(name)||null==name){
			return false;
		}
		return true;
	}

	@Override
	//得到用户权限    用户权限 1:普通用户   2:管理员  3:超级管理员
	public int selectGradeByName(String userName) {
		int grade = logindao.selectGradeByName(userName);
		if("".equals(grade)||0==grade){
			return 1;
		}
		return grade;
	}
	

	
}
