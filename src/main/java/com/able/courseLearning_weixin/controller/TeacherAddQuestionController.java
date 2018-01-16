package com.able.courseLearning_weixin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.able.courseLearning_weixin.pojo.ChoiceQuestion;
import com.able.courseLearning_weixin.service.IFindPaperService;

@Controller
public class TeacherAddQuestionController {
	
	@Resource
	private IFindPaperService findpaper;
@RequestMapping(value="/addQuestion",method=RequestMethod.POST)
@ResponseBody
public Map<String, String> addQuestion(@RequestBody List<ChoiceQuestion> choiceQuestion,String teacherName,String title){
	String Ititle = org.springframework.web.util.HtmlUtils.htmlEscape(title);
	String IteacherName = org.springframework.web.util.HtmlUtils.htmlEscape(teacherName);
	Map<String, String> map = new HashMap<>();
	//System.out.print(choiceQuestion.size());
	if("".equals(teacherName)||"".equals(title)||choiceQuestion.size()==0){
		map.put("message","请完整填写数据!");
		return map;
	}
	if(findpaper.addQuestion(choiceQuestion,IteacherName,Ititle)){
		map.put("message","提交成功!");
		return map;
	}
	map.put("message","提交失败!");
	return map;
	
}

@RequestMapping("/toAddQuestion")
public String toAddQuestion(){
	return "teacher/addQuestion";
}
}
