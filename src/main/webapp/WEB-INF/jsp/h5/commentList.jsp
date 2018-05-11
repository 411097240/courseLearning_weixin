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

    

    <!-- testimonials wrapper starts -->

    <div class="testimonialsWrapper">
          <c:if test="${commentDtoList.size() == 0}">
              <h3 class="sectionTitle testimonialsTitle">
              你的班级下还没有讨论
              </h3>
          </c:if>

<c:forEach items="${commentDtoList}" var="item" varStatus="status">
    <a href="commentDetailList?commentId=${item.id}&openId=${openId}">
        <div class="testimonialWrapper">
            <p class="testimonialText"><h4>话题：${item.title}</h4><br>&nbsp;&nbsp;&nbsp;&nbsp;老师姓名：${item.teacherName}<br>&nbsp;&nbsp;&nbsp;&nbsp;发布时间：${item.commentCreateTime}<br>&nbsp;&nbsp;&nbsp;&nbsp;</p>
        </div>
    </a>
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
<script type="text/javascript">
    var index = 0;
    var myGeo = new BMap.Geocoder();
    var Longitude = ${Longitude};
    var Latitude = ${Latitude};
    var points = new Array();
    var adds = new Array();
    console.log(Longitude);
    for(var i = 0 ; i < Longitude.length; i++){
        points.push(new BMap.Point(Longitude[i],Latitude[i]));
        console.log("转换前经度"+Longitude[i]);
    }
    //坐标转换完之后的回调函数
    translateCallback = function (data){
        if(data.status === 0) {
            for (var i = 0; i < data.points.length; i++) {
                adds.push(new BMap.Point(data.points[i].lng,data.points[i].lat));
                console.log("转换后经度"+data.points[i].lng);
            }
            bdGEO();
        }
    }
    setTimeout(function(){
        var convertor = new BMap.Convertor();
        convertor.translate(points, 1, 5, translateCallback)
    }, 1000);

    function bdGEO(){
        var pt = adds[index];
        geocodeSearch(pt);
        index++;
    }
    function geocodeSearch(pt){
        if(index < adds.length-1){
            setTimeout(window.bdGEO,400);
        }
        myGeo.getLocation(pt, function(rs){
            var addComp = rs.addressComponents;
            $("#myLocation"+(index-1)).html("-"+addComp.province + addComp.city +addComp.district+addComp.street+addComp.streetNumber);
            console.log( index + ". " +adds[index-1].lng + "," + adds[index-1].lat + "："  + "商圈(" + rs.business + ")  结构化数据(" + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
        });
    }


</script>