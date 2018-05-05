<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
            入班审核
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    <body>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        <div class="x-body">
            <xblock><span class="x-right" style="line-height:40px">共有数据：${listSize} 条</span></xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            申请人
                        </th>
                        <th>
                            学号
                        </th>
                        <th>
                            申请时间
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>
                <c:forEach var="joinClassApplyDto"   items="${joinClassApplyDtoList}"   varStatus="status" >
                    <tbody id="x-link">
                    <tr>
                        <td>
                            ${status.index+1}
                        </td>
                        <td>
                                ${joinClassApplyDto.userName}
                        </td>
                        <td >
                                ${joinClassApplyDto.schoolCode}
                        </td>
                        <td >
                                ${joinClassApplyDto.applyTime}
                        </td>
                        <td class="td-manage">
                            <a onclick="updateStatus('${joinClassApplyDto.openId}','${joinClassApplyDto.classId}')">
                         <span class="layui-btn layui-btn-normal layui-btn-mini">
                               通过审核
                            </span>
                            </a>
                        </td>
                    </tr>
                    </tbody>

                </c:forEach>
            </table>

            <div id="page"></div>
        </div>
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-layui.js" charset="utf-8"></script>
        <script>
            layui.use(['element','laypage','layer','form'], function(){
                $ = layui.jquery;//jquery
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层
              form = layui.form();//弹出层


          })

              

              //以上模块根据需要引入
            
            
            /*删除*/
            function updateStatus(openId,classId){
                layer.confirm('确认审核？',function(index){
                   window.location("updateSginStatus?openId="+openId+"&classId="+classId);
                });
            }
            </script>
            
    </body>
</html>