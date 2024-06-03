/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Likes;
import com.btl.service.LikeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
public class APILikeController {
    @Autowired
    private LikeService likeService;
    
    @GetMapping("/api/likes")
    public ResponseEntity<List<Likes>> listLikes() {
        List<Likes> likes = this.likeService.getLikesById(0);
        
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }
    
    @GetMapping("/api/like/{postId}")
    public void like(@PathVariable(value = "postId") Integer postId,
            HttpSession session) {
//        Map<Integer, Likes> likes = new HashMap<>();
    }
}
