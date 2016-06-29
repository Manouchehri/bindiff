package org.jfree.chart.annotations;

import java.awt.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;

public class XYShapeAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -8553218317600684041L;
    private transient Shape shape;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;
    
    public XYShapeAnnotation(final Shape shape) {
        this(shape, new BasicStroke(1.0f), Color.black);
    }
    
    public XYShapeAnnotation(final Shape shape, final Stroke stroke, final Paint paint) {
        this(shape, stroke, paint, null);
    }
    
    public XYShapeAnnotation(final Shape shape, final Stroke stroke, final Paint outlinePaint, final Paint fillPaint) {
        if (shape == null) {
            throw new IllegalArgumentException("Null 'shape' argument.");
        }
        this.shape = shape;
        this.stroke = stroke;
        this.outlinePaint = outlinePaint;
        this.fillPaint = fillPaint;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        final Rectangle2D bounds2D = this.shape.getBounds2D();
        final double minX = bounds2D.getMinX();
        final double maxX = bounds2D.getMaxX();
        final double valueToJava2D = valueAxis.valueToJava2D(minX, rectangle2D, resolveDomainAxisLocation);
        final double n2 = (valueAxis.valueToJava2D(maxX, rectangle2D, resolveDomainAxisLocation) - valueToJava2D) / (maxX - minX);
        final double n3 = valueToJava2D - minX * n2;
        final double maxY = bounds2D.getMaxY();
        final double minY = bounds2D.getMinY();
        final double valueToJava2D2 = valueAxis2.valueToJava2D(maxY, rectangle2D, resolveRangeAxisLocation);
        final double n4 = (valueAxis2.valueToJava2D(minY, rectangle2D, resolveRangeAxisLocation) - valueToJava2D2) / (minY - maxY);
        final double n5 = valueToJava2D2 - n4 * maxY;
        Shape shape = null;
        if (orientation == PlotOrientation.HORIZONTAL) {
            shape = new AffineTransform(n4, 0.0, 0.0, n2, n5, n3).createTransformedShape(new AffineTransform(0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f).createTransformedShape(this.shape));
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            shape = new AffineTransform(n2, 0.0, 0.0, n4, n3, n5).createTransformedShape(this.shape);
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
        if (!(o instanceof XYShapeAnnotation)) {
            return false;
        }
        final XYShapeAnnotation xyShapeAnnotation = (XYShapeAnnotation)o;
        return this.shape.equals(xyShapeAnnotation.shape) && ObjectUtilities.equal(this.stroke, xyShapeAnnotation.stroke) && PaintUtilities.equal(this.outlinePaint, xyShapeAnnotation.outlinePaint) && PaintUtilities.equal(this.fillPaint, xyShapeAnnotation.fillPaint);
    }
    
    public int hashCode() {
        int n = 37 * 193 + this.shape.hashCode();
        if (this.stroke != null) {
            n = 37 * n + this.stroke.hashCode();
        }
        return 37 * (37 * n + HashUtilities.hashCodeForPaint(this.outlinePaint)) + HashUtilities.hashCodeForPaint(this.fillPaint);
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writeShape(this.shape, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
        SerialUtilities.writePaint(this.outlinePaint, objectOutputStream);
        SerialUtilities.writePaint(this.fillPaint, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.shape = SerialUtilities.readShape(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
        this.outlinePaint = SerialUtilities.readPaint(objectInputStream);
        this.fillPaint = SerialUtilities.readPaint(objectInputStream);
    }
}
