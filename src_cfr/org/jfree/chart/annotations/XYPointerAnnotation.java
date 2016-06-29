/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYPointerAnnotation
extends XYTextAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -4031161445009858551L;
    public static final double DEFAULT_TIP_RADIUS = 10.0;
    public static final double DEFAULT_BASE_RADIUS = 30.0;
    public static final double DEFAULT_LABEL_OFFSET = 3.0;
    public static final double DEFAULT_ARROW_LENGTH = 5.0;
    public static final double DEFAULT_ARROW_WIDTH = 3.0;
    private double angle;
    private double tipRadius;
    private double baseRadius;
    private double arrowLength;
    private double arrowWidth;
    private transient Stroke arrowStroke;
    private transient Paint arrowPaint;
    private double labelOffset;

    public XYPointerAnnotation(String string, double d2, double d3, double d4) {
        super(string, d2, d3);
        this.angle = d4;
        this.tipRadius = 10.0;
        this.baseRadius = 30.0;
        this.arrowLength = 5.0;
        this.arrowWidth = 3.0;
        this.labelOffset = 3.0;
        this.arrowStroke = new BasicStroke(1.0f);
        this.arrowPaint = Color.black;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double d2) {
        this.angle = d2;
    }

    public double getTipRadius() {
        return this.tipRadius;
    }

    public void setTipRadius(double d2) {
        this.tipRadius = d2;
    }

    public double getBaseRadius() {
        return this.baseRadius;
    }

    public void setBaseRadius(double d2) {
        this.baseRadius = d2;
    }

    public double getLabelOffset() {
        return this.labelOffset;
    }

    public void setLabelOffset(double d2) {
        this.labelOffset = d2;
    }

    public double getArrowLength() {
        return this.arrowLength;
    }

    public void setArrowLength(double d2) {
        this.arrowLength = d2;
    }

    public double getArrowWidth() {
        return this.arrowWidth;
    }

    public void setArrowWidth(double d2) {
        this.arrowWidth = d2;
    }

    public Stroke getArrowStroke() {
        return this.arrowStroke;
    }

    public void setArrowStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' not permitted.");
        }
        this.arrowStroke = stroke;
    }

    public Paint getArrowPaint() {
        return this.arrowPaint;
    }

    public void setArrowPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.arrowPaint = paint;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        double d2;
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        double d3 = valueAxis.valueToJava2D(this.getX(), rectangle2D, rectangleEdge);
        double d4 = valueAxis2.valueToJava2D(this.getY(), rectangle2D, rectangleEdge2);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d2 = d3;
            d3 = d4;
            d4 = d2;
        }
        d2 = d3 + Math.cos(this.angle) * this.baseRadius;
        double d5 = d4 + Math.sin(this.angle) * this.baseRadius;
        double d6 = d3 + Math.cos(this.angle) * this.tipRadius;
        double d7 = d4 + Math.sin(this.angle) * this.tipRadius;
        double d8 = d6 + Math.cos(this.angle) * this.arrowLength;
        double d9 = d7 + Math.sin(this.angle) * this.arrowLength;
        double d10 = d8 + Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        double d11 = d9 + Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        double d12 = d8 - Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        double d13 = d9 - Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)d6, (float)d7);
        generalPath.lineTo((float)d10, (float)d11);
        generalPath.lineTo((float)d12, (float)d13);
        generalPath.closePath();
        graphics2D.setStroke(this.arrowStroke);
        graphics2D.setPaint(this.arrowPaint);
        Line2D.Double double_ = new Line2D.Double(d2, d5, d6, d7);
        graphics2D.draw(double_);
        graphics2D.fill(generalPath);
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        double d14 = d3 + Math.cos(this.angle) * (this.baseRadius + this.labelOffset);
        double d15 = d4 + Math.sin(this.angle) * (this.baseRadius + this.labelOffset);
        Rectangle2D rectangle2D2 = TextUtilities.drawAlignedString(this.getText(), graphics2D, (float)d14, (float)d15, this.getTextAnchor());
        String string = this.getToolTipText();
        String string2 = this.getURL();
        if (string == null) {
            if (string2 == null) return;
        }
        this.addEntity(plotRenderingInfo, rectangle2D2, n2, string, string2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYPointerAnnotation)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        XYPointerAnnotation xYPointerAnnotation = (XYPointerAnnotation)object;
        if (this.angle != xYPointerAnnotation.angle) {
            return false;
        }
        if (this.tipRadius != xYPointerAnnotation.tipRadius) {
            return false;
        }
        if (this.baseRadius != xYPointerAnnotation.baseRadius) {
            return false;
        }
        if (this.arrowLength != xYPointerAnnotation.arrowLength) {
            return false;
        }
        if (this.arrowWidth != xYPointerAnnotation.arrowWidth) {
            return false;
        }
        if (!this.arrowPaint.equals(xYPointerAnnotation.arrowPaint)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.arrowStroke, xYPointerAnnotation.arrowStroke)) {
            return false;
        }
        if (this.labelOffset == xYPointerAnnotation.labelOffset) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        long l2 = Double.doubleToLongBits(this.angle);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.tipRadius);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.baseRadius);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.arrowLength);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.arrowWidth);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = n2 * 37 + HashUtilities.hashCodeForPaint(this.arrowPaint);
        n2 = n2 * 37 + this.arrowStroke.hashCode();
        l2 = Double.doubleToLongBits(this.labelOffset);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        return super.hashCode();
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.arrowPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.arrowStroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.arrowPaint = SerialUtilities.readPaint(objectInputStream);
        this.arrowStroke = SerialUtilities.readStroke(objectInputStream);
    }
}

