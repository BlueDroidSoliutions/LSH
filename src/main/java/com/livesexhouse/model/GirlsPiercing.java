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
@Table(name = "girls_piercing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GirlsPiercing.findAll", query = "SELECT g FROM GirlsPiercing g")
    , @NamedQuery(name = "GirlsPiercing.findById", query = "SELECT g FROM GirlsPiercing g WHERE g.id = :id")
    , @NamedQuery(name = "GirlsPiercing.findByWhere", query = "SELECT g FROM GirlsPiercing g WHERE g.where = :where")})
public class GirlsPiercing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "where")
    private String where;

    public GirlsPiercing() {
    }

    public GirlsPiercing(Integer id) {
        this.id = id;
    }

    public GirlsPiercing(Integer id, String where) {
        this.id = id;
        this.where = where;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
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
        if (!(object instanceof GirlsPiercing)) {
            return false;
        }
        GirlsPiercing other = (GirlsPiercing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.GirlsPiercing[ id=" + id + " ]";
    }
    
}
