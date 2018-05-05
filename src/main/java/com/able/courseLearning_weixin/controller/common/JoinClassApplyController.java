package com.able.courseLearning_weixin.controller.common;

import com.able.courseLearning_weixin.common.dto.JoinClassApplyDto;
import com.able.courseLearning_weixin.dao.common.IClassDao;
import com.able.courseLearning_weixin.dao.common.IClassUnionStudentDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class JoinClassApplyController {
    @Resource
    private IClassDao classDao;
    @Resource
    private IClassUnionStudentDao classUnionStudentDao;
    @RequestMapping("toApply")
    public ModelAndView toApply(Integer classId){
        ModelAndView mav = new ModelAndView();
        List<JoinClassApplyDto> joinClassApplyDtoList = classDao.findApplyMessage(classId,0);
        if (joinClassApplyDtoList != null && joinClassApplyDtoList.size() > 0){
            mav.addObject("listSize",joinClassApplyDtoList.size());
        }else{
            mav.addObject("listSize",0);
        }
        mav.addObject("joinClassApplyDtoList",joinClassApplyDtoList);
        mav.setViewName("admin/apply");
        return mav;
    }

    @RequestMapping("studentList")
    public ModelAndView studentList(Integer classId){
        ModelAndView mav = new ModelAndView();
        List<JoinClassApplyDto> joinClassApplyDtoList = classDao.findApplyMessage(classId,1);
        if (joinClassApplyDtoList != null && joinClassApplyDtoList.size() > 0){
            mav.addObject("listSize",joinClassApplyDtoList.size());
        }else{
            mav.addObject("listSize",0);
        }
        mav.addObject("joinClassApplyDtoList",joinClassApplyDtoList);
        mav.setViewName("admin/studentList");
        return mav;
    }

    @RequestMapping("updateSginStatus")
    public ModelAndView updateSginStatus(Integer classId,String openId){
        ModelAndView mav = new ModelAndView();
        classUnionStudentDao.updateStudentStatus(openId,classId);
        mav.setViewName("admin/apply");
        return mav;
    }

}
