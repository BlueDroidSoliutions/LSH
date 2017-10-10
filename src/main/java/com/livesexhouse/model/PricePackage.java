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

    @Column(name = "credits", nullable = false, unique = true)
    private Integer credits;
    
    @Column(name = "amount", nullable = false, unique = true)
    private Double amount;

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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
}
