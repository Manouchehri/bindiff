/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.Color;

public interface IColormap {
    public boolean colorize(byte[] var1, long var2);

    public Color getBackgroundColor(byte[] var1, long var2);

    public Color getForegroundColor(byte[] var1, long var2);
}

