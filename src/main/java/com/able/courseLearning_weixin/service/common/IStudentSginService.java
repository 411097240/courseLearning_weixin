package com.able.courseLearning_weixin.service.common;

import com.able.courseLearning_weixin.common.dto.StudentSginDto;

import java.util.List;

public interface IStudentSginService {
    //得到每天的签到列表
    List<StudentSginDto> findSginMessageByDay(String classId);
    /**
     * 插入签到数据，每个人一天只有一条，再次签到更新第一次的记录
    * */
    Integer insertStudentSgin(String headImgUrl,String openId,String longitude,String latitude,Integer classId);
}