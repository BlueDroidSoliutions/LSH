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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "video_file_name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoFileName.findAll", query = "SELECT v FROM VideoFileName v")
    , @NamedQuery(name = "VideoFileName.findByClipId", query = "SELECT v FROM VideoFileName v WHERE v.clipId = :clipId")
    , @NamedQuery(name = "VideoFileName.findByFileName", query = "SELECT v FROM VideoFileName v WHERE v.fileName = :fileName")})
public class VideoFileName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clipId")
    private Integer clipId;
    @Size(max = 128)
    @Column(name = "fileName")
    private String fileName;

    public VideoFileName() {
    }

    public VideoFileName(Integer clipId) {
        this.clipId = clipId;
    }

    public Integer getClipId() {
        return clipId;
    }

    public void setClipId(Integer clipId) {
        this.clipId = clipId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clipId != null ? clipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideoFileName)) {
            return false;
        }
        VideoFileName other = (VideoFileName) object;
        if ((this.clipId == null && other.clipId != null) || (this.clipId != null && !this.clipId.equals(other.clipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.VideoFileName[ clipId=" + clipId + " ]";
    }
    
}
