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
@Table(name = "user_bck_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBckData.findAll", query = "SELECT u FROM UserBckData u")
    , @NamedQuery(name = "UserBckData.findById", query = "SELECT u FROM UserBckData u WHERE u.id = :id")
    , @NamedQuery(name = "UserBckData.findByName", query = "SELECT u FROM UserBckData u WHERE u.name = :name")
    , @NamedQuery(name = "UserBckData.findByState", query = "SELECT u FROM UserBckData u WHERE u.state = :state")
    , @NamedQuery(name = "UserBckData.findByCity", query = "SELECT u FROM UserBckData u WHERE u.city = :city")
    , @NamedQuery(name = "UserBckData.findByZipCode", query = "SELECT u FROM UserBckData u WHERE u.zipCode = :zipCode")})
public class UserBckData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "zip_code")
    private String zipCode;

    public UserBckData() {
    }

    public UserBckData(Integer id) {
        this.id = id;
    }

    public UserBckData(Integer id, String name, String state, String city, String zipCode) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
        if (!(object instanceof UserBckData)) {
            return false;
        }
        UserBckData other = (UserBckData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.UserBckData[ id=" + id + " ]";
    }
    
}
