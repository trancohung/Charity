/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Donationproduct.findByStatus", query = "SELECT d FROM Donationproduct d WHERE d.status = :status"),
    @NamedQuery(name = "Donationproduct.findByName", query = "SELECT d FROM Donationproduct d WHERE d.name = :name"),
    @NamedQuery(name = "Donationproduct.findByPrice", query = "SELECT d FROM Donationproduct d WHERE d.price = :price")})
public class Donationproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonationProduct")
    private Integer iddonationProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationProductid")
    private Collection<Image> imageCollection;
    @JoinColumn(name = "post_id", referencedColumnName = "idPosts")
    @ManyToOne(optional = false)
    private Posts postId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donationProductid")
    private Collection<Auction> auctionCollection;

    public Donationproduct() {
    }

    public Donationproduct(Integer iddonationProduct) {
        this.iddonationProduct = iddonationProduct;
    }

    public Donationproduct(Integer iddonationProduct, short status, String name, BigDecimal price) {
        this.iddonationProduct = iddonationProduct;
        this.status = status;
        this.name = name;
        this.price = price;
    }

    public Integer getIddonationProduct() {
        return iddonationProduct;
    }

    public void setIddonationProduct(Integer iddonationProduct) {
        this.iddonationProduct = iddonationProduct;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Image> getImageCollection() {
        return imageCollection;
    }

    public void setImageCollection(Collection<Image> imageCollection) {
        this.imageCollection = imageCollection;
    }

    public Posts getPostId() {
        return postId;
    }

    public void setPostId(Posts postId) {
        this.postId = postId;
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
    
}
