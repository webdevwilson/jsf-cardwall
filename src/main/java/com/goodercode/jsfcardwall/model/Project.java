package com.goodercode.jsfcardwall.model;

import java.util.Collection;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project extends NamedModel {

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
