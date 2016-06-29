/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.needle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.io.SerialUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public abstract class MeterNeedle
implements Serializable {
    private static final long serialVersionUID = 5203064851510951052L;
    private transient Paint outlinePaint = Color.black;
    private transient Stroke outlineStroke = new BasicStroke(2.0f);
    private transient Paint fillPaint = null;
    private transient Paint highlightPaint = null;
    private int size = 5;
    private double rotateX = 0.5;
    private double rotateY = 0.5;
    protected static AffineTransform transform = new AffineTransform();

    public MeterNeedle() {
        this(null, null, null);
    }

    public MeterNeedle(Paint paint, Paint paint2, Paint paint3) {
        this.fillPaint = paint2;
        this.highlightPaint = paint3;
        this.outlinePaint = paint;
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    public void setOutlinePaint(Paint paint) {
        if (paint == null) return;
        this.outlinePaint = paint;
    }

    public Stroke getOutlineStroke() {
        return this.outlineStroke;
    }

    public void setOutlineStroke(Stroke stroke) {
        if (stroke == null) return;
        this.outlineStroke = stroke;
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public void setFillPaint(Paint paint) {
        if (paint == null) return;
        this.fillPaint = paint;
    }

    public Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    public void setHighlightPaint(Paint paint) {
        if (paint == null) return;
        this.highlightPaint = paint;
    }

    public double getRotateX() {
        return this.rotateX;
    }

    public void setRotateX(double d2) {
        this.rotateX = d2;
    }

    public void setRotateY(double d2) {
        this.rotateY = d2;
    }

    public double getRotateY() {
        return this.rotateY;
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        this.draw(graphics2D, rectangle2D, 0.0);
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, double d2) {
        Point2D.Double double_ = new Point2D.Double();
        double_.setLocation(rectangle2D.getMinX() + this.rotateX * rectangle2D.getWidth(), rectangle2D.getMinY() + this.rotateY * rectangle2D.getHeight());
        this.draw(graphics2D, rectangle2D, double_, d2);
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Point2D point2D, double d2) {
        Color color = graphics2D.getColor();
        Stroke stroke = graphics2D.getStroke();
        this.drawNeedle(graphics2D, rectangle2D, point2D, Math.toRadians(d2));
        graphics2D.setStroke(stroke);
        graphics2D.setPaint(color);
    }

    protected abstract void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4);

    protected void defaultDisplay(Graphics2D graphics2D, Shape shape) {
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(shape);
        }
        if (this.outlinePaint == null) return;
        graphics2D.setStroke(this.outlineStroke);
        graphics2D.setPaint(this.outlinePaint);
        graphics2D.draw(shape);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int n2) {
        this.size = n2;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MeterNeedle)) {
            return false;
        }
        MeterNeedle meterNeedle = (MeterNeedle)object;
        if (!PaintUtilities.equal(this.outlinePaint, meterNeedle.outlinePaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.outlineStroke, meterNeedle.outlineStroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.fillPaint, meterNeedle.fillPaint)) {
            return false;
        }
        if (!PaintUtilities.equal(this.highlightPaint, meterNeedle.highlightPaint)) {
            return false;
        }
        if (this.size != meterNeedle.size) {
            return false;
        }
        if (this.rotateX != meterNeedle.rotateX) {
            return false;
        }
        if (this.rotateY == meterNeedle.rotateY) return true;
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.outlineStroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
        SerialUtilities.writePaint(this.highlightPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.outlineStroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
        this.highlightPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

