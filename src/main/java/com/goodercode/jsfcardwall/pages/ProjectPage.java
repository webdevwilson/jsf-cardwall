package com.goodercode.jsfcardwall.pages;

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
        dao.save(project);
        getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "project.saved", ""));
        return "/index";
    }
    
    public Project getProject() {
        return project;
    }
    
    public void setId(final Long id) {
        project = dao.get(Project.class, id);
    }
    
}
