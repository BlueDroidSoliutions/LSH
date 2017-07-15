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
@Table(name = "girls_m2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GirlsM2m.findAll", query = "SELECT g FROM GirlsM2m g")
    , @NamedQuery(name = "GirlsM2m.findById", query = "SELECT g FROM GirlsM2m g WHERE g.id = :id")
    , @NamedQuery(name = "GirlsM2m.findByGirlId", query = "SELECT g FROM GirlsM2m g WHERE g.girlId = :girlId")
    , @NamedQuery(name = "GirlsM2m.findByPiercing", query = "SELECT g FROM GirlsM2m g WHERE g.piercing = :piercing")
    , @NamedQuery(name = "GirlsM2m.findByHair", query = "SELECT g FROM GirlsM2m g WHERE g.hair = :hair")
    , @NamedQuery(name = "GirlsM2m.findByDress", query = "SELECT g FROM GirlsM2m g WHERE g.dress = :dress")
    , @NamedQuery(name = "GirlsM2m.findByDoStuff", query = "SELECT g FROM GirlsM2m g WHERE g.doStuff = :doStuff")})
public class GirlsM2m implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "girl_id")
    private int girlId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piercing")
    private int piercing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hair")
    private int hair;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dress")
    private int dress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "do_stuff")
    private int doStuff;

    public GirlsM2m() {
    }

    public GirlsM2m(Integer id) {
        this.id = id;
    }

    public GirlsM2m(Integer id, int girlId, int piercing, int hair, int dress, int doStuff) {
        this.id = id;
        this.girlId = girlId;
        this.piercing = piercing;
        this.hair = hair;
        this.dress = dress;
        this.doStuff = doStuff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGirlId() {
        return girlId;
    }

    public void setGirlId(int girlId) {
        this.girlId = girlId;
    }

    public int getPiercing() {
        return piercing;
    }

    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }

    public int getHair() {
        return hair;
    }

    public void setHair(int hair) {
        this.hair = hair;
    }

    public int getDress() {
        return dress;
    }

    public void setDress(int dress) {
        this.dress = dress;
    }

    public int getDoStuff() {
        return doStuff;
    }

    public void setDoStuff(int doStuff) {
        this.doStuff = doStuff;
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
        if (!(object instanceof GirlsM2m)) {
            return false;
        }
        GirlsM2m other = (GirlsM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.GirlsM2m[ id=" + id + " ]";
    }
    
}
