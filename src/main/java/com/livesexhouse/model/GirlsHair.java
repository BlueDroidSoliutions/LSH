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
@Table(name = "girls_hair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GirlsHair.findAll", query = "SELECT g FROM GirlsHair g")
    , @NamedQuery(name = "GirlsHair.findById", query = "SELECT g FROM GirlsHair g WHERE g.id = :id")
    , @NamedQuery(name = "GirlsHair.findByHair", query = "SELECT g FROM GirlsHair g WHERE g.hair = :hair")})
public class GirlsHair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "hair")
    private String hair;

    public GirlsHair() {
    }

    public GirlsHair(Integer id) {
        this.id = id;
    }

    public GirlsHair(Integer id, String hair) {
        this.id = id;
        this.hair = hair;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
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
        if (!(object instanceof GirlsHair)) {
            return false;
        }
        GirlsHair other = (GirlsHair) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.GirlsHair[ id=" + id + " ]";
    }
    
}
