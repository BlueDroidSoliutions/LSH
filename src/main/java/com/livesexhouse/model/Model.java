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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roller
 */
@Entity
@Table(name = "model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
    , @NamedQuery(name = "Model.findById", query = "SELECT m FROM Model m WHERE m.id = :id")
    , @NamedQuery(name = "Model.findByEmail", query = "SELECT m FROM Model m WHERE m.email = :email")
    , @NamedQuery(name = "Model.findByFullname", query = "SELECT m FROM Model m WHERE m.fullname = :fullname")
    , @NamedQuery(name = "Model.findByRegion", query = "SELECT m FROM Model m WHERE m.region = :region")
    , @NamedQuery(name = "Model.findByCountry", query = "SELECT m FROM Model m WHERE m.country = :country")
    , @NamedQuery(name = "Model.findByAddress", query = "SELECT m FROM Model m WHERE m.address = :address")
    , @NamedQuery(name = "Model.findByTelephone", query = "SELECT m FROM Model m WHERE m.telephone = :telephone")
    , @NamedQuery(name = "Model.findByPassword", query = "SELECT m FROM Model m WHERE m.password = :password")
    , @NamedQuery(name = "Model.findByNickname", query = "SELECT m FROM Model m WHERE m.nickname = :nickname")
    , @NamedQuery(name = "Model.findByGender", query = "SELECT m FROM Model m WHERE m.gender = :gender")
    , @NamedQuery(name = "Model.findByBirthday", query = "SELECT m FROM Model m WHERE m.birthday = :birthday")
    , @NamedQuery(name = "Model.findBySex", query = "SELECT m FROM Model m WHERE m.sex = :sex")
    , @NamedQuery(name = "Model.findByDspName", query = "SELECT m FROM Model m WHERE m.dspName = :dspName")
    , @NamedQuery(name = "Model.findByZodiac", query = "SELECT m FROM Model m WHERE m.zodiac = :zodiac")
    , @NamedQuery(name = "Model.findByLanguage", query = "SELECT m FROM Model m WHERE m.language = :language")
    , @NamedQuery(name = "Model.findByBody", query = "SELECT m FROM Model m WHERE m.body = :body")
    , @NamedQuery(name = "Model.findByDecoration", query = "SELECT m FROM Model m WHERE m.decoration = :decoration")
    , @NamedQuery(name = "Model.findByLanguageSpoken", query = "SELECT m FROM Model m WHERE m.languageSpoken = :languageSpoken")
    , @NamedQuery(name = "Model.findByHeight", query = "SELECT m FROM Model m WHERE m.height = :height")
    , @NamedQuery(name = "Model.findByWeight", query = "SELECT m FROM Model m WHERE m.weight = :weight")
    , @NamedQuery(name = "Model.findByHair", query = "SELECT m FROM Model m WHERE m.hair = :hair")
    , @NamedQuery(name = "Model.findByEye", query = "SELECT m FROM Model m WHERE m.eye = :eye")
    , @NamedQuery(name = "Model.findByEthnicity", query = "SELECT m FROM Model m WHERE m.ethnicity = :ethnicity")
    , @NamedQuery(name = "Model.findByCupSize", query = "SELECT m FROM Model m WHERE m.cupSize = :cupSize")
    , @NamedQuery(name = "Model.findByMeasurements", query = "SELECT m FROM Model m WHERE m.measurements = :measurements")
    , @NamedQuery(name = "Model.findByAudio", query = "SELECT m FROM Model m WHERE m.audio = :audio")
    , @NamedQuery(name = "Model.findByHd", query = "SELECT m FROM Model m WHERE m.hd = :hd")
    , @NamedQuery(name = "Model.findByPhoneService", query = "SELECT m FROM Model m WHERE m.phoneService = :phoneService")
    , @NamedQuery(name = "Model.findByGroupYN", query = "SELECT m FROM Model m WHERE m.groupYN = :groupYN")
    , @NamedQuery(name = "Model.findByPrivate1", query = "SELECT m FROM Model m WHERE m.private1 = :private1")
    , @NamedQuery(name = "Model.findByExpireID", query = "SELECT m FROM Model m WHERE m.expireID = :expireID")
    , @NamedQuery(name = "Model.findByPermanentId", query = "SELECT m FROM Model m WHERE m.permanentId = :permanentId")
    , @NamedQuery(name = "Model.findByPubicHair", query = "SELECT m FROM Model m WHERE m.pubicHair = :pubicHair")
    , @NamedQuery(name = "Model.findByAbout", query = "SELECT m FROM Model m WHERE m.about = :about")})
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 128)
    @Column(name = "email")
    private String email;
    @Size(max = 128)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 128)
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private Integer country;
    @Size(max = 128)
    @Column(name = "address")
    private String address;
    @Size(max = 64)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 64)
    @Column(name = "password")
    private String password;
    @Size(max = 64)
    @Column(name = "nickname")
    private String nickname;
    @Size(max = 64)
    @Column(name = "gender")
    private String gender;
    @Size(max = 64)
    @Column(name = "birthday")
    private String birthday;
    @Size(max = 64)
    @Column(name = "sex")
    private String sex;
    @Size(max = 64)
    @Column(name = "dspName")
    private String dspName;
    @Size(max = 64)
    @Column(name = "zodiac")
    private String zodiac;
    @Column(name = "language")
    private Integer language;
    @Column(name = "body")
    private Integer body;
    @Column(name = "decoration")
    private Integer decoration;
    @Column(name = "languageSpoken")
    private Integer languageSpoken;
    @Size(max = 32)
    @Column(name = "height")
    private String height;
    @Size(max = 32)
    @Column(name = "weight")
    private String weight;
    @Column(name = "hair")
    private Integer hair;
    @Size(max = 64)
    @Column(name = "eye")
    private String eye;
    @Size(max = 64)
    @Column(name = "ethnicity")
    private String ethnicity;
    @Size(max = 64)
    @Column(name = "cupSize")
    private String cupSize;
    @Size(max = 64)
    @Column(name = "measurements")
    private String measurements;
    @Column(name = "audio")
    private Integer audio;
    @Column(name = "hd")
    private Integer hd;
    @Column(name = "phoneService")
    private Integer phoneService;
    @Column(name = "groupYN")
    private Integer groupYN;
    @Column(name = "private")
    private Integer private1;
    @Size(max = 32)
    @Column(name = "expireID")
    private String expireID;
    @Column(name = "permanentId")
    private Integer permanentId;
    @Size(max = 32)
    @Column(name = "pubicHair")
    private String pubicHair;
    @Size(max = 2048)
    @Column(name = "about")
    private String about;

    public Model() {
    }

    public Model(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDspName() {
        return dspName;
    }

    public void setDspName(String dspName) {
        this.dspName = dspName;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public Integer getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(Integer languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getHair() {
        return hair;
    }

    public void setHair(Integer hair) {
        this.hair = hair;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public Integer getAudio() {
        return audio;
    }

    public void setAudio(Integer audio) {
        this.audio = audio;
    }

    public Integer getHd() {
        return hd;
    }

    public void setHd(Integer hd) {
        this.hd = hd;
    }

    public Integer getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(Integer phoneService) {
        this.phoneService = phoneService;
    }

    public Integer getGroupYN() {
        return groupYN;
    }

    public void setGroupYN(Integer groupYN) {
        this.groupYN = groupYN;
    }

    public Integer getPrivate1() {
        return private1;
    }

    public void setPrivate1(Integer private1) {
        this.private1 = private1;
    }

    public String getExpireID() {
        return expireID;
    }

    public void setExpireID(String expireID) {
        this.expireID = expireID;
    }

    public Integer getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(Integer permanentId) {
        this.permanentId = permanentId;
    }

    public String getPubicHair() {
        return pubicHair;
    }

    public void setPubicHair(String pubicHair) {
        this.pubicHair = pubicHair;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.livesexhouse.model.Model[ id=" + id + " ]";
    }
    
}
