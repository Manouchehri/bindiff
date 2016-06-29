package org.jfree.chart.needle;

import java.awt.geom.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public abstract class MeterNeedle implements Serializable
{
    private static final long serialVersionUID = 5203064851510951052L;
    private transient Paint outlinePaint;
    private transient Stroke outlineStroke;
    private transient Paint fillPaint;
    private transient Paint highlightPaint;
    private int size;
    private double rotateX;
    private double rotateY;
    protected static AffineTransform transform;
    
    public MeterNeedle() {
        this(null, null, null);
    }
    
    public MeterNeedle(final Paint outlinePaint, final Paint fillPaint, final Paint highlightPaint) {
        this.outlinePaint = Color.black;
        this.outlineStroke = new BasicStroke(2.0f);
        this.fillPaint = null;
        this.highlightPaint = null;
        this.size = 5;
        this.rotateX = 0.5;
        this.rotateY = 0.5;
        this.fillPaint = fillPaint;
        this.highlightPaint = highlightPaint;
        this.outlinePaint = outlinePaint;
    }
    
    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }
    
    public void setOutlinePaint(final Paint outlinePaint) {
        if (outlinePaint != null) {
            this.outlinePaint = outlinePaint;
        }
    }
    
    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }
    
    public void setOutlineStroke(final Stroke outlineStroke) {
        if (outlineStroke != null) {
            this.outlineStroke = outlineStroke;
        }
    }
    
    public Paint getFillPaint() {
        return this.fillPaint;
    }
    
    public void setFillPaint(final Paint fillPaint) {
        if (fillPaint != null) {
            this.fillPaint = fillPaint;
        }
    }
    
    public Paint getHighlightPaint() {
        return this.highlightPaint;
    }
    
    public void setHighlightPaint(final Paint highlightPaint) {
        if (highlightPaint != null) {
            this.highlightPaint = highlightPaint;
        }
    }
    
    public double getRotateX() {
        return this.rotateX;
    }
    
    public void setRotateX(final double rotateX) {
        this.rotateX = rotateX;
    }
    
    public void setRotateY(final double rotateY) {
        this.rotateY = rotateY;
    }
    
    public double getRotateY() {
        return this.rotateY;
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, 0.0);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final double n) {
        final Point2D.Double double1 = new Point2D.Double();
        double1.setLocation(rectangle2D.getMinX() + this.rotateX * rectangle2D.getWidth(), rectangle2D.getMinY() + this.rotateY * rectangle2D.getHeight());
        this.draw(graphics2D, rectangle2D, double1, n);
    }
    
    public void draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Point2D point2D, final double n) {
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        this.drawNeedle(graphics2D, rectangle2D, point2D, Math.toRadians(n));
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(color);
    }
    
    protected abstract void drawNeedle(final Graphics2D p0, final Rectangle2D p1, final Point2D p2, final double p3);
    
    protected void defaultDisplay(final Graphics2D graphics2D, final Shape shape) {
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(shape);
        }
        if (this.outlinePaint != null) {
            graphics2D.setStroke(this.outlineStroke);
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.draw(shape);
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void setSize(final int size) {
        this.size = size;
    }
    
    public AffineTransform getTransform() {
        return MeterNeedle.transform;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MeterNeedle)) {
            return false;
        }
        final MeterNeedle meterNeedle = (MeterNeedle)o;
        return PaintUtilities.equal(this.outlinePaint, meterNeedle.outlinePaint) && ObjectUtilities.equal(this.outlineStroke, meterNeedle.outlineStroke) && PaintUtilities.equal(this.fillPaint, meterNeedle.fillPaint) && PaintUtilities.equal(this.highlightPaint, meterNeedle.highlightPaint) && this.size == meterNeedle.size && this.rotateX == meterNeedle.rotateX && this.rotateY == meterNeedle.rotateY;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.highlightPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
        this.highlightPaint = SerialUtilities.readPaint(objectInputStream);
    }
    
    static {
        MeterNeedle.transform = new AffineTransform();
    }
}
