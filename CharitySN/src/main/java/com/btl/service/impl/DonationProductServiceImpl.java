/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.pojos.Donationproduct;
import com.btl.repository.DonationProductRepository;
import com.btl.service.DonationProductService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Service
@Transactional
public class DonationProductServiceImpl implements DonationProductService{
    @Autowired
    private DonationProductRepository donationProductRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Donationproduct> getDonationProducts(String kw, int page) {
        return this.donationProductRepository.getDonationProducts(kw, page);
        
    }

    @Override
    public boolean addOrUpdate(Donationproduct donationproduct) {
        try {
            Map r = this.cloudinary.uploader().upload(donationproduct.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            donationproduct.setImage((String) r.get("secure_url"));
            donationproduct.setCreated(new Date());
            return this.donationProductRepository.addOrUpdate(donationproduct);
        } catch (IOException ex) {
                ex.printStackTrace();
            }
        return false;
    }

    @Override
    public Donationproduct getDonationproductById(int iddonationProduct) {
        return this.donationProductRepository.getDonationproductById(iddonationProduct);
    }

    @Override
    public long countDonationproduct() {
        return this.donationProductRepository.countDonationproduct();
    }
    
}
