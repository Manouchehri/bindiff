package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class LineNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = 6215321387896748945L;
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final Line2D.Double double1 = new Line2D.Double();
        final double n2 = rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0;
        double1.setLine(n2, rectangle2D.getMinY(), n2, rectangle2D.getMaxY());
        Shape transformedShape = double1;
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            transformedShape = this.getTransform().createTransformedShape(transformedShape);
        }
        this.defaultDisplay(graphics2D, transformedShape);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof LineNeedle && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
