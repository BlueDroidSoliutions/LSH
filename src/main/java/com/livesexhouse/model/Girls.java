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
    , @NamedQuery(name = "Girls.findByStory", query = "SELECT g FROM Girls g WHERE g.story = :story")})
public class Girls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private boolean gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "zip_code")
    private String zipCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_name")
    private String userName;
    @Column(name = "like")
    private Integer like;
    @Basic(optional = false)
    @NotNull
    @Column(name = "breast")
    private int breast;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private int weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piercing")
    private boolean piercing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shave")
    private boolean shave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "toy")
    private boolean toy;
    @Size(max = 255)
    @Column(name = "story")
    private String story;

    public Girls() {
    }

    public Girls(Integer id) {
        this.id = id;
    }

    public Girls(Integer id, String name, boolean gender, int age, String state, String city, String zipCode, String email, String userName, int breast, int weight, boolean piercing, boolean shave, boolean toy) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
        this.userName = userName;
        this.breast = breast;
        this.weight = weight;
        this.piercing = piercing;
        this.shave = shave;
        this.toy = toy;
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

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public int getBreast() {
        return breast;
    }

    public void setBreast(int breast) {
        this.breast = breast;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getPiercing() {
        return piercing;
    }

    public void setPiercing(boolean piercing) {
        this.piercing = piercing;
    }

    public boolean getShave() {
        return shave;
    }

    public void setShave(boolean shave) {
        this.shave = shave;
    }

    public boolean getToy() {
        return toy;
    }

    public void setToy(boolean toy) {
        this.toy = toy;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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
