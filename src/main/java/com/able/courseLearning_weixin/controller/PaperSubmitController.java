package com.able.courseLearning_weixin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.able.courseLearning_weixin.pojo.QuestionAnswer;
import com.able.courseLearning_weixin.service.IFindPaperService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaperSubmitController {
	@Resource
	private IFindPaperService findpaper;
	@Resource
	private IClassDao classDao;
	@RequestMapping(value="/submitPaper",method=RequestMethod.POST)
	@ResponseBody
	public String submitPaper(@RequestBody List<QuestionAnswer> questionanswers,String openId){
		//System.out.println(questionanswers.get(0).getQaUserName());
		int paperId  = questionanswers.get(0).getQaPaperId();
		if("".equals(openId)||null==openId){
			return "请先登陆再完成试卷!";
		}
		if(findpaper.cheakSubmit(openId, paperId)){
			return "你已提交过试卷，请勿重复提交!";
		}
		if(findpaper.isSubmit(questionanswers)&&findpaper.updateUserPaper(openId, paperId)){
			return "试卷提交成功!";
		}
		return "试卷提交失败!";		
	}
	
	@RequestMapping("/submitScore")
	public ModelAndView submitScore(String openId,Integer  paperId, Integer totalScore,HttpServletRequest request){
		HttpSession session  = request.getSession();
		String teacherName = (String) session.getAttribute("userName");
		Integer classId = classDao.findClassIdByteacherName(teacherName);
		if(findpaper.submitScore(openId, paperId, totalScore)){
			ModelAndView mav = new ModelAndView("teacher/teacherIndex");
			mav.addObject("classId",classId);
			return mav;
		}
		ModelAndView mav = new ModelAndView("err");
		return mav;
	}
}
