<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
</head>
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<link href="css/studentIndex.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<body>
    <div class="my-container">
        <div class="my-header">
           <div class="subject-title black">
           <center>
           	你好${sessionScope.userName}，这里是学生端！
           	<a href="getPaper?userName=${sessionScope.userName}&state=0">未完成考试</a>
            <a href="getPaper?userName=${sessionScope.userName}&state=1">历史考试分数</a>
            </center>
           </div>           
        </div>
        <div class="nk-main  clearfix">
            </div>
    </div>
</body>
</html>