package com.able.courseLearning_weixin.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class StudentSginController {
    @RequestMapping(value = "toStudentSgin",method = RequestMethod.GET)
    public ModelAndView toStudentSgin(){
        ModelAndView mav = new ModelAndView("h5/vip");
        return mav;
    }
}
