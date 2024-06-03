<%-- 
    Document   : posts
    Created on : Aug 28, 2022, 3:33:39 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1 class="text-center text-danger">Bài viết</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(counter/30)}" var="i">
        <li class="page-item"><a class="page-link" href="<c:url value="posts"/>?page=${i}">${i}</a></li>
    </c:forEach>
</ul>
    
<div>
    <c:forEach var="h" items="${posts}">
        <div class="card">
            <div class="card-header">${h.userId.fullname}</div>
                <a href="<c:url value="/posts/${h.idPosts}"/>">
                    <c:if test="${h.image != null && h.image.startsWith('https') == true}">
                        <img class="img-fluid" src="${h.image}" width="200px" height="200px" alt="alt" />
                    </c:if>
                    <c:if test="${h.image == null || h.image.startsWith('https') == false}">
                        <img class="img-fluid" src="<c:url value="/images/bird.png" />" width="200px" height="200px" alt="alt" />
                    </c:if>
                </a>
            <div class="card-body">
                <h3>${h.content}</h3>
                <p>${h.likeCount}</p>
                <hr>
                <div>
                    <input type="button" value="Like" class="btn btn-danger"/>
                    <a href="<c:url value="/del/${h.idPosts}"/>" class="btn btn-danger">Xoa</a>
                </div>
            </div>
            
        </div>
    </c:forEach>
</div>