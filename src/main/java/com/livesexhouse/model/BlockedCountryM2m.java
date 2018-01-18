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
@Table(name = "blockedCountryM2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockedCountryM2m.findAll", query = "SELECT b FROM BlockedCountryM2m b")
    , @NamedQuery(name = "BlockedCountryM2m.findById", query = "SELECT b FROM BlockedCountryM2m b WHERE b.id = :id")
    , @NamedQuery(name = "BlockedCountryM2m.findByUserId", query = "SELECT b FROM BlockedCountryM2m b WHERE b.userId = :userId")
    , @NamedQuery(name = "BlockedCountryM2m.findByBlockedCountryId", query = "SELECT b FROM BlockedCountryM2m b WHERE b.blockedCountryId = :blockedCountryId")})
public class BlockedCountryM2m implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blockedCountryId")
    private int blockedCountryId;

    public BlockedCountryM2m() {
    }

    public BlockedCountryM2m(Integer id) {
        this.id = id;
    }

    public BlockedCountryM2m(Integer id, int userId, int blockedCountryId) {
        this.id = id;
        this.userId = userId;
        this.blockedCountryId = blockedCountryId;
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

    public int getBlockedCountryId() {
        return blockedCountryId;
    }

    public void setBlockedCountryId(int blockedCountryId) {
        this.blockedCountryId = blockedCountryId;
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
        if (!(object instanceof BlockedCountryM2m)) {
            return false;
        }
        BlockedCountryM2m other = (BlockedCountryM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.BlockedCountryM2m[ id=" + id + " ]";
    }
    
}
