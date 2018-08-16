<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<img src="hello.jpg" alt="上海鲜花港 - 郁金香" />--%>
<head>
    <script>
        var xmlhttp;

        function check() {
            var name = document.getElementById("name").value;
            var url = "http://localhost:8080/find/" + name;

            xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = checkResult; //响应函数
            xmlhttp.open("POST", url, true);   //设置访问的页面
            xmlhttp.send(null);  //执行访问
        }

        function checkResult() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                if (xmlhttp.responseText != null) {
                    document.getElementById('checkResult').innerHTML = xmlhttp.responseText;
                }
        }

    </script>
</head>
<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <thead>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>地址</th>
        </thead>

        <c:forEach items="${cs}" var="c" varStatus="st">
            <tbody>
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.sex}</td>
                <td>${c.address}</td>
                <td><a href="/delete/${c.id}">删除</a></td>
                <td><a href="/edit/${c.id}">编辑</a></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="/list/?start=0">首 页</a>
        <a href="/list/?start=${page.start-page.count}">上一页</a>
        <a href="/list/?start=${page.start+page.count}">下一页</a>
        <a href="/list/?start=${page.last}">末 页</a>
    </div>
    <span align='center' border='1' cellspacing='0'>输入id :</span>
    <input id="name" name="name" onkeyup="check()" type="text"><br>
    <span id="checkResult"></span>
</div>