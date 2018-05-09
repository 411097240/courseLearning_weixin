package com.able.courseLearning_weixin.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.able.courseLearning_weixin.common.dto.JoinClassApplyDto;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.able.courseLearning_weixin.dao.IExamPaperDAO;
import com.able.courseLearning_weixin.pojo.ChoiceQuestion;
import com.able.courseLearning_weixin.pojo.QuestionAnswer;
import com.able.courseLearning_weixin.pojo.User;
import com.able.courseLearning_weixin.service.IFindPaperService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Service
public class FindPaperServiceImpl implements IFindPaperService{
	@Resource
	private IExamPaperDAO findpaper;
	@Resource
	private IClassDao classDao;
	@Override
	//通过用户名和state找试卷信息
	public JSONArray findPaper(String openId,int state) {
		
	    List<Map<String,String>> ls = findpaper.findExamPaperByUser(openId,state);
		String s = JSON.toJSONString(ls);
		JSONArray jsonArray = JSONArray.parseArray(s);
		System.out.println(jsonArray);		
		return jsonArray;
	}
	
	@Override
	//通过试卷id找到试卷所有题目
	public JSONArray findExamPaperByPaperId(int paperId) {
		List<Map<String,String>> ls = findpaper.findExamPaperByPaperId(paperId);
		String s = JSON.toJSONString(ls);
		JSONArray jsonArray = JSONArray.parseArray(s);
		System.out.println(jsonArray);		
		return jsonArray;
	}

	@Override
	//判断是否试卷提交成功
	public boolean isSubmit(List<QuestionAnswer> answerlist) {
		int count=findpaper.answerInsert(answerlist);
		if(count > 0){
			return true;
		}
		return false;
		
	}

	@Override
	//判断试卷是否重复提交
	public boolean cheakSubmit(String openId, int paperId) {
		int count =findpaper.cheakSubmit(openId, paperId);
		if(count > 0){
			return true;
		}
		return false;
	}
	//老师端找未批改试卷列表
	@Override
	public JSONArray findPaperListNotCorrecting(int classId) {
		List<Map<String,String>> ls = findpaper.findPaperListNotCorrecting(classId);
		String s = JSON.toJSONString(ls);
		JSONArray jsonArray = JSONArray.parseArray(s);
		System.out.println(jsonArray);		
		return jsonArray;
	}
	
	
	//指定用户和试卷id的所有选择题答案信息
	@Override
	public JSONArray findSubmitPaperMessage(String openId, int paperId) {
		List<Map<String,String>> ls = findpaper.findSubmitPaperMessage(openId, paperId);
		String s = JSON.toJSONString(ls);
		JSONArray jsonArray = JSONArray.parseArray(s);
		System.out.println(jsonArray);		
		return jsonArray;
	}
	//提交试卷成绩
	@Override
	public boolean submitScore(String openId, int paperId, int totalScore) {
		if(findpaper.submitScore(openId, paperId, totalScore)>0){
			return true;
		}
		return false;
	}
	//学生提交试卷时将user_paper表的state更新为1,score更新为-1
	@Override
	public boolean updateUserPaper(String openId, int paperId) {
		if(findpaper.updateUserPaper(openId, paperId)>0){
			return true;
		}
		return false;
	}

	
	//老师新建试题
	@Override
	@Transactional  
	public boolean addQuestion(List<ChoiceQuestion> choiceQuestion,String teacherName,String title) {
		//找到数据库最大的paperId
		//System.out.println(findpaper.findMaxPaperId().get(0).getId());
		//批量插入题目
		int maxPaperId = findpaper.findMaxPaperId().get(0).getId()+1;
		for(int i=0;i<choiceQuestion.size();i++){
		choiceQuestion.get(i).setCqPaperId(maxPaperId);
		}
		Integer classId = classDao.findClassIdByteacherName(teacherName);
		//在试卷表添加一张试卷信息
		int count = findpaper.insertPaper(teacherName,title,maxPaperId,classId);
		//新增用户试卷关联表user_paper数据,先找到学生用户再批量更新
		//找到所有通过申请的学生
		List<JoinClassApplyDto> joinClassApplyDtoList = classDao.findApplyMessage(classId,1);
		int num = findpaper.insertUserPaper(joinClassApplyDtoList, maxPaperId);
		if(findpaper.questionInsert(choiceQuestion)>0&&count>0&&num>0)
		return true;
		return false;
	}

	

}
