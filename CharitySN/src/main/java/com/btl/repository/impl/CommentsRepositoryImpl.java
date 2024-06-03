/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.impl;

import com.btl.pojos.Comments;
import com.btl.repository.CommentRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class CommentsRepositoryImpl implements CommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Comments addComment(Comments c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(c);
            
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Comments> getCommentsByPostId(int postId, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comments> query = builder.createQuery(Comments.class);
        Root root = query.from(Comments.class);
        
        query = query.where(builder.equal(root.get("postId"), postId));
        query = query.orderBy(builder.desc(root.get("idcomments")));
        
        Query q = session.createQuery(query);
        
        int max = 3;
        q.setMaxResults(max);
        q.setFirstResult((page - 1 ) * max);
        
        return q.getResultList();
    }

    @Override
    public long countComment(int postId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Comments Where postId.idPosts=:idPosts");
        q.setParameter("idPosts", postId);
        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
}
