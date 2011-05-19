package com.goodercode.jsfcardwall.persistence.jpa;

import com.goodercode.jsfcardwall.Globals;
import com.goodercode.jsfcardwall.model.BaseModel;
import com.goodercode.jsfcardwall.persistence.Dao;
import com.goodercode.jsfcardwall.persistence.Transactional;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("dao")
@ApplicationScoped
public class JPADaoImpl implements Dao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(final BaseModel obj) {
        em.persist(obj);
    }

    @Override
    public <T extends BaseModel> T get(final Class<T> model, final Long id) {
        return em.find(model, id);
    }

    @Override
    public List<? extends BaseModel> list(final String model) {
        return em.createQuery("select e from " + model + " as e").getResultList();
    }

    private Class<? extends BaseModel> getModelClass(final String model) {
        try {
            return (Class<? extends BaseModel>) Class.forName(Globals.MODEL_PACKAGE + "." + model);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
