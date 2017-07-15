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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "video_m2m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoM2m.findAll", query = "SELECT v FROM VideoM2m v")
    , @NamedQuery(name = "VideoM2m.findById", query = "SELECT v FROM VideoM2m v WHERE v.id = :id")
    , @NamedQuery(name = "VideoM2m.findByClipId", query = "SELECT v FROM VideoM2m v WHERE v.clipId = :clipId")
    , @NamedQuery(name = "VideoM2m.findByCategoryId", query = "SELECT v FROM VideoM2m v WHERE v.categoryId = :categoryId")
    , @NamedQuery(name = "VideoM2m.findByMemberHouseId", query = "SELECT v FROM VideoM2m v WHERE v.memberHouseId = :memberHouseId")
    , @NamedQuery(name = "VideoM2m.findBySeason", query = "SELECT v FROM VideoM2m v WHERE v.season = :season")
    , @NamedQuery(name = "VideoM2m.findByRoom", query = "SELECT v FROM VideoM2m v WHERE v.room = :room")})
public class VideoM2m implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clip_id")
    private int clipId;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "member_house_id")
    private Integer memberHouseId;
    @Column(name = "season")
    private Integer season;
    @Column(name = "room")
    private Integer room;

    public VideoM2m() {
    }

    public VideoM2m(Integer id) {
        this.id = id;
    }

    public VideoM2m(Integer id, int clipId) {
        this.id = id;
        this.clipId = clipId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClipId() {
        return clipId;
    }

    public void setClipId(int clipId) {
        this.clipId = clipId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getMemberHouseId() {
        return memberHouseId;
    }

    public void setMemberHouseId(Integer memberHouseId) {
        this.memberHouseId = memberHouseId;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
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
        if (!(object instanceof VideoM2m)) {
            return false;
        }
        VideoM2m other = (VideoM2m) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.VideoM2m[ id=" + id + " ]";
    }
    
}
