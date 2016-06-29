/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;

public class AxisSpace
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -2490732595134766305L;
    private double top = 0.0;
    private double bottom = 0.0;
    private double left = 0.0;
    private double right = 0.0;

    public double getTop() {
        return this.top;
    }

    public void setTop(double d2) {
        this.top = d2;
    }

    public double getBottom() {
        return this.bottom;
    }

    public void setBottom(double d2) {
        this.bottom = d2;
    }

    public double getLeft() {
        return this.left;
    }

    public void setLeft(double d2) {
        this.left = d2;
    }

    public double getRight() {
        return this.right;
    }

    public void setRight(double d2) {
        this.right = d2;
    }

    public void add(double d2, RectangleEdge rectangleEdge) {
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'edge' argument.");
        }
        if (rectangleEdge == RectangleEdge.TOP) {
            this.top += d2;
            return;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            this.bottom += d2;
            return;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            this.left += d2;
            return;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) throw new IllegalStateException("Unrecognised 'edge' argument.");
        this.right += d2;
    }

    public void ensureAtLeast(AxisSpace axisSpace) {
        this.top = Math.max(this.top, axisSpace.top);
        this.bottom = Math.max(this.bottom, axisSpace.bottom);
        this.left = Math.max(this.left, axisSpace.left);
        this.right = Math.max(this.right, axisSpace.right);
    }

    public void ensureAtLeast(double d2, RectangleEdge rectangleEdge) {
        if (rectangleEdge == RectangleEdge.TOP) {
            if (this.top >= d2) return;
            this.top = d2;
            return;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            if (this.bottom >= d2) return;
            this.bottom = d2;
            return;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            if (this.left >= d2) return;
            this.left = d2;
            return;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) throw new IllegalStateException("AxisSpace.ensureAtLeast(): unrecognised AxisLocation.");
        if (this.right >= d2) return;
        this.right = d2;
    }

    public Rectangle2D shrink(Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        if (rectangle2D2 == null) {
            rectangle2D2 = new Rectangle2D.Double();
        }
        rectangle2D2.setRect(rectangle2D.getX() + this.left, rectangle2D.getY() + this.top, rectangle2D.getWidth() - this.left - this.right, rectangle2D.getHeight() - this.top - this.bottom);
        return rectangle2D2;
    }

    public Rectangle2D expand(Rectangle2D rectangle2D, Rectangle2D rectangle2D2) {
        if (rectangle2D2 == null) {
            rectangle2D2 = new Rectangle2D.Double();
        }
        rectangle2D2.setRect(rectangle2D.getX() - this.left, rectangle2D.getY() - this.top, rectangle2D.getWidth() + this.left + this.right, rectangle2D.getHeight() + this.top + this.bottom);
        return rectangle2D2;
    }

    public Rectangle2D reserved(Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        Rectangle2D.Double double_ = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            return new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), this.top);
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            return new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getMaxY() - this.top, rectangle2D.getWidth(), this.bottom);
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            return new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY(), this.left, rectangle2D.getHeight());
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return double_;
        return new Rectangle2D.Double(rectangle2D.getMaxX() - this.right, rectangle2D.getY(), this.right, rectangle2D.getHeight());
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AxisSpace)) {
            return false;
        }
        AxisSpace axisSpace = (AxisSpace)object;
        if (this.top != axisSpace.top) {
            return false;
        }
        if (this.bottom != axisSpace.bottom) {
            return false;
        }
        if (this.left != axisSpace.left) {
            return false;
        }
        if (this.right == axisSpace.right) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 23;
        long l2 = Double.doubleToLongBits(this.top);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.bottom);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.left);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.right);
        return 37 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append("[left=").append(this.left).append(",right=").append(this.right).append(",top=").append(this.top).append(",bottom=").append(this.bottom).append("]").toString();
    }
}

