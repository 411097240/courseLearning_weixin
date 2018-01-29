package com.able.courseLearning_weixin.dao.common;

public interface IStudentSginDao {
    //插入学生签到信息
    Integer insertStudentSgin(String headImgUrl,String openId,String location,Integer classId);
}
