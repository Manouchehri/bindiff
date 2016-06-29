package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class RecursionCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new RecursionCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Recursion";
    }
}
