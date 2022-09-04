<%-- 
    Document   : donationproduct
    Created on : Sep 4, 2022, 2:40:43 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<h1 class="text-center text-danger">Quản lý sản phẩm</h1>

<c:url value="/admin/donationproducts" var="action" />

<form:form method="post" action="${action}" modelAttribute="donationproduct" enctype="multipart/form-data">
    <div class="form-group">
        <label for="file">Ảnh sản phẩm</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <br>
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
            
</form:form>
