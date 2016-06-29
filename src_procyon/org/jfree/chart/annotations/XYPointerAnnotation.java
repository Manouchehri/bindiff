package org.jfree.chart.annotations;

import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;

public class XYPointerAnnotation extends XYTextAnnotation implements Serializable, Cloneable, PublicCloneable
{
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
    
    public XYPointerAnnotation(final String s, final double n, final double n2, final double angle) {
        super(s, n, n2);
        this.angle = angle;
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
    
    public void setAngle(final double angle) {
        this.angle = angle;
    }
    
    public double getTipRadius() {
        return this.tipRadius;
    }
    
    public void setTipRadius(final double tipRadius) {
        this.tipRadius = tipRadius;
    }
    
    public double getBaseRadius() {
        return this.baseRadius;
    }
    
    public void setBaseRadius(final double baseRadius) {
        this.baseRadius = baseRadius;
    }
    
    public double getLabelOffset() {
        return this.labelOffset;
    }
    
    public void setLabelOffset(final double labelOffset) {
        this.labelOffset = labelOffset;
    }
    
    public double getArrowLength() {
        return this.arrowLength;
    }
    
    public void setArrowLength(final double arrowLength) {
        this.arrowLength = arrowLength;
    }
    
    public double getArrowWidth() {
        return this.arrowWidth;
    }
    
    public void setArrowWidth(final double arrowWidth) {
        this.arrowWidth = arrowWidth;
    }
    
    public Stroke getArrowStroke() {
        return this.arrowStroke;
    }
    
    public void setArrowStroke(final Stroke arrowStroke) {
        if (arrowStroke == null) {
            throw new IllegalArgumentException("Null 'stroke' not permitted.");
        }
        this.arrowStroke = arrowStroke;
    }
    
    public Paint getArrowPaint() {
        return this.arrowPaint;
    }
    
    public void setArrowPaint(final Paint arrowPaint) {
        if (arrowPaint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.arrowPaint = arrowPaint;
    }
    
    public void draw(final Graphics2D graphics2D, final XYPlot xyPlot, final Rectangle2D rectangle2D, final ValueAxis valueAxis, final ValueAxis valueAxis2, final int n, final PlotRenderingInfo plotRenderingInfo) {
        final PlotOrientation orientation = xyPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(xyPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(xyPlot.getRangeAxisLocation(), orientation);
        double valueToJava2D = valueAxis.valueToJava2D(this.getX(), rectangle2D, resolveDomainAxisLocation);
        double valueToJava2D2 = valueAxis2.valueToJava2D(this.getY(), rectangle2D, resolveRangeAxisLocation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double n2 = valueToJava2D;
            valueToJava2D = valueToJava2D2;
            valueToJava2D2 = n2;
        }
        final double n3 = valueToJava2D + Math.cos(this.angle) * this.baseRadius;
        final double n4 = valueToJava2D2 + Math.sin(this.angle) * this.baseRadius;
        final double n5 = valueToJava2D + Math.cos(this.angle) * this.tipRadius;
        final double n6 = valueToJava2D2 + Math.sin(this.angle) * this.tipRadius;
        final double n7 = n5 + Math.cos(this.angle) * this.arrowLength;
        final double n8 = n6 + Math.sin(this.angle) * this.arrowLength;
        final double n9 = n7 + Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n10 = n8 + Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n11 = n7 - Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n12 = n8 - Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)n5, (float)n6);
        generalPath.lineTo((float)n9, (float)n10);
        generalPath.lineTo((float)n11, (float)n12);
        generalPath.closePath();
        graphics2D.setStroke(this.arrowStroke);
        graphics2D.setPaint(this.arrowPaint);
        graphics2D.draw(new Line2D.Double(n3, n4, n5, n6));
        graphics2D.fill(generalPath);
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        final Rectangle2D drawAlignedString = TextUtilities.drawAlignedString(this.getText(), graphics2D, (float)(valueToJava2D + Math.cos(this.angle) * (this.baseRadius + this.labelOffset)), (float)(valueToJava2D2 + Math.sin(this.angle) * (this.baseRadius + this.labelOffset)), this.getTextAnchor());
        final String toolTipText = this.getToolTipText();
        final String url = this.getURL();
        if (toolTipText != null || url != null) {
            this.addEntity(plotRenderingInfo, drawAlignedString, n, toolTipText, url);
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYPointerAnnotation)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final XYPointerAnnotation xyPointerAnnotation = (XYPointerAnnotation)o;
        return this.angle == xyPointerAnnotation.angle && this.tipRadius == xyPointerAnnotation.tipRadius && this.baseRadius == xyPointerAnnotation.baseRadius && this.arrowLength == xyPointerAnnotation.arrowLength && this.arrowWidth == xyPointerAnnotation.arrowWidth && this.arrowPaint.equals(xyPointerAnnotation.arrowPaint) && ObjectUtilities.equal(this.arrowStroke, xyPointerAnnotation.arrowStroke) && this.labelOffset == xyPointerAnnotation.labelOffset;
    }
    
    public int hashCode() {
        final int hashCode = super.hashCode();
        final long doubleToLongBits = Double.doubleToLongBits(this.angle);
        final int n = 37 * hashCode + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.tipRadius);
        final int n2 = 37 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.baseRadius);
        final int n3 = 37 * n2 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.arrowLength);
        final int n4 = 37 * n3 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
        final long doubleToLongBits5 = Double.doubleToLongBits(this.arrowWidth);
        final int n5 = ((37 * n4 + (int)(doubleToLongBits5 ^ doubleToLongBits5 >>> 32)) * 37 + HashUtilities.hashCodeForPaint(this.arrowPaint)) * 37 + this.arrowStroke.hashCode();
        final long doubleToLongBits6 = Double.doubleToLongBits(this.labelOffset);
        final int n6 = 37 * n5 + (int)(doubleToLongBits6 ^ doubleToLongBits6 >>> 32);
        return super.hashCode();
    }
    
    public Object clone() {
        return super.clone();
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.arrowPaint, objectOutputStream);
        SerialUtilities.writeStroke(this.arrowStroke, objectOutputStream);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.arrowPaint = SerialUtilities.readPaint(objectInputStream);
        this.arrowStroke = SerialUtilities.readStroke(objectInputStream);
    }
}
