package com.goodercode.jsfcardwall.model;

import javax.persistence.Entity;
import javax.persistence.OrderColumn;

@Entity
public class Phase extends NamedModel {

    private static final long serialVersionUID = 1L;

    @OrderColumn
    private Integer sortOrder;

    public Integer getSortOrder() {
	return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
	this.sortOrder = sortOrder;
    }

}
