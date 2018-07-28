/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled")
    , @NamedQuery(name = "Users.findByTokens", query = "SELECT u FROM Users u WHERE u.tokens = :tokens")
    , @NamedQuery(name = "Users.findByMemberfrom", query = "SELECT u FROM Users u WHERE u.memberfrom = :memberfrom")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "enabled")
    private short enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tokens")
    private int tokens;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memberfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberfrom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "email")
    private String email;

    @Column(name = "epoch_cam_charge_member_id")
    private String epochCamChargeMemberId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "user_id")
    private List<Membership> memberships;
    
    @Transient
    private final Boolean isVipMember = isVipMember();

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, short enabled, int tokens, Date memberfrom, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.tokens = tokens;
        this.memberfrom = memberfrom;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public Date getMemberfrom() {
        return memberfrom;
    }

    public void setMemberfrom(Date memberfrom) {
        this.memberfrom = memberfrom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEpochCamChargeMemberId() {
        return epochCamChargeMemberId;
    }

    public void setEpochCamChargeMemberId(String epochCamChargeMemberId) {
        this.epochCamChargeMemberId = epochCamChargeMemberId;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships;
    }
    
    public void addMembership(String externalMembershipId) {
    	if (this.memberships == null) {
    		this.memberships = new ArrayList<>();
    	}
    	Membership membership = new Membership();
    	membership.setActive(Boolean.TRUE);
    	membership.setStartDate(new Date());
    	Date endDate = Date.from(LocalDateTime.now().plusDays(30).atZone(ZoneId.systemDefault()).toInstant());
    	membership.setEndDate(endDate);
    	this.memberships.add(membership);
    }
    
    public Boolean isVipMember() {
    	if (memberships == null || memberships.isEmpty()) {
    		return Boolean.FALSE;
    	}
    	Date now = new Date();
    	return memberships.stream().filter(m -> m.getActive() && m.getStartDate().before(now) && m.getEndDate().after(now)).findFirst().isPresent();
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