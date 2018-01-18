package com.able.courseLearning_weixin.controller.validate;


import com.able.courseLearning_weixin.helper.MD5Utils;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IUserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lx
 * @Description: 登陆，注册 控制层 
 * **/
@Controller
public class UserRegisterController {
	@Resource
	private IUserLoginService loginservice;
	
	@RequestMapping("/toH5Register")
	public String toH5Register(){
		return "h5/register";
	}
	
	
	
	//用户注册
	@RequestMapping("/joinClass")
	public  ModelAndView doRegister(String userName,String schoolCode) {
		String IuserName = org.springframework.web.util.HtmlUtils.htmlEscape(userName);
		System.out.print(schoolCode);
		System.out.print(userName);
		//判断输入合法性
		if ("".equals(userName) || "".equals(schoolCode)) {
			ModelAndView mav = new ModelAndView("h5/register");
			mav.addObject("msg", "学号和姓名不能为空");
			return mav;
		}
		ModelAndView mav = new ModelAndView("h5/register");
		mav.addObject("msg", "申请成功，等待老师审核");
		return mav;
		
	}

}
