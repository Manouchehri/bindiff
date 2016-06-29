/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.AbstractCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;

public abstract class ConditionCriterium
extends AbstractCriterium {
    @Override
    public CriteriumType getType() {
        return CriteriumType.CONDITION;
    }
}

