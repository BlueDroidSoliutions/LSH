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

    @Override
    public String toString() {
        return "name=" + name;
    }

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
}
