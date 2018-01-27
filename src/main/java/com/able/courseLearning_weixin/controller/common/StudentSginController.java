package com.able.courseLearning_weixin.controller.common;

import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.pojo.ClassModel;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class StudentSginController {
    @Resource
    private IClassDao classDao;
    @RequestMapping(value = "toStudentSgin",method = RequestMethod.GET)
    public ModelAndView toStudentSgin(HttpServletRequest request, HttpServletResponse response){
        String openId = null;
        //得到openId
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
            openId = weixinOauth2Token.getOpenId();
            System.out.print("openId:"+openId);
        }
        List<ClassModel> classModelList = classDao.findClassByOpenId(openId);
        ModelAndView mav = new ModelAndView("h5/classList");
        mav.addObject("classModelList",classModelList);
        return mav;
    }

    @RequestMapping(value = "toSginDetail",method = RequestMethod.GET)
    public ModelAndView sginDetail(HttpServletRequest request, HttpServletResponse response){
        System.out.print("hello");
        ModelAndView mav = new ModelAndView("h5/sginDetail");
        return mav;
    }
}
