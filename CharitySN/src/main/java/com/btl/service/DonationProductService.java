/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.service;

import com.btl.pojos.Donationproduct;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface DonationProductService {
    List<Donationproduct> getDonationProducts(String kw, int page);
    boolean addOrUpdate(Donationproduct donationproduct);
    Donationproduct getDonationproductById(int iddonationProduct);
    long countDonationproduct();
}
