package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

public enum VisibilityState
{
    VISIBLE("VISIBLE", 0), 
    UNVISIBLE("UNVISIBLE", 1);
    
    private VisibilityState(final String s, final int n) {
    }
    
    @Override
    public String toString() {
        return (this == VisibilityState.VISIBLE) ? "visible" : "invisible";
    }
}
