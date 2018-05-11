<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
           创建讨论
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
        <script type="text/javascript" src="js/jquery.min.js"></script>
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
            <input type="hidden" value="${classId}" id="classId">
            <input type="hidden" value="${teacherName}" id="teacherName">
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
            <div class="layui-form layui-form-pane">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">
                        话题讨论
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" class="layui-textarea" id="title"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <button class="layui-btn"   id="submitComment">
                            发布
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-layui.js" charset="utf-8"></script>
<script>
    $(function () {
        $('#submitComment').click(function () {
            var classId = $('#classId').val();
            var title = $('#title').val();
            var teacherName = $('#teacherName').val();
            if(title == "" || title.trim() == ""){
                alert("内容不能为空");
                return;
            }
            $.ajax({
                type:"post",
                url:"addComment",
                dataType:"json",
                data:{classId:classId,title:title,teacherName:teacherName},
                success:function(data){
                    if(data.status == '1'){
                       alert("发布成功");
                        $('#title').val('');
                    }
                },
                error:function(){
                    alert("服务器异常啦！");
                }
            })
        });
    });
</script>
        
    </body>
</html>