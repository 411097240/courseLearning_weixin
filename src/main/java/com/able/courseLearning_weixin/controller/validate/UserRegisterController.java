package com.able.courseLearning_weixin.controller.validate;


import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.common.pojo.ClassModel;
import com.able.courseLearning_weixin.dao.common.IClassDao;
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
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Resource
	IClassDao classDao;
	
	@RequestMapping(value = "toH5Register",method = RequestMethod.GET)
	public ModelAndView toH5Register(HttpServletRequest request, HttpServletResponse response){
		String msg = request.getParameter("msg");
		System.out.print("msg:_____________"+msg);
		String openId = null;
		List<ClassModel> classList = classDao.findAllClass();
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
		if(classList!=null&&classList.size()>0){
			mav.addObject("classList", classList);
		}
		mav.addObject("openId", openId);
		if("1".equals(msg)){
			mav.addObject("msg", "用户名和密码不能为空");
		}else if("2".equals(msg)){
			mav.addObject("msg", "获取微信信息失败，返回微信菜单，重试");
		}else{
			if("3".equals(msg)){
				mav.addObject("msg", "你已经提交过申请，等待老师审核中！");
			}
			if("4".equals(msg)){
				mav.addObject("msg", "老师已经同意你的申请！");
			}
			if("5".equals(msg)){
				mav.addObject("msg", "申请已提交，等待老师审核！");
			}
			if("6".equals(msg)){
				mav.addObject("msg", "申请提交失败！");
			}
			if("7".equals(msg)){
				mav.addObject("msg", "申请已提交，等待老师审核！");
			}
			if("8".equals(msg)){
				mav.addObject("msg", "申请提交失败！");
			}
			if("9".equals(msg)){
				mav.addObject("msg", "获取微信openId失败，请稍后再试！");
			}

		}
		return mav;
	}
	
	
	
	//用户注册
	@RequestMapping("joinClass")
	public  ModelAndView doRegister(Integer classId,String openId,String userName,String schoolCode,HttpServletRequest request, HttpServletResponse response) {
		String IuserName = org.springframework.web.util.HtmlUtils.htmlEscape(userName);
		System.out.print("------openId--------"+openId);
		System.out.print("------classId--------"+classId);
		//判断输入合法性
		if ("".equals(userName) || "".equals(schoolCode)) {
			ModelAndView mav = new ModelAndView("redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2fcourseLearning_weixin%2ftoH5Register?msg=1&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
			return mav;
		}
		//如果没有openId直接返回
		if(openId==""){
			ModelAndView mav = new ModelAndView("redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2fcourseLearning_weixin%2ftoH5Register?msg=2&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
			return mav;
		}
		AllUser user = new AllUser();
		user.setOpenId(openId);
		user.setSchoolCode(schoolCode);
		user.setRealName(userName);
		//默认权限学生
		user.setPower(3);
		String message =  userRegisterService.doRegister(classId,user,request,response);
		System.out.print("----------------------"+message);
		ModelAndView mav = new ModelAndView("redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxfc8eae6dd688043e&redirect_uri=http%3a%2f%2fweixin.411097240qqcom.yxnat.softdev.top%2fcourseLearning_weixin%2ftoH5Register?msg="+message+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
		return mav;
		
	}

}
