package com.able.courseLearning_weixin.pojo;

import java.util.List;

public class ExamPaper {
	private Integer id;
	//试卷题目
	private String title;
	//出题老师
	private String teacherName;
	//一对多关系
	private List <User> user;
	//一张试卷对应多个题目
	private List<ChoiceQuestion> choiceQuestion;
	private List<SubjectiveQuestion> subjectiveQuestion;
	//一张试卷多个用户状态
	private List<UserPaper> userPaper;
	//一份试卷多个答案
	private List<QuestionAnswer> questionAnswer;
	public List<QuestionAnswer> getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(List<QuestionAnswer> questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public List<UserPaper> getUserPaper() {
		return userPaper;
	}
	public void setUserPaper(List<UserPaper> userPaper) {
		this.userPaper = userPaper;
	}
	public List<SubjectiveQuestion> getSubjectiveQuestion() {
		return subjectiveQuestion;
	}
	public void setSubjectiveQuestion(List<SubjectiveQuestion> subjectiveQuestion) {
		this.subjectiveQuestion = subjectiveQuestion;
	}
	public List<User> getUser() {
		return user;
	}
	public List<ChoiceQuestion> getChoiceQuestion() {
		return choiceQuestion;
	}
	public void setChoiceQuestion(List<ChoiceQuestion> choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
}
