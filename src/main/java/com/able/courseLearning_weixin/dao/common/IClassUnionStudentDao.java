package com.able.courseLearning_weixin.dao.common;

import com.able.courseLearning_weixin.common.pojo.ClassUnionStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClassUnionStudentDao {
    //学生入班申请
    Integer insertStudentToClass(Integer classId, String openId);
    //老师同意学生入班
    Integer updateStudentStatus(String openId,Integer classId);
    //得到班级下的所有学生
    List<ClassUnionStudent> findStudentByClassId(Integer classId);
    //通过openId，classId得到学生信息是否同意入班
    List<ClassUnionStudent> findStudentStatus(Integer classId,String openId);
}
