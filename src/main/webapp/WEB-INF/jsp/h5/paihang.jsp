<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no">
  <title>投票-奖励</title>
  <style type="text/css"> 
    *{
        margin: 0;
        padding: 0;
    }
    .clear-fix{
        clear:both;
    }
    html{
        width: 100%;
        height: 100%;
        overflow: hidden;
    }
    body{
    background: url("images/paihang.jpg") no-repeat;
    background-size: 100% 100%;
    font-family: 'Microsoft YaHei';
     background-attachment:fixed
    }
    .company{
        width: 100%;
        /*position: fixed;*/
        color: #fff;
        text-align: center;
        /*bottom: 10px;*/
    }
    .title{
        width:100%;
    }
    .title img{
        width:100%;
    }
    .list{
        width:90%;
        margin:10px auto;
        text-align:center;
    }
    .list-name{
        color:#fff;
        font-size:18px;
        font-weight:bold;
    }
    .list-name .name-l{
        width:60%;
        
        float:left;
    }
    .list-name .name-r{
        width:40%;
        float:left;
    }
    .list-content{
        color:#fff;
        font-size:16px;
    }
    .list-content .item{
        margin-top:6px;
    }
    .list-content .content-l{
        width:60%;
        float:left;
        overflow:hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .list-content .content-r{
        width:40%;
        float:left;
    }
  </style> 
</head>

<body>
    <div class="title">
        <img src="images/log_1.png" alt="">
    </div>
    <div class="list">
        <div class="list-name">
            <div class="name-l">球队名称</div>
            <div class="name-r">支持人数</div>
            <div class="clear-fix"></div>
        </div>
        <div class="list-content">
            <div class="item">
                <div class="content-l">球队名称球队名称球队名称</div>
                <div class="content-r">支持人数</div>
                <div class="clear-fix"></div>
            </div>
           
            
            
            
        </div>
    </div>
    <div class="company">
          公司提供技术支持
    </div>
    <script>document.write('<script src="http://' + (location.host || 'localhost').split(':')[0] + ':35729/livereload.js?snipver=1"></' + 'script>')</script>
</body>
</html>