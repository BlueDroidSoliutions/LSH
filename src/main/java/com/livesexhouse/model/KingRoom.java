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
@Table(name = "king_room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KingRoom.findAll", query = "SELECT k FROM KingRoom k")
    , @NamedQuery(name = "KingRoom.findById", query = "SELECT k FROM KingRoom k WHERE k.id = :id")
    , @NamedQuery(name = "KingRoom.findByGirl", query = "SELECT k FROM KingRoom k WHERE k.girl = :girl")
    , @NamedQuery(name = "KingRoom.findByUser", query = "SELECT k FROM KingRoom k WHERE k.user = :user")
    , @NamedQuery(name = "KingRoom.findByToken", query = "SELECT k FROM KingRoom k WHERE k.token = :token")})
public class KingRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "girl")
    private int girl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user")
    private int user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "token")
    private int token;

    public KingRoom() {
    }

    public KingRoom(Integer id) {
        this.id = id;
    }

    public KingRoom(Integer id, int girl, int user, int token) {
        this.id = id;
        this.girl = girl;
        this.user = user;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGirl() {
        return girl;
    }

    public void setGirl(int girl) {
        this.girl = girl;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
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
        if (!(object instanceof KingRoom)) {
            return false;
        }
        KingRoom other = (KingRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.KingRoom[ id=" + id + " ]";
    }
    
}
