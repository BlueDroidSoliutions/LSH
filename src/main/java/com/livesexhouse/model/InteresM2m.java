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
@Table(name = "interesM2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InteresM2m.findAll", query = "SELECT i FROM InteresM2m i")
    , @NamedQuery(name = "InteresM2m.findById", query = "SELECT i FROM InteresM2m i WHERE i.id = :id")
    , @NamedQuery(name = "InteresM2m.findByUserId", query = "SELECT i FROM InteresM2m i WHERE i.userId = :userId")
    , @NamedQuery(name = "InteresM2m.findByInteresId", query = "SELECT i FROM InteresM2m i WHERE i.interesId = :interesId")})
public class InteresM2m implements Serializable {

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
    @Column(name = "interesId")
    private int interesId;

    public InteresM2m() {
    }

    public InteresM2m(Integer id) {
        this.id = id;
    }

    public InteresM2m(Integer id, int userId, int interesId) {
        this.id = id;
        this.userId = userId;
        this.interesId = interesId;
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

    public int getInteresId() {
        return interesId;
    }

    public void setInteresId(int interesId) {
        this.interesId = interesId;
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
        if (!(object instanceof InteresM2m)) {
            return false;
        }
        InteresM2m other = (InteresM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.InteresM2m[ id=" + id + " ]";
    }
    
}
