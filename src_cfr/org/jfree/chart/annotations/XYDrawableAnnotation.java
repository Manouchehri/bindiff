/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.Drawable;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYDrawableAnnotation
extends AbstractXYAnnotation
implements Serializable,
Cloneable,
PublicCloneable {
    private static final long serialVersionUID = -6540812859722691020L;
    private double x;
    private double y;
    private double width;
    private double height;
    private Drawable drawable;

    public XYDrawableAnnotation(double d2, double d3, double d4, double d5, Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Null 'drawable' argument.");
        }
        this.x = d2;
        this.y = d3;
        this.width = d4;
        this.height = d5;
        this.drawable = drawable;
    }

    @Override
    public void draw(Graphics2D graphics2D, XYPlot xYPlot, Rectangle2D rectangle2D, ValueAxis valueAxis, ValueAxis valueAxis2, int n2, PlotRenderingInfo plotRenderingInfo) {
        PlotOrientation plotOrientation = xYPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(xYPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(xYPlot.getRangeAxisLocation(), plotOrientation);
        float f2 = (float)valueAxis.valueToJava2D(this.x, rectangle2D, rectangleEdge);
        float f3 = (float)valueAxis2.valueToJava2D(this.y, rectangle2D, rectangleEdge2);
        Rectangle2D.Double double_ = new Rectangle2D.Double((double)f2 - this.width / 2.0, (double)f3 - this.height / 2.0, this.width, this.height);
        this.drawable.draw(graphics2D, double_);
        String string = this.getToolTipText();
        String string2 = this.getURL();
        if (string == null) {
            if (string2 == null) return;
        }
        this.addEntity(plotRenderingInfo, double_, n2, string, string2);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof XYDrawableAnnotation)) {
            return false;
        }
        XYDrawableAnnotation xYDrawableAnnotation = (XYDrawableAnnotation)object;
        if (this.x != xYDrawableAnnotation.x) {
            return false;
        }
        if (this.y != xYDrawableAnnotation.y) {
            return false;
        }
        if (this.width != xYDrawableAnnotation.width) {
            return false;
        }
        if (this.height != xYDrawableAnnotation.height) {
            return false;
        }
        if (ObjectUtilities.equal(this.drawable, xYDrawableAnnotation.drawable)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.x);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.y);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.width);
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.height);
        return 29 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

