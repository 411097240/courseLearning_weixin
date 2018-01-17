package com.able.courseLearning_weixin.controller;

import com.able.courseLearning.weixin.util.CoreService;
import com.able.courseLearning.weixin.util.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ConfirmService extends HttpServlet {
    @RequestMapping(value = "/checkService",method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 微信加密签名
         */
        String signature = request.getParameter("signature");
        /**
         * 时间戳
         */
        String timestamp = request.getParameter("timestamp");
        /**
         * 随机数
         */
        String nonce = request.getParameter("nonce");
        /**
         *  随机字符串
         */
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        System.out.println(signature+"  "+timestamp+"  "+nonce+"  "+echostr);

        /**
         * 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
         */

        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }

        out.close();
        out = null;


    }

    /**
     * 处理微信服务器发来的消息
     */
    @RequestMapping(value = "/checkService",method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String respXml = CoreService.processRequest(request,response);
        PrintWriter out = response.getWriter();
        //out.print()和out.write()都可以输出字符串，但是当字符为空时，print输出null，write抛出异常
        out.print(respXml);
        out.close();
    }

}
