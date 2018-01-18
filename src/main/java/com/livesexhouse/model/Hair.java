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
@Table(name = "hair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hair.findAll", query = "SELECT h FROM Hair h")
    , @NamedQuery(name = "Hair.findById", query = "SELECT h FROM Hair h WHERE h.id = :id")
    , @NamedQuery(name = "Hair.findByHairName", query = "SELECT h FROM Hair h WHERE h.hairName = :hairName")})
public class Hair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "hair_name")
    private String hairName;

    public Hair() {
    }

    public Hair(Integer id) {
        this.id = id;
    }

    public Hair(Integer id, String hairName) {
        this.id = id;
        this.hairName = hairName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHairName() {
        return hairName;
    }

    public void setHairName(String hairName) {
        this.hairName = hairName;
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
        if (!(object instanceof Hair)) {
            return false;
        }
        Hair other = (Hair) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Hair[ id=" + id + " ]";
    }
    
}
