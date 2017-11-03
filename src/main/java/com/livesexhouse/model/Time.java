/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")
    , @NamedQuery(name = "Time.findById", query = "SELECT t FROM Time t WHERE t.id = :id")
    , @NamedQuery(name = "Time.findByUserId", query = "SELECT t FROM Time t WHERE t.userId = :userId")
    , @NamedQuery(name = "Time.findByTime", query = "SELECT t FROM Time t WHERE t.time = :time")
        , @NamedQuery(name = "Time.findByUserIdPr", query = "SELECT t FROM Time t WHERE t.userId = :userId AND girlId = :girlId AND t.status = 1")
    , @NamedQuery(name = "Time.findByUserIdGr", query = "SELECT t FROM Time t WHERE t.userId = :userId AND girlId = :girlId AND t.status = 2")
    , @NamedQuery(name = "Time.findByStatus", query = "SELECT t FROM Time t WHERE t.status = :status")
    , @NamedQuery(name = "Time.findByGirlId", query = "SELECT t FROM Time t WHERE t.girlId = :girlId")})
public class Time implements Serializable {

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
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "girlId")
    private int girlId;

    public Time() {
    }

    public Time(Integer id) {
        this.id = id;
    }

    public Time(Integer id, int userId, Date time, int status, int girlId) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.status = status;
        this.girlId = girlId;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGirlId() {
        return girlId;
    }

    public void setGirlId(int girlId) {
        this.girlId = girlId;
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
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Time[ id=" + id + " ]";
    }
    
}
