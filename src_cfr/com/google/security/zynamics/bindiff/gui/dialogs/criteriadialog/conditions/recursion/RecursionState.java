/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

public enum RecursionState {
    IS_RECURSION,
    IS_NOT_RECURSION;
    

    private RecursionState() {
    }

    public String toString() {
        if (this != IS_RECURSION) return "not recursive";
        return "recursive";
    }
}

