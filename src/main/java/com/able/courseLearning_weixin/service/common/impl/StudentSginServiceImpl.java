package com.able.courseLearning_weixin.service.common.impl;

import com.able.courseLearning_weixin.common.dto.StudentSginDto;
import com.able.courseLearning_weixin.common.util.DateUtil;
import com.able.courseLearning_weixin.dao.common.IStudentSginDao;
import com.able.courseLearning_weixin.service.common.IStudentSginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service("studentSginService")
public class StudentSginServiceImpl implements IStudentSginService {
    @Resource
    private IStudentSginDao studentSginDao;
    @Override
    public List<StudentSginDto> findSginMessageByDay(String classId) {
        Date day=new Date();
        String time = DateUtil.tranDate(day,"yyyy-MM-dd");
        String startTime = time + " 00:00:00";
        String endTime = time +" 23:59:59";
        System.out.println("-------------------endTime:"+endTime);
        return studentSginDao.findSginMessageByDay(classId,startTime,endTime);
    }
}
