package com.google.security.zynamics.zylib.gui.zygraph;

import java.text.*;

public enum MouseWheelAction
{
    ZOOM("ZOOM", 0), 
    SCROLL("SCROLL", 1);
    
    private MouseWheelAction(final String s, final int n) {
    }
    
    public static MouseWheelAction parseInt(final int n) {
        if (n == MouseWheelAction.ZOOM.ordinal()) {
            return MouseWheelAction.ZOOM;
        }
        if (n == MouseWheelAction.SCROLL.ordinal()) {
            return MouseWheelAction.SCROLL;
        }
        throw new ParseException("Error: Invalid action", 0);
    }
}
