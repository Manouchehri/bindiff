package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class ColorCriteriumCreator implements ICriteriumCreator
{
    private final AbstractGraphsContainer graphs;
    
    public ColorCriteriumCreator(final AbstractGraphsContainer graphs) {
        Preconditions.checkNotNull(graphs);
        this.graphs = graphs;
    }
    
    @Override
    public ICriterium createCriterium() {
        return new ColorCriterium(this.graphs);
    }
    
    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Color";
    }
}
