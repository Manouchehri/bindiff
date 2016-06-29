package org.jfree.chart.annotations;

import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYLineAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -80535465244091334L;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private transient Stroke stroke;
    private transient Paint paint;
    
    public XYLineAnnotation(final double n, final double n2, final double n3, final double n4) {
        this(n, n2, n3, n4, new BasicStroke(1.0f), Color.black);
    }
    
    public XYLineAnnotation(final double x1, final double y1, final double x2, final double y2, final Stroke stroke, final Paint paint) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.stroke = stroke;
        this.paint = paint;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        float n2 = 0.0f;
        float n3 = 0.0f;
        float n4 = 0.0f;
        float n5 = 0.0f;
        if (orientation == PlotOrientation.VERTICAL) {
            n2 = (float)valueAxis.valueToJava2D(this.x1, rectangle2D, resolveDomainAxisLocation);
            n4 = (float)valueAxis2.valueToJava2D(this.y1, rectangle2D, resolveRangeAxisLocation);
            n3 = (float)valueAxis.valueToJava2D(this.x2, rectangle2D, resolveDomainAxisLocation);
            n5 = (float)valueAxis2.valueToJava2D(this.y2, rectangle2D, resolveRangeAxisLocation);
        }
        else if (orientation == PlotOrientation.HORIZONTAL) {
            n4 = (float)valueAxis.valueToJava2D(this.x1, rectangle2D, resolveDomainAxisLocation);
            n2 = (float)valueAxis2.valueToJava2D(this.y1, rectangle2D, resolveRangeAxisLocation);
            n5 = (float)valueAxis.valueToJava2D(this.x2, rectangle2D, resolveDomainAxisLocation);
            n3 = (float)valueAxis2.valueToJava2D(this.y2, rectangle2D, resolveRangeAxisLocation);
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setStroke(this.stroke);
        final Line2D.Float float1 = new Line2D.Float(n2, n4, n3, n5);
        graphics2D.draw(float1);
        final String toolTipText = this.getToolTipText();
        final String url = this.getURL();
        if (toolTipText != null || url != null) {
            this.addEntity(plotRenderingInfo, ShapeUtilities.createLineRegion(float1, 1.0f), n, toolTipText, url);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof XYLineAnnotation)) {
            return false;
        }
        final XYLineAnnotation xyLineAnnotation = (XYLineAnnotation)o;
        return this.x1 == xyLineAnnotation.x1 && this.y1 == xyLineAnnotation.y1 && this.x2 == xyLineAnnotation.x2 && this.y2 == xyLineAnnotation.y2 && PaintUtilities.equal(this.paint, xyLineAnnotation.paint) && ObjectUtilities.equal(this.stroke, xyLineAnnotation.stroke);
    }
    
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.x1);
        final int n = (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.x2);
        final int n2 = 29 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.y1);
        final int n3 = 29 * n2 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.y2);
        return 29 * n3 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
    }
}
