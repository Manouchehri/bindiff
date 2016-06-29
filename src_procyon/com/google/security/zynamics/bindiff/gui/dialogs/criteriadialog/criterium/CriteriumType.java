package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

public enum CriteriumType
{
    CONDITION("CONDITION", 0), 
    AND("AND", 1), 
    OR("OR", 2), 
    NOT("NOT", 3);
    
    private CriteriumType(final String s, final int n) {
    }
    
    public boolean isOperator() {
        return this != CriteriumType.CONDITION;
    }
}
