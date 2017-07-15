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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByMemberfrom", query = "SELECT u FROM Users u WHERE u.memberfrom = :memberfrom")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByRola", query = "SELECT u FROM Users u WHERE u.rola = :rola")
    , @NamedQuery(name = "Users.findByTokens", query = "SELECT u FROM Users u WHERE u.tokens = :tokens")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByBadgeOne", query = "SELECT u FROM Users u WHERE u.badgeOne = :badgeOne")
    , @NamedQuery(name = "Users.findByBadgeTwo", query = "SELECT u FROM Users u WHERE u.badgeTwo = :badgeTwo")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memberfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberfrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rola")
    private int rola;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tokens")
    private int tokens;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "badgeOne")
    private int badgeOne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "badgeTwo")
    private int badgeTwo;
    @Size(max = 128)
    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, Date memberfrom, String username, int rola, int tokens, String email, int badgeOne, int badgeTwo) {
        this.id = id;
        this.memberfrom = memberfrom;
        this.username = username;
        this.rola = rola;
        this.tokens = tokens;
        this.email = email;
        this.badgeOne = badgeOne;
        this.badgeTwo = badgeTwo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMemberfrom() {
        return memberfrom;
    }

    public void setMemberfrom(Date memberfrom) {
        this.memberfrom = memberfrom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRola() {
        return rola;
    }

    public void setRola(int rola) {
        this.rola = rola;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBadgeOne() {
        return badgeOne;
    }

    public void setBadgeOne(int badgeOne) {
        this.badgeOne = badgeOne;
    }

    public int getBadgeTwo() {
        return badgeTwo;
    }

    public void setBadgeTwo(int badgeTwo) {
        this.badgeTwo = badgeTwo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Users[ id=" + id + " ]";
    }
    
}
