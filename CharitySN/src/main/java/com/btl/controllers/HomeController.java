/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Users;
import com.btl.service.UsersService;
//import javax.persistence.Query;
//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ACER
 */
@Controller
public class HomeController {
    @Autowired
    private UsersService usersService;
    
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model) {
//        Session s = sessionFactory.getObject().getCurrentSession();
//        Query q = s.createQuery("From Donationproduct");
        model.addAttribute("name", "Chinh");
        
        return "index";
    }
    
//    @RequestMapping(name="/register-post", method = RequestMethod.POST)
//    public String register(Model model, @ModelAttribute(value = "users") Users users) {
//        model.addAttribute("fullname", users.getFullname());
//        
//        return "index";
//    }
}
