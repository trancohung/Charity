/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
/* global fetch */

function addComment(postId) {
    fetch("/CharitySN/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "postId": postId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        console.info(res)
        
        return res.json();
    }).then(function(data){
        console.info(data);
        
        let area= document.getElementById("commentArea");
        
        area.innerHTML = `
            <div class="row">
                <div class="col-md-2">
                    <img style="width:35px;" src="${data.userId.avatar}" class="rounded-circle"/>
                </div>
                <div class="col-md-10 my-date">
                    <p>${data.userId.fullname}</p>
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                </div>
            </div>
        ` + area.innerHTML
    }).then(window.location='/CharitySN');
}

