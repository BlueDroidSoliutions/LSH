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
@Table(name = "interes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interes.findAll", query = "SELECT i FROM Interes i")
    , @NamedQuery(name = "Interes.findById", query = "SELECT i FROM Interes i WHERE i.id = :id")
    , @NamedQuery(name = "Interes.findByInteresName", query = "SELECT i FROM Interes i WHERE i.interesName = :interesName")})
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "interes_name")
    private String interesName;

    public Interes() {
    }

    public Interes(Integer id) {
        this.id = id;
    }

    public Interes(Integer id, String interesName) {
        this.id = id;
        this.interesName = interesName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInteresName() {
        return interesName;
    }

    public void setInteresName(String interesName) {
        this.interesName = interesName;
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
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Interes[ id=" + id + " ]";
    }
    
}
