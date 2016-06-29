package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import java.awt.*;

public class CHighlighting implements Comparable
{
    private final double m_start;
    private final double m_end;
    private final int m_level;
    private final Color m_color;
    
    public CHighlighting(final int level, final double start, final double end, final Color color) {
        this.m_level = level;
        this.m_start = start;
        this.m_end = end;
        this.m_color = color;
    }
    
    public int compareTo(final CHighlighting cHighlighting) {
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
