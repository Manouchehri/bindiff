/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees.IndegreeCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;

public class IndegreeCriteriumCreator
implements ICriteriumCreator {
    @Override
    public ICriterium createCriterium() {
        return new IndegreeCriterium();
    }

    @Override
    public String getCriteriumDescription() {
        return "Select Nodes by Indegree";
    }
}

