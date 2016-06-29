package org.jfree.chart.axis;

import java.io.*;
import org.jfree.util.*;
import org.jfree.ui.*;
import java.awt.geom.*;

public class AxisSpace implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -2490732595134766305L;
    private double top;
    private double bottom;
    private double left;
    private double right;
    
    public AxisSpace() {
        this.top = 0.0;
        this.bottom = 0.0;
        this.left = 0.0;
        this.right = 0.0;
    }
    
    public double getTop() {
        return this.top;
    }
    
    public void setTop(final double top) {
        this.top = top;
    }
    
    public double getBottom() {
        return this.bottom;
    }
    
    public void setBottom(final double bottom) {
        this.bottom = bottom;
    }
    
    public double getLeft() {
        return this.left;
    }
    
    public void setLeft(final double left) {
        this.left = left;
    }
    
    public double getRight() {
        return this.right;
    }
    
    public void setRight(final double right) {
        this.right = right;
    }
    
    public void add(final double n, final RectangleEdge rectangleEdge) {
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'edge' argument.");
        }
        if (rectangleEdge == RectangleEdge.TOP) {
            this.top += n;
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.bottom += n;
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            this.left += n;
        }
        else {
            if (rectangleEdge != RectangleEdge.RIGHT) {
                throw new IllegalStateException("Unrecognised 'edge' argument.");
            }
            this.right += n;
        }
    }
    
    public void ensureAtLeast(final AxisSpace axisSpace) {
        this.top = Math.max(this.top, axisSpace.top);
        this.bottom = Math.max(this.bottom, axisSpace.bottom);
        this.left = Math.max(this.left, axisSpace.left);
        this.right = Math.max(this.right, axisSpace.right);
    }
    
    public void ensureAtLeast(final double n, final RectangleEdge rectangleEdge) {
        if (rectangleEdge == RectangleEdge.TOP) {
            if (this.top < n) {
                this.top = n;
            }
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            if (this.bottom < n) {
                this.bottom = n;
            }
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            if (this.left < n) {
                this.left = n;
            }
        }
        else {
            if (rectangleEdge != RectangleEdge.RIGHT) {
                throw new IllegalStateException("AxisSpace.ensureAtLeast(): unrecognised AxisLocation.");
            }
            if (this.right < n) {
                this.right = n;
            }
        }
    }
    
    public Rectangle2D shrink(final Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        if (rectangle2D2 == null) {
            rectangle2D2 = new Rectangle2D.Double();
        }
        rectangle2D2.setRect(rectangle2D.getX() + this.left, rectangle2D.getY() + this.top, rectangle2D.getWidth() - this.left - this.right, rectangle2D.getHeight() - this.top - this.bottom);
        return rectangle2D2;
    }
    
    public Rectangle2D expand(final Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        if (rectangle2D2 == null) {
            rectangle2D2 = new Rectangle2D.Double();
        }
        rectangle2D2.setRect(rectangle2D.getX() - this.left, rectangle2D.getY() - this.top, rectangle2D.getWidth() + this.left + this.right, rectangle2D.getHeight() + this.top + this.bottom);
        return rectangle2D2;
    }
    
    public Rectangle2D reserved(final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        Rectangle2D rectangle2D2 = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            rectangle2D2 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), this.top);
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            rectangle2D2 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getMaxY() - this.top, rectangle2D.getWidth(), this.bottom);
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            rectangle2D2 = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), this.left, rectangle2D.getHeight());
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            rectangle2D2 = new Rectangle2D.Double(rectangle2D.getMaxX() - this.right, rectangle2D.getY(), this.right, rectangle2D.getHeight());
        }
        return rectangle2D2;
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AxisSpace)) {
            return false;
        }
        final AxisSpace axisSpace = (AxisSpace)o;
        return this.top == axisSpace.top && this.bottom == axisSpace.bottom && this.left == axisSpace.left && this.right == axisSpace.right;
    }
    
    public int hashCode() {
        final int n = 23;
        final long doubleToLongBits = Double.doubleToLongBits(this.top);
        final int n2 = 37 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.bottom);
        final int n3 = 37 * n2 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.left);
        final int n4 = 37 * n3 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.right);
        return 37 * n4 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
    }
    
    public String toString() {
        return super.toString() + "[left=" + this.left + ",right=" + this.right + ",top=" + this.top + ",bottom=" + this.bottom + "]";
    }
}
