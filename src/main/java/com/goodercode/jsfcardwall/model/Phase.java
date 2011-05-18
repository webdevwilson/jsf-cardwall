package com.goodercode.jsfcardwall.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

@Entity
public class Phase extends NamedModel {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Project project;
    
    @OrderColumn
    private Integer sortOrder;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getSortOrder() {
	return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
	this.sortOrder = sortOrder;
    }

}
