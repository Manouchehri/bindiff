package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class ArrowNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -5334056511213782357L;
    private boolean isArrowAtTop;
    
    public ArrowNeedle(final boolean isArrowAtTop) {
        this.isArrowAtTop = true;
        this.isArrowAtTop = isArrowAtTop;
    }
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final Line2D.Float float1 = new Line2D.Float();
        final float n2 = (float)(rectangle2D.getMinX() + rectangle2D.getWidth() / 2.0);
        final float n3 = (float)rectangle2D.getMinY();
        final float n4 = (float)rectangle2D.getMaxY();
        float1.setLine(n2, n3, n2, n4);
        final GeneralPath generalPath = new GeneralPath();
        float n5;
        if (this.isArrowAtTop) {
            generalPath.moveTo(n2, n3);
            n5 = n3 + 4 * this.getSize();
        }
        else {
            generalPath.moveTo(n2, n4);
            n5 = n4 - 4 * this.getSize();
        }
        generalPath.lineTo(n2 + this.getSize(), n5);
        generalPath.lineTo(n2 - this.getSize(), n5);
        generalPath.closePath();
        Shape transformedShape;
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            transformedShape = this.getTransform().createTransformedShape(float1);
        }
        else {
            transformedShape = float1;
        }
        this.defaultDisplay(graphics2D, transformedShape);
        Shape transformedShape2;
        if (point2D != null && n != 0.0) {
            transformedShape2 = this.getTransform().createTransformedShape(generalPath);
        }
        else {
            transformedShape2 = generalPath;
        }
        this.defaultDisplay(graphics2D, transformedShape2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof ArrowNeedle && super.equals(o) && this.isArrowAtTop == ((ArrowNeedle)o).isArrowAtTop);
    }
    
    public Object clone() {
        return super.clone();
    }
}
