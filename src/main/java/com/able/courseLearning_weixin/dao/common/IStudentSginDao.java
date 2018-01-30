package com.able.courseLearning_weixin.dao.common;


import com.able.courseLearning_weixin.common.dto.StudentSginDto;

import java.util.List;

public interface IStudentSginDao {
    //插入学生签到信息
    Integer insertStudentSgin(String headImgUrl,String openId,String longitude,String latitude,Integer classId);
    //得到班级的签到信息（每天的）
    List<StudentSginDto> findSginMessageByDay(String classId, String startTime, String endTime);

}
