/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "likes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l"),
    @NamedQuery(name = "Likes.findByIdlikes", query = "SELECT l FROM Likes l WHERE l.idlikes = :idlikes")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlikes")
    private Integer idlikes;
    @JoinColumn(name = "post_id", referencedColumnName = "idPosts")
    @ManyToOne(optional = false)
    private Posts postId;

    public Likes() {
    }

    public Likes(Integer idlikes) {
        this.idlikes = idlikes;
    }

    public Integer getIdlikes() {
        return idlikes;
    }

    public void setIdlikes(Integer idlikes) {
        this.idlikes = idlikes;
    }

    public Posts getPostId() {
        return postId;
    }

    public void setPostId(Posts postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlikes != null ? idlikes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.idlikes == null && other.idlikes != null) || (this.idlikes != null && !this.idlikes.equals(other.idlikes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Likes[ idlikes=" + idlikes + " ]";
    }
    
}
