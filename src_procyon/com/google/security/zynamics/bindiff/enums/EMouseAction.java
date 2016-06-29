package com.google.security.zynamics.bindiff.enums;

public enum EMouseAction
{
    ZOOM("ZOOM", 0), 
    SCROLL("SCROLL", 1);
    
    private EMouseAction(final String s, final int n) {
    }
    
    public static EMouseAction getEnum(final int n) {
        return (n == 0) ? EMouseAction.ZOOM : EMouseAction.SCROLL;
    }
    
    public static int getOrdinal(final EMouseAction eMouseAction) {
        return (eMouseAction != EMouseAction.ZOOM) ? 1 : 0;
    }
}
