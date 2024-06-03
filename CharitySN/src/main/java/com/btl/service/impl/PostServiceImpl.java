/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import com.btl.repository.PostsRepository;
import com.btl.service.PostService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service
@Transactional
public class PostServiceImpl implements PostService{
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public boolean AddPosts(Posts posts, Users creator) {
        try {
            Map r = this.cloudinary.uploader().upload(posts.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            posts.setImage((String) r.get("secure_url"));
            posts.setUserId(creator);
            posts.setCreated(new Date());
            return this.postsRepository.AddPosts(posts);
        } catch(IOException ex){
             ex.printStackTrace();
            }
        return false;
    }

    @Override
    public List<Posts> getPosts(int page) {
        return this.postsRepository.getPosts(page);
    }

    @Override
    public Posts getPostsById(int idPosts) {
        return this.postsRepository.getPostsById(idPosts);
    }

    @Override
    public List<Posts> getPostsByUser(int iduser) {
        return this.postsRepository.getPostsByUser(iduser);
    }

    @Override
    public long countPost() {
        return this.postsRepository.countPost();
    }

    @Override
    public boolean delPosts(int idPosts) {
        return this.postsRepository.delPosts(idPosts);
    }
    
}
