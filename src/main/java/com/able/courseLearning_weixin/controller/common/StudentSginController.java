package com.able.courseLearning_weixin.controller.common;

import com.able.courseLearning.weixin.pojo.SNSUserInfo;
import com.able.courseLearning.weixin.pojo.WeixinOauth2Token;
import com.able.courseLearning.weixin.util.AdvancedUtil;
import com.able.courseLearning_weixin.common.dto.StudentSginDto;
import com.able.courseLearning_weixin.common.pojo.ClassModel;
import com.able.courseLearning_weixin.common.util.DateUtil;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import com.able.courseLearning_weixin.dao.common.IStudentSginDao;
import com.able.courseLearning_weixin.redis.common.RedisForUserLocation;
import com.able.courseLearning_weixin.service.common.IStudentSginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class StudentSginController {
    @Resource
    private IClassDao classDao;
    @Resource
    IStudentSginDao studentSginDao;
    @Resource
    IStudentSginService studentSginService;
    @Resource
    RedisForUserLocation redisForUserLocation;
    @RequestMapping(value = "toStudentSgin",method = RequestMethod.GET)
    public ModelAndView toStudentSgin(HttpServletRequest request, HttpServletResponse response){
        String openId = null;
        SNSUserInfo snsUserInfo = null;
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
        ModelAndView mav = new ModelAndView("h5/classList");
        mav.addObject("classModelList",classModelList);
        mav.addObject("openId",openId);
        mav.addObject("snsUserInfo",snsUserInfo);
        return mav;
    }

    @RequestMapping(value = "toSginDetail")
    public ModelAndView sginDetail(String classId){
        String className =null;
        List<String> Longitude = new ArrayList<String>();
        List<String> Latitude = new ArrayList<String>();
        List<StudentSginDto> StudentSginDtoList = new ArrayList<StudentSginDto>();
        List<StudentSginDto> StudentSginDto = studentSginService.findSginMessageByDay(classId);
        ModelAndView mav = new ModelAndView("h5/sginDetail");
        if(StudentSginDto!=null&&StudentSginDto.size()>0){
            className = StudentSginDto.get(0).getClassName();
            for(int i = 0;i<StudentSginDto.size();i++){
                StudentSginDto studentSginDto = new StudentSginDto();
                studentSginDto.setRealName(StudentSginDto.get(i).getRealName());
                studentSginDto.setHeadImgUrl(StudentSginDto.get(i).getHeadImgUrl());
                Date time = StudentSginDto.get(i).getCreateTime();
                String sginTime = DateUtil.tranDate(time,"HH:mm:ss");
                studentSginDto.setSginTime(sginTime);
                studentSginDto.setSchoolCode(StudentSginDto.get(i).getSchoolCode());
                studentSginDto.setLongitude(StudentSginDto.get(i).getLongitude());
                studentSginDto.setLatitude(StudentSginDto.get(i).getLatitude());
                Longitude.add(StudentSginDto.get(i).getLongitude());
                Latitude.add(StudentSginDto.get(i).getLatitude());
                StudentSginDtoList.add(studentSginDto);
            }
        }
        mav.addObject("StudentSginDtoList",StudentSginDtoList);
        mav.addObject("className",className);
        mav.addObject("Longitude",Longitude);
        mav.addObject("Latitude",Latitude);
        return mav;
    }
    //保存用户位置
    @RequestMapping("saveStudentLocation")
    @ResponseBody
    public void saveStudentLocation(String openId,String Longitude,String Latitude){
        redisForUserLocation.saveUserLocation(openId,Longitude,Latitude);
    }

    @RequestMapping("startSgin")
    @ResponseBody
    public Object startSgin(Integer classId,String openId,String headImgUrl){
        System.out.println(classId);
        System.out.println(openId);
        System.out.println(headImgUrl);
        String longitude = null;
        String latitude = null;
        Map<String,String> map = new HashMap<String,String>();
        String location = redisForUserLocation.findUserLocation(openId);
        //如果位置信息为空，签到失败
        if("".equals(location)||null == location){
           map.put("status","2");
           return map;
        }else{
            String[] myLocation = location.split(",");
            longitude = myLocation[0];
            latitude = myLocation[1];
        }
        Integer row = studentSginService.insertStudentSgin(headImgUrl,openId,longitude,latitude,classId);
        if(row > 0){
            map.put("status","1");
        }
        return map;
    }
    @RequestMapping("studentSgin")
    public ModelAndView studentSgin(Integer classId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/studentSgin");
        return mav;
    }
}
