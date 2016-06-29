package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class CSelectionCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new CSelectionCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Selection";
    }
}
