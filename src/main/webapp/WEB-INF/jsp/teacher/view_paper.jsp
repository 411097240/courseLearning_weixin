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
		$('.titleArea').html(jsonObj[0].title);
		html="";
		for(var i=jsonObj[0].choiceQuestion.length-1;i>=0;i--){
			html = '<p>第'+(i+1)+'题、'+jsonObj[0].choiceQuestion[i].cqQuestion+'('+jsonObj[0].choiceQuestion[i].cqScorePre+')分</p>'
					+'<p>第'+(i+1)+'题答案、'+jsonObj[0].questionAnswer[i].qaAnswer+'</p>'
					+'<hr>'
					+html;

		}
		$('.contentArea').html(html);
	});
</script>
    <div class="my-container">
        <div class="my-header">
           <div class="subject-title black">
           <center>
           	你好${sessionScope.userName}，这里是教师端！
           	<a href="findPaperNotCorrecting?score=-1">待批改的试卷</a>
            <a href="toAddQuestion">新建考试试卷</a>
            </center>
           </div>           
        </div>
        <div class="nk-main  clearfix">
            <div class="subject-progress"> 
            	
            </div>
          <center>
          <h1><p class="titleArea"></p></h1>  
          </center>
         <div class="contentArea">
        </div>
       <div class="input-group">
      <input type="text" class="form-control Score" value="" placeholder="试卷得分">
      <span class="input-group-btn">
       <button class="btn btn-success" id="submitForm">提交分数</button>
      </span>
    </div>         
    </div>
</body>
 <input  type="hidden" id="jsonarray" value= ${jsonarray}> 
 <script type="text/javascript">
 //提交分数
 $(function(){
	 $('#submitForm').click(function(){
		 totalScore = $('.Score').val()
		 userName = jsonObj[0].questionAnswer[0].qaUserName;
		 paperId = jsonObj[0].id;  
		 window.location = 'submitScore?userName='+userName+'&paperId='+paperId+'&totalScore='+totalScore+'';
	 });
 });
 
 </script>
</html>