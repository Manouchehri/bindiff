/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class ArrowNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -5334056511213782357L;
    private boolean isArrowAtTop = true;

    public ArrowNeedle(boolean bl2) {
        this.isArrowAtTop = bl2;
    }

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        Line2D.Float float_ = new Line2D.Float();
        Shape shape = null;
        float f2 = (float)(rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0);
        float f3 = (float)rectangle2D.getMinY();
        float f4 = (float)rectangle2D.getMaxY();
        float_.setLine(f2, f3, f2, f4);
        Shape shape2 = new GeneralPath();
        if (this.isArrowAtTop) {
            shape2.moveTo(f2, f3);
            f3 += (float)(4 * this.getSize());
        } else {
            shape2.moveTo(f2, f4);
            f3 = f4 - (float)(4 * this.getSize());
        }
        shape2.lineTo(f2 + (float)this.getSize(), f3);
        shape2.lineTo(f2 - (float)this.getSize(), f3);
        shape2.closePath();
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            shape = this.getTransform().createTransformedShape(float_);
        } else {
            shape = float_;
        }
        this.defaultDisplay(graphics2D, shape);
        shape = point2D != null && d2 != 0.0 ? this.getTransform().createTransformedShape(shape2) : shape2;
        this.defaultDisplay(graphics2D, shape);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ArrowNeedle)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ArrowNeedle arrowNeedle = (ArrowNeedle)object;
        if (this.isArrowAtTop == arrowNeedle.isArrowAtTop) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

