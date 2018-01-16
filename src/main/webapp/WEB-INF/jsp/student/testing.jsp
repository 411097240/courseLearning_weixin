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
//得到卷子信息json串，处理拼接字符串
	$(function(){
		var jsonarray = $('#jsonarray').val();
		jsonObj = eval('('+jsonarray+')');
		var html="";
		var count = jsonObj[0].choiceQuestion.length;
		//alert(jsonObj[0].choiceQuestion[0].cqQuestion);
		for(var i=count-1;i>=0;i--){
			html = '<div class="subject-title">[选择题]'+(i+1)+'、'+jsonObj[0].choiceQuestion[i].cqQuestion+'('+jsonObj[0].choiceQuestion[i].cqScorePre+'分)</div>'
					+'<ul class="list-group">'
					+'<label class="radio">'
					+'<li class="list-group-item"><input checked type="radio" name="answer'+i+'"  value="'+jsonObj[0].choiceQuestion[i].cqOne+'" >'+jsonObj[0].choiceQuestion[i].cqOne+'</li>'
					+'</label>'
					+'<label class="radio">'
					+'<li class="list-group-item"><input type="radio" name="answer'+i+'"  value="'+jsonObj[0].choiceQuestion[i].cqTwo+'" >'+jsonObj[0].choiceQuestion[i].cqTwo+'</li>'
					+'</label>'
					+'<label class="radio">'
					+'<li class="list-group-item"><input type="radio" name="answer'+i+'"  value="'+jsonObj[0].choiceQuestion[i].cqThree+'" >'+jsonObj[0].choiceQuestion[i].cqThree+'</li>'
					+'</label>'
					+'<label class="radio">'
					+'<li class="list-group-item"><input type="radio" name="answer'+i+'"  value="'+jsonObj[0].choiceQuestion[i].cqFour+'" >'+jsonObj[0].choiceQuestion[i].cqFour+'</li>'
					+'<input class="paperId'+i+'" type="hidden" value="'+jsonObj[0].choiceQuestion[i].cqPaperId+'">'
					+'<input class="questionType'+i+'" type="hidden" value="'+jsonObj[0].choiceQuestion[i].cqQuestionType+'">'
					+'<input class="questionId'+i+'" type="hidden" value="'+jsonObj[0].choiceQuestion[i].cqId+'">'
					+'<input class="userName'+i+'" type="hidden" value=${sessionScope.userName}>'
					+'</label>'
					+'</ul>'+html;		
		}
		$('.questionArea').html(html);		
	});
	
	$(function(){
		$('#submitForm').click(function(){
			var totalRadio = $('input:radio:checked').length;
			var totalMessage = new Array();
			for(var i=0;i<totalRadio;i++){
				totalMessage.push({qaAnswer:$('input:radio:checked')[i].value,qaPaperId:$('.paperId'+i+'').val(),
					qaUserName:$('.userName'+i+'').val(),qaQuestionId:$('.questionId'+i+'').val(),
					qaQuestionType:$('.questionType'+i+'').val()});
			}
			console.log(totalMessage);
			$.ajax({
                url: "submitPaper",
                type: "POST",
                contentType : 'application/json;charset=utf-8', //设置请求头信息
                dataType:"json",
                data: JSON.stringify(totalMessage),    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
                success: function(data){
                    alert(data);
                },
                error: function(res){
                    alert(res.responseText);
                }
            });
		});	
	});
	
</script>
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
            <div class="subject-progress">        
            </div>
         <div class="questionArea">
         	
         </div>
                  <!-- <button class="btn btn-warning">下一题</button> -->
                  <button class="btn btn-success" id="submitForm">提交试卷</button>
                  <!--  
                  <nav>
                        <ul class="pagination pagination-lg">
                         
                          <li><a href="#">2</a></li>
                          <li><a href="#">3</a></li>
                          <li><a href="#">4</a></li>
                          <li><a href="#">5</a></li>
                         
                        </ul>
                      </nav>
                -->    
        </div>
    </div>
    <input type="hidden" id="jsonarray" value=${jsonarray}>
</body>
</html>