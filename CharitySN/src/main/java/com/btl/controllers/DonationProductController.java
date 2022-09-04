/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Donationproduct;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DonationProductController {
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/admin/donationproducts")
    public String list(Model model) {
        model.addAttribute("donationproduct", new Donationproduct());
        return "donationproduct";
    }
    
    @PostMapping("/admin/donationproducts")
    public String add(@ModelAttribute(value ="donationproduct") Donationproduct donationproduct) {
        try {
            Map r = this.cloudinary.uploader().upload(donationproduct.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            String img = (String) r.get("secure_url");
            return "redirect:/";
        } catch (IOException ex) {
            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
        }
        
        return "donationproduct";
    }
}
