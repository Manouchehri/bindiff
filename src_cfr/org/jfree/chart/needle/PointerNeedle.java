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

public class PointerNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -4744677345334729606L;

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        GeneralPath generalPath = new GeneralPath();
        GeneralPath generalPath2 = new GeneralPath();
        float f2 = (float)rectangle2D.getMinX();
        float f3 = (float)rectangle2D.getMinY();
        float f4 = (float)rectangle2D.getMaxX();
        float f5 = (float)rectangle2D.getMaxY();
        float f6 = (float)((double)f2 + rectangle2D.getWidth() / 2.0);
        float f7 = (float)((double)f3 + rectangle2D.getHeight() / 2.0);
        generalPath.moveTo(f2, f7);
        generalPath.lineTo(f6, f3);
        generalPath.lineTo(f4, f7);
        generalPath.closePath();
        generalPath2.moveTo(f2, f7);
        generalPath2.lineTo(f6, f5);
        generalPath2.lineTo(f4, f7);
        generalPath2.closePath();
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            generalPath.transform(this.getTransform());
            generalPath2.transform(this.getTransform());
        }
        if (this.getFillPaint() != null) {
            graphics2D.setPaint(this.getFillPaint());
            graphics2D.fill(generalPath);
        }
        if (this.getHighlightPaint() != null) {
            graphics2D.setPaint(this.getHighlightPaint());
            graphics2D.fill(generalPath2);
        }
        if (this.getOutlinePaint() == null) return;
        graphics2D.setStroke(this.getOutlineStroke());
        graphics2D.setPaint(this.getOutlinePaint());
        graphics2D.draw(generalPath);
        graphics2D.draw(generalPath2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PointerNeedle)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

