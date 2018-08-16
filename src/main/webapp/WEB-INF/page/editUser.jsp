<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div style="text-align:center;margin-top:40px">

    <form action="/editUser">
        用户名： <input name="name" value="${user.name}" type="text"> <br>
        性别： <input name="sex" value="${user.sex}" type="text"> <br>
        地址： <input name="address" value="${user.address}" type="text"> <br>
        <input type="hidden" value="${user.id}" name="id">
        <input type="submit" value="修改用户">
    </form>

</div>
