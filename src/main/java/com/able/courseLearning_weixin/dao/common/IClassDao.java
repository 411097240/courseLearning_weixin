package com.able.courseLearning_weixin.dao.common;

import com.able.courseLearning_weixin.common.dto.JoinClassApplyDto;
import com.able.courseLearning_weixin.common.pojo.ClassModel;

import java.util.List;

public interface IClassDao {
    //得到所有班级信息
    List<ClassModel> findAllClass();
    //通过openId得到审核已通过的班级信息
    List<ClassModel> findClassByOpenId(String openId);
    //通过老师名字得到classId
    Integer findClassIdByteacherName(String teacherName);
    /**
     *classId得到通过通过审核和未通过审核的学生人数（type 1：通过审核人数 0：未通过审核人数）
     */
    Integer findStudentCountByclassId(Integer classId,Integer type);
    /**
     *classId得到班级基本信息
     */
    ClassModel findClassMessageByClassId(Integer classId);
    /**
     *获取学生入班信息(0:未通过审核 1：已通过审核)
     */
    List<JoinClassApplyDto> findApplyMessage(Integer classId,Integer type);
}
