<%-- 
    Document   : donationproduct
    Created on : Aug 30, 2022, 3:33:39 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">Trang Đấu giá</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(counter/30)}" var="i">
        <li class="page-item"><a class="page-link" href="<c:url value="donationproduct"/>?page=${i}">${i}</a></li>
    </c:forEach>
</ul>
<div>
    <c:forEach var="d" items="${donationproducts}">
        <div class="card">
            <div class="card-header">${d.name}</div
            <c:if test="${d.image != null && d.image.startsWith('https') == true}">
               <img class="img-fluid" src="${d.image}" width="200px" height="200px" alt="alt" />
            </c:if>
            <c:if test="${d.image == null || d.image.startsWith('https') == false}">
                <img class="img-fluid" src="<c:url value="/images/bird.png" />" width="200px" height="200px" alt="alt" />
            </c:if> 
            <div class="card-body">
                <p>${d.price} VND</p>
                <img class="img-fluid" src="${d.image}" width="200px" height="200px" alt="alt"/>
            </div>
        </div>
    </c:forEach>
</div>

    