package com.google.security.zynamics.zylib.gui.zygraph;

public enum EdgeHidingMode
{
    HIDE_NEVER("HIDE_NEVER", 0), 
    HIDE_ALWAYS("HIDE_ALWAYS", 1), 
    HIDE_ON_THRESHOLD("HIDE_ON_THRESHOLD", 2);
    
    private EdgeHidingMode(final String s, final int n) {
    }
    
    public static EdgeHidingMode parseInt(final int n) {
        if (n == EdgeHidingMode.HIDE_NEVER.ordinal()) {
            return EdgeHidingMode.HIDE_NEVER;
        }
        if (n == EdgeHidingMode.HIDE_ALWAYS.ordinal()) {
            return EdgeHidingMode.HIDE_ALWAYS;
        }
        if (n == EdgeHidingMode.HIDE_ON_THRESHOLD.ordinal()) {
            return EdgeHidingMode.HIDE_ON_THRESHOLD;
        }
        throw new IllegalStateException("Error: Invalid edge hiding mode");
    }
}
