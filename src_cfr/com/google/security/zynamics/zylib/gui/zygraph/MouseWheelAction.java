/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

import java.text.ParseException;

public enum MouseWheelAction {
    ZOOM,
    SCROLL;
    

    private MouseWheelAction() {
    }

    public static MouseWheelAction parseInt(int n2) {
        if (n2 == ZOOM.ordinal()) {
            return ZOOM;
        }
        if (n2 != SCROLL.ordinal()) throw new ParseException("Error: Invalid action", 0);
        return SCROLL;
    }
}

