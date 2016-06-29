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
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
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

public class XYPolygonAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -6984203651995900036L;
    private double[] polygon;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;

    public XYPolygonAnnotation(double[] arrd) {
        this(arrd, new BasicStroke(1.0f), Color.black);
    }

    public XYPolygonAnnotation(double[] arrd, Stroke stroke, Paint paint) {
        this(arrd, stroke, paint, null);
    }

    public XYPolygonAnnotation(double[] arrd, Stroke stroke, Paint paint, Paint paint2) {
        if (arrd == null) {
            throw new IllegalArgumentException("Null 'polygon' argument.");
        }
        if (arrd.length % 2 != 0) {
            throw new IllegalArgumentException("The 'polygon' array must contain an even number of items.");
        }
        this.polygon = (double[])arrd.clone();
        this.stroke = stroke;
        this.outlinePaint = paint;
        this.fillPaint = paint2;
    }

    public double[] getPolygonCoordinates() {
        return (double[])this.polygon.clone();
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public Stroke getOutlineStroke() {
        return this.stroke;
    }

    public Paint getOutlinePaint() {
        return this.outlinePaint;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        if (this.polygon.length < 4) {
            return;
        }
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        GeneralPath generalPath = new GeneralPath();
        double d2 = valueAxis.valueToJava2D(this.polygon[0], rectangle2D, rectangleEdge);
        double d3 = valueAxis2.valueToJava2D(this.polygon[1], rectangle2D, rectangleEdge2);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            generalPath.moveTo((float)d3, (float)d2);
            for (int i2 = 2; i2 < this.polygon.length; i2 += 2) {
                d2 = valueAxis.valueToJava2D(this.polygon[i2], rectangle2D, rectangleEdge);
                d3 = valueAxis2.valueToJava2D(this.polygon[i2 + 1], rectangle2D, rectangleEdge2);
                generalPath.lineTo((float)d3, (float)d2);
            }
            generalPath.closePath();
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            generalPath.moveTo((float)d2, (float)d3);
            for (int i3 = 2; i3 < this.polygon.length; i3 += 2) {
                d2 = valueAxis.valueToJava2D(this.polygon[i3], rectangle2D, rectangleEdge);
                d3 = valueAxis2.valueToJava2D(this.polygon[i3 + 1], rectangle2D, rectangleEdge2);
                generalPath.lineTo((float)d2, (float)d3);
            }
            generalPath.closePath();
        }
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(generalPath);
        }
        if (this.stroke != null && this.outlinePaint != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.stroke);
            graphics2D.draw(generalPath);
        }
        this.addEntity(plotRenderingInfo, generalPath, n2, this.getToolTipText(), this.getURL());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYPolygonAnnotation)) {
            return false;
        }
        XYPolygonAnnotation xYPolygonAnnotation = (XYPolygonAnnotation)object;
        if (!Arrays.equals(this.polygon, xYPolygonAnnotation.polygon)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.stroke, xYPolygonAnnotation.stroke)) {
            return false;
        }
        if (!PaintUtilities.equal(this.outlinePaint, xYPolygonAnnotation.outlinePaint)) {
            return false;
        }
        if (PaintUtilities.equal(this.fillPaint, xYPolygonAnnotation.fillPaint)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + HashUtilities.hashCodeForDoubleArray(this.polygon);
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.fillPaint);
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.outlinePaint);
        if (this.stroke == null) return n2;
        return 37 * n2 + this.stroke.hashCode();
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

