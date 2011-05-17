package com.goodercode.jsfcardwall;

import com.goodercode.jsfcardwall.model.BaseModel;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class Entities {
    
    @PersistenceContext
    private EntityManager em;
    
    public void save(final BaseModel obj) {
        em.persist(obj);
    }
    
    public <T extends BaseModel> T get(final Class<T> model, final Long id) {
        return em.find(model, id);
    }
    
    public List<? extends BaseModel> list(final String model) {
        return em.createQuery("select e from " + model + " as e").getResultList();
    }
    
    private Class<? extends BaseModel> getModelClass(final String model) {
        try {
            return (Class<? extends BaseModel>)Class.forName(Globals.MODEL_PACKAGE + "." + model);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
