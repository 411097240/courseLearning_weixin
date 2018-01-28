package com.able.courseLearning_weixin.redis.common;

import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
@Controller
public class RedisForUserLocation {
    @Resource
    private JedisPool jedisPool;//注入JedisPool
    //保存用户地理位置
    public void saveUserLocation(String openId,String longitude,String latitude){
        String key = RedisUtil.userLocation + openId;
        Jedis jedis = jedisPool.getResource();
        //根据键值获得数据
        String result = jedis.set(key,longitude+","+latitude);
        System.out.print("保存key结果："+result);
        jedis.close();

    }
}
