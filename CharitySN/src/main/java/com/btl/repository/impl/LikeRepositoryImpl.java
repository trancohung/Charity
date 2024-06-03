/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.impl;

import com.btl.pojos.Likes;
import com.btl.repository.LikeRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class LikeRepositoryImpl implements LikeRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Likes> getLikesByPostId(int postId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Likes> query = builder.createQuery(Likes.class); 
        Root root = query.from(Likes.class);
        
        query = query.where(builder.equal(root.get("postId"), postId));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
    
}
