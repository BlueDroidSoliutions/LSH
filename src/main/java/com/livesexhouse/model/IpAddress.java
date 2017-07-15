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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "ip_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpAddress.findAll", query = "SELECT i FROM IpAddress i")
    , @NamedQuery(name = "IpAddress.findById", query = "SELECT i FROM IpAddress i WHERE i.id = :id")
    , @NamedQuery(name = "IpAddress.findByUserId", query = "SELECT i FROM IpAddress i WHERE i.userId = :userId")
    , @NamedQuery(name = "IpAddress.findByIpAddress", query = "SELECT i FROM IpAddress i WHERE i.ipAddress = :ipAddress")})
public class IpAddress implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ip_address")
    private String ipAddress;

    public IpAddress() {
    }

    public IpAddress(Integer id) {
        this.id = id;
    }

    public IpAddress(Integer id, int userId, String ipAddress) {
        this.id = id;
        this.userId = userId;
        this.ipAddress = ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
        if (!(object instanceof IpAddress)) {
            return false;
        }
        IpAddress other = (IpAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.IpAddress[ id=" + id + " ]";
    }
    
}
