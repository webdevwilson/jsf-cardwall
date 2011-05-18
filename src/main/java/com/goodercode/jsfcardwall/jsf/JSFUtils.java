package com.goodercode.jsfcardwall.jsf;

import javax.faces.context.FacesContext;

public final class JSFUtils {
    
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
}
