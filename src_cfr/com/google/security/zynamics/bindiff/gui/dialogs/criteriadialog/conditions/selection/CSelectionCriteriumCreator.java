/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection.CSelectionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class CSelectionCriteriumCreator
implements ICriteriumCreator {
    @Override
    public ICriterium createCriterium() {
        return new CSelectionCriterium();
    }

    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Selection";
    }
}

