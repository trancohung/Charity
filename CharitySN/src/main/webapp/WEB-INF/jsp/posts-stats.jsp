<%-- 
    Document   : category-stats
    Created on : Oct 19, 2022, 3:52:15 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-black">THỐNG KÊ BÀI VIẾT THEO NGƯỜI DÙNG</h1>

<div style="width: 80%">
    <canvas id="myPostsStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã người dùng</th>
        <th>Tên người dùng </th>
        <th>Số lượng bài viết</th>
    </tr>
    <c:forEach items="${postsStats}" var="ps">
        <tr>
            <td>${ps[0]}</td>
            <td>${ps[1]} </td>
            <td>${ps[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let postsLabels=[], postsInfo=[];
    
    <c:forEach items="${postsStats}" var="ps">
        postsLabels.push('${ps[1]}') 
        postsInfo.push('${ps[2]}')
    </c:forEach>
    
    window.onload = function() {
        postsChart("myPostsStatsChart", postsLabels, postsInfo)
    }
</script>