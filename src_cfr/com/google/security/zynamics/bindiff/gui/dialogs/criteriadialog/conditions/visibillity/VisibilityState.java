/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

public enum VisibilityState {
    VISIBLE,
    UNVISIBLE;
    

    private VisibilityState() {
    }

    public String toString() {
        if (this != VISIBLE) return "invisible";
        return "visible";
    }
}

