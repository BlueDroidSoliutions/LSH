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
@Table(name = "girls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Girls.findAll", query = "SELECT g FROM Girls g")
    , @NamedQuery(name = "Girls.findById", query = "SELECT g FROM Girls g WHERE g.id = :id")
    , @NamedQuery(name = "Girls.findByName", query = "SELECT g FROM Girls g WHERE g.name = :name")
    , @NamedQuery(name = "Girls.findByGender", query = "SELECT g FROM Girls g WHERE g.gender = :gender")
    , @NamedQuery(name = "Girls.findByAge", query = "SELECT g FROM Girls g WHERE g.age = :age")
    , @NamedQuery(name = "Girls.findByState", query = "SELECT g FROM Girls g WHERE g.state = :state")
    , @NamedQuery(name = "Girls.findByCity", query = "SELECT g FROM Girls g WHERE g.city = :city")
    , @NamedQuery(name = "Girls.findByZipCode", query = "SELECT g FROM Girls g WHERE g.zipCode = :zipCode")
    , @NamedQuery(name = "Girls.findByEmail", query = "SELECT g FROM Girls g WHERE g.email = :email")
    , @NamedQuery(name = "Girls.findByUserName", query = "SELECT g FROM Girls g WHERE g.userName = :userName")
    , @NamedQuery(name = "Girls.findByLike", query = "SELECT g FROM Girls g WHERE g.like = :like")
    , @NamedQuery(name = "Girls.findByBreast", query = "SELECT g FROM Girls g WHERE g.breast = :breast")
    , @NamedQuery(name = "Girls.findByWeight", query = "SELECT g FROM Girls g WHERE g.weight = :weight")
    , @NamedQuery(name = "Girls.findByPiercing", query = "SELECT g FROM Girls g WHERE g.piercing = :piercing")
    , @NamedQuery(name = "Girls.findByShave", query = "SELECT g FROM Girls g WHERE g.shave = :shave")
    , @NamedQuery(name = "Girls.findByToy", query = "SELECT g FROM Girls g WHERE g.toy = :toy")
    , @NamedQuery(name = "Girls.findByStory", query = "SELECT g FROM Girls g WHERE g.story = :story")
    , @NamedQuery(name = "Girls.findByEnabled", query = "SELECT g FROM Girls g WHERE g.enabled = 1")
    , @NamedQuery(name = "Girls.findByPrivateTariff", query = "SELECT g FROM Girls g WHERE g.privateTariff = :privateTariff")
    , @NamedQuery(name = "Girls.findByGroupTariff", query = "SELECT g FROM Girls g WHERE g.groupTariff = :groupTariff")
        
        
//    , @NamedQuery(name = "Girls.findByGroupTariff", query = "SELECT g FROM Girls g WHERE g.groupTariff = :groupTariff")    
        
        
        
        
    , @NamedQuery(name = "Girls.findByGroupMinPerson", query = "SELECT g FROM Girls g WHERE g.groupMinPerson = :groupMinPerson")})
public class Girls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "age")
    private Integer age;
    @Size(max = 128)
    @Column(name = "state")
    private String state;
    @Size(max = 128)
    @Column(name = "city")
    private String city;
    @Size(max = 16)
    @Column(name = "zip_code")
    private String zipCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 128)
    @Column(name = "email")
    private String email;
    @Size(max = 128)
    @Column(name = "user_name")
    private String userName;
    @Column(name = "like")
    private Integer like;
    @Column(name = "breast")
    private Integer breast;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "piercing")
    private Boolean piercing;
    @Column(name = "shave")
    private Boolean shave;
    @Column(name = "toy")
    private Boolean toy;
    @Size(max = 255)
    @Column(name = "story")
    private String story;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "private_tariff")
    private Integer privateTariff;
    @Column(name = "group_tariff")
    private Integer groupTariff;
    @Column(name = "group_min_person")
    private Integer groupMinPerson;

    public Girls() {
    }

    public Girls(Integer id) {
        this.id = id;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getBreast() {
        return breast;
    }

    public void setBreast(Integer breast) {
        this.breast = breast;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getPiercing() {
        return piercing;
    }

    public void setPiercing(Boolean piercing) {
        this.piercing = piercing;
    }

    public Boolean getShave() {
        return shave;
    }

    public void setShave(Boolean shave) {
        this.shave = shave;
    }

    public Boolean getToy() {
        return toy;
    }

    public void setToy(Boolean toy) {
        this.toy = toy;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getPrivateTariff() {
        return privateTariff;
    }

    public void setPrivateTariff(Integer privateTariff) {
        this.privateTariff = privateTariff;
    }

    public Integer getGroupTariff() {
        return groupTariff;
    }

    public void setGroupTariff(Integer groupTariff) {
        this.groupTariff = groupTariff;
    }

    public Integer getGroupMinPerson() {
        return groupMinPerson;
    }

    public void setGroupMinPerson(Integer groupMinPerson) {
        this.groupMinPerson = groupMinPerson;
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
        if (!(object instanceof Girls)) {
            return false;
        }
        Girls other = (Girls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Girls[ id=" + id + " ]";
    }
    
}
