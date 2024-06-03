/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import com.btl.repository.PostsRepository;
import com.btl.service.CommentService;
import com.btl.service.PostService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class PostController {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/addpost")
    public String addpost(Model model) {
        model.addAttribute("addpost", new Posts());
        return "addpost";
    }
    
            
    
    @PostMapping("/addpost")
    public String add(Model model, @ModelAttribute(value ="addpost") Posts posts,HttpSession session) {
        Users u = (Users) session.getAttribute("currentUser");
        if(this.postService.AddPosts(posts, u)==true)
            return "redirect:/posts";
        else
            model.addAttribute("errMsg","Loi");
        return "addpost";
    }
    
    @RequestMapping("/posts")
    public String posts(Model model, @RequestParam(required = false) Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("posts", this.postService.getPosts(page));
        model.addAttribute("counter", this.postService.countPost());
        
        return "posts";
    }
    
    @GetMapping("/posts/{postId}")
    public String detail(Model model, 
            @PathVariable(value = "postId") int postId,
            @RequestParam(required = false) Map<String, String> params) {
        model.addAttribute("posts", this.postService.getPostsById(postId));
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("comments", this.commentService.getCommentsById(postId, page));
        
        model.addAttribute("commentCounter", this.commentService.countComment(postId));
        
        return "posts-detail";
    }
    
    @RequestMapping("/del/{postId}")
    public String del(Model model, @PathVariable(value = "postId") int postId){
        if(this.postService.delPosts(postId) == true)
            return "redirect:/posts";
        return "redirect:/posts";
    }
//        try {
//            Map r = this.cloudinary.uploader().upload(posts.getFile().getBytes(),
//                    ObjectUtils.asMap("resource_type", "auto"));
//            String img = (String) r.get("secure_url");
//            return "redirect:/";
//        } catch (IOException ex) {
//            System.err.println("== ADD POST ==" + ex.getMessage());
//        }
//        
//        return "addpost";
//   }
}
