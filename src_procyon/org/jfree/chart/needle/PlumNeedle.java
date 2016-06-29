package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class PlumNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -3082660488660600718L;
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final Arc2D.Double double1 = new Arc2D.Double(2);
        final double height = rectangle2D.getHeight();
        final double n2 = rectangle2D.getWidth() / 2.0;
        final double n3 = 2.0 * height;
        double1.setFrame(rectangle2D.getMinX() + n2 - height, rectangle2D.getMinY() - height, n3, n3);
        final double degrees = Math.toDegrees(Math.asin(n2 / height));
        double1.setAngleStart(270.0 - degrees);
        double1.setAngleExtent(2.0 * degrees);
        final Area area = new Area(double1);
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            area.transform(this.getTransform());
        }
        this.defaultDisplay(graphics2D, area);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof PlumNeedle && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
