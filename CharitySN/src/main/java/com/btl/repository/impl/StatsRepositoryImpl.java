/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.impl;

import com.btl.pojos.Posts;
import com.btl.pojos.Users;
import com.btl.repository.StatsRepository;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> postsStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootP = q.from(Posts.class);
        Root rootU = q.from(Users.class);
        
        q.where(b.equal(rootP.get("userId"), rootU.get("idUsers")));
        
        q.multiselect(rootU.get("idUsers"), rootU.get("fullname"),
                b.count(rootP.get("idPosts")));
        
        q.groupBy(rootU.get("idUsers"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
