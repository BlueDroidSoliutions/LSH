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
@Table(name = "blockedRegion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockedRegion.findAll", query = "SELECT b FROM BlockedRegion b")
    , @NamedQuery(name = "BlockedRegion.findById", query = "SELECT b FROM BlockedRegion b WHERE b.id = :id")
    , @NamedQuery(name = "BlockedRegion.findByBlockedRegionname", query = "SELECT b FROM BlockedRegion b WHERE b.blockedRegionname = :blockedRegionname")})
public class BlockedRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "blockedRegion_name")
    private String blockedRegionname;

    public BlockedRegion() {
    }

    public BlockedRegion(Integer id) {
        this.id = id;
    }

    public BlockedRegion(Integer id, String blockedRegionname) {
        this.id = id;
        this.blockedRegionname = blockedRegionname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlockedRegionname() {
        return blockedRegionname;
    }

    public void setBlockedRegionname(String blockedRegionname) {
        this.blockedRegionname = blockedRegionname;
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
        if (!(object instanceof BlockedRegion)) {
            return false;
        }
        BlockedRegion other = (BlockedRegion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.BlockedRegion[ id=" + id + " ]";
    }
    
}