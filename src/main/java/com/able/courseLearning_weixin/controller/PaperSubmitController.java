package com.able.courseLearning_weixin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.able.courseLearning_weixin.pojo.QuestionAnswer;
import com.able.courseLearning_weixin.service.IFindPaperService;

@Controller
public class PaperSubmitController {
	@Resource
	private IFindPaperService findpaper;

	@RequestMapping(value="/submitPaper",method=RequestMethod.POST)
	@ResponseBody
	public String submitPaper(@RequestBody List<QuestionAnswer> questionanswers){
		//System.out.println(questionanswers.get(0).getQaUserName());
		String userName = questionanswers.get(0).getQaUserName();
		int paperId  = questionanswers.get(0).getQaPaperId();
		if("".equals(userName)||null==userName){
			return "请先登陆再完成试卷!";
		}
		if(findpaper.cheakSubmit(userName, paperId)){
			return "你已提交过试卷，请勿重复提交!";
		}
		if(findpaper.isSubmit(questionanswers)&&findpaper.updateUserPaper(userName, paperId)){
			return "试卷提交成功!";
		}
		return "试卷提交失败!";		
	}
	
	@RequestMapping("/submitScore")
	public String submitScore(String userName,String paperId, String totalScore){
		int IPaperId = Integer.parseInt(paperId);
		int ITotalScore = Integer.parseInt(totalScore);
		System.out.println(userName);
		System.out.println(IPaperId);
		System.out.println(ITotalScore);
		if(findpaper.submitScore(userName, IPaperId, ITotalScore)){
			return "teacher/teacherIndex";
		}
		return "err";
	}
}
