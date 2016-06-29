package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.root;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class RootCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new RootCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Root Node";
    }
}
