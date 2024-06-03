/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.pojos.Likes;
import com.btl.repository.LikeRepository;
import com.btl.repository.PostsRepository;
import com.btl.repository.UsersRepository;
import com.btl.service.LikeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private PostsRepository postsRepository; 
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Likes> getLikesById(int postId) {
        return this.likeRepository.getLikesByPostId(postId);
    }
}
