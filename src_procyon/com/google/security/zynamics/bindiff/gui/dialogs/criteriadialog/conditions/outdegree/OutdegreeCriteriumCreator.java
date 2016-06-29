package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.outdegree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class OutdegreeCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new OutdegreeCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Outdegree";
    }
}
