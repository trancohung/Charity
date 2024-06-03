/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.repository;

import com.btl.pojos.Posts;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ACER
 */
@Component
public interface PostsRepository {
    boolean AddPosts(Posts posts);
    boolean delPosts(int idPosts);
    List<Posts> getPosts(int page);
    List<Posts> getPostsByUser(int iduser);
    long countPost();
    Posts getPostsById(int idPosts);
}
