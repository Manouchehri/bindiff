/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.ArrowNeedle;

public class WindNeedle
extends ArrowNeedle
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -2861061368907167834L;

    public WindNeedle() {
        super(false);
    }

    @Override
    protected void drawNeedle(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        super.drawNeedle(graphics2D, rectangle2D, point2D, d2);
        if (point2D == null) return;
        if (rectangle2D == null) return;
        int n2 = this.getSize() * 3;
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        Point2D point2D2 = point2D;
        double_.setRect(rectangle2D.getMinX() - (double)n2, rectangle2D.getMinY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        super.drawNeedle(graphics2D, double_, point2D2, d2);
        double_.setRect(rectangle2D.getMinX() + (double)n2, rectangle2D.getMinY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        super.drawNeedle(graphics2D, double_, point2D2, d2);
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
        if (!(object instanceof WindNeedle)) return false;
        return true;
    }
}

