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
@Table(name = "hashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hashtag.findAll", query = "SELECT h FROM Hashtag h"),
    @NamedQuery(name = "Hashtag.findByIdhashtag", query = "SELECT h FROM Hashtag h WHERE h.idhashtag = :idhashtag")})
public class Hashtag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhashtag")
    private Integer idhashtag;
    @JoinColumn(name = "post_id", referencedColumnName = "idPosts")
    @ManyToOne(optional = false)
    private Posts postId;

    public Hashtag() {
    }

    public Hashtag(Integer idhashtag) {
        this.idhashtag = idhashtag;
    }

    public Integer getIdhashtag() {
        return idhashtag;
    }

    public void setIdhashtag(Integer idhashtag) {
        this.idhashtag = idhashtag;
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
        hash += (idhashtag != null ? idhashtag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hashtag)) {
            return false;
        }
        Hashtag other = (Hashtag) object;
        if ((this.idhashtag == null && other.idhashtag != null) || (this.idhashtag != null && !this.idhashtag.equals(other.idhashtag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Hashtag[ idhashtag=" + idhashtag + " ]";
    }
    
}
