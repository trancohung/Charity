<%-- 
    Document   : addproduct
    Created on : Aug 29, 2022, 3:33:39 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">Quản lý sản phẩm</h1>

<c:url value="/addproduct" var="action" />

<form:form method="post" action="${action}" modelAttribute="addproduct" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Tên sản phẩm</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh sản phẩm</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="price">Giá sản phẩm</label>
        <form:input type="number" id="price" path="price" cssClass="form-control"/>
    </div>
    
    <div class="form-group">
        <br>
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
            
</form:form>
