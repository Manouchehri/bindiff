/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.annotations;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.annotations.TextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class CategoryTextAnnotation
extends TextAnnotation
implements Serializable,
Cloneable,
CategoryAnnotation {
    private static final long serialVersionUID = 3333360090781320147L;
    private Comparable category;
    private CategoryAnchor categoryAnchor;
    private double value;

    public CategoryTextAnnotation(String string, Comparable comparable, double d2) {
        super(string);
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category = comparable;
        this.value = d2;
        this.categoryAnchor = CategoryAnchor.MIDDLE;
    }

    public Comparable getCategory() {
        return this.category;
    }

    public void setCategory(Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category = comparable;
    }

    public CategoryAnchor getCategoryAnchor() {
        return this.categoryAnchor;
    }

    public void setCategoryAnchor(CategoryAnchor categoryAnchor) {
        if (categoryAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.categoryAnchor = categoryAnchor;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double d2) {
        this.value = d2;
    }

    @Override
    public void draw(Graphics2D graphics2D, CategoryPlot categoryPlot, Rectangle2D rectangle2D, CategoryAxis categoryAxis, ValueAxis valueAxis) {
        CategoryDataset categoryDataset = categoryPlot.getDataset();
        int n2 = categoryDataset.getColumnIndex(this.category);
        int n3 = categoryDataset.getColumnCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        RectangleEdge rectangleEdge = Plot.resolveDomainAxisLocation(categoryPlot.getDomainAxisLocation(), plotOrientation);
        RectangleEdge rectangleEdge2 = Plot.resolveRangeAxisLocation(categoryPlot.getRangeAxisLocation(), plotOrientation);
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            f3 = (float)categoryAxis.getCategoryJava2DCoordinate(this.categoryAnchor, n2, n3, rectangle2D, rectangleEdge);
            f2 = (float)valueAxis.valueToJava2D(this.value, rectangle2D, rectangleEdge2);
        } else if (plotOrientation == PlotOrientation.VERTICAL) {
            f2 = (float)categoryAxis.getCategoryJava2DCoordinate(this.categoryAnchor, n2, n3, rectangle2D, rectangleEdge);
            f3 = (float)valueAxis.valueToJava2D(this.value, rectangle2D, rectangleEdge2);
        }
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        TextUtilities.drawRotatedString(this.getText(), graphics2D, f2, f3, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryTextAnnotation)) {
            return false;
        }
        CategoryTextAnnotation categoryTextAnnotation = (CategoryTextAnnotation)object;
        if (!super.equals(object)) {
            return false;
        }
        if (!this.category.equals(categoryTextAnnotation.getCategory())) {
            return false;
        }
        if (!this.categoryAnchor.equals(categoryTextAnnotation.getCategoryAnchor())) {
            return false;
        }
        if (this.value == categoryTextAnnotation.getValue()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 37 * n2 + this.category.hashCode();
        n2 = 37 * n2 + this.categoryAnchor.hashCode();
        long l2 = Double.doubleToLongBits(this.value);
        return 37 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    public Object clone() {
        return super.clone();
    }
}

