package org.jfree.chart.annotations;

import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.ui.*;
import java.awt.*;
import org.jfree.util.*;
import org.jfree.io.*;
import java.io.*;

public class XYBoxAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = 6764703772526757457L;
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;
    
    public XYBoxAnnotation(final double n, final double n2, final double n3, final double n4) {
        this(n, n2, n3, n4, new BasicStroke(1.0f), Color.black);
    }
    
    public XYBoxAnnotation(final double n, final double n2, final double n3, final double n4, final Stroke stroke, final Paint paint) {
        this(n, n2, n3, n4, stroke, paint, null);
    }
    
    public XYBoxAnnotation(final double x0, final double y0, final double x2, final double y2, final Stroke stroke, final Paint outlinePaint, final Paint fillPaint) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x2;
        this.y1 = y2;
        this.stroke = stroke;
        this.outlinePaint = outlinePaint;
        this.fillPaint = fillPaint;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        final double valueToJava2D = valueAxis.valueToJava2D(this.x0, rectangle2D, resolveDomainAxisLocation);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(this.y0, rectangle2D, resolveRangeAxisLocation);
        final double valueToJava2D3 = valueAxis.valueToJava2D(this.x1, rectangle2D, resolveDomainAxisLocation);
        final double valueToJava2D4 = valueAxis2.valueToJava2D(this.y1, rectangle2D, resolveRangeAxisLocation);
        Shape shape = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new Rectangle2D.Double(valueToJava2D2, valueToJava2D3, valueToJava2D4 - valueToJava2D2, valueToJava2D - valueToJava2D3);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new Rectangle2D.Double(valueToJava2D, valueToJava2D4, valueToJava2D3 - valueToJava2D, valueToJava2D2 - valueToJava2D4);
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
        this.addEntity(plotRenderingInfo, shape, n, this.getToolTipText(), this.getURL());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof XYBoxAnnotation)) {
            return false;
        }
        final XYBoxAnnotation xyBoxAnnotation = (XYBoxAnnotation)o;
        return this.x0 == xyBoxAnnotation.x0 && this.y0 == xyBoxAnnotation.y0 && this.x1 == xyBoxAnnotation.x1 && this.y1 == xyBoxAnnotation.y1 && ObjectUtilities.equal(this.stroke, xyBoxAnnotation.stroke) && PaintUtilities.equal(this.outlinePaint, xyBoxAnnotation.outlinePaint) && PaintUtilities.equal(this.fillPaint, xyBoxAnnotation.fillPaint);
    }
    
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.x0);
        final int n = (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.x1);
        final int n2 = 29 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.y0);
        final int n3 = 29 * n2 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.y1);
        return 29 * n3 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
