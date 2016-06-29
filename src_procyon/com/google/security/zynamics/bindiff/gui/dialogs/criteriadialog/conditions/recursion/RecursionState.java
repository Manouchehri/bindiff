package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

public enum RecursionState
{
    IS_RECURSION("IS_RECURSION", 0), 
    IS_NOT_RECURSION("IS_NOT_RECURSION", 1);
    
    private RecursionState(final String s, final int n) {
    }
    
    @Override
    public String toString() {
        return (this == RecursionState.IS_RECURSION) ? "recursive" : "not recursive";
    }
}
