package com.able.courseLearning_weixin.validate;

import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.AllUser;
import com.able.courseLearning_weixin.dao.validate.IUserRegisterDao;
import com.able.courseLearning_weixin.service.validate.impl.IUserRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Service("userRegisterService")
public class UserRegisterServiceImpl implements IUserRegisterService{
    @Resource
    IUserRegisterDao userRegisterDao;

    @Override
    public String doRegister(AllUser user,HttpServletRequest request,HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //response.setCharacterEncoding("utf-8");
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String AppId="wxfc8eae6dd688043e";
        String appsecret="103d37579877c2a4e8a9b6b76b4b54bc";
        System.out.println(code);
        System.out.println(state);

        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(AppId,
                    appsecret, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            String openId = weixinOauth2Token.getOpenId();
            System.out.print("openId:"+openId);
        }
        //判断user表中是否有信息
//        Integer countUser = userRegisterDao.selectUserByOpenId(user.getOpenId());
//        if(countUser>0){
//            //存在，查询该生申请的班级信息，看是否通过审核
//        }else{
//            //得到openId
//            AdvancedUtil.getOauth2AccessToken("1","","");
//            Integer count = userRegisterDao.insertUser(user);
//            if(count > 0){
//                return "申请已提交，等待老师审核！";
//            }
//        }
        return null;
    }
}
