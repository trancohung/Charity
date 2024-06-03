<%-- 
    Document   : admin-left
    Created on : Oct 19, 2022, 3:47:07 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar">
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/admin/posts-stats"/>">Thống kê bài viết theo người dùng</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Thống kê lượt like, comment từng bài viết</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Thống kê bài viết theo thời gian</a>
      </li>
    </ul>
  </div>
</nav>
 
  
