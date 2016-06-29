/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class LineNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 6215321387896748945L;

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        Line2D.Double double_ = new Line2D.Double();
        double d3 = rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0;
        double_.setLine(d3, rectangle2D.getMinY(), d3, rectangle2D.getMaxY());
        Shape shape = double_;
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            shape = this.getTransform().createTransformedShape(shape);
        }
        this.defaultDisplay(graphics2D, shape);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LineNeedle)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

