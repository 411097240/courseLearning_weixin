package com.able.courseLearning_weixin.dao.common;

import com.able.courseLearning_weixin.common.pojo.ClassModel;

import java.util.List;

public interface IClassDao {
    //得到所有班级信息
    List<ClassModel> findAllClass();
}
