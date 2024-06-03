<%-- 
    Document   : base.jsp
    Created on : Aug 28, 2022, 12:34:12 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/resources/images/bird.png" rel="shortcut icon">
        <title>
            <tiles:insertAttribute name="title"/>
        </title>
        <link href="<c:url value="/resources/images/bird.png"/>" rel="icon"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="<c:url value="/resources/js/main.js"/>"></script>
    </head>
    <body>
        <div class="header">
            <!-- HEADER -->
            <tiles:insertAttribute name="header"/>
        </div>
        <div class="container">
            <!-- CONTENT -->
            <tiles:insertAttribute name="content"/>
        </div>
        <div class="footer">
            <!-- FOOTER -->
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
