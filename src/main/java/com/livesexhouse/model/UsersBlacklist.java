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
@Table(name = "users_blacklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersBlacklist.findAll", query = "SELECT u FROM UsersBlacklist u")
    , @NamedQuery(name = "UsersBlacklist.findById", query = "SELECT u FROM UsersBlacklist u WHERE u.id = :id")
    , @NamedQuery(name = "UsersBlacklist.findByIp", query = "SELECT u FROM UsersBlacklist u WHERE u.ip = :ip")})
public class UsersBlacklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ip")
    private String ip;

    public UsersBlacklist() {
    }

    public UsersBlacklist(Integer id) {
        this.id = id;
    }

    public UsersBlacklist(Integer id, String ip) {
        this.id = id;
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        if (!(object instanceof UsersBlacklist)) {
            return false;
        }
        UsersBlacklist other = (UsersBlacklist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.UsersBlacklist[ id=" + id + " ]";
    }
    
}
