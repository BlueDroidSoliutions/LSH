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
@Table(name = "heartbeat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heartbeat.findAll", query = "SELECT h FROM Heartbeat h")
    , @NamedQuery(name = "Heartbeat.findById", query = "SELECT h FROM Heartbeat h WHERE h.id = :id")
    , @NamedQuery(name = "Heartbeat.findByUser", query = "SELECT h FROM Heartbeat h WHERE h.user = :user")
    , @NamedQuery(name = "Heartbeat.findByPrice", query = "SELECT h FROM Heartbeat h WHERE h.price = :price")
    , @NamedQuery(name = "Heartbeat.findByStatus", query = "SELECT h FROM Heartbeat h WHERE h.status = :status")
    , @NamedQuery(name = "Heartbeat.findByGirl", query = "SELECT h FROM Heartbeat h WHERE h.girl = :girl")})
public class Heartbeat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user")
    private int user;
    @Column(name = "price")
    private Integer price;
    @Column(name = "status")
    private Integer status;
    @Column(name = "girl")
    private Integer girl;

    public Heartbeat() {
    }

    public Heartbeat(Integer id) {
        this.id = id;
    }

    public Heartbeat(Integer id, int user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGirl() {
        return girl;
    }

    public void setGirl(Integer girl) {
        this.girl = girl;
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
        if (!(object instanceof Heartbeat)) {
            return false;
        }
        Heartbeat other = (Heartbeat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Heartbeat[ id=" + id + " ]";
    }
    
}
