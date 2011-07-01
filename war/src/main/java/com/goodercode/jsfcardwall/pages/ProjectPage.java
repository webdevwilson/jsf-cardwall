package com.goodercode.jsfcardwall.pages;

import com.goodercode.jsfcardwall.model.Phase;
import com.goodercode.jsfcardwall.model.Project;
import com.goodercode.jsfcardwall.persistence.Dao;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import static com.goodercode.jsfcardwall.jsf.JSFUtils.*;

@Named
@RequestScoped
public class ProjectPage {

    @Inject
    private Dao dao;

    private Project project = new Project();

    public String save() {
        final Boolean created = project.getId() == null;
        dao.save(project);
        addFlashMessage(FacesMessage.SEVERITY_INFO, (created ? "project.created" : "project.updated"));
        return "/index.xhtml?faces-redirect=true";
    }
    
    public Project getProject() {
        return project;
    }

    public void setId(final Long id) {
        project = dao.get(Project.class, id);
    }
    
    public Long getId() {
        return project.getId();
    }
}
