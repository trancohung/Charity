<%-- 
    Document   : header
    Created on : Aug 28, 2022, 12:39:34 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link active" href="#">Trang chủ</a>
        </li>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/login"/>">Đăng nhập</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/register"/>">Đăng ký</a>
            </li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/logout" />">Logout</a>
            </li>
        </c:if>
       
    </ul>
</nav>