/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class ShipNeedle
extends MeterNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 149554868169435612L;

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        GeneralPath generalPath = new GeneralPath();
        generalPath.append(new Arc2D.Double(-9.0, -7.0, 10.0, 14.0, 0.0, 25.5, 0), true);
        generalPath.append(new Arc2D.Double(0.0, -7.0, 10.0, 14.0, 154.5, 25.5, 0), true);
        generalPath.closePath();
        this.getTransform().setToTranslation(rectangle2D.getMinX(), rectangle2D.getMaxY());
        this.getTransform().scale(rectangle2D.getWidth(), rectangle2D.getHeight() / 3.0);
        generalPath.transform(this.getTransform());
        if (point2D != null && d2 != 0.0) {
            this.getTransform().setToRotation(d2, point2D.getX(), point2D.getY());
            generalPath.transform(this.getTransform());
        }
        this.defaultDisplay(graphics2D, generalPath);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) return false;
        if (!(object instanceof ShipNeedle)) return false;
        return true;
    }

    public Object clone() {
        return super.clone();
    }
}

