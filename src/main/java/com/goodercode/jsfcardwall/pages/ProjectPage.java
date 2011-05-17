package com.goodercode.jsfcardwall.pages;

import com.goodercode.jsfcardwall.Entities;
import com.goodercode.jsfcardwall.model.Project;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProjectPage {

    @Inject
    private Entities entities;
    
    private Project project = new Project();

    public String save() {
        entities.save(project);
        return "/index";
    }
    
    public Project getProject() {
        return project;
    }
    
    public void setId(final Long id) {
        project = entities.get(Project.class, id);
    }
    
}
