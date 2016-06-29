package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.awt.*;

public class ColoredRange implements Comparable
{
    private final Color fcolor;
    private final long start;
    private final int size;
    private final Color bgcolor;
    
    public ColoredRange(final long start, final int size, final Color fcolor, final Color bgcolor) {
        this.start = start;
        this.size = size;
        this.fcolor = fcolor;
        this.bgcolor = bgcolor;
    }
    
    public int compareTo(final ColoredRange coloredRange) {
        return (int)(this.start - coloredRange.start);
    }
    
    public boolean containsOffset(final long n) {
        return n >= this.start && n < this.start + this.size;
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
