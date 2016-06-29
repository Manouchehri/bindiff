/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.Color;

public class ColoredRange
implements Comparable {
    private final Color fcolor;
    private final long start;
    private final int size;
    private final Color bgcolor;

    public ColoredRange(long l2, int n2, Color color, Color color2) {
        this.start = l2;
        this.size = n2;
        this.fcolor = color;
        this.bgcolor = color2;
    }

    public int compareTo(ColoredRange coloredRange) {
        return (int)(this.start - coloredRange.start);
    }

    public boolean containsOffset(long l2) {
        if (l2 < this.start) return false;
        if (l2 >= this.start + (long)this.size) return false;
        return true;
    }

    public Color getBackgroundColor() {
        return this.bgcolor;
    }

    public Color getColor() {
        return this.fcolor;
    }

    public int getSize() {
        return this.size;
    }

    public long getStart() {
        return this.start;
    }
}

