package org.jfree.chart.annotations;

import org.jfree.chart.plot.*;
import java.awt.image.*;
import java.awt.*;
import org.jfree.chart.axis.*;
import org.jfree.ui.*;
import java.awt.geom.*;
import org.jfree.util.*;
import java.io.*;

public class XYImageAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -4364694501921559958L;
    private double x;
    private double y;
    private transient Image image;
    private RectangleAnchor anchor;
    
    public XYImageAnnotation(final double n, final double n2, final Image image) {
        this(n, n2, image, RectangleAnchor.CENTER);
    }
    
    public XYImageAnnotation(final double x, final double y, final Image image, final RectangleAnchor anchor) {
        if (image == null) {
            throw new IllegalArgumentException("Null 'image' argument.");
        }
        if (anchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.x = x;
        this.y = y;
        this.image = image;
        this.anchor = anchor;
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
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final AxisLocation domainAxisLocation = xyPlot.getDomainAxisLocation();
        final AxisLocation rangeAxisLocation = xyPlot.getRangeAxisLocation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(domainAxisLocation, orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(rangeAxisLocation, orientation);
        final float n2 = (float)valueAxis.valueToJava2D(this.x, rectangle2D, resolveDomainAxisLocation);
        final float n3 = (float)valueAxis2.valueToJava2D(this.y, rectangle2D, resolveRangeAxisLocation);
        float n4 = 0.0f;
        float n5 = 0.0f;
        if (orientation == PlotOrientation.HORIZONTAL) {
            n4 = n3;
            n5 = n2;
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            n4 = n2;
            n5 = n3;
        }
        final int width = this.image.getWidth(null);
        final int height = this.image.getHeight(null);
        final Point2D coordinates = RectangleAnchor.coordinates(new Rectangle2D.Double(0.0, 0.0, width, height), this.anchor);
        final float n6 = n4 - (float)coordinates.getX();
        final float n7 = n5 - (float)coordinates.getY();
        graphics2D.drawImage(this.image, (int)n6, (int)n7, null);
        final String toolTipText = this.getToolTipText();
        final String url = this.getURL();
        if (toolTipText != null || url != null) {
            this.addEntity(plotRenderingInfo, new Rectangle2D.Float(n6, n7, width, height), n, toolTipText, url);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof XYImageAnnotation)) {
            return false;
        }
        final XYImageAnnotation xyImageAnnotation = (XYImageAnnotation)o;
        return this.x == xyImageAnnotation.x && this.y == xyImageAnnotation.y && ObjectUtilities.equal(this.image, xyImageAnnotation.image) && this.anchor.equals(xyImageAnnotation.anchor);
    }
    
    public int hashCode() {
        return this.image.hashCode();
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
