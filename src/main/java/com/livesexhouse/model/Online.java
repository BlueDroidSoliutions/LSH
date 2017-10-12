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
@Table(name = "online")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Online.findAll", query = "SELECT o FROM Online o")
    , @NamedQuery(name = "Online.findById", query = "SELECT o FROM Online o WHERE o.id = :id")
        , @NamedQuery(name = "Online.findGirlO", query = "SELECT o.id FROM Online o WHERE o.status = 4")
        , @NamedQuery(name = "Online.findGirlOP", query = "SELECT o.id FROM Online o WHERE o.status = 6")
        , @NamedQuery(name = "Online.findGirlM", query = "SELECT o.id FROM Online o WHERE o.status = 3")
        , @NamedQuery(name = "Online.findGirlMP", query = "SELECT o.id FROM Online o WHERE o.status = 5")
        , @NamedQuery(name = "Online.findMemberOnline", query = "SELECT o.id FROM Online o WHERE o.status = 5")
        , @NamedQuery(name = "Online.findAllOnline", query = "SELECT o.id FROM Online o WHERE o.status = 2 OR o.status = 3 OR o.status = 4")
    , @NamedQuery(name = "Online.findByStatus", query = "SELECT o.id FROM Online o WHERE o.status = :status")})
public class Online implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public Online() {
    }

    public Online(Integer id) {
        this.id = id;
    }

    public Online(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Online)) {
            return false;
        }
        Online other = (Online) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Online[ id=" + id + " ]";
    }
    
}
