/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
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
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYImageAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -4364694501921559958L;
    private double x;
    private double y;
    private transient Image image;
    private RectangleAnchor anchor;

    public XYImageAnnotation(double d2, double d3, Image image) {
        this(d2, d3, image, RectangleAnchor.CENTER);
    }

    public XYImageAnnotation(double d2, double d3, Image image, RectangleAnchor rectangleAnchor) {
        if (image == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.x = d2;
        this.y = d3;
        this.image = image;
        this.anchor = rectangleAnchor;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Image getImage() {
        return this.image;
    }

    public RectangleAnchor getImageAnchor() {
        return this.anchor;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        AxisLocation axisLocation = xYPlot.getDomainAxisLocation();
        AxisLocation axisLocation2 = xYPlot.getRangeAxisLocation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(axisLocation, plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(axisLocation2, plotOrientation);
        float f2 = (float)valueAxis.valueToJava2D(this.x, rectangle2D, rectangleEdge);
        float f3 = (float)valueAxis2.valueToJava2D(this.y, rectangle2D, rectangleEdge2);
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            f4 = f3;
            f5 = f2;
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            f4 = f2;
            f5 = f3;
        }
        int n3 = this.image.getWidth(null);
        int n4 = this.image.getHeight(null);
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, n3, n4);
        Point2D point2D = RectangleAnchor.coordinates(double_, this.anchor);
        graphics2D.drawImage(this.image, (int)(f4 -= (float)point2D.getX()), (int)(f5 -= (float)point2D.getY()), null);
        String string = this.getToolTipText();
        String string2 = this.getURL();
        if (string == null) {
            if (string2 == null) return;
        }
        this.addEntity(plotRenderingInfo, new Rectangle2D.Float(f4, f5, n3, n4), n2, string, string2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYImageAnnotation)) {
            return false;
        }
        XYImageAnnotation xYImageAnnotation = (XYImageAnnotation)object;
        if (this.x != xYImageAnnotation.x) {
            return false;
        }
        if (this.y != xYImageAnnotation.y) {
            return false;
        }
        if (!ObjectUtilities.equal(this.image, xYImageAnnotation.image)) {
            return false;
        }
        if (this.anchor.equals(xYImageAnnotation.anchor)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.image.hashCode();
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}

