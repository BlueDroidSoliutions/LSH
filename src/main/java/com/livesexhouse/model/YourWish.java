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
@Table(name = "your_wish")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YourWish.findAll", query = "SELECT y FROM YourWish y")
    , @NamedQuery(name = "YourWish.findById", query = "SELECT y FROM YourWish y WHERE y.id = :id")
    , @NamedQuery(name = "YourWish.findByParticipant1", query = "SELECT y FROM YourWish y WHERE y.participant1 = :participant1")
    , @NamedQuery(name = "YourWish.findByParticipant2", query = "SELECT y FROM YourWish y WHERE y.participant2 = :participant2")
    , @NamedQuery(name = "YourWish.findByAction", query = "SELECT y FROM YourWish y WHERE y.action = :action")
    , @NamedQuery(name = "YourWish.findByExtra", query = "SELECT y FROM YourWish y WHERE y.extra = :extra")
    , @NamedQuery(name = "YourWish.findByLocation", query = "SELECT y FROM YourWish y WHERE y.location = :location")
    , @NamedQuery(name = "YourWish.findByUserId", query = "SELECT y FROM YourWish y WHERE y.userId = :userId")})
public class YourWish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "participant1")
    private String participant1;
    @Size(max = 32)
    @Column(name = "participant2")
    private String participant2;
    @Size(max = 32)
    @Column(name = "action")
    private String action;
    @Size(max = 32)
    @Column(name = "extra")
    private String extra;
    @Size(max = 32)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public YourWish() {
    }

    public YourWish(Integer id) {
        this.id = id;
    }

    public YourWish(Integer id, String participant1, int userId) {
        this.id = id;
        this.participant1 = participant1;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParticipant1() {
        return participant1;
    }

    public void setParticipant1(String participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2() {
        return participant2;
    }

    public void setParticipant2(String participant2) {
        this.participant2 = participant2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        if (!(object instanceof YourWish)) {
            return false;
        }
        YourWish other = (YourWish) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.YourWish[ id=" + id + " ]";
    }
    
}
