/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import java.awt.Color;

public class CHighlighting
implements Comparable {
    private final double m_start;
    private final double m_end;
    private final int m_level;
    private final Color m_color;

    public CHighlighting(int n2, double d2, double d3, Color color) {
        this.m_level = n2;
        this.m_start = d2;
        this.m_end = d3;
        this.m_color = color;
    }

    public int compareTo(CHighlighting cHighlighting) {
        return this.m_level - cHighlighting.m_level;
    }

    public Color getColor() {
        return this.m_color;
    }

    public double getEnd() {
        return this.m_end;
    }

    public int getLevel() {
        return this.m_level;
    }

    public double getStart() {
        return this.m_start;
    }
}

