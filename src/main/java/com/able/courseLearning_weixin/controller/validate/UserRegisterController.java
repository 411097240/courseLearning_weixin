package com.able.courseLearning_weixin.controller.validate;


import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.helper.MD5Utils;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IUserLoginService;
import com.able.courseLearning_weixin.service.validate.IUserRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author: lx
 * @Description: 登陆，注册 控制层 
 * **/
@Controller
public class UserRegisterController {
	@Resource
	private IUserLoginService loginservice;
	@Resource
	IUserRegisterService userRegisterService;
	
	@RequestMapping(value = "toH5Register",method = RequestMethod.GET)
	public ModelAndView toH5Register(HttpServletRequest request, HttpServletResponse response){

		String openId = null;
		//得到openId
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//response.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String AppId="wxfc8eae6dd688043e";
		String appsecret="103d37579877c2a4e8a9b6b76b4b54bc";
		System.out.println(code);
		System.out.println(state);

		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(AppId,
					appsecret, code);
			// 网页授权接口访问凭证
			String accessToken = weixinOauth2Token.getAccessToken();
			openId = weixinOauth2Token.getOpenId();
			System.out.print("openId:"+openId);
		}
		ModelAndView mav = new ModelAndView("h5/register");
		mav.addObject("openId", openId);
		return mav;
	}
	
	
	
	//用户注册
	@RequestMapping("joinClass")
	public  ModelAndView doRegister(String openId,String userName,String schoolCode,HttpServletRequest request, HttpServletResponse response) {
		String IuserName = org.springframework.web.util.HtmlUtils.htmlEscape(userName);
		System.out.print(schoolCode);
		System.out.print(userName);
		//判断输入合法性
		if ("".equals(userName) || "".equals(schoolCode)) {
			ModelAndView mav = new ModelAndView("h5/register");
			mav.addObject("msg", "学号和姓名不能为空");
			return mav;
		}
		AllUser user = new AllUser();
		user.setOpenId(openId);
		user.setSchoolCode(schoolCode);
		user.setRealName(userName);
		String message =  userRegisterService.doRegister(user,request,response);
		ModelAndView mav = new ModelAndView("h5/register");
		mav.addObject("msg", message);
		return mav;
		
	}

}
