/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.controllers;

import com.btl.pojos.Donationproduct;
import com.btl.service.DonationProductService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class DonationProductController {
    @Autowired
    private DonationProductService donationProductService;
    
    @GetMapping("/addproduct")
    public String addproduct(Model model) {
        model.addAttribute("addproduct", new Donationproduct());
        return "addproduct";
    }
    
    @PostMapping("/addproduct")
    public String add(Model model, @ModelAttribute(value ="addproduct") Donationproduct donationproduct, HttpSession session) {
        if (this.donationProductService.addOrUpdate(donationproduct) == true)
            return "redirect:/donationproduct";
        else 
           model.addAttribute("errMsg", "Something wrong!!!");
        return "addproduct";
    }
    
    @RequestMapping("/donationproduct")
    public String donationproduct(Model model, @RequestParam(required = false) Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String kw = params.getOrDefault("kw", null);
        model.addAttribute("donationproducts", this.donationProductService.getDonationProducts(kw, page));
        model.addAttribute("counter", this.donationProductService.countDonationproduct());
        
//        model.addAttribute("counter", this.Service.countPost());
        
        return "donationproduct";
    }
}
