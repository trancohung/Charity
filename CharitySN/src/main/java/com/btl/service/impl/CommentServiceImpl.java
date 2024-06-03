/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.pojos.Comments;
import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import com.btl.repository.CommentRepository;
import com.btl.repository.PostsRepository;
import com.btl.repository.UsersRepository;
import com.btl.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostsRepository postsRepository; 
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public Comments addComment(String content, Posts p, Users creator) {
        
        Comments c = new Comments();
        c.setContent(content);
        c.setPostId(p);
        c.setUserId(creator);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }

    @Override
    public List<Comments> getCommentsById(int postId, int page) {
        return this.commentRepository.getCommentsByPostId(postId, page);
    }

    @Override
    public long countComment(int postId) {
        return this.commentRepository.countComment(postId);
    }
    
}
