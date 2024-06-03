/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.repository.impl;

import com.btl.pojos.Posts;
import com.btl.repository.PostsRepository;
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
public class PostsRepositoryImpl implements PostsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean AddPosts(Posts posts) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(posts);
            return true;
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Posts> getPosts(int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Posts> query = builder.createQuery(Posts.class);
        Root root = query.from(Posts.class);
        query = query.select(root);
        
        query = query.orderBy(builder.desc(root.get("created")));
        Query q = s.createQuery(query);
        
        int max = 30;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public List<Posts> getPostsByUser(int iduser) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Posts> query = builder.createQuery(Posts.class);
        Root root = query.from(Posts.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("idUser"), iduser);
        query = query.where(p).orderBy(builder.desc(root.get("created")));
        
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public Posts getPostsById(int idPosts) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Posts.class, idPosts);
    }

    @Override
    public long countPost() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Posts");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean delPosts(int idPosts) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        String hql = "delete from Posts where idPosts.idPosts=:idPosts";
        session.createQuery(hql).setParameter("idPosts", idPosts).executeUpdate();
        return true;
    }
    
}
