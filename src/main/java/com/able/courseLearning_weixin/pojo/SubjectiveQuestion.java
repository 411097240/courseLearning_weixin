package com.able.courseLearning_weixin.pojo;

public class SubjectiveQuestion {
	private int sqId;
	//问题
	private String sqQuestion;
	//答案
	private String sqAnswer;
	//问题类型 0：选择题 1：问答题
	private int sqQuestionType;
	//试卷id
	private int sqPaperId;
	//每题分数
	private int sqScorePre;
	public int getSqId() {
		return sqId;
	}
	public void setSqId(int sqId) {
		this.sqId = sqId;
	}
	public String getSqQuestion() {
		return sqQuestion;
	}
	public void setSqQuestion(String sqQuestion) {
		this.sqQuestion = sqQuestion;
	}
	public String getSqAnswer() {
		return sqAnswer;
	}
	public void setSqAnswer(String sqAnswer) {
		this.sqAnswer = sqAnswer;
	}
	public int getSqQuestionType() {
		return sqQuestionType;
	}
	public void setSqQuestionType(int sqQuestionType) {
		this.sqQuestionType = sqQuestionType;
	}
	public int getSqPaperId() {
		return sqPaperId;
	}
	public void setSqPaperId(int sqPaperId) {
		this.sqPaperId = sqPaperId;
	}
	public int getSqScorePre() {
		return sqScorePre;
	}
	public void setSqScorePre(int sqScorePre) {
		this.sqScorePre = sqScorePre;
	}
	
}
