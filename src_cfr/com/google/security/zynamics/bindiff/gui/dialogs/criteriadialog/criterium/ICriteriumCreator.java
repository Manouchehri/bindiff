/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;

public interface ICriteriumCreator {
    public ICriterium createCriterium();

    public String getCriteriumDescription();
}

