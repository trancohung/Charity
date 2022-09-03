/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p"),
    @NamedQuery(name = "Posts.findByIdPosts", query = "SELECT p FROM Posts p WHERE p.idPosts = :idPosts"),
    @NamedQuery(name = "Posts.findByContent", query = "SELECT p FROM Posts p WHERE p.content = :content"),
    @NamedQuery(name = "Posts.findByLikeCount", query = "SELECT p FROM Posts p WHERE p.likeCount = :likeCount"),
    @NamedQuery(name = "Posts.findByCreated", query = "SELECT p FROM Posts p WHERE p.created = :created")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPosts")
    private Integer idPosts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "like_count")
    private int likeCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Image> imageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Comments> commentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Donationproduct> donationproductCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "idUsers")
    @ManyToOne(optional = false)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Hashtag> hashtagCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Likes> likesCollection;

    public Posts() {
    }

    public Posts(Integer idPosts) {
        this.idPosts = idPosts;
    }

    public Posts(Integer idPosts, String content, int likeCount, Date created) {
        this.idPosts = idPosts;
        this.content = content;
        this.likeCount = likeCount;
        this.created = created;
    }

    public Integer getIdPosts() {
        return idPosts;
    }

    public void setIdPosts(Integer idPosts) {
        this.idPosts = idPosts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @XmlTransient
    public Collection<Image> getImageCollection() {
        return imageCollection;
    }

    public void setImageCollection(Collection<Image> imageCollection) {
        this.imageCollection = imageCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Donationproduct> getDonationproductCollection() {
        return donationproductCollection;
    }

    public void setDonationproductCollection(Collection<Donationproduct> donationproductCollection) {
        this.donationproductCollection = donationproductCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<Hashtag> getHashtagCollection() {
        return hashtagCollection;
    }

    public void setHashtagCollection(Collection<Hashtag> hashtagCollection) {
        this.hashtagCollection = hashtagCollection;
    }

    @XmlTransient
    public Collection<Likes> getLikesCollection() {
        return likesCollection;
    }

    public void setLikesCollection(Collection<Likes> likesCollection) {
        this.likesCollection = likesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosts != null ? idPosts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.idPosts == null && other.idPosts != null) || (this.idPosts != null && !this.idPosts.equals(other.idPosts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Posts[ idPosts=" + idPosts + " ]";
    }
    
}
