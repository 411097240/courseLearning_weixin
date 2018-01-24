package com.able.courseLearning_weixin.controller.validate;

import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @Resource
    IUserRegisterDao userRegisterDao;
    @Resource
    IUserRegisterService userRegisterService;
    @Resource
    IClassDao classDao;
    @Autowired
    private JedisPool jedisPool;//注入JedisPool
    @RequestMapping("test")
    @ResponseBody
    public Object test(HttpServletRequest request, HttpServletResponse response){
        return classDao.findAllClass();
        //Jedis jedis = jedisPool.getResource();
        //根据键值获得数据
        //String result = jedis.get("key2");
       // jedis.close();
        //return result;
    }

    @ResponseBody
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public Object test1(String userName,String schoolCode,HttpServletRequest request, HttpServletResponse response){
         AllUser user = new AllUser();
         user.setSchoolCode(schoolCode);
         user.setRealName(userName);
         return userRegisterService.doRegister(user,request,response);

    }
}
