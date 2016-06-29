package org.jfree.chart.annotations;

import org.jfree.chart.axis.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import org.jfree.ui.*;
import java.util.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;

public class XYPolygonAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable
{
    private static final long serialVersionUID = -6984203651995900036L;
    private double[] polygon;
    private transient Stroke stroke;
    private transient Paint outlinePaint;
    private transient Paint fillPaint;
    
    public XYPolygonAnnotation(final double[] array) {
        this(array, new BasicStroke(1.0f), Color.black);
    }
    
    public XYPolygonAnnotation(final double[] array, final Stroke stroke, final Paint paint) {
        this(array, stroke, paint, null);
    }
    
    public XYPolygonAnnotation(final double[] array, final Stroke stroke, final Paint outlinePaint, final Paint fillPaint) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'polygon' argument.");
        }
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException("The 'polygon' array must contain an even number of items.");
        }
        this.polygon = array.clone();
        this.stroke = stroke;
        this.outlinePaint = outlinePaint;
        this.fillPaint = fillPaint;
    }
    
    public double[] getPolygonCoordinates() {
        return this.polygon.clone();
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
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        if (this.polygon.length < 4) {
            return;
        }
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        final GeneralPath generalPath = new GeneralPath();
        final double valueToJava2D = valueAxis.valueToJava2D(this.polygon[0], rectangle2D, resolveDomainAxisLocation);
        final double valueToJava2D2 = valueAxis2.valueToJava2D(this.polygon[1], rectangle2D, resolveRangeAxisLocation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            generalPath.moveTo((float)valueToJava2D2, (float)valueToJava2D);
            for (int i = 2; i < this.polygon.length; i += 2) {
                generalPath.lineTo((float)valueAxis2.valueToJava2D(this.polygon[i + 1], rectangle2D, resolveRangeAxisLocation), (float)valueAxis.valueToJava2D(this.polygon[i], rectangle2D, resolveDomainAxisLocation));
            }
            generalPath.closePath();
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            generalPath.moveTo((float)valueToJava2D, (float)valueToJava2D2);
            for (int j = 2; j < this.polygon.length; j += 2) {
                generalPath.lineTo((float)valueAxis.valueToJava2D(this.polygon[j], rectangle2D, resolveDomainAxisLocation), (float)valueAxis2.valueToJava2D(this.polygon[j + 1], rectangle2D, resolveRangeAxisLocation));
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
        this.addEntity(plotRenderingInfo, generalPath, n, this.getToolTipText(), this.getURL());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (!(o instanceof XYPolygonAnnotation)) {
            return false;
        }
        final XYPolygonAnnotation xyPolygonAnnotation = (XYPolygonAnnotation)o;
        return Arrays.equals(this.polygon, xyPolygonAnnotation.polygon) && ObjectUtilities.equal(this.stroke, xyPolygonAnnotation.stroke) && PaintUtilities.equal(this.outlinePaint, xyPolygonAnnotation.outlinePaint) && PaintUtilities.equal(this.fillPaint, xyPolygonAnnotation.fillPaint);
    }
    
    public int hashCode() {
        int n = 37 * (37 * (37 * 193 + HashUtilities.hashCodeForDoubleArray(this.polygon)) + HashUtilities.hashCodeForPaint(this.fillPaint)) + HashUtilities.hashCodeForPaint(this.outlinePaint);
        if (this.stroke != null) {
            n = 37 * n + this.stroke.hashCode();
        }
        return n;
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
