package com.goodercode.jsfcardwall.persistence;

import com.goodercode.jsfcardwall.model.BaseModel;
import java.util.List;

public interface Dao {

    public void save(final BaseModel obj);
        
    public <T extends BaseModel> T get(final Class<T> model, final Long id);

    public List<? extends BaseModel> list(final String model);

}
