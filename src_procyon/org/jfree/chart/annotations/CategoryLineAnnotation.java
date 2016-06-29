package org.jfree.chart.annotations;

import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import org.jfree.data.category.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import org.jfree.chart.*;
import org.jfree.io.*;
import java.io.*;

public class CategoryLineAnnotation implements Serializable, Cloneable, CategoryAnnotation
{
    private Comparable category1;
    private double value1;
    private Comparable category2;
    private double value2;
    private transient Paint paint;
    private transient Stroke stroke;
    
    public CategoryLineAnnotation(final Comparable category1, final double value1, final Comparable category2, final double value2, final Paint paint, final Stroke stroke) {
        this.paint = Color.black;
        this.stroke = new BasicStroke(1.0f);
        if (category1 == null) {
            throw new IllegalArgumentException("Null 'category1' argument.");
        }
        if (category2 == null) {
            throw new IllegalArgumentException("Null 'category2' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.category1 = category1;
        this.value1 = value1;
        this.category2 = category2;
        this.value2 = value2;
        this.paint = paint;
        this.stroke = stroke;
    }
    
    public Comparable getCategory1() {
        return this.category1;
    }
    
    public void setCategory1(final Comparable category1) {
        if (category1 == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category1 = category1;
    }
    
    public double getValue1() {
        return this.value1;
    }
    
    public void setValue1(final double value1) {
        this.value1 = value1;
    }
    
    public Comparable getCategory2() {
        return this.category2;
    }
    
    public void setCategory2(final Comparable category2) {
        if (category2 == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category2 = category2;
    }
    
    public double getValue2() {
        return this.value2;
    }
    
    public void setValue2(final double value2) {
        this.value2 = value2;
    }
    
    public Paint getPaint() {
        return this.paint;
    }
    
    public void setPaint(final Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
    }
    
    public Stroke getStroke() {
        return this.stroke;
    }
    
    public void setStroke(final Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stroke = stroke;
    }
    
    public void draw(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final CategoryAxis categoryAxis, final ValueAxis valueAxis) {
        final CategoryDataset dataset = categoryPlot.getDataset();
        final int columnIndex = dataset.getColumnIndex(this.category1);
        final int columnIndex2 = dataset.getColumnIndex(this.category2);
        final int columnCount = dataset.getColumnCount();
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        double n4 = 0.0;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(categoryPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(categoryPlot.getRangeAxisLocation(), orientation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            n2 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, columnIndex, columnCount, rectangle2D, resolveDomainAxisLocation);
            n = valueAxis.valueToJava2D(this.value1, rectangle2D, resolveRangeAxisLocation);
            n4 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, columnIndex2, columnCount, rectangle2D, resolveDomainAxisLocation);
            n3 = valueAxis.valueToJava2D(this.value2, rectangle2D, resolveRangeAxisLocation);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            n = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, columnIndex, columnCount, rectangle2D, resolveDomainAxisLocation);
            n2 = valueAxis.valueToJava2D(this.value1, rectangle2D, resolveRangeAxisLocation);
            n3 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, columnIndex2, columnCount, rectangle2D, resolveDomainAxisLocation);
            n4 = valueAxis.valueToJava2D(this.value2, rectangle2D, resolveRangeAxisLocation);
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setStroke(this.stroke);
        graphics2D.drawLine((int)n, (int)n2, (int)n3, (int)n4);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryLineAnnotation)) {
            return false;
        }
        final CategoryLineAnnotation categoryLineAnnotation = (CategoryLineAnnotation)o;
        return this.category1.equals(categoryLineAnnotation.getCategory1()) && this.value1 == categoryLineAnnotation.getValue1() && this.category2.equals(categoryLineAnnotation.getCategory2()) && this.value2 == categoryLineAnnotation.getValue2() && PaintUtilities.equal(this.paint, categoryLineAnnotation.paint) && ObjectUtilities.equal(this.stroke, categoryLineAnnotation.stroke);
    }
    
    public int hashCode() {
        final int n = 37 * 193 + this.category1.hashCode();
        final long doubleToLongBits = Double.doubleToLongBits(this.value1);
        final int n2 = 37 * (37 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32)) + this.category2.hashCode();
        final long doubleToLongBits2 = Double.doubleToLongBits(this.value2);
        return 37 * (37 * (37 * n2 + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32)) + HashUtilities.hashCodeForPaint(this.paint)) + this.stroke.hashCode();
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
