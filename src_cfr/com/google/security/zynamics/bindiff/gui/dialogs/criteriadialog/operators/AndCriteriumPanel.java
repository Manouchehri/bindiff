/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AbstractOperatorPanel;

public class AndCriteriumPanel
extends AbstractOperatorPanel {
    @Override
    public String getBorderTitle() {
        return "AND Operator";
    }

    @Override
    public String getInvalidInfoString() {
        return "AND operator needs at least two children.";
    }

    @Override
    public String getValidInfoString() {
        return "AND Operator is valid.";
    }
}

