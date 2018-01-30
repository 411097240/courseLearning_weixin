<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

<title>签到排行榜</title>

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

    

    <!-- testimonials wrapper starts -->

    <div class="testimonialsWrapper">

      <h3 class="sectionTitle testimonialsTitle">《数据结构》课堂签到</h3>

      <!-- testimonial wrapper starts -->
      <c:forEach items="${StudentSginDtoList}" var="item" varStatus="status">
        <div class="testimonialWrapper"> <a href="#" class="testimonialImageWrapper"><img class="testimonialImage" src="${item.headImgUrl}" alt=""/></a>

          <p class="testimonialText">学号：${item.schoolCode}<br>&nbsp;&nbsp;&nbsp;&nbsp;姓名：${item.realName}<br>&nbsp;&nbsp;&nbsp;&nbsp;签到时间：${item.sginTime}<span class="testimonialAuthor">- ${item.longitude},${item.latitude}</span></p>

        </div>
      </c:forEach>

      <div class="testimonialWrapper"> <a href="#" class="testimonialImageWrapper"><img class="testimonialImage" src="images/testimonial-1.jpg" alt=""/></a>

        <p class="testimonialText">学号：201421092074<br>&nbsp;&nbsp;&nbsp;&nbsp;姓名：梁响<br>&nbsp;&nbsp;&nbsp;&nbsp;签到时间：09:10<span class="testimonialAuthor">- 湖北省武汉市洪山区南湖大道政院路1号</span></p>

      </div>

      <!-- testimonial wrapper ends --> 

      <!-- testimonial wrapper starts -->

      <div class="testimonialWrapper"> <a href="#" class="testimonialImageWrapper"><img class="testimonialImage" src="images/testimonial-2.jpg" alt=""/></a>

        <p class="testimonialText">学号：201421092074<br>&nbsp;&nbsp;&nbsp;&nbsp;姓名：梁响<br>&nbsp;&nbsp;&nbsp;&nbsp;签到时间：09:10<span class="testimonialAuthor">- 湖北省武汉市洪山区南湖大道政院路1号</span></p>

      </div>

      <!-- testimonial wrapper ends --> 

      <!-- testimonial wrapper starts -->

      <div class="testimonialWrapper"> <a href="#" class="testimonialImageWrapper"><img class="testimonialImage" src="images/testimonial-3.jpg" alt=""/></a>

        <p class="testimonialText">学号：201421092074<br>&nbsp;&nbsp;&nbsp;&nbsp;姓名：梁响<br>&nbsp;&nbsp;&nbsp;&nbsp;签到时间：09:10<span class="testimonialAuthor">- 湖北省武汉市洪山区南湖大道政院路1号</span></p>

      </div>

      <!-- testimonial wrapper ends --> 

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

</body>

</html>

