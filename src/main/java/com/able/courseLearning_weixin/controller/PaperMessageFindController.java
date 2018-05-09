package com.able.courseLearning_weixin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.able.courseLearning.weixin.pojo.SNSUserInfo;
import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.able.courseLearning_weixin.service.IFindPaperService;
import com.alibaba.fastjson.JSONArray;

import java.io.UnsupportedEncodingException;

@Controller
public class PaperMessageFindController {
	@Resource
	private IFindPaperService findpaper;
	@Resource
	private IClassDao classDao;
	//通过用户名和状态查询已考试和未考试的试卷信息
	@RequestMapping("/getPaper")
	public ModelAndView findPaper(String openId,String state){
		//防止String转int空指针
		if("".equals(state)||null==state){
			state="100";
		}
		int Istate =Integer.parseInt(state);
		ModelAndView mav = new ModelAndView("student/exam_score");
		JSONArray jsonarray = findpaper.findPaper(openId,Istate);
		mav.addObject("jsonarray",jsonarray);
		mav.addObject("openId",openId);
		return mav;
	}
	@RequestMapping("/toStudentIndex")
	public ModelAndView toStudentIndex(HttpServletRequest request, HttpServletResponse response){
		String openId = null;
		SNSUserInfo snsUserInfo = null;
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
			snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
		}
		ModelAndView mav = new ModelAndView("student/index");
		mav.addObject("openId",openId);
		return mav;
	}
	
	//开始考试
	@RequestMapping("/beginTest")
		public ModelAndView beginTest(String paperId,String openId){
			int IpaperId = Integer.parseInt(paperId);
			JSONArray jsonarray = findpaper.findExamPaperByPaperId(IpaperId);
			ModelAndView mav = new ModelAndView("student/testing");
			mav.addObject("jsonarray",jsonarray);
		    mav.addObject("openId",openId);
			return mav;
		}
	
	//教师端查询未批改的试卷列表
	@RequestMapping("/findPaperNotCorrecting")
		public ModelAndView findPaperNotCorrecting(Integer classId){
		if(null == classId){
			ModelAndView mav = new ModelAndView("teacher/teacherIndex");
			return mav;
		}
		JSONArray jsonarray = findpaper.findPaperListNotCorrecting(classId);
		ModelAndView mav = new ModelAndView("teacher/teacherIndex");
		mav.addObject("jsonarray",jsonarray);
		return mav;
	}
	
	
	@RequestMapping("/viewPaper")
	public ModelAndView viewPaper(String openId,Integer paperId,HttpServletRequest request){
		JSONArray jsonarray = findpaper.findSubmitPaperMessage(openId, paperId);
		HttpSession session  = request.getSession();
		String teacherName = (String) session.getAttribute("userName");
		Integer classId = classDao.findClassIdByteacherName(teacherName);
		ModelAndView mav = new ModelAndView("teacher/view_paper");
		mav.addObject("classId",classId);
		mav.addObject("jsonarray",jsonarray);
		return mav;
	}
		
	
}
