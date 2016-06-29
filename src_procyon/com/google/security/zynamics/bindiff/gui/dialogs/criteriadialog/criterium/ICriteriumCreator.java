package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

public interface ICriteriumCreator
{
    ICriterium createCriterium();
    
    String getCriteriumDescription();
}
