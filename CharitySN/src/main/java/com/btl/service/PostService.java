/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface PostService {
    boolean AddPosts(Posts posts, Users creator);
    boolean delPosts(int idPosts);
    List<Posts> getPosts(int page);
    Posts getPostsById(int idPosts);
    long countPost();
    List<Posts> getPostsByUser(int iduser);
    
}
