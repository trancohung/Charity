/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service.impl;

import com.btl.repository.StatsRepository;
import com.btl.service.StatsService;
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
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;
    
    @Override
    public List<Object[]> postsStats() {
        return this.statsRepository.postsStats();
    }
    
}
