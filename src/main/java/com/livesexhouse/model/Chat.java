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
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findById", query = "SELECT c FROM Chat c WHERE c.id = :id")
    , @NamedQuery(name = "Chat.findByFromUser", query = "SELECT c FROM Chat c WHERE c.fromUser = :fromUser")
    , @NamedQuery(name = "Chat.findByToUser", query = "SELECT c FROM Chat c WHERE c.toUser = :toUser")
    , @NamedQuery(name = "Chat.findByMsg", query = "SELECT c FROM Chat c WHERE c.msg = :msg")
    , @NamedQuery(name = "Chat.findByDate", query = "SELECT c FROM Chat c WHERE c.date = :date")
    , @NamedQuery(name = "Chat.findByService", query = "SELECT c FROM Chat c WHERE c.service = :service")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "from_user")
    private String fromUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "to_user")
    private String toUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "msg")
    private String msg;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "service")
    private Integer service;

    public Chat() {
    }

    public Chat(Integer id) {
        this.id = id;
    }

    public Chat(Integer id, String fromUser, String toUser, String msg) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
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
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Chat[ id=" + id + " ]";
    }
    
}
