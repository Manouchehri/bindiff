/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class ColorCriteriumCreator
implements ICriteriumCreator {
    private final AbstractGraphsContainer graphs;

    public ColorCriteriumCreator(AbstractGraphsContainer abstractGraphsContainer) {
        Preconditions.checkNotNull(abstractGraphsContainer);
        this.graphs = abstractGraphsContainer;
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

