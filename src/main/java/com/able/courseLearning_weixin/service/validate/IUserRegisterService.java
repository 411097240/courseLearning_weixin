package com.able.courseLearning_weixin.service.validate;

import com.able.courseLearning_weixin.common.pojo.AllUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserRegisterService {
    String doRegister(AllUser user,HttpServletRequest request,HttpServletResponse response);
}
