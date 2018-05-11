<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

<title>话题列表</title>

<!-- meta tags start -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

<!-- meta tags end -->

<!-- favorite icon starts -->

<link rel="shortcut icon" href="images/common/favicon.ico" type="image/x-icon" />

<!-- favorite icon ends -->

<!-- CSS files start -->

<link href="css/framework.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/colorbox.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/elements.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/styleOne.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/responsive.css" rel="stylesheet" type="text/css" media="screen" />

<link href="css/hidpi.css" rel="stylesheet" type="text/css" media="screen" />

<link href="css/skin.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/custom.css" rel="stylesheet" type="text/css" media="all" />

<!-- CSS files end -->



<!-- JavaScript files start -->

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/effects.jquery-ui.min.js"></script>

<script type="text/javascript" src="js/jquery.nivo-slider.min.js"></script>

<script type="text/javascript" src="js/jquery.colorbox.min.js"></script>

<script type="text/javascript" src="js/custom.js"></script>

<!-- JavaScript files end -->

</head>
<body>

<!-- website wrapper starts -->

<div class="websiteWrapper"> 

  

  

  

  

  <div class="pageWrapper homePageWrapper"> 

  

    

    <div class="sectionBreak"></div>

    
      <input type="hidden" id="openId" value="${openId}">
      <input type="hidden" id="commentId" value="${commentId}">
    <!-- testimonials wrapper starts -->

    <div class="testimonialsWrapper">
          <c:if test="${commentDtoList.size() == 0}">
              <h3 class="sectionTitle testimonialsTitle">
              该问题还没有讨论
              </h3>
          </c:if>
        <div class="testimonialWrapper">
            <p class="testimonialText">我的观点：<textarea id="comment" style="width: 100%;height: auto"></textarea><button id="submitComment">提交回答</button></p>
        </div>
<c:forEach items="${commentDtoList}" var="item" varStatus="status">
        <div class="testimonialWrapper">
            <p class="testimonialText">姓名：${item.userName}<br>&nbsp;&nbsp;&nbsp;&nbsp;回答时间：${item.createTime}<br>&nbsp;&nbsp;&nbsp;&nbsp;回答：${item.comment}<br>&nbsp;&nbsp;&nbsp;&nbsp;</p>
        </div>
      <!-- testimonial wrapper ends --> 
</c:forEach>
    </div>

    <!-- testimonials wrapper ends -->

    

    <div class="sectionBreak"></div>


  

  <!-- footer wrapper starts -->

  <div class="footerTopDeco"></div>

  <div class="footerWrapper"> 

    <!-- copyright wrapper starts -->

    <div class="copyrightWrapper"> 

      <!-- copyright starts --> 

      <span class="copyright">Powered by <a href="" target="_blank">当当</a> </span> 

      <!-- copyright ends --> 

      <!-- back to top button starts --> 

      <!-- back to top button ends --> 

    </div>

    <!-- copyright wrapper ends --> 

  </div>

  <!-- footer wrapper ends --> 

  

</div>

<!-- website wrapper ends -->

</html>
<script>
    $(function () {
        $('#submitComment').click(function () {
            var openId = $('#openId').val();
            var commentId = $('#commentId').val();
            var comment = $('#comment').val();
            if(comment == "" || comment.trim() == ""){
                alert("内容不能为空");
                return;
            }
            $.ajax({
                type:"post",
                url:"submitComment",
                dataType:"json",
                data:{openId:openId,commentId:commentId,comment:comment},
                success:function(data){
                    if(data.status == '1'){
                        alert("发布成功");
                        window.location.href="commentDetailList?commentId="+commentId+"&openId="+openId;
                    }
                },
                error:function(){
                    alert("服务器异常啦！");
                }
            })
        });
    });
</script>