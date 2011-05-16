package com.goodercode.jsfcardwall.model;

import java.util.Collection;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Project extends BaseModel {

    @OneToMany(mappedBy = "project")
    private Set<Phase> phases;
    
    @OneToMany(mappedBy = "project")
    private Collection<Card> cards;

    public Collection<Card> getCards() {
	return cards;
    }

    public void setCards(Collection<Card> cards) {
	this.cards = cards;
    }

    public Set<Phase> getPhases() {
	return phases;
    }

    public void setPhases(Set<Phase> phases) {
	this.phases = phases;
    }

}
