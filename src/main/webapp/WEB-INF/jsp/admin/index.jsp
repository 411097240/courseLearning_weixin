<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>中南民族大学微信端学习交流平台</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="css/x-admin.css?version=2" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header header header-demo">
    <div class="layui-main">
    <div class="admin-logo-box">
				<a class="logo" href="http://www.kuxuebao.net" title="logo">中南民族大学</a>
				<div class="larry-side-menu">
					<i class="fa fa-th-large" aria-hidden="true"></i>
				</div>
			</div>
            <ul class="layui-nav layui-layout-left layui-ygyd-menu" style="position:absolute; left:250px;">
      <!--<li class="layui-nav-item"><a href="">班级信息统计</a></li>-->
              <!--
      <li class="layui-nav-item">
        <a href="">班级管理</a>
        <dl class="layui-nav-child">
          <dd><a href="toApply">入班申请</a></dd>
          <dd><a href="">学生签到</a></dd>
        </dl>
      </li>
      -->
    </ul>
    
      <ul class="layui-nav" lay-filter="">
      <!-- <li class="layui-nav-item">
                        <a href="" title="消息">
                            <i class="layui-icon" style="top: 1px;">&#xe63a;</i>
                        </a>
                        </li> -->
        <li class="layui-nav-item"><img src="images/logo.png" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" alt=""></li>
        <li class="layui-nav-item"> <a href="javascript:;"> ${sessionScope.userName}</a>
          <dl class="layui-nav-child">
            <dd><a href="loginOut?userName=${sessionScope.userName}">退出</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  <div class="layui-side layui-bg-black x-side" style="left:0px;">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe606;</i><cite>评论管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="./comment-list.html"> <cite>评论列表</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="./feedback-list.html"> <cite>意见反馈</cite> </a> </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>班级管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class=""> <a href="javascript:;" _href="studentList?classId=${classId}"> <cite>已入班学生</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="toApply?classId=${classId}"> <cite>入班审核</cite> </a> </dd>
            <dd class=""> <a href="javascript:;" _href="studentSgin"> <cite>签到管理</cite> </a> </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe642;</i><cite>课后练习题</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="toAddQuestion"> <cite>创建批改练习题</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item" style="height: 30px; text-align: center"> </li>
      </ul>
    </div>
  </div>
  <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true" style="left: 200px;border-left: solid 2px #2299ee;">
    <ul class="layui-tab-title">
      <li class="layui-this"> 我的桌面 <i class="layui-icon layui-unselect layui-tab-close">ဆ</i> </li>
    </ul>
    <div class="layui-tab-content site-demo site-demo-body">
      <div class="layui-tab-item layui-show">
        <iframe frameborder="0" src="toWelcome" class="x-iframe" scrolling="yes"></iframe>
      </div>
    </div>
  </div>
  <div class="site-mobile-shade"> </div>
</div>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="js/x-admin.js?version=1"></script>
</body>
</html>