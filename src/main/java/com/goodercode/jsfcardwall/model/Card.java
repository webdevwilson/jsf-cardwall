package com.goodercode.jsfcardwall.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Card extends NamedModel {

    @ManyToOne
    private Phase currentPhase;

    public Phase getCurrentPhase() {
	return currentPhase;
    }

    public void setCurrentPhase(Phase currentPhase) {
	this.currentPhase = currentPhase;
    }
    
}
