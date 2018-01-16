package com.able.courseLearning_weixin.pojo;

import java.util.List;

//用户试卷中间表实体类
public class UserPaper {
	private Integer id;
	//用户名
	private String userName;
	//试卷id
	private Integer paperId;
	//试卷分数
	private Integer score;
	//试卷状态
	private Integer state;
	
	public List<ExamPaper> getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(List<ExamPaper> examPaper) {
		this.examPaper = examPaper;
	}
	private List<ExamPaper> examPaper;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
