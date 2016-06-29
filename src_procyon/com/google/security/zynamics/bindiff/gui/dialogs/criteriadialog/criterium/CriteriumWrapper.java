package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.zylib.gui.*;

public class CriteriumWrapper extends DefaultWrapper
{
    public CriteriumWrapper(final ICriteriumCreator criteriumCreator) {
        super(criteriumCreator);
    }
    
    @Override
    public String toString() {
        return ((ICriteriumCreator)this.getObject()).getCriteriumDescription();
    }
}
