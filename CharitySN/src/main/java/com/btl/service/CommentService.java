/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Comments;
import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CommentService {
    Comments addComment(String content, Posts p, Users creator);
    List<Comments> getCommentsById(int postId, int page);
    long countComment(int postId);
}
