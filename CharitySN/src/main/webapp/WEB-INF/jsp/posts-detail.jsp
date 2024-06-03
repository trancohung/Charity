<%-- 
    Document   : posts-detail
    Created on : Sep 10, 2022, 12:50:43 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-md-6">
        <c:if test="${posts.image != null && posts.image.startsWith('https') == true}">
            <img class="card-img-top img-fluid" src="${posts.image}" width="200px" height="200px" alt="alt" />
        </c:if>
        <c:if test="${posts.image == null || posts.image.startsWith('https') == false}">
            <img class="card-img-top img-fluid" src="<c:url value="/images/bird.png" />" width="200px" height="200px" alt="alt" />
        </c:if>
    </div>
    <div class="col-md-6">
        <h1 style="color: midnightblue">${posts.userId.fullname}</h1>
        <div>
            <hr>
            <input type="button" value="Like" class="btn btn-primary"/>
            <hr>
        </div>
        <div id="commentArea">
            <c:forEach items="${comments}" var="c">
                <div class="row">
                    <div class="col-md-2">
                        <img style="width:35px;" src="${c.userId.avatar}" class="rounded-circle"/>
                    </div>
                    <div class="col-md-10 my-date">
                        <p>${c.userId.fullname}</p>
                        <p>${c.content}</p>
                        <i>${c.createdDate}</i>
                    </div>
                </div>
            </c:forEach>
            <ul class="pagination">
                <c:forEach begin="1" end="${Math.ceil(commentCounter/3)}" var="i">
                    <li class="page-item"><a class="page-link" href="<c:url value="/posts/${posts.idPosts}"/>?page=${i}">${i}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="row">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" style="width:35px; height:50px" src="${currentUser.avatar}" alt="alt" />
            </div>
            <div style="height:20%" class="col-md-8">
                <form>
                    <div class="form-group">
                        <textarea class="form-control" id="commentId" placeholder="Nhap binh luan"></textarea>
                    </div>
                </form>
            </div>
            <div class="col-md-2">
                <input type="button" onclick="addComment(${posts.idPosts})" value="Gui" class="btn btn-primary"/>
            </div>
        </div>
    </div>
</div>
<style>
    .container{
        padding-left: 0px;
        margin-left: 0px;
        max-width: 100%;
    }
    .card-img, .card-img-bottom, .card-img-top {
        width: 90%;
    }
    p{
        margin:0;
    }
    div.col-md-2{
        padding: 5px;
    }
    
</style>
<script>
    window.onload = function() {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>