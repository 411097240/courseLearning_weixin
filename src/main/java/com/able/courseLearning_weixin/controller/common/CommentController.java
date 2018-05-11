package com.able.courseLearning_weixin.controller.common;

import com.able.courseLearning.weixin.pojo.SNSUserInfo;
import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.dto.CommentDto;
import com.able.courseLearning_weixin.common.pojo.ClassModel;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import com.able.courseLearning_weixin.dao.common.ICommentDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Resource
    private ICommentDao commentDao;
    @Resource
    private IClassDao classDao;
    @RequestMapping("createComment")
    public ModelAndView createComment(HttpServletRequest request){
        HttpSession session  = request.getSession();
        String teacherName = (String) session.getAttribute("userName");
        Integer classId = classDao.findClassIdByteacherName(teacherName);
        ModelAndView mav = new ModelAndView();
        mav.addObject("classId",classId);
        mav.addObject("teacherName",teacherName);
        mav.setViewName("admin/createComment");
        return mav;
    }
    @RequestMapping("addComment")
    @ResponseBody
    public Object addComment(Integer classId,String title,String teacherName){
        Map<String,Object> map = new HashMap<>();
        try {
            if(commentDao.insertComment(classId,title,teacherName)>0){
                map.put("status","1");
                return map;
            }
            map.put("status","0");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","0");
            return map;
        }
    }
    @RequestMapping("toH5CommentList")
    public ModelAndView toH5CommentList(HttpServletRequest request, HttpServletResponse response){
        String openId = null;
        SNSUserInfo snsUserInfo = null;
        List<CommentDto> commentDtoList = new ArrayList<>();
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
            snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
        }
        List<ClassModel> classModelList = classDao.findClassByOpenId(openId);
        if(classModelList != null && classModelList.size() > 0 ){
            for(int i= 0;i<classModelList.size();i++){
                Integer classId = classModelList.get(i).getId();
                List<CommentDto> commentDtoList1 = commentDao.findCommentlistByClassId(classId);
                commentDtoList.addAll(commentDtoList1);
            }

        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("commentDtoList",commentDtoList);
        mav.addObject("openId",openId);
        mav.setViewName("h5/commentList");
        return mav;
    }
    @RequestMapping("commentDetailList")
    public ModelAndView commentDetailList(Integer commentId,String openId){
        ModelAndView mav = new ModelAndView();
        List<CommentDto> commentDtoList = commentDao.findCommentDetailList(commentId);
        mav.addObject("commentDtoList",commentDtoList);
        mav.addObject("commentId",commentId);
        mav.addObject("openId",openId);
        mav.setViewName("h5/commentDetailList");
        return mav;
    }

    @RequestMapping("submitComment")
    @ResponseBody
    public Object submitComment(String comment,String openId,Integer commentId){
        Map<String,Object> map = new HashMap<>();
        try {
            if(commentDao.studentInsertComment(comment,openId,commentId)>0){
                map.put("status","1");
                return map;
            }
            map.put("status","0");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","0");
            return map;
        }
    }
}
