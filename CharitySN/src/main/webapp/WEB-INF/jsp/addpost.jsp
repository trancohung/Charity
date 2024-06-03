<%-- 
    Document   : addpost
    Created on : Aug 27, 2022, 3:33:39 PM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">Thêm bài viết</h1>

<c:url value="/addpost" var="action"/>

<form:form method="post" action="${action}" modelAttribute="addpost" enctype="multipart/form-data">
    <div class="form-group">
        <label for="content">Nội dung</label>
        <form:input type="text-area" id="content" path="content" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh bài viết</label>
        <form:input type="file" id="file" path="file" cssClass="form-control" />
    </div>
    <div class="form-group">
        <br>
        <input type="submit" value="Thêm bài viết" class="btn btn-danger"/>
    </div>
</form:form>
