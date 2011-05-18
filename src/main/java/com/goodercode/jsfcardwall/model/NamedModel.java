package com.goodercode.jsfcardwall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public abstract class NamedModel extends BaseModel {
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(length = 50)
    protected String name;

    @Lob
    protected String description;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return name;
    }

}
