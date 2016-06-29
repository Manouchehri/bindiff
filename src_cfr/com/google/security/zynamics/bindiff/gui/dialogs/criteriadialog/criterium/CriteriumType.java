/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

public enum CriteriumType {
    CONDITION,
    AND,
    OR,
    NOT;
    

    private CriteriumType() {
    }

    public boolean isOperator() {
        if (this == CONDITION) return false;
        return true;
    }
}

