<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>课堂签到</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--苹果手机全屏问题-->
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />        
		<meta content="yes" name="apple-mobile-web-app-capable" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style" /> 
		<meta content="telephone=no" name="format-detection" /> 
		<link rel="stylesheet" href="css/swiper-3.4.0.min.css">
		<link href="css/sweet-alert.css" rel="stylesheet" type="text/css">

		
		<link href="css/stylefootball.css" rel="stylesheet" type="text/css">
		
	</head>

	<body>

		<div class="header">
			<input type="hidden" id="openId" value="${openId}">
			<input type="hidden" id="headImgUrl" value="${snsUserInfo.headImgUrl}">
		</div>

		<!--战队1-->
		<div class="swiper-container" id="page1">
			<div class="swiper-wrapper" id="list">
				<!--1-->
				<c:forEach items="${classModelList}" var="item" varStatus="status">
					<div class="swiper-slide"  style="background-image:url('images/v1.png')">

						<div class="renwu">
							<img src="${item.classImg}" alt="">
						</div>

						<div class="num">
							<span class="num-name">老师：</span>
							<span class="num-xuhao">${item.teacherName}</span>
						</div>
						<div class="num">
							<span class="num-name">课程：</span>
							<span class="num-xuhao">${item.className}</span>
						</div>
						<div class="detail" data-source="mv/1.mp4">
						<a href="toSginDetail?classId=${item.id}">
							<img src="images/detail1.png" alt="">
						</a>
						</div>
						<div class="toupiao" onclick="saveStudentLocation('位置',${item.id})">
							<img src="images/vote2.png" alt="">
						</div>
					</div>
				</c:forEach>
				
			</div>
			<div class="middle" id="swiper-pagination1"></div>
		</div>
		
		<div class="vediobox">
			<video  class="video-js" id="video-js" controls>
			<source src="mv/1.mp4" type="video/mp4"></source>
			</video>
		</div>
		<div class="paihang"><span>选择班级</span></div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/layer.js"></script>
		<script type="text/javascript" src="js/swiper-3.4.0.jquery.min.js"></script>
		<script src="js/sweet-alert.min.js"></script>
		<script>
			$(function() {
				// $("body,html").css("background-size", $(window).width() + "px " + $(window).height() + "px");
				 
				$('.swiper-slide').css('height', $('.swiper-slide').width() * 950 / 590 + 'px');
				$(".swiper-container").css("padding-top", ($(window).height() - $('.swiper-slide').width() * 950 / 590 + 50) / 2);
				
				function getSwiperOptions (pagination) {
					return {
						pagination: pagination,
						effect: 'coverflow',
						centeredSlides: true,
						loop: true,
						speed: 1000,
						autoplay:3000,
						autoplayDisableOnInteraction: false,
						slidesPerView: 'auto',
						coverflow: {
							rotate: 0,
							stretch: -55,
							depth: 350,
							modifier: 1,
							slideShadows: false
						}
					}
				}
				
				var swiper = [];
				swiper['#page1'] = new Swiper('#page1', getSwiperOptions('#swiper-pagination1'));
				
				var tabhosts = $(".header a");  
				  
				tabhosts.each(function() {  
				
					$($(this).attr("href")).hide();  
					  
					if ($(this).hasClass("selected")) {  
						$($(this).attr("href")).show();  
					}  
					  
					$(this).click(function(event) {  
						event.preventDefault();
						  var id = $(this).attr("href");
						  if(swiper.hasOwnProperty(id)){
							  swiper[id].slideTo(0, 1000, false);
							  swiper[id].stopAutoplay();
							  swiper[id].startAutoplay();
						  }
						  
						if (!$(this).hasClass("selected")) {  
							tabhosts.each(function() {  
								$(this).removeClass("selected");  
								$($(this).attr("href")).hide();  
							});  
							  
							$(this).addClass("selected");  
							$($(this).attr("href")).show();  
						}  
					});  
				});  
			});  
	   </script>

	   <script type="text/javascript">

		function saveStudentLocation(location,classId){
		    var openId = $('#openId').val();
		    var headImgUrl = $('#headImgUrl').val();
                $.ajax({
                    type:"post",
                    url:"startSgin",
                    dataType:"json",
                    data:{location:location,classId:classId,openId:openId,headImgUrl:headImgUrl},
                    success:function(data){
                        if(data.status == '1'){
                            swal('签到成功!', '非常感谢,么么哒！', 'success');
                        }
                    },
                    error:function(){
                        alert("服务器异常啦！");
                    }
                })
		}
	   </script>


	</body>

</html>