package com.goodercode.jsfcardwall.jsf;

import com.goodercode.jsfcardwall.Globals;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class JSFUtils {
    
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    public static void addFlashMessage(final FacesMessage.Severity severity, final String messageId) {
        getFacesContext().getExternalContext().getFlash().setKeepMessages(true);
        addMessage(severity, messageId);
    }
    
    public static void addMessage(final FacesMessage.Severity severity, final String messageId) {
        final FacesContext facesContext = getFacesContext();
        final FacesMessage facesMessage = new FacesMessage(severity, getResource(messageId), "");
        facesContext.addMessage(null, facesMessage);
    }
    
    public static String getResource(final String id) {
        return ResourceBundle.getBundle(Globals.BUNDLE, getFacesContext().getViewRoot().getLocale()).getString(id);
    }
    
}
