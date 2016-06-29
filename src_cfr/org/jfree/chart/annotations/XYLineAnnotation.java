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
import java.awt.geom.Line2D;
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
import org.jfree.util.ShapeUtilities;

public class XYLineAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -80535465244091334L;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private transient Stroke stroke;
    private transient Paint paint;

    public XYLineAnnotation(double d2, double d3, double d4, double d5) {
        this(d2, d3, d4, d5, new BasicStroke(1.0f), Color.black);
    }

    public XYLineAnnotation(double d2, double d3, double d4, double d5, Stroke stroke, Paint paint) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.x1 = d2;
        this.y1 = d3;
        this.x2 = d4;
        this.y2 = d5;
        this.stroke = stroke;
        this.paint = paint;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (plotOrientation == PlotOrientation.VERTICAL) {
            f2 = (float)valueAxis.valueToJava2D(this.x1, rectangle2D, rectangleEdge);
            f4 = (float)valueAxis2.valueToJava2D(this.y1, rectangle2D, rectangleEdge2);
            f3 = (float)valueAxis.valueToJava2D(this.x2, rectangle2D, rectangleEdge);
            f5 = (float)valueAxis2.valueToJava2D(this.y2, rectangle2D, rectangleEdge2);
        } else if (plotOrientation == PlotOrientation.HORIZONTAL) {
            f4 = (float)valueAxis.valueToJava2D(this.x1, rectangle2D, rectangleEdge);
            f2 = (float)valueAxis2.valueToJava2D(this.y1, rectangle2D, rectangleEdge2);
            f5 = (float)valueAxis.valueToJava2D(this.x2, rectangle2D, rectangleEdge);
            f3 = (float)valueAxis2.valueToJava2D(this.y2, rectangle2D, rectangleEdge2);
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setStroke(this.stroke);
        Line2D.Float float_ = new Line2D.Float(f2, f4, f3, f5);
        graphics2D.draw(float_);
        String string = this.getToolTipText();
        String string2 = this.getURL();
        if (string == null) {
            if (string2 == null) return;
        }
        this.addEntity(plotRenderingInfo, ShapeUtilities.createLineRegion(float_, 1.0f), n2, string, string2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYLineAnnotation)) {
            return false;
        }
        XYLineAnnotation xYLineAnnotation = (XYLineAnnotation)object;
        if (this.x1 != xYLineAnnotation.x1) {
            return false;
        }
        if (this.y1 != xYLineAnnotation.y1) {
            return false;
        }
        if (this.x2 != xYLineAnnotation.x2) {
            return false;
        }
        if (this.y2 != xYLineAnnotation.y2) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, xYLineAnnotation.paint)) {
            return false;
        }
        if (ObjectUtilities.equal(this.stroke, xYLineAnnotation.stroke)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.x1);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.x2);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y1);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y2);
        return 29 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
    }
}

