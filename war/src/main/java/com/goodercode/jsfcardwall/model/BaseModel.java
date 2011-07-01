package com.goodercode.jsfcardwall.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public abstract class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }
    
    @PrePersist
    public void onCreate() {
	this.created = new Date();
	this.updated = new Date();
    }
    
    @PreUpdate
    public void onUpdate() {
	this.updated = new Date();
    }
}
