package com.able.courseLearning.weixin.redis.common;

import com.able.courseLearning.weixin.redis.common.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisForUserLocation {
    @Autowired
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
