package com.able.courseLearning_weixin.dao.common;

import com.able.courseLearning_weixin.common.pojo.ClassModel;

import java.util.List;

public interface IClassDao {
    //得到所有班级信息
    List<ClassModel> findAllClass();
    //通过openId得到审核已通过的班级信息
    List<ClassModel> findClassByOpenId(String openId);
    //通过老师名字得到classId
    Integer findClassIdByteacherName(String teacherNAme);
}
