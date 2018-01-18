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
@Table(name = "kinkyM2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KinkyM2m.findAll", query = "SELECT k FROM KinkyM2m k")
    , @NamedQuery(name = "KinkyM2m.findById", query = "SELECT k FROM KinkyM2m k WHERE k.id = :id")
    , @NamedQuery(name = "KinkyM2m.findByUserId", query = "SELECT k FROM KinkyM2m k WHERE k.userId = :userId")
    , @NamedQuery(name = "KinkyM2m.findByKinkyId", query = "SELECT k FROM KinkyM2m k WHERE k.kinkyId = :kinkyId")})
public class KinkyM2m implements Serializable {

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
    @Column(name = "kinkyId")
    private int kinkyId;

    public KinkyM2m() {
    }

    public KinkyM2m(Integer id) {
        this.id = id;
    }

    public KinkyM2m(Integer id, int userId, int kinkyId) {
        this.id = id;
        this.userId = userId;
        this.kinkyId = kinkyId;
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

    public int getKinkyId() {
        return kinkyId;
    }

    public void setKinkyId(int kinkyId) {
        this.kinkyId = kinkyId;
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
        if (!(object instanceof KinkyM2m)) {
            return false;
        }
        KinkyM2m other = (KinkyM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.KinkyM2m[ id=" + id + " ]";
    }
    
}
