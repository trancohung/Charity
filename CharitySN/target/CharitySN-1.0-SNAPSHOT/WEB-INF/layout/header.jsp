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
            <a class="nav-link active" href="<c:url value="/" />">Trang chủ</a>
        </li>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/login"/>">
                    <i class="fa fa-user"></i>Đăng nhập
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/register"/>">Đăng ký</a>
            </li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/posts" />">
                    <c:if test="${currentUser.avatar != null}" >
                        <img style="width:16px;" src="${currentUser.avatar}" class="rounded-circle img-fluid" />
                    </c:if>
                    <c:if test="${currentUser.avatar == null}" >
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </c:if>
                        
                    ${currentUser.fullname}
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/logout" />">Logout</a>
            </li>
        </c:if>
        <c:if test="${currentUser != null}">    
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/addpost"/>">Thêm bài viết</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/posts"/>">Bài viết</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/addproduct"/>">Thêm sản phẩm</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link text-danger" href="<c:url value="/donationproduct"/>">Đấu giá</a>
            </li>
        </c:if>    
    </ul>
</nav>