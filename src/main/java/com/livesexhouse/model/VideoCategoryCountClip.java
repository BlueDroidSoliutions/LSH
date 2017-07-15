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
@Table(name = "video_category_count_clip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoCategoryCountClip.findAll", query = "SELECT v FROM VideoCategoryCountClip v")
    , @NamedQuery(name = "VideoCategoryCountClip.findById", query = "SELECT v FROM VideoCategoryCountClip v WHERE v.id = :id")
    , @NamedQuery(name = "VideoCategoryCountClip.findByName", query = "SELECT v FROM VideoCategoryCountClip v WHERE v.name = :name")
    , @NamedQuery(name = "VideoCategoryCountClip.findByNumb", query = "SELECT v FROM VideoCategoryCountClip v WHERE v.numb = :numb")})
public class VideoCategoryCountClip implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "numb")
    private long numb;

    public VideoCategoryCountClip() {
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

    public long getNumb() {
        return numb;
    }

    public void setNumb(long numb) {
        this.numb = numb;
    }
    
}
