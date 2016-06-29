package org.jfree.chart.needle;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;

public class WindNeedle extends ArrowNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -2861061368907167834L;
    
    public WindNeedle() {
        super(false);
    }
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        super.drawNeedle(graphics2D, rectangle2D, point2D, n);
        if (point2D != null && rectangle2D != null) {
            final int n2 = this.getSize() * 3;
            final Rectangle2D.Double double1 = new Rectangle2D.Double();
            double1.setRect(rectangle2D.getMinX() - n2, rectangle2D.getMinY(), rectangle2D.getWidth(), rectangle2D.getHeight());
            super.drawNeedle(graphics2D, double1, point2D, n);
            double1.setRect(rectangle2D.getMinX() + n2, rectangle2D.getMinY(), rectangle2D.getWidth(), rectangle2D.getHeight());
            super.drawNeedle(graphics2D, double1, point2D, n);
        }
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (super.equals(o) && o instanceof WindNeedle));
    }
}
