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
<script type="text/javascript">
$(function(){
	jsonarray = $('#jsonarray').val();
	jsonObj = eval("("+jsonarray+")");
	//console.log(jsonObj.length);
	 function console(jsonObj){
	        var html = [];
	        var index = 0;
	        for(var i=jsonObj.length-1;i>=0;i--,index++){ 
	          html[index] = ' <div class="subject-title">试卷编号:'+jsonObj[i].examPaper[0].id
	              +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;试卷名:'+jsonObj[i].examPaper[0].title
	              +'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出题老师:'+jsonObj[i].examPaper[0].teacherName
	              if(jsonObj[i].state==0){
	                html[index] = html[index] + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=beginTest?paperId='+jsonObj[i].examPaper[0].id+'>开始考试</a>:';
	              }else if(jsonObj[i].score==-1){
	                html[index] = html[index] + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考试成绩:等待老师批阅';
	              }else{
	            	  html[index] = html[index] + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考试成绩:'+jsonObj[i].score; 
	              }
	              html[index] = html[index] +'</div> ';      
	        }
	        return html.join("");
	    }

	    var html = console(jsonObj);
	$('.message').append(html);
});
	
</script>
<body>
    <div class="my-container">
        <div class="my-header">
        <center>
           <div class="subject-title black">你好${sessionScope.userName}，这里是学生端！
           	<a href="getPaper?userName=${sessionScope.userName}&state=0">未完成考试</a>
            <a href="getPaper?userName=${sessionScope.userName}&state=1">历史考试分数</a>
           </div>  
           </center>         
        </div>
        <div class="nk-main  clearfix">
            <div class="subject-progress">
           
            </div>
            <div class="subject-title">
                   	我的考试信息
            </div>
            <div class="subject-title  message">
                  
             </div>
          
        </div>
    </div>
</body>
 <input value=${jsonarray} type="hidden" id="jsonarray"> 
</html>