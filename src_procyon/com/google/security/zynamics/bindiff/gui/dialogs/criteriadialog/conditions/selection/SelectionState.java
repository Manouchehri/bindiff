package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

public enum SelectionState
{
    SELECTED("SELECTED", 0), 
    UNSELECTED("UNSELECTED", 1);
    
    private SelectionState(final String s, final int n) {
    }
    
    @Override
    public String toString() {
        return (this == SelectionState.SELECTED) ? "selected" : "unselected";
    }
}
