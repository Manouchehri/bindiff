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
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

public class XYBoxAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = 6764703772526757457L;
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;

    public XYBoxAnnotation(double d2, double d3, double d4, double d5) {
        this(d2, d3, d4, d5, new BasicStroke(1.0f), Color.black);
    }

    public XYBoxAnnotation(double d2, double d3, double d4, double d5, Stroke stroke, Paint paint) {
        this(d2, d3, d4, d5, stroke, paint, null);
    }

    public XYBoxAnnotation(double d2, double d3, double d4, double d5, Stroke stroke, Paint paint, Paint paint2) {
        this.x0 = d2;
        this.y0 = d3;
        this.x1 = d4;
        this.y1 = d5;
        this.stroke = stroke;
        this.outlinePaint = paint;
        this.fillPaint = paint2;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        double d2 = valueAxis.valueToJava2D(this.x0, rectangle2D, rectangleEdge);
        double d3 = valueAxis2.valueToJava2D(this.y0, rectangle2D, rectangleEdge2);
        double d4 = valueAxis.valueToJava2D(this.x1, rectangle2D, rectangleEdge);
        double d5 = valueAxis2.valueToJava2D(this.y1, rectangle2D, rectangleEdge2);
        Rectangle2D.Double double_ = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            double_ = new Rectangle2D.Double(d3, d4, d5 - d3, d2 - d4);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            double_ = new Rectangle2D.Double(d2, d5, d4 - d2, d3 - d5);
        }
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(double_);
        }
        if (this.stroke != null && this.outlinePaint != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.stroke);
            graphics2D.draw(double_);
        }
        this.addEntity(plotRenderingInfo, double_, n2, this.getToolTipText(), this.getURL());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYBoxAnnotation)) {
            return false;
        }
        XYBoxAnnotation xYBoxAnnotation = (XYBoxAnnotation)object;
        if (this.x0 != xYBoxAnnotation.x0) {
            return false;
        }
        if (this.y0 != xYBoxAnnotation.y0) {
            return false;
        }
        if (this.x1 != xYBoxAnnotation.x1) {
            return false;
        }
        if (this.y1 != xYBoxAnnotation.y1) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, xYBoxAnnotation.stroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, xYBoxAnnotation.outlinePaint)) {
            return false;
        }
        if (PaintUtilities.equal(this.fillPaint, xYBoxAnnotation.fillPaint)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.x0);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.x1);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y0);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y1);
        return 29 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
    }
}

