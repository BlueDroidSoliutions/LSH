package com.livesexhouse.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author nstankovic
 */
@Entity
@Table(name = "price_package")
public class PricePackage implements Serializable {
    
	private static final long serialVersionUID = 1500860025200682563L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "tokens", nullable = false)
    private Integer tokens;
    
    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "active", nullable = false)
    private Boolean active;
    
    @Column(name = "monthly", nullable = false)
    private Boolean monthly;
    
    @Column(name = "external_package_id")
    private String externalPackageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer credits) {
        this.tokens = credits;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public Boolean getMonthly() {
		return monthly;
	}
    
    public void setMonthly(Boolean monthly) {
		this.monthly = monthly;
	}
    
    public String getExternalPackageId() {
		return externalPackageId;
	}
    
    public void setExternalPackageId(String externalPackageId) {
		this.externalPackageId = externalPackageId;
	}
    
    @Override
    public String toString() {
        return "name=" + name;
    }
   
}