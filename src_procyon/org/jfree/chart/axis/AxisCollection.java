package org.jfree.chart.axis;

import java.util.*;
import org.jfree.ui.*;

public class AxisCollection
{
    private List axesAtTop;
    private List axesAtBottom;
    private List axesAtLeft;
    private List axesAtRight;
    
    public AxisCollection() {
        this.axesAtTop = new ArrayList();
        this.axesAtBottom = new ArrayList();
        this.axesAtLeft = new ArrayList();
        this.axesAtRight = new ArrayList();
    }
    
    public List getAxesAtTop() {
        return this.axesAtTop;
    }
    
    public List getAxesAtBottom() {
        return this.axesAtBottom;
    }
    
    public List getAxesAtLeft() {
        return this.axesAtLeft;
    }
    
    public List getAxesAtRight() {
        return this.axesAtRight;
    }
    
    public void add(final Axis axis, final RectangleEdge rectangleEdge) {
        if (axis == null) {
            throw new IllegalArgumentException("Null 'axis' argument.");
        }
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'edge' argument.");
        }
        if (rectangleEdge == RectangleEdge.TOP) {
            this.axesAtTop.add(axis);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.axesAtBottom.add(axis);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            this.axesAtLeft.add(axis);
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            this.axesAtRight.add(axis);
        }
    }
}
