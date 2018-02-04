package com.able.courseLearning_weixin.service.common;

import com.able.courseLearning_weixin.common.dto.StudentSginDto;

import java.util.List;

public interface IStudentSginService {
    //得到每天的签到列表
    List<StudentSginDto> findSginMessageByDay(String classId);
}