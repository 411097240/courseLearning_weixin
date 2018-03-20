package com.able.courseLearning_weixin.common.util;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class LoginInterceptor implements HandlerInterceptor{
    private final String ADMINSESSION = "userName";
    //拦截前处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        String url = request.getRequestURI();
        //判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
        //这里公开地址是登陆提交的地址
        if(url.indexOf("js")>=0 ||url.indexOf("css")>=0 ||url.indexOf("lib")>=0 ||url.indexOf("images")>=0 ){
            //如果进行登陆提交，放行
            return true;
        }

        //判断session
        HttpSession session  = request.getSession();
        //从session中取出用户身份信息
        String username = (String) session.getAttribute(ADMINSESSION);

        if(username != null){
            //身份存在，放行
            return true;
        }

        //执行这里表示用户身份需要认证，跳转登陆页面
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

        //return false表示拦截，不向下执行
        //return true表示放行
        return false;
    }
    //拦截后处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception { }
    //全部完成后处理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception { }
}
