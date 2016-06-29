package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class PointerNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -4744677345334729606L;
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final GeneralPath generalPath = new GeneralPath();
        final GeneralPath generalPath2 = new GeneralPath();
        final float n2 = (float)rectangle2D.getMinX();
        final float n3 = (float)rectangle2D.getMinY();
        final float n4 = (float)rectangle2D.getMaxX();
        final float n5 = (float)rectangle2D.getMaxY();
        final float n6 = (float)(n2 + rectangle2D.getWidth() / 2.0);
        final float n7 = (float)(n3 + rectangle2D.getHeight() / 2.0);
        generalPath.moveTo(n2, n7);
        generalPath.lineTo(n6, n3);
        generalPath.lineTo(n4, n7);
        generalPath.closePath();
        generalPath2.moveTo(n2, n7);
        generalPath2.lineTo(n6, n5);
        generalPath2.lineTo(n4, n7);
        generalPath2.closePath();
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
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
        if (this.getOutlinePaint() != null) {
            graphics2D.setStroke(this.getOutlineStroke());
            graphics2D.setPaint(this.getOutlinePaint());
            graphics2D.draw(generalPath);
            graphics2D.draw(generalPath2);
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof PointerNeedle && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
