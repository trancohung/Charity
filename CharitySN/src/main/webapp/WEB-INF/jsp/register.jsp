<%-- 
    Document   : register
    Created on : Aug 31, 2022, 5:00:10 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Đăng ký</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />

<form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="users" >
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
    </div>
    <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    <div class="form-group">
        <label for="fullname">Full Name</label>
        <form:input type="text" id="fullname" path="fullname" class="form-control" />
    </div>
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" id="avatar" path="file" class="form-control" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
    <div class="form-group">
        <br>
        <input type="submit" value="Đăng ký" class="btn btn-danger"/>
    </div>
</form:form>