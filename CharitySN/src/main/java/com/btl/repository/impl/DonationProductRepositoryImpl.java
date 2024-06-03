/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.impl;

import com.btl.pojos.Donationproduct;
import com.btl.repository.DonationProductRepository;
import java.util.List;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class DonationProductRepositoryImpl implements DonationProductRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Donationproduct> getDonationProducts(String kw, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Donationproduct> query = builder.createQuery(Donationproduct.class);
        Root root = query.from(Donationproduct.class);
        query = query.select(root);
 
        query = query.orderBy(builder.desc(root.get("created")));
         
        if (kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        
        int max = 30;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Donationproduct donationproduct) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(donationproduct);
            
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Donationproduct getDonationproductById(int iddonationProduct) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Donationproduct.class, iddonationProduct);
    }

    @Override
    public long countDonationproduct() {
       Session session = this.sessionFactory.getObject().getCurrentSession();
       Query q = session.createQuery("Select Count(*) From Donationproduct");
       
       return Long.parseLong(q.getSingleResult().toString());
    }
    
}
