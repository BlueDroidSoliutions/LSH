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
@Table(name = "blockedCountry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlockedCountry.findAll", query = "SELECT b FROM BlockedCountry b")
    , @NamedQuery(name = "BlockedCountry.findById", query = "SELECT b FROM BlockedCountry b WHERE b.id = :id")
    , @NamedQuery(name = "BlockedCountry.findByBlockedCountryname", query = "SELECT b FROM BlockedCountry b WHERE b.blockedCountryname = :blockedCountryname")})
public class BlockedCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "blockedCountry_name")
    private String blockedCountryname;

    public BlockedCountry() {
    }

    public BlockedCountry(Integer id) {
        this.id = id;
    }

    public BlockedCountry(Integer id, String blockedCountryname) {
        this.id = id;
        this.blockedCountryname = blockedCountryname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlockedCountryname() {
        return blockedCountryname;
    }

    public void setBlockedCountryname(String blockedCountryname) {
        this.blockedCountryname = blockedCountryname;
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
        if (!(object instanceof BlockedCountry)) {
            return false;
        }
        BlockedCountry other = (BlockedCountry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.BlockedCountry[ id=" + id + " ]";
    }
    
}
