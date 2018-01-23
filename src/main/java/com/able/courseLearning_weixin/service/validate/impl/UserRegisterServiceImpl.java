package com.able.courseLearning_weixin.service.validate.impl;

import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.IUserRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Service("userRegisterService")
public class UserRegisterServiceImpl implements IUserRegisterService {
    @Resource
    IUserRegisterDao userRegisterDao;

    @Override
    public String doRegister(AllUser user,HttpServletRequest request,HttpServletResponse response) {
        String openId = user.getOpenId();
        //判断user表中是否有信息
        Integer countUser = userRegisterDao.selectUserByOpenId(openId);
        if(countUser>0){
            //存在，查询该生申请的班级信息，看是否通过审核
            return "班级已存在";
        }else{
            if(openId!=null){
                user.setOpenId(openId);
                Integer count = userRegisterDao.insertUser(user);
                if(count > 0){
                    return "申请已提交，等待老师审核！";
                }else{
                    return "申请提交失败！";
                }
            }else{
                return "获取微信openId失败，请稍后再试！";
            }

        }
    }
}
