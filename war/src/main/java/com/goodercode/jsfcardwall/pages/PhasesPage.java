package com.goodercode.jsfcardwall.pages;

import static com.goodercode.jsfcardwall.jsf.JSFUtils.*;

import com.goodercode.jsfcardwall.model.Phase;
import com.goodercode.jsfcardwall.model.Project;
import com.goodercode.jsfcardwall.persistence.Dao;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class PhasesPage {

    @Inject
    private Dao dao;

    private Project project = new Project();

    private Phase phase = new Phase();

    public String save() {
        phase.setProject(project);
        dao.save(phase);
        addFlashMessage(FacesMessage.SEVERITY_INFO, "phase.created");
        return redirectToSelf();
    }

    public String moveUp(final Phase phase) {
        return redirectToSelf();
    }

    public String moveDown(final Phase phase) {
        return redirectToSelf();
    }

    private String redirectToSelf() {
        return "/phases.xhtml?faces-redirect=true&projectId=" + project.getId();
    }

    public void setProjectId(final Long projectId) {
        project = dao.get(Project.class, projectId);
    }
    
    public Long getProjectId() {
        return project.getId();
    }

    public Project getProject() {
        return project;
    }

    public Phase getPhase() {
        return phase;
    }
}
