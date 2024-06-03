/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Users;
import com.btl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ACER
 */
@Controller
public class UserController {
    @Autowired
    private UsersService userDetailsService;
            
            
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("users", new Users());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "users")Users users) {
        String errMsg= "";
        if (users.getPassword().equals(users.getConfirmPassword())){
            if (this.userDetailsService.addUser(users) == true){
                return "redirect:/login";
            }else
                errMsg = "Đã có lỗi xảy ra!";
        } else
            errMsg = "Mật khẩu không khớp!";
        
        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
    
}
