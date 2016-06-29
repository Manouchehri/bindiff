/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class LongNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -4319985779783688159L;

    public LongNeedle() {
        this.setRotateY(0.8);
    }

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        GeneralPath generalPath = new GeneralPath();
        GeneralPath generalPath2 = new GeneralPath();
        GeneralPath generalPath3 = new GeneralPath();
        float f2 = (float)rectangle2D.getMinX();
        float f3 = (float)rectangle2D.getMinY();
        float f4 = (float)rectangle2D.getMaxX();
        float f5 = (float)rectangle2D.getMaxY();
        float f6 = (float)((double)f2 + rectangle2D.getWidth() * 0.5);
        float f7 = (float)((double)f3 + rectangle2D.getHeight() * 0.8);
        float f8 = f5 - 2.0f * (f5 - f7);
        if (f8 < f3) {
            f8 = f3;
        }
        generalPath.moveTo(f2, f7);
        generalPath.lineTo(f6, f3);
        generalPath.lineTo(f6, f8);
        generalPath.closePath();
        generalPath2.moveTo(f4, f7);
        generalPath2.lineTo(f6, f3);
        generalPath2.lineTo(f6, f8);
        generalPath2.closePath();
        generalPath3.moveTo(f2, f7);
        generalPath3.lineTo(f6, f5);
        generalPath3.lineTo(f4, f7);
        generalPath3.lineTo(f6, f8);
        generalPath3.closePath();
        Shape shape = generalPath;
        Shape shape2 = generalPath2;
        Shape shape3 = generalPath3;
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            shape = generalPath.createTransformedShape(transform);
            shape2 = generalPath2.createTransformedShape(transform);
            shape3 = generalPath3.createTransformedShape(transform);
        }
        if (this.getHighlightPaint() != null) {
            graphics2D.setPaint(this.getHighlightPaint());
            graphics2D.fill(shape3);
        }
        if (this.getFillPaint() != null) {
            graphics2D.setPaint(this.getFillPaint());
            graphics2D.fill(shape);
            graphics2D.fill(shape2);
        }
        if (this.getOutlinePaint() == null) return;
        graphics2D.setStroke(this.getOutlineStroke());
        graphics2D.setPaint(this.getOutlinePaint());
        graphics2D.draw(shape);
        graphics2D.draw(shape2);
        graphics2D.draw(shape3);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LongNeedle)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

