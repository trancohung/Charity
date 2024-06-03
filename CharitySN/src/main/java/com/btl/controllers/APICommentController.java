/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Comments;
import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import com.btl.service.CommentService;
import com.btl.service.PostService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
public class APICommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;
    
    @PostMapping(path="/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comments> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        Users u = (Users) session.getAttribute("currentUser");
        if (u != null)
            try{
                String content = params.get("content");
                int postId = Integer.parseInt(params.get("postId"));
                
                Posts p = this.postService.getPostsById(postId);
                Comments c = this.commentService.addComment(content, p, u);

                return new ResponseEntity<>(c, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
