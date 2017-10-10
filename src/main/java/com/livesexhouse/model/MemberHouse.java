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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "member_house")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberHouse.findAll", query = "SELECT m FROM MemberHouse m")
    , @NamedQuery(name = "MemberHouse.findById", query = "SELECT m FROM MemberHouse m WHERE m.id = :id")
    , @NamedQuery(name = "MemberHouse.findByName", query = "SELECT m FROM MemberHouse m WHERE m.name = :name")
    , @NamedQuery(name = "MemberHouse.findByTxt", query = "SELECT m FROM MemberHouse m WHERE m.txt = :txt")
    , @NamedQuery(name = "MemberHouse.findByVote", query = "SELECT m FROM MemberHouse m WHERE m.vote = :vote")})
public class MemberHouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "txt")
    private String txt;
    @Column(name = "vote")
    private Integer vote;
    
    @Transient
    private int rank;
    

    public MemberHouse() {
    }

    public MemberHouse(Integer id) {
        this.id = id;
    }

    public MemberHouse(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
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
        if (!(object instanceof MemberHouse)) {
            return false;
        }
        MemberHouse other = (MemberHouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.MemberHouse[ id=" + id + " ]";
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
    
}
