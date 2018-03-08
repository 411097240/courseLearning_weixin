package com.able.courseLearning_weixin.controller.validate;

import com.able.courseLearning.weixin.pojo.AccessToken;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import com.able.courseLearning_weixin.dao.common.IClassUnionStudentDao;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.redis.common.RedisForUserLocation;
import com.able.courseLearning_weixin.service.validate.IUserRegisterService;
import com.sun.deploy.net.HttpResponse;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.able.courseLearning.weixin.util.WeixinUtil.httpRequest;

@Controller
public class TestController {
    @Resource
    IUserRegisterDao userRegisterDao;
    @Resource
    IUserRegisterService userRegisterService;
    @Resource
    IClassDao classDao;
    @Resource
    IClassUnionStudentDao classUnionStudentDao;
    @Resource
    RedisForUserLocation redisForUserLocation;
    @Autowired
    private JedisPool jedisPool;//注入JedisPool
    /**
     * 获取用户登陆openid方法
     */
    private static final String APPID = "wx80b64e9d27d59167";   //小程序的APPID
    private static final String APPSECRET = "758a6b933f567cfdb1585e75876faf29"; //小程序的appsecret
    private static final String OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret" +
            "=SECRET&js_code=JSCODE&grant_type=authorization_code";//获取openid的地址
    @RequestMapping("test")
    @ResponseBody
    public Object test(Integer classId){
        //return classUnionStudentDao.findStudentStatus(1,"123456");
       // Jedis jedis = jedisPool.getResource();
        //根据键值获得数据
       // String result = jedis.get("key1");
       // jedis.close();
      //  return result;

        redisForUserLocation.saveUserLocation("1","1","1");
        return 1;
    }

    @ResponseBody
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public Object test1(String userName,String schoolCode,HttpServletRequest request, HttpServletResponse response){
         AllUser user = new AllUser();
         user.setSchoolCode(schoolCode);
         user.setRealName(userName);
         return userRegisterService.doRegister(1,user,request,response);

    }

    @ResponseBody
    @RequestMapping("getOpenId")
    public Map<String ,String> getOpenId(String Code){

        String url = OPENID_URL.replace("APPID",APPID).replace("SECRET",APPSECRET).replace("JSCODE",Code);
        Map<String,String> map = new HashMap<>();
        JSONObject jsonObject = TestController.doGetStr(url);   //调取Get提交方法

        String OpenId = jsonObject.getString("openid"); //获取openid
        System.out.println(OpenId);
        map.put("openId",OpenId);
        return map;
    }
    /**
     * get请求
     * @param url
     * @return
     */
    public static JSONObject doGetStr(String url){

        JSONObject jsonObject = httpRequest(url, "GET", null);
        return jsonObject;
    }
}
