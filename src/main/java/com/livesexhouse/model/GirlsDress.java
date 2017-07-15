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
@Table(name = "girls_dress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GirlsDress.findAll", query = "SELECT g FROM GirlsDress g")
    , @NamedQuery(name = "GirlsDress.findById", query = "SELECT g FROM GirlsDress g WHERE g.id = :id")
    , @NamedQuery(name = "GirlsDress.findByDress", query = "SELECT g FROM GirlsDress g WHERE g.dress = :dress")})
public class GirlsDress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "dress")
    private String dress;

    public GirlsDress() {
    }

    public GirlsDress(Integer id) {
        this.id = id;
    }

    public GirlsDress(Integer id, String dress) {
        this.id = id;
        this.dress = dress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDress() {
        return dress;
    }

    public void setDress(String dress) {
        this.dress = dress;
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
        if (!(object instanceof GirlsDress)) {
            return false;
        }
        GirlsDress other = (GirlsDress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.GirlsDress[ id=" + id + " ]";
    }
    
}
