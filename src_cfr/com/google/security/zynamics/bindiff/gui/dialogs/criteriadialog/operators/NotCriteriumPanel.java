/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class NotCriteriumPanel
extends AbstractOperatorPanel {
    @Override
    public String getBorderTitle() {
        return "NOT Operator";
    }

    @Override
    public String getInvalidInfoString() {
        return "NOT operator requires exactly one child.";
    }

    @Override
    public String getValidInfoString() {
        return "NOT Operator is valid.";
    }
}

