package org.jfree.chart.annotations;

import java.io.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import java.awt.*;
import org.jfree.chart.plot.*;
import org.jfree.util.*;

public class XYDrawableAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -6540812859722691020L;
    private double x;
    private double y;
    private double width;
    private double height;
    private Drawable drawable;
    
    public XYDrawableAnnotation(final double x, final double y, final double width, final double height, final Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Null 'drawable' argument.");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.drawable = drawable;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final Rectangle2D.Double double1 = new Rectangle2D.Double((float)valueAxis.valueToJava2D(this.x, rectangle2D, Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation)) - this.width / 2.0, (float)valueAxis2.valueToJava2D(this.y, rectangle2D, Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation)) - this.height / 2.0, this.width, this.height);
        this.drawable.draw(graphics2D, double1);
        final String toolTipText = this.getToolTipText();
        final String url = this.getURL();
        if (toolTipText != null || url != null) {
            this.addEntity(plotRenderingInfo, double1, n, toolTipText, url);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof XYDrawableAnnotation)) {
            return false;
        }
        final XYDrawableAnnotation xyDrawableAnnotation = (XYDrawableAnnotation)o;
        return this.x == xyDrawableAnnotation.x && this.y == xyDrawableAnnotation.y && this.width == xyDrawableAnnotation.width && this.height == xyDrawableAnnotation.height && ObjectUtilities.equal(this.drawable, xyDrawableAnnotation.drawable);
    }
    
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.x);
        final int n = (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        final int n2 = 29 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.width);
        final int n3 = 29 * n2 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.height);
        return 29 * n3 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
    }
    
    public Object clone() {
        return super.clone();
    }
}
