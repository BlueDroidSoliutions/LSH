package com.livesexhouse.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nstankovic
 */
@Entity
@Table(name = "membership")
public class Membership implements Serializable {

	private static final long serialVersionUID = -2912819471014168468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "active", nullable = false)
	private Boolean active;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

}
