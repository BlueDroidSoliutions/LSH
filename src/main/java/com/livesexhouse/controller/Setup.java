/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.controller;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "setup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setup.findAll", query = "SELECT s FROM Setup s")
    , @NamedQuery(name = "Setup.findById", query = "SELECT s FROM Setup s WHERE s.id = :id")
    , @NamedQuery(name = "Setup.findByNameString", query = "SELECT s FROM Setup s WHERE s.nameString = :nameString")
    , @NamedQuery(name = "Setup.findByNameInt", query = "SELECT s FROM Setup s WHERE s.nameInt = :nameInt")
    , @NamedQuery(name = "Setup.findByValueString", query = "SELECT s FROM Setup s WHERE s.valueString = :valueString")
    , @NamedQuery(name = "Setup.findByValueInt", query = "SELECT s FROM Setup s WHERE s.valueInt = :valueInt")})
public class Setup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "nameString")
    private String nameString;
    @Column(name = "nameInt")
    private Integer nameInt;
    @Size(max = 128)
    @Column(name = "valueString")
    private String valueString;
    @Column(name = "valueInt")
    private Integer valueInt;

    public Setup() {
    }

    public Setup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public Integer getNameInt() {
        return nameInt;
    }

    public void setNameInt(Integer nameInt) {
        this.nameInt = nameInt;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public Integer getValueInt() {
        return valueInt;
    }

    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
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
        if (!(object instanceof Setup)) {
            return false;
        }
        Setup other = (Setup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Setup[ id=" + id + " ]";
    }
    
}
