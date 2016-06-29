/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion.RecursionCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class RecursionCriteriumCreator
implements ICriteriumCreator {
    @Override
    public ICriterium createCriterium() {
        return new RecursionCriterium();
    }

    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Recursion";
    }
}

