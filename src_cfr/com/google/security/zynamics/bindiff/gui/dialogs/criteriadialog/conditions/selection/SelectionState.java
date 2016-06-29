/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

public enum SelectionState {
    SELECTED,
    UNSELECTED;
    

    private SelectionState() {
    }

    public String toString() {
        if (this != SELECTED) return "unselected";
        return "selected";
    }
}

