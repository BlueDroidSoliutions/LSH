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
@Table(name = "blockedRegionM2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockedRegionM2m.findAll", query = "SELECT b FROM BlockedRegionM2m b")
    , @NamedQuery(name = "BlockedRegionM2m.findById", query = "SELECT b FROM BlockedRegionM2m b WHERE b.id = :id")
    , @NamedQuery(name = "BlockedRegionM2m.findByUserId", query = "SELECT b FROM BlockedRegionM2m b WHERE b.userId = :userId")
    , @NamedQuery(name = "BlockedRegionM2m.findByBlockedRegionId", query = "SELECT b FROM BlockedRegionM2m b WHERE b.blockedRegionId = :blockedRegionId")})
public class BlockedRegionM2m implements Serializable {

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
    @Column(name = "blockedRegionId")
    private int blockedRegionId;

    public BlockedRegionM2m() {
    }

    public BlockedRegionM2m(Integer id) {
        this.id = id;
    }

    public BlockedRegionM2m(Integer id, int userId, int blockedRegionId) {
        this.id = id;
        this.userId = userId;
        this.blockedRegionId = blockedRegionId;
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

    public int getBlockedRegionId() {
        return blockedRegionId;
    }

    public void setBlockedRegionId(int blockedRegionId) {
        this.blockedRegionId = blockedRegionId;
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
        if (!(object instanceof BlockedRegionM2m)) {
            return false;
        }
        BlockedRegionM2m other = (BlockedRegionM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.BlockedRegionM2m[ id=" + id + " ]";
    }
    
}
