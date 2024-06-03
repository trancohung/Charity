/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Comments;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ACER
 */
@Component
public interface CommentRepository {
    Comments addComment(Comments c);
    List<Comments> getCommentsByPostId(int postId, int page);
    long countComment(int postId);
}
