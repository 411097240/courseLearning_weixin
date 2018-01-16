package com.able.courseLearning_weixin.pojo;
//问题答案表实体类
public class QuestionAnswer {
	private int  qaId;
	private String qaUserName;
	//试卷id
	private int qaPaperId;
	//问题type
	private int qaQuestionType;
	//问题id
	private int qaQuestionId;
	//问题答案
	private String qaAnswer;
	public int getQaId() {
		return qaId;
	}
	public void setQaId(int qaId) {
		this.qaId = qaId;
	}
	public String getQaUserName() {
		return qaUserName;
	}
	public void setQaUserName(String qaUserName) {
		this.qaUserName = qaUserName;
	}
	public int getQaPaperId() {
		return qaPaperId;
	}
	public void setQaPaperId(int qaPaperId) {
		this.qaPaperId = qaPaperId;
	}
	public int getQaQuestionType() {
		return qaQuestionType;
	}
	public void setQaQuestionType(int qaQuestionType) {
		this.qaQuestionType = qaQuestionType;
	}
	public int getQaQuestionId() {
		return qaQuestionId;
	}
	public void setQaQuestionId(int qaQuestionId) {
		this.qaQuestionId = qaQuestionId;
	}
	public String getQaAnswer() {
		return qaAnswer;
	}
	public void setQaAnswer(String qaAnswer) {
		this.qaAnswer = qaAnswer;
	}
	

}
