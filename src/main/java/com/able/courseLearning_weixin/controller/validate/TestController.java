package com.able.courseLearning_weixin.controller.validate;

import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.impl.IUserRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @Resource
    IUserRegisterDao userRegisterDao;
    @Resource
    IUserRegisterService userRegisterService;
    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object test(HttpServletRequest request, HttpServletResponse response){
        return userRegisterService.doRegister(new AllUser(),request,response);
    }
}
