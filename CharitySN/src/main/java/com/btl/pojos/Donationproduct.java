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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "donationproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donationproduct.findAll", query = "SELECT d FROM Donationproduct d"),
    @NamedQuery(name = "Donationproduct.findByIddonationProduct", query = "SELECT d FROM Donationproduct d WHERE d.iddonationProduct = :iddonationProduct"),
    @NamedQuery(name = "Donationproduct.findByName", query = "SELECT d FROM Donationproduct d WHERE d.name = :name"),
    @NamedQuery(name = "Donationproduct.findByPrice", query = "SELECT d FROM Donationproduct d WHERE d.price = :price"),
    @NamedQuery(name = "Donationproduct.findByImage", query = "SELECT d FROM Donationproduct d WHERE d.image = :image")})
public class Donationproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonationProduct")
    private Integer iddonationProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @Size(max = 1000)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @OneToMany(mappedBy = "donationproductId")
    private Collection<Posts> postsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationProductid")
    private Collection<Auction> auctionCollection;
    @Transient
    private MultipartFile file;
    public Donationproduct() {
    }

    public Donationproduct(Integer iddonationProduct) {
        this.iddonationProduct = iddonationProduct;
    }

    public Donationproduct(Integer iddonationProduct, String name, long price, Date created) {
        this.iddonationProduct = iddonationProduct;
        this.name = name;
        this.price = price;
        this.created = created;
    }

    public Integer getIddonationProduct() {
        return iddonationProduct;
    }

    public void setIddonationProduct(Integer iddonationProduct) {
        this.iddonationProduct = iddonationProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Posts> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Posts> postsCollection) {
        this.postsCollection = postsCollection;
    }

    @XmlTransient
    public Collection<Auction> getAuctionCollection() {
        return auctionCollection;
    }

    public void setAuctionCollection(Collection<Auction> auctionCollection) {
        this.auctionCollection = auctionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonationProduct != null ? iddonationProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donationproduct)) {
            return false;
        }
        Donationproduct other = (Donationproduct) object;
        if ((this.iddonationProduct == null && other.iddonationProduct != null) || (this.iddonationProduct != null && !this.iddonationProduct.equals(other.iddonationProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Donationproduct[ iddonationProduct=" + iddonationProduct + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    
}
