<%--
  Created by IntelliJ IDEA.
  User: hongwei.gao
  Date: 2018/7/20
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<form action="/addUser">

    用户名 ：<input type="text" name="name" value=""><br/>
    性别： <input type="text" name="sex" value=""><br/>
    地址： <input type="text" name="address" value=""><br/>

    <input type="submit" value="增加用户">
</form>