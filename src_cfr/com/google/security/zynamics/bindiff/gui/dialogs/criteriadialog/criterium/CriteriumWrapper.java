/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.zylib.gui.DefaultWrapper;

public class CriteriumWrapper
extends DefaultWrapper {
    public CriteriumWrapper(ICriteriumCreator iCriteriumCreator) {
        super(iCriteriumCreator);
    }

    @Override
    public String toString() {
        return ((ICriteriumCreator)this.getObject()).getCriteriumDescription();
    }
}

