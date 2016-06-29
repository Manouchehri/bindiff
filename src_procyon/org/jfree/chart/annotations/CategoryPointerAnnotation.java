package org.jfree.chart.annotations;

import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import java.awt.geom.*;
import java.awt.*;
import org.jfree.text.*;
import org.jfree.ui.*;
import org.jfree.data.category.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;

public class CategoryPointerAnnotation extends CategoryTextAnnotation implements Serializable, Cloneable, PublicCloneable
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
    
    public CategoryPointerAnnotation(final String s, final Comparable comparable, final double n, final double angle) {
        super(s, comparable, n);
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
    
    public void draw(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final CategoryAxis categoryAxis, final ValueAxis valueAxis) {
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(categoryPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(categoryPlot.getRangeAxisLocation(), orientation);
        final CategoryDataset dataset = categoryPlot.getDataset();
        double categoryMiddle = categoryAxis.getCategoryMiddle(dataset.getColumnIndex(this.getCategory()), dataset.getColumnCount(), rectangle2D, resolveDomainAxisLocation);
        double valueToJava2D = valueAxis.valueToJava2D(this.getValue(), rectangle2D, resolveRangeAxisLocation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            final double n = categoryMiddle;
            categoryMiddle = valueToJava2D;
            valueToJava2D = n;
        }
        final double n2 = categoryMiddle + Math.cos(this.angle) * this.baseRadius;
        final double n3 = valueToJava2D + Math.sin(this.angle) * this.baseRadius;
        final double n4 = categoryMiddle + Math.cos(this.angle) * this.tipRadius;
        final double n5 = valueToJava2D + Math.sin(this.angle) * this.tipRadius;
        final double n6 = n4 + Math.cos(this.angle) * this.arrowLength;
        final double n7 = n5 + Math.sin(this.angle) * this.arrowLength;
        final double n8 = n6 + Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n9 = n7 + Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n10 = n6 - Math.cos(this.angle + 1.5707963267948966) * this.arrowWidth;
        final double n11 = n7 - Math.sin(this.angle + 1.5707963267948966) * this.arrowWidth;
        final GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo((float)n4, (float)n5);
        generalPath.lineTo((float)n8, (float)n9);
        generalPath.lineTo((float)n10, (float)n11);
        generalPath.closePath();
        graphics2D.setStroke(this.arrowStroke);
        graphics2D.setPaint(this.arrowPaint);
        graphics2D.draw(new Line2D.Double(n2, n3, n4, n5));
        graphics2D.fill(generalPath);
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        TextUtilities.drawAlignedString(this.getText(), graphics2D, (float)(categoryMiddle + Math.cos(this.angle) * (this.baseRadius + this.labelOffset)), (float)(valueToJava2D + Math.sin(this.angle) * (this.baseRadius + this.labelOffset)), this.getTextAnchor());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryPointerAnnotation)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CategoryPointerAnnotation categoryPointerAnnotation = (CategoryPointerAnnotation)o;
        return this.angle == categoryPointerAnnotation.angle && this.tipRadius == categoryPointerAnnotation.tipRadius && this.baseRadius == categoryPointerAnnotation.baseRadius && this.arrowLength == categoryPointerAnnotation.arrowLength && this.arrowWidth == categoryPointerAnnotation.arrowWidth && this.arrowPaint.equals(categoryPointerAnnotation.arrowPaint) && ObjectUtilities.equal(this.arrowStroke, categoryPointerAnnotation.arrowStroke) && this.labelOffset == categoryPointerAnnotation.labelOffset;
    }
    
    public int hashCode() {
        final int n = 193;
        final long doubleToLongBits = Double.doubleToLongBits(this.angle);
        final int n2 = 37 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.tipRadius);
        final int n3 = 37 * n2 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
        final long doubleToLongBits3 = Double.doubleToLongBits(this.baseRadius);
        final int n4 = 37 * n3 + (int)(doubleToLongBits3 ^ doubleToLongBits3 >>> 32);
        final long doubleToLongBits4 = Double.doubleToLongBits(this.arrowLength);
        final int n5 = 37 * n4 + (int)(doubleToLongBits4 ^ doubleToLongBits4 >>> 32);
        final long doubleToLongBits5 = Double.doubleToLongBits(this.arrowWidth);
        final int n6 = 37 * (37 * (37 * n5 + (int)(doubleToLongBits5 ^ doubleToLongBits5 >>> 32)) + HashUtilities.hashCodeForPaint(this.arrowPaint)) + this.arrowStroke.hashCode();
        final long doubleToLongBits6 = Double.doubleToLongBits(this.labelOffset);
        return 37 * n6 + (int)(doubleToLongBits6 ^ doubleToLongBits6 >>> 32);
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
