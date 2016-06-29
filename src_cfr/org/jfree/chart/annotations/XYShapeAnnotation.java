/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYShapeAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -8553218317600684041L;
    private transient Shape shape;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;

    public XYShapeAnnotation(Shape shape) {
        this(shape, new BasicStroke(1.0f), Color.black);
    }

    public XYShapeAnnotation(Shape shape, Stroke stroke, Paint paint) {
        this(shape, stroke, paint, null);
    }

    public XYShapeAnnotation(Shape shape, Stroke stroke, Paint paint, Paint paint2) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.shape = shape;
        this.stroke = stroke;
        this.outlinePaint = paint;
        this.fillPaint = paint2;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        Rectangle2D rectangle2D2 = this.shape.getBounds2D();
        double d2 = rectangle2D2.getMinX();
        double d3 = rectangle2D2.getMaxX();
        double d4 = valueAxis.valueToJava2D(d2, rectangle2D, rectangleEdge);
        double d5 = valueAxis.valueToJava2D(d3, rectangle2D, rectangleEdge);
        double d6 = (d5 - d4) / (d3 - d2);
        double d7 = d4 - d2 * d6;
        double d8 = rectangle2D2.getMaxY();
        double d9 = rectangle2D2.getMinY();
        double d10 = valueAxis2.valueToJava2D(d8, rectangle2D, rectangleEdge2);
        double d11 = valueAxis2.valueToJava2D(d9, rectangle2D, rectangleEdge2);
        double d12 = (d11 - d10) / (d9 - d8);
        double d13 = d10 - d12 * d8;
        Shape shape = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            AffineTransform affineTransform = new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
            AffineTransform affineTransform2 = new AffineTransform(d12, 0.0, 0.0, d6, d13, d7);
            shape = affineTransform.createTransformedShape(this.shape);
            shape = affineTransform2.createTransformedShape(shape);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            AffineTransform affineTransform = new AffineTransform(d6, 0.0, 0.0, d12, d7, d13);
            shape = affineTransform.createTransformedShape(this.shape);
        }
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(shape);
        }
        if (this.stroke != null && this.outlinePaint != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.stroke);
            graphics2D.draw(shape);
        }
        this.addEntity(plotRenderingInfo, shape, n2, this.getToolTipText(), this.getURL());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYShapeAnnotation)) {
            return false;
        }
        XYShapeAnnotation xYShapeAnnotation = (XYShapeAnnotation)object;
        if (!this.shape.equals(xYShapeAnnotation.shape)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, xYShapeAnnotation.stroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, xYShapeAnnotation.outlinePaint)) {
            return false;
        }
        if (PaintUtilities.equal(this.fillPaint, xYShapeAnnotation.fillPaint)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + this.shape.hashCode();
        if (this.stroke != null) {
            n2 = 37 * n2 + this.stroke.hashCode();
        }
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.outlinePaint);
        return 37 * n2 + HashUtilities.hashCodeForPaint(this.fillPaint);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.shape = SerialUtilities.readShape(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

