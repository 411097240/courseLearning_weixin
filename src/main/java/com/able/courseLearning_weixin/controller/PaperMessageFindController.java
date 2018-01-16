package com.able.courseLearning_weixin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.able.courseLearning_weixin.service.IFindPaperService;
import com.alibaba.fastjson.JSONArray;

@Controller
public class PaperMessageFindController {
	@Resource
	private IFindPaperService findpaper;
	//通过用户名和状态查询已考试和未考试的试卷信息
	@RequestMapping("/getPaper")
	public ModelAndView findPaper(String userName,String state){
		//防止String转int空指针
		if("".equals(state)||null==state){
			state="100";
		}
		int Istate =Integer.parseInt(state); 
		ModelAndView mav = new ModelAndView("student/exam_score");
		JSONArray jsonarray = findpaper.findPaper(userName,Istate);	
		mav.addObject("jsonarray",jsonarray);
		return mav;
	}
	
	//开始考试
	@RequestMapping("/beginTest")
		public ModelAndView beginTest(String paperId){
			int IpaperId = Integer.parseInt(paperId);
			JSONArray jsonarray = findpaper.findExamPaperByPaperId(IpaperId);
			ModelAndView mav = new ModelAndView("student/testing");
			mav.addObject("jsonarray",jsonarray);
			return mav;
		}
	
	//教师端查询未批改的试卷列表
	@RequestMapping("/findPaperNotCorrecting")
		public ModelAndView findPaperNotCorrecting(String score){
		//防止String转int空指针
		if("".equals(score)||null==score){
			score="1000";
		}
		int Iscore =Integer.parseInt(score); 
		JSONArray jsonarray = findpaper.findPaperListNotCorrecting(Iscore);
		ModelAndView mav = new ModelAndView("teacher/teacherIndex");
		mav.addObject("jsonarray",jsonarray);
		return mav;
	}
	
	
	@RequestMapping("/viewPaper")
	public ModelAndView viewPaper(String userName,String paperId){
		int IpaperId = Integer.parseInt(paperId);
		JSONArray jsonarray = findpaper.findSubmitPaperMessage(userName, IpaperId);
		ModelAndView mav = new ModelAndView("teacher/view_paper");
		mav.addObject("jsonarray",jsonarray);
		return mav;
	}
		
	
}
