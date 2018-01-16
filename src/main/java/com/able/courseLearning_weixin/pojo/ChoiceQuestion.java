package com.able.courseLearning_weixin.pojo;
//选择题表实体类
public class ChoiceQuestion {
	private int cqId;
	//问题
	private String cqQuestion;
	//选项
	private String cqOne;
	private String cqTwo;
	private String cqThree;
	private String cqFour;
	//问题类型 0：选择题 1：问答题
	private int cqQuestionType;
	private int cqPaperId;
	//每题分数
	private int cqScorePre;
	public int getCqId() {
		return cqId;
	}
	public void setCqId(int cqId) {
		this.cqId = cqId;
	}
	public String getCqQuestion() {
		return cqQuestion;
	}
	public void setCqQuestion(String cqQuestion) {
		this.cqQuestion = cqQuestion;
	}
	public String getCqOne() {
		return cqOne;
	}
	public void setCqOne(String cqOne) {
		this.cqOne = cqOne;
	}
	public String getCqTwo() {
		return cqTwo;
	}
	public void setCqTwo(String cqTwo) {
		this.cqTwo = cqTwo;
	}
	public String getCqThree() {
		return cqThree;
	}
	public void setCqThree(String cqThree) {
		this.cqThree = cqThree;
	}
	public String getCqFour() {
		return cqFour;
	}
	public void setCqFour(String cqFour) {
		this.cqFour = cqFour;
	}
	
	public int getCqQuestionType() {
		return cqQuestionType;
	}
	public void setCqQuestionType(int cqQuestionType) {
		this.cqQuestionType = cqQuestionType;
	}
	public int getCqPaperId() {
		return cqPaperId;
	}
	public void setCqPaperId(int cqPaperId) {
		this.cqPaperId = cqPaperId;
	}
	public int getCqScorePre() {
		return cqScorePre;
	}
	public void setCqScorePre(int cqScorePre) {
		this.cqScorePre = cqScorePre;
	}
	
	
}
