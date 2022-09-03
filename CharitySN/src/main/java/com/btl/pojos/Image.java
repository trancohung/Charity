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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findByIdimage", query = "SELECT i FROM Image i WHERE i.idimage = :idimage"),
    @NamedQuery(name = "Image.findByImage", query = "SELECT i FROM Image i WHERE i.image = :image")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idimage")
    private Integer idimage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "donationProduct_id", referencedColumnName = "iddonationProduct")
    @ManyToOne(optional = false)
    private Donationproduct donationProductid;
    @JoinColumn(name = "post_id", referencedColumnName = "idPosts")
    @ManyToOne(optional = false)
    private Posts postId;

    public Image() {
    }

    public Image(Integer idimage) {
        this.idimage = idimage;
    }

    public Image(Integer idimage, String image) {
        this.idimage = idimage;
        this.image = image;
    }

    public Integer getIdimage() {
        return idimage;
    }

    public void setIdimage(Integer idimage) {
        this.idimage = idimage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Donationproduct getDonationProductid() {
        return donationProductid;
    }

    public void setDonationProductid(Donationproduct donationProductid) {
        this.donationProductid = donationProductid;
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
        hash += (idimage != null ? idimage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.idimage == null && other.idimage != null) || (this.idimage != null && !this.idimage.equals(other.idimage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Image[ idimage=" + idimage + " ]";
    }
    
}
