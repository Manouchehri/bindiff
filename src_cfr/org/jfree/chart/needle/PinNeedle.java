/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class PinNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -3787089953079863373L;

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        GeneralPath generalPath = new GeneralPath();
        int n2 = (int)rectangle2D.getMinY();
        int n3 = (int)rectangle2D.getMaxY();
        int n4 = (int)(rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0);
        int n5 = (int)(rectangle2D.getWidth() / 10.0);
        if (n5 < 2) {
            n5 = 2;
        }
        generalPath.moveTo(n4 - n5, n3 - n5);
        generalPath.lineTo(n4 + n5, n3 - n5);
        generalPath.lineTo(n4, n2 + n5);
        generalPath.closePath();
        n5 = 4 * n5;
        Ellipse2D.Double double_ = new Ellipse2D.Double(n4 - n5 / 2, rectangle2D.getMaxY() - (double)n5, n5, n5);
        Area area = new Area(double_);
        area.add(new Area(generalPath));
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            area.transform(this.getTransform());
        }
        this.defaultDisplay(graphics2D, area);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PinNeedle)) {
            return false;
        }
        if (super.equals(object)) return true;
        return false;
    }

    public Object clone() {
        return super.clone();
    }
}

