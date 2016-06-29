package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public abstract class ConditionCriterium extends AbstractCriterium
{
    @Override
    public CriteriumType getType() {
        return CriteriumType.CONDITION;
    }
}
