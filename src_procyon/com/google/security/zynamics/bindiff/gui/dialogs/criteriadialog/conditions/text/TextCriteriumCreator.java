package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.text;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class TextCriteriumCreator implements ICriteriumCreator
{
    @Override
    public ICriterium createCriterium() {
        return new TextCriterium();
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Text";
    }
}
