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
import javax.persistence.Lob;
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
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByIdcomments", query = "SELECT c FROM Comments c WHERE c.idcomments = :idcomments"),
    @NamedQuery(name = "Comments.findByImage", query = "SELECT c FROM Comments c WHERE c.image = :image"),
    @NamedQuery(name = "Comments.findBySticker", query = "SELECT c FROM Comments c WHERE c.sticker = :sticker"),
    @NamedQuery(name = "Comments.findByReply", query = "SELECT c FROM Comments c WHERE c.reply = :reply")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomments")
    private Integer idcomments;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "content")
    private String content;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @Size(max = 45)
    @Column(name = "sticker")
    private String sticker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reply")
    private String reply;
    @JoinColumn(name = "post_id", referencedColumnName = "idPosts")
    @ManyToOne(optional = false)
    private Posts postId;
    @JoinColumn(name = "user_id", referencedColumnName = "idUsers")
    @ManyToOne(optional = false)
    private Users userId;

    public Comments() {
    }

    public Comments(Integer idcomments) {
        this.idcomments = idcomments;
    }

    public Comments(Integer idcomments, String content, String reply) {
        this.idcomments = idcomments;
        this.content = content;
        this.reply = reply;
    }

    public Integer getIdcomments() {
        return idcomments;
    }

    public void setIdcomments(Integer idcomments) {
        this.idcomments = idcomments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSticker() {
        return sticker;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Posts getPostId() {
        return postId;
    }

    public void setPostId(Posts postId) {
        this.postId = postId;
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
        hash += (idcomments != null ? idcomments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.idcomments == null && other.idcomments != null) || (this.idcomments != null && !this.idcomments.equals(other.idcomments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Comments[ idcomments=" + idcomments + " ]";
    }
    
}
