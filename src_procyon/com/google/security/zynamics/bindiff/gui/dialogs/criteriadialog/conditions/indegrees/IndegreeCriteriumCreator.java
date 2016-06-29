package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class IndegreeCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new IndegreeCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Indegree";
    }
}
