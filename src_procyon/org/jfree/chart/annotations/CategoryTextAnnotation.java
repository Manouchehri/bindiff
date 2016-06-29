package org.jfree.chart.annotations;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.text.*;
import org.jfree.data.category.*;
import org.jfree.ui.*;

public class CategoryTextAnnotation extends TextAnnotation implements Serializable, Cloneable, CategoryAnnotation
{
    private static final long serialVersionUID = 3333360090781320147L;
    private Comparable category;
    private CategoryAnchor categoryAnchor;
    private double value;
    
    public CategoryTextAnnotation(final String s, final Comparable category, final double value) {
        super(s);
        if (category == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category = category;
        this.value = value;
        this.categoryAnchor = CategoryAnchor.MIDDLE;
    }
    
    public Comparable getCategory() {
        return this.category;
    }
    
    public void setCategory(final Comparable category) {
        if (category == null) {
            throw new IllegalArgumentException("Null 'category' argument.");
        }
        this.category = category;
    }
    
    public CategoryAnchor getCategoryAnchor() {
        return this.categoryAnchor;
    }
    
    public void setCategoryAnchor(final CategoryAnchor categoryAnchor) {
        if (categoryAnchor == null) {
            throw new IllegalArgumentException("Null 'anchor' argument.");
        }
        this.categoryAnchor = categoryAnchor;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setValue(final double value) {
        this.value = value;
    }
    
    public void draw(final Graphics2D graphics2D, final CategoryPlot categoryPlot, final Rectangle2D rectangle2D, final CategoryAxis categoryAxis, final ValueAxis valueAxis) {
        final CategoryDataset dataset = categoryPlot.getDataset();
        final int columnIndex = dataset.getColumnIndex(this.category);
        final int columnCount = dataset.getColumnCount();
        float n = 0.0f;
        float n2 = 0.0f;
        final PlotOrientation orientation = categoryPlot.getOrientation();
        final RectangleEdge resolveDomainAxisLocation = Plot.resolveDomainAxisLocation(categoryPlot.getDomainAxisLocation(), orientation);
        final RectangleEdge resolveRangeAxisLocation = Plot.resolveRangeAxisLocation(categoryPlot.getRangeAxisLocation(), orientation);
        if (orientation == PlotOrientation.HORIZONTAL) {
            n2 = (float)categoryAxis.getCategoryJava2DCoordinate(this.categoryAnchor, columnIndex, columnCount, rectangle2D, resolveDomainAxisLocation);
            n = (float)valueAxis.valueToJava2D(this.value, rectangle2D, resolveRangeAxisLocation);
        }
        else if (orientation == PlotOrientation.VERTICAL) {
            n = (float)categoryAxis.getCategoryJava2DCoordinate(this.categoryAnchor, columnIndex, columnCount, rectangle2D, resolveDomainAxisLocation);
            n2 = (float)valueAxis.valueToJava2D(this.value, rectangle2D, resolveRangeAxisLocation);
        }
        graphics2D.setFont(this.getFont());
        graphics2D.setPaint(this.getPaint());
        TextUtilities.drawRotatedString(this.getText(), graphics2D, n, n2, this.getTextAnchor(), this.getRotationAngle(), this.getRotationAnchor());
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryTextAnnotation)) {
            return false;
        }
        final CategoryTextAnnotation categoryTextAnnotation = (CategoryTextAnnotation)o;
        return super.equals(o) && this.category.equals(categoryTextAnnotation.getCategory()) && this.categoryAnchor.equals(categoryTextAnnotation.getCategoryAnchor()) && this.value == categoryTextAnnotation.getValue();
    }
    
    public int hashCode() {
        final int n = 37 * (37 * super.hashCode() + this.category.hashCode()) + this.categoryAnchor.hashCode();
        final long doubleToLongBits = Double.doubleToLongBits(this.value);
        return 37 * n + (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
    }
    
    public Object clone() {
        return super.clone();
    }
}
