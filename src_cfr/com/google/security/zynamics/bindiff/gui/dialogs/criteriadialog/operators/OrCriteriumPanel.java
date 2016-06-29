/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class OrCriteriumPanel
extends AbstractOperatorPanel {
    @Override
    public String getBorderTitle() {
        return "OR Operator";
    }

    @Override
    public String getInvalidInfoString() {
        return "OR operator needs at least two child conditions or operators.";
    }

    @Override
    public String getValidInfoString() {
        return "OR Operator is valid.";
    }
}

