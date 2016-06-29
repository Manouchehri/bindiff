/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class CategoryLineAnnotation
implements Serializable,
Cloneable,
CategoryAnnotation {
    private Comparable category1;
    private double value1;
    private Comparable category2;
    private double value2;
    private transient Paint paint = Color.black;
    private transient Stroke stroke = new BasicStroke(1.0f);

    public CategoryLineAnnotation(Comparable comparable, double d2, Comparable comparable2, double d3, Paint paint, Stroke stroke) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category1' argument.");
        }
        if (comparable2 == null) {
            throw new IllegalArgumentException("Null 'category2' argument.");
        }
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.category1 = comparable;
        this.value1 = d2;
        this.category2 = comparable2;
        this.value2 = d3;
        this.paint = paint;
        this.stroke = stroke;
    }

    public Comparable getCategory1() {
        return this.category1;
    }

    public void setCategory1(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category1 = comparable;
    }

    public double getValue1() {
        return this.value1;
    }

    public void setValue1(double d2) {
        this.value1 = d2;
    }

    public Comparable getCategory2() {
        return this.category2;
    }

    public void setCategory2(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category2 = comparable;
    }

    public double getValue2() {
        return this.value2;
    }

    public void setValue2(double d2) {
        this.value2 = d2;
    }

    public Paint getPaint() {
        return this.paint;
    }

    public void setPaint(Paint paint) {
        if (paint == null) {
            throw new IllegalArgumentException("Null 'paint' argument.");
        }
        this.paint = paint;
    }

    public Stroke getStroke() {
        return this.stroke;
    }

    public void setStroke(Stroke stroke) {
        if (stroke == null) {
            throw new IllegalArgumentException("Null 'stroke' argument.");
        }
        this.stroke = stroke;
    }

    @Override
    public void draw(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D, CategoryAxis categoryAxis, ValueAxis valueAxis) {
        CategoryDataset categoryDataset = categoryPlot.getDataset();
        int n2 = categoryDataset.getColumnIndex(this.category1);
        int n3 = categoryDataset.getColumnIndex(this.category2);
        int n4 = categoryDataset.getColumnCount();
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(categoryPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(categoryPlot.getRangeAxisLocation(), plotOrientation);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            d3 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, n2, n4, rectangle2D, rectangleEdge);
            d2 = valueAxis.valueToJava2D(this.value1, rectangle2D, rectangleEdge2);
            d5 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, n3, n4, rectangle2D, rectangleEdge);
            d4 = valueAxis.valueToJava2D(this.value2, rectangle2D, rectangleEdge2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            d2 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, n2, n4, rectangle2D, rectangleEdge);
            d3 = valueAxis.valueToJava2D(this.value1, rectangle2D, rectangleEdge2);
            d4 = categoryAxis.getCategoryJava2DCoordinate(CategoryAnchor.MIDDLE, n3, n4, rectangle2D, rectangleEdge);
            d5 = valueAxis.valueToJava2D(this.value2, rectangle2D, rectangleEdge2);
        }
        graphics2D.setPaint(this.paint);
        graphics2D.setStroke(this.stroke);
        graphics2D.drawLine((int)d2, (int)d3, (int)d4, (int)d5);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryLineAnnotation)) {
            return false;
        }
        CategoryLineAnnotation categoryLineAnnotation = (CategoryLineAnnotation)object;
        if (!this.category1.equals(categoryLineAnnotation.getCategory1())) {
            return false;
        }
        if (this.value1 != categoryLineAnnotation.getValue1()) {
            return false;
        }
        if (!this.category2.equals(categoryLineAnnotation.getCategory2())) {
            return false;
        }
        if (this.value2 != categoryLineAnnotation.getValue2()) {
            return false;
        }
        if (!PaintUtilities.equal(this.paint, categoryLineAnnotation.paint)) {
            return false;
        }
        if (ObjectUtilities.equal(this.stroke, categoryLineAnnotation.stroke)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + this.category1.hashCode();
        long l2 = Double.doubleToLongBits(this.value1);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 37 * n2 + this.category2.hashCode();
        l2 = Double.doubleToLongBits(this.value2);
        n2 = 37 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 37 * n2 + HashUtilities.hashCodeForPaint(this.paint);
        return 37 * n2 + this.stroke.hashCode();
    }

    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        SerialUtilities.writePaint(this.paint, objectOutputStream);
        SerialUtilities.writeStroke(this.stroke, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.paint = SerialUtilities.readPaint(objectInputStream);
        this.stroke = SerialUtilities.readStroke(objectInputStream);
    }
}

