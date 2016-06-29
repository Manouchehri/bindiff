package org.jfree.chart.axis;

import java.util.*;
import org.jfree.ui.*;

public class AxisState
{
    private double cursor;
    private List ticks;
    private double max;
    
    public AxisState() {
        this(0.0);
    }
    
    public AxisState(final double cursor) {
        this.cursor = cursor;
        this.ticks = new ArrayList();
    }
    
    public double getCursor() {
        return this.cursor;
    }
    
    public void setCursor(final double cursor) {
        this.cursor = cursor;
    }
    
    public void moveCursor(final double n, final RectangleEdge rectangleEdge) {
        if (rectangleEdge == RectangleEdge.TOP) {
            this.cursorUp(n);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.cursorDown(n);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            this.cursorLeft(n);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            this.cursorRight(n);
        }
    }
    
    public void cursorUp(final double n) {
        this.cursor -= n;
    }
    
    public void cursorDown(final double n) {
        this.cursor += n;
    }
    
    public void cursorLeft(final double n) {
        this.cursor -= n;
    }
    
    public void cursorRight(final double n) {
        this.cursor += n;
    }
    
    public List getTicks() {
        return this.ticks;
    }
    
    public void setTicks(final List ticks) {
        this.ticks = ticks;
    }
    
    public double getMax() {
        return this.max;
    }
    
    public void setMax(final double max) {
        this.max = max;
    }
}
