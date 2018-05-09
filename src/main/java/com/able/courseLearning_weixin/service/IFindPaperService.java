package com.able.courseLearning_weixin.service;


import java.util.List;

import com.able.courseLearning_weixin.pojo.ChoiceQuestion;
import com.able.courseLearning_weixin.pojo.QuestionAnswer;
import com.alibaba.fastjson.JSONArray;

public interface IFindPaperService {
	//通过用户名和state找试卷信息
	JSONArray findPaper(String openId,int state);
	//通过试卷id找到试卷所有题目
	JSONArray  findExamPaperByPaperId(int paperId);
	//判断是否提交试卷成功
	boolean isSubmit(List<QuestionAnswer> answerlist);
	//通过用户名和试卷id查询答案表，判断用户是否已经提交过卷子
	boolean cheakSubmit(String openId,int paperId);
	//教师端通过试卷分数（-1）找到所有未批改的试卷
	JSONArray  findPaperListNotCorrecting(int classId);
	//指定用户和试卷id的所有选择题答案信息
	JSONArray  findSubmitPaperMessage(String openId,int paperId);
	//提交试卷成绩
	boolean submitScore(String userName,int paperId,int totalScore);
	//学生提交试卷时将user_paper表的state更新为1,score更新为-1
	boolean updateUserPaper(String openId,int paperId);
	//老师生成试卷
	boolean addQuestion(List<ChoiceQuestion> choiceQuestion,String teacherName,String title);
	
}
