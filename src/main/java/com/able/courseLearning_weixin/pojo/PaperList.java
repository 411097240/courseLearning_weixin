package com.able.courseLearning_weixin.pojo;

import java.util.List;

//多张试卷对应多个用户
public class PaperList {
	private List<UserPaper> userPaper;
	private List<ExamPaper> examPaper;
	public List<UserPaper> getUserPaper() {
		return userPaper;
	}
	public void setUserPaper(List<UserPaper> userPaper) {
		this.userPaper = userPaper;
	}
	public List<ExamPaper> getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(List<ExamPaper> examPaper) {
		this.examPaper = examPaper;
	}
	
}
