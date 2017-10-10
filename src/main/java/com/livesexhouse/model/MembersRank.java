/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "members_rank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MembersRank.findAll", query = "SELECT m FROM MembersRank m")
    , @NamedQuery(name = "MembersRank.findById", query = "SELECT m FROM MembersRank m WHERE m.id = :id")
    , @NamedQuery(name = "MembersRank.findByName", query = "SELECT m FROM MembersRank m WHERE m.name = :name")
    , @NamedQuery(name = "MembersRank.findByTxt", query = "SELECT m FROM MembersRank m WHERE m.txt = :txt")
    , @NamedQuery(name = "MembersRank.findByRank", query = "SELECT m FROM MembersRank m WHERE m.rank = :rank")
    , @NamedQuery(name = "MembersRank.findByVote", query = "SELECT m FROM MembersRank m WHERE m.vote = :vote")})
public class MembersRank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "txt")
    private String txt;
    @Column(name = "rank")
    private BigInteger rank;
    @Column(name = "vote")
    private Integer vote;

    public MembersRank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public BigInteger getRank() {
        return rank;
    }

    public void setRank(BigInteger rank) {
        this.rank = rank;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
    
}
