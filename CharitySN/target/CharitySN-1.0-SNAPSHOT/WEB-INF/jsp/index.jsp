<%-- 
    Document   : index.jsp
    Created on : Aug 26, 2022, 12:57:37 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h1>Welcome to our website!</h1>
<h1>Hello ${name}</h1>
<div>
    <img src="<c:url value="/images/luan.jpg"/> "alt="test"/>
</div>

<ul>
    <c:forEach var="u" items="${users}">
        <li>${u.username}</li>
    </c:forEach>
</ul>

