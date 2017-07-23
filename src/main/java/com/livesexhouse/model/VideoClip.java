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
@Table(name = "video_clip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoClip.findAll", query = "SELECT v FROM VideoClip v WHERE enabled = 1")
    , @NamedQuery(name = "VideoClip.findById", query = "SELECT v FROM VideoClip v WHERE v.id = :id AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByIdWithout", query = "SELECT v FROM VideoClip v WHERE v.id = :id")
    , @NamedQuery(name = "VideoClip.findByName", query = "SELECT v FROM VideoClip v WHERE v.name = :name AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByTag", query = "SELECT v FROM VideoClip v WHERE v.tag = :tag AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByWishList", query = "SELECT v FROM VideoClip v WHERE v.wishList = :wishList AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByViewCount", query = "SELECT v FROM VideoClip v WHERE v.viewCount = :viewCount AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByVoteUp", query = "SELECT v FROM VideoClip v WHERE v.voteUp = :voteUp AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByVoteDown", query = "SELECT v FROM VideoClip v WHERE v.voteDown = :voteDown AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByDuration", query = "SELECT v FROM VideoClip v WHERE v.duration = :duration AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByUploadDate", query = "SELECT v FROM VideoClip v WHERE v.uploadDate = :uploadDate AND enabled = 1")
    , @NamedQuery(name = "VideoClip.findByEnabled", query = "SELECT v FROM VideoClip v WHERE v.enabled = :enabled AND enabled = 1")})
public class VideoClip implements Serializable {

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
    @Size(max = 128)
    @Column(name = "tag")
    private String tag;
    @Column(name = "wish_list")
    private Integer wishList;
    @Column(name = "view_count")
    private Integer viewCount;
    @Column(name = "vote_up")
    private Integer voteUp;
    @Column(name = "vote_down")
    private Integer voteDown;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "upload_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @Column(name = "enabled")
    private Integer enabled;

    public VideoClip() {
    }

    public VideoClip(Integer id) {
        this.id = id;
    }

    public VideoClip(Integer id, String name) {
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getWishList() {
        return wishList;
    }

    public void setWishList(Integer wishList) {
        this.wishList = wishList;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    public Integer getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(Integer voteDown) {
        this.voteDown = voteDown;
    }

    public String getDuration() {
        int totalSecs = this.duration;

        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return timeString;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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
        if (!(object instanceof VideoClip)) {
            return false;
        }
        VideoClip other = (VideoClip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.VideoClip[ id=" + id + " ]";
    }

}
