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
<script type="text/javascript">
	$(function(){
		jsonarray = $('#jsonarray').val();
		jsonObj = eval("("+jsonarray+")");
		console.log(jsonObj);
		console.log(jsonObj[0].userPaper.length);
		var html="";
		for(var i=0;i<jsonObj[0].userPaper.length;i++){
			html='<div class="subject-title">试卷编号：'+jsonObj[0].userPaper[i].paperId
			+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;试卷名称：'+jsonObj[0].examPaper[i].title
			+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考试人：'+jsonObj[0].userPaper[i].openId
			+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出题老师：'+jsonObj[0].examPaper[i].teacherName
			+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="viewPaper?openId='+jsonObj[0].userPaper[i].openId
			+'&paperId='+jsonObj[0].userPaper[i].paperId+'">开始改卷</a>'
			+'</div>'+html;
		}
		$('.contentArea').html(html);
	});
</script>
    <div class="my-container">
        <div class="my-header">
           <div class="subject-title black">
           <center>
           	你好${sessionScope.userName}，这里是教师端！
               <a href="findPaperNotCorrecting?classId=${classId}">待批改的练习题</a>
               <a href="toAddQuestion">新建练习题</a>
            </center>
           </div>           
        </div>
        <div class="nk-main  clearfix">
            <div class="subject-progress">        
            </div>
         <div class="contentArea">
         	
 
        </div>
           
    </div>
</body>
 <input  type="hidden" id="jsonarray" value= ${jsonarray}> 
</html>