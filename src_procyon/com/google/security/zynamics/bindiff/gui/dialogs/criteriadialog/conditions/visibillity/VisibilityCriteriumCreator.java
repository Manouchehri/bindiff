package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class VisibilityCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new VisibilityCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Visibility";
    }
}
