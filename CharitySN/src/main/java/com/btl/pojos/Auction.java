/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "auction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a"),
    @NamedQuery(name = "Auction.findByIdAuction", query = "SELECT a FROM Auction a WHERE a.idAuction = :idAuction"),
    @NamedQuery(name = "Auction.findByPay", query = "SELECT a FROM Auction a WHERE a.pay = :pay"),
    @NamedQuery(name = "Auction.findByCreated", query = "SELECT a FROM Auction a WHERE a.created = :created")})
public class Auction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuction")
    private Integer idAuction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pay")
    private int pay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @JoinColumn(name = "donationProduct_id", referencedColumnName = "iddonationProduct")
    @ManyToOne(optional = false)
    private Donationproduct donationProductid;
    @JoinColumn(name = "user_id", referencedColumnName = "idUsers")
    @ManyToOne(optional = false)
    private Users userId;

    public Auction() {
    }

    public Auction(Integer idAuction) {
        this.idAuction = idAuction;
    }

    public Auction(Integer idAuction, int pay, Date created) {
        this.idAuction = idAuction;
        this.pay = pay;
        this.created = created;
    }

    public Integer getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(Integer idAuction) {
        this.idAuction = idAuction;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Donationproduct getDonationProductid() {
        return donationProductid;
    }

    public void setDonationProductid(Donationproduct donationProductid) {
        this.donationProductid = donationProductid;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuction != null ? idAuction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auction)) {
            return false;
        }
        Auction other = (Auction) object;
        if ((this.idAuction == null && other.idAuction != null) || (this.idAuction != null && !this.idAuction.equals(other.idAuction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Auction[ idAuction=" + idAuction + " ]";
    }
    
}
