package org.jfree.chart.needle;

import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class LongNeedle extends MeterNeedle implements Serializable, Cloneable
{
    private static final long serialVersionUID = -4319985779783688159L;
    
    public LongNeedle() {
        this.setRotateY(0.8);
    }
    
    protected void drawNeedle(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final GeneralPath generalPath = new GeneralPath();
        final GeneralPath generalPath2 = new GeneralPath();
        final GeneralPath generalPath3 = new GeneralPath();
        final float n2 = (float)rectangle2D.getMinX();
        final float n3 = (float)rectangle2D.getMinY();
        final float n4 = (float)rectangle2D.getMaxX();
        final float n5 = (float)rectangle2D.getMaxY();
        final float n6 = (float)(n2 + rectangle2D.getWidth() * 0.5);
        final float n7 = (float)(n3 + rectangle2D.getHeight() * 0.8);
        float n8 = n5 - 2.0f * (n5 - n7);
        if (n8 < n3) {
            n8 = n3;
        }
        generalPath.moveTo(n2, n7);
        generalPath.lineTo(n6, n3);
        generalPath.lineTo(n6, n8);
        generalPath.closePath();
        generalPath2.moveTo(n4, n7);
        generalPath2.lineTo(n6, n3);
        generalPath2.lineTo(n6, n8);
        generalPath2.closePath();
        generalPath3.moveTo(n2, n7);
        generalPath3.lineTo(n6, n5);
        generalPath3.lineTo(n4, n7);
        generalPath3.lineTo(n6, n8);
        generalPath3.closePath();
        Shape transformedShape = generalPath;
        Shape transformedShape2 = generalPath2;
        Shape transformedShape3 = generalPath3;
        if (point2D != null && n != 0.0) {
            this.getTransform().setToRotation(n, point2D.getX(), point2D.getY());
            transformedShape = generalPath.createTransformedShape(LongNeedle.transform);
            transformedShape2 = generalPath2.createTransformedShape(LongNeedle.transform);
            transformedShape3 = generalPath3.createTransformedShape(LongNeedle.transform);
        }
        if (this.getHighlightPaint() != null) {
            graphics2D.setPaint(this.getHighlightPaint());
            graphics2D.fill(transformedShape3);
        }
        if (this.getFillPaint() != null) {
            graphics2D.setPaint(this.getFillPaint());
            graphics2D.fill(transformedShape);
            graphics2D.fill(transformedShape2);
        }
        if (this.getOutlinePaint() != null) {
            graphics2D.setStroke(this.getOutlineStroke());
            graphics2D.setPaint(this.getOutlinePaint());
            graphics2D.draw(transformedShape);
            graphics2D.draw(transformedShape2);
            graphics2D.draw(transformedShape3);
        }
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof LongNeedle && super.equals(o));
    }
    
    public Object clone() {
        return super.clone();
    }
}
