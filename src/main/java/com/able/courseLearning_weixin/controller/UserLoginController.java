package com.able.courseLearning_weixin.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.able.courseLearning_weixin.helper.MD5Utils;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IUserLoginService;
/**
 * @author: lx
 * @Description: 登陆，注册 控制层 
 * **/
@Controller
public class UserLoginController {
	@Resource
	private IUserLoginService loginservice;
	
	//用户登录
	@RequestMapping("/userlogin")
	public ModelAndView userLogin(HttpServletRequest requset,HttpServletResponse rsponse,String userName,String passWord){
		String IuserName = org.springframework.web.util.HtmlUtils.htmlEscape(userName);
		ModelAndView mav = null;
		//passWord加密
		String pwd = MD5Utils.getPwd(passWord);
		if(loginservice.isCheck(IuserName,pwd)){
			//判断用户权限
			int grade = loginservice.selectGradeByName(IuserName);
			if(grade==1){
				requset.getSession().setAttribute("userName", IuserName);
				mav = new ModelAndView("student/index");
				return mav;
			}
			    mav = new ModelAndView("teacher/teacherIndex");
			    requset.getSession().setAttribute("userName", IuserName);
				return mav;
		}
		
		 mav = new ModelAndView("h5/index");
		 mav.addObject("msg","用户名或密码错误");
		 return mav;
	}
	
	@RequestMapping("/register")
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping("/index")	
	public String toIndex(){
		return "h5/index";
	}
	
	
	
	//用户注册
	@RequestMapping("/doRegister")
	public  ModelAndView doRegister(String userName,String passWord,String confirm_password){
		String IuserName = org.springframework.web.util.HtmlUtils.htmlEscape(userName);
		//判断输入合法性
		if("".equals(userName)||"".equals(passWord)||"".equals(confirm_password)){
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("msg", "用户名或密码不能为空");
			return mav;
		}
		if(!passWord.equals(confirm_password)){
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("msg", "两次密码不一致");
			return mav;
		}
		User user = new User();
		//passWord加密
		String pwd = MD5Utils.getPwd(passWord);
		user.setUserName(IuserName);
		user.setPassWord(pwd);
		//注册默认权限1
		user.setGrade(1);
		//判断用户名是否重复
		if(loginservice.isUserExist(IuserName)){
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("msg", "用户名已被占用！");
			return mav;
		}
		//是否注册成功
		boolean flag = loginservice.isRegister(user);
		if(flag){
			ModelAndView mav = new ModelAndView("h5/index");
			mav.addObject("msg", "注册成功，现在登录！");
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("msg", "注册失败！");
			return mav;
		}
		
	}

}
