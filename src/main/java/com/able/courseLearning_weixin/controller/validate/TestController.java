package com.able.courseLearning_weixin.controller.validate;

import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.impl.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @Resource
    IUserRegisterDao userRegisterDao;
    @Resource
    IUserRegisterService userRegisterService;
    @Autowired
    private ShardedJedisPool shardedJedisPool;//注入ShardedJedisPool
    @ResponseBody
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public Object test(HttpServletRequest request, HttpServletResponse response){
       // return userRegisterService.doRegister(new AllUser(),request,response);
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        //根据键值获得数据
        String result = shardedJedis.get("key2");
        shardedJedis.close();

        return result;
    }
}
