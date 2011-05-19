package com.goodercode.jsfcardwall.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Card extends NamedModel {

    @ManyToOne
    private Phase currentPhase;
    
    @ManyToOne
    private Project project;

    public Phase getCurrentPhase() {
	return currentPhase;
    }

    public void setCurrentPhase(Phase currentPhase) {
	this.currentPhase = currentPhase;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
}
