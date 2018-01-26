package com.able.courseLearning_weixin.service.validate.impl;

import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.common.pojo.ClassUnionStudent;
import com.able.courseLearning_weixin.dao.common.IClassUnionStudentDao;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.IUserRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service("userRegisterService")
public class UserRegisterServiceImpl implements IUserRegisterService {
    @Resource
    IUserRegisterDao userRegisterDao;
    @Resource
    IClassUnionStudentDao classUnionStudentDao;

    @Override
    public String doRegister(Integer classId,AllUser user,HttpServletRequest request,HttpServletResponse response) {
        String openId = user.getOpenId();
        //判断user表中是否有信息
        Integer countUser = userRegisterDao.selectUserByOpenId(openId);
        if(countUser>0){
            //存在，查询该生申请的班级信息，看是否通过审核
            List<ClassUnionStudent> studentLists =  classUnionStudentDao.findStudentStatus(classId,openId);
            if(studentLists != null && studentLists.size() > 0){
                Integer status = studentLists.get(0).getIsChecked();
                if(status == 0){
                    return "3";
                }else{
                    return "4";
                }
            }else{
                Integer rows = classUnionStudentDao.insertStudentToClass(classId,openId);
                if(rows > 0) {
                    return "5";
                }else{
                    return "6";
                }
            }
        }else{
            if(openId!=null){
                user.setOpenId(openId);
                Integer count = userRegisterDao.insertUser(user);
                Integer rows = classUnionStudentDao.insertStudentToClass(classId,openId);
                if(count > 0 && rows > 0){
                    return "7";
                }else{
                    return "8";
                }
            }else{
                return "9";
            }

        }
    }
}
