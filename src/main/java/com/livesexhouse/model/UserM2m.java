/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "user_m2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserM2m.findAll", query = "SELECT u FROM UserM2m u")
    , @NamedQuery(name = "UserM2m.findById", query = "SELECT u FROM UserM2m u WHERE u.id = :id")
    , @NamedQuery(name = "UserM2m.findByUserId", query = "SELECT u FROM UserM2m u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserM2m.findByFavClip", query = "SELECT u FROM UserM2m u WHERE u.favClip = :favClip")
    , @NamedQuery(name = "UserM2m.findByLikedClip", query = "SELECT u FROM UserM2m u WHERE u.likedClip = :likedClip")
    , @NamedQuery(name = "UserM2m.findByFavGirl", query = "SELECT u FROM UserM2m u WHERE u.favGirl = :favGirl")
    , @NamedQuery(name = "UserM2m.findByVote", query = "SELECT u FROM UserM2m u WHERE u.vote = :vote")
    , @NamedQuery(name = "UserM2m.findByDisLikedclip", query = "SELECT u FROM UserM2m u WHERE u.disLikedclip = :disLikedclip")})
public class UserM2m implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Column(name = "fav_clip")
    private Integer favClip;
    @Column(name = "liked_clip")
    private Integer likedClip;
    @Column(name = "fav_girl")
    private Integer favGirl;
    @Column(name = "vote")
    private Integer vote;
    @Column(name = "disLiked_clip")
    private Integer disLikedclip;

    public UserM2m() {
    }

    public UserM2m(Integer id) {
        this.id = id;
    }

    public UserM2m(Integer id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getFavClip() {
        return favClip;
    }

    public void setFavClip(Integer favClip) {
        this.favClip = favClip;
    }

    public Integer getLikedClip() {
        return likedClip;
    }

    public void setLikedClip(Integer likedClip) {
        this.likedClip = likedClip;
    }

    public Integer getFavGirl() {
        return favGirl;
    }

    public void setFavGirl(Integer favGirl) {
        this.favGirl = favGirl;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Integer getDisLikedclip() {
        return disLikedclip;
    }

    public void setDisLikedclip(Integer disLikedclip) {
        this.disLikedclip = disLikedclip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserM2m)) {
            return false;
        }
        UserM2m other = (UserM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.UserM2m[ id=" + id + " ]";
    }
    
}
