package com.able.courseLearning_weixin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.able.courseLearning_weixin.pojo.ChoiceQuestion;
import com.able.courseLearning_weixin.service.IFindPaperService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherAddQuestionController {
	
	@Resource
	private IFindPaperService findpaper;
	@Resource
	private IClassDao classDao;
@RequestMapping(value="/addQuestion",method=RequestMethod.POST)
@ResponseBody
public Map<String, String> addQuestion(HttpServletRequest request,@RequestBody List<ChoiceQuestion> choiceQuestion, String title){
	Map<String, String> map = new HashMap<>();
	//System.out.print(choiceQuestion.size());
	if("".equals(title)||choiceQuestion.size()==0){
		map.put("message","请完整填写数据!");
		return map;
	}
	HttpSession session  = request.getSession();
	String teacherName = (String) session.getAttribute("userName");
	if(findpaper.addQuestion(choiceQuestion,teacherName,title)){
		map.put("message","提交成功!");
		return map;
	}
	map.put("message","提交失败!");
	return map;
	
}

@RequestMapping("/toAddQuestion")
public ModelAndView toAddQuestion(HttpServletRequest request){
	HttpSession session  = request.getSession();
	String teacherName = (String) session.getAttribute("userName");
	Integer classId = classDao.findClassIdByteacherName(teacherName);
	ModelAndView mav = new ModelAndView("admin/addQuestion");
	mav.addObject("classId",classId);
	return mav;
}
}
