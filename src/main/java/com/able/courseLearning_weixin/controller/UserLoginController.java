package com.able.courseLearning_weixin.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.able.courseLearning_weixin.common.pojo.ClassModel;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.able.courseLearning_weixin.helper.MD5Utils;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IUserLoginService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lx
 * @Description: 登陆，注册 控制层 
 * **/
@Controller
public class UserLoginController {
	@Resource
	private IUserLoginService loginservice;
	@Resource
	private IClassDao classDao;
	
	//用户登录
	@RequestMapping("/userlogin")
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse rsponse,String userName,String passWord){
		ModelAndView mav = new ModelAndView();
		//passWord加密
		String pwd = "";
		Integer classId = 0;
		if(passWord!=null&&!("".equals(passWord))){
			pwd = MD5Utils.getPwd(passWord);
		}
		if(loginservice.isCheck(userName,pwd)){
			//判断用户权限
			int grade = loginservice.selectGradeByName(userName);
			request.getSession().setAttribute("userName", userName);
			classId = classDao.findClassIdByteacherName(userName);
			ClassModel classMessage = classDao.findClassMessageByClassId(classId);
			mav.addObject("classId",classId);
			mav.addObject("clsssMessage",classMessage);
			//超级管理
			if(grade==2){
				mav.setViewName("admin/index");
				return mav;
			}else {
                //老师
				mav.setViewName("admin/index");
				return mav;
			}
		}
		
		 mav = new ModelAndView("index");
		 mav.addObject("msg","用户名或密码错误");
		 return mav;
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

	//welcome.jsp页面数据
	@RequestMapping("/toWelcome")
	public ModelAndView toWelcome(){
		ModelAndView mav = new ModelAndView("admin/welcome");
		return mav;
	}

	//退出登录
	@RequestMapping("/loginOut")
	public ModelAndView loginOut(String userName,HttpServletRequest request){
		request.getSession().invalidate();
		System.out.println(request.getSession().getAttribute(userName));
		ModelAndView mav = new ModelAndView("redirect:userlogin");
		return mav;
	}

	//异步得到入班人数和待审核人数
	@ResponseBody
	@RequestMapping("/findStudentCountByclassId")
	public Object findStudentCountByclassId(Integer classId){
		Map<String,Object> map = new HashMap<String,Object>();
		//得到通过审核的人数
		Integer checkedCount = classDao.findStudentCountByclassId(classId,1);
		Integer notCheckedCount = classDao.findStudentCountByclassId(classId,0);
		map.put("checkedCount",checkedCount);
		map.put("notCheckCount",notCheckedCount);
		return map;
	}


}
