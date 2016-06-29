package org.jfree.chart.axis;

import java.io.*;
import org.jfree.text.*;
import org.jfree.ui.*;

public class CategoryLabelPosition implements Serializable
{
    private static final long serialVersionUID = 5168681143844183864L;
    private RectangleAnchor categoryAnchor;
    private TextBlockAnchor labelAnchor;
    private TextAnchor rotationAnchor;
    private double angle;
    private CategoryLabelWidthType widthType;
    private float widthRatio;
    
    public CategoryLabelPosition() {
        this(RectangleAnchor.CENTER, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0, CategoryLabelWidthType.CATEGORY, 0.95f);
    }
    
    public CategoryLabelPosition(final RectangleAnchor rectangleAnchor, final TextBlockAnchor textBlockAnchor) {
        this(rectangleAnchor, textBlockAnchor, TextAnchor.CENTER, 0.0, CategoryLabelWidthType.CATEGORY, 0.95f);
    }
    
    public CategoryLabelPosition(final RectangleAnchor rectangleAnchor, final TextBlockAnchor textBlockAnchor, final CategoryLabelWidthType categoryLabelWidthType, final float n) {
        this(rectangleAnchor, textBlockAnchor, TextAnchor.CENTER, 0.0, categoryLabelWidthType, n);
    }
    
    public CategoryLabelPosition(final RectangleAnchor categoryAnchor, final TextBlockAnchor labelAnchor, final TextAnchor rotationAnchor, final double angle, final CategoryLabelWidthType widthType, final float widthRatio) {
        if (categoryAnchor == null) {
            throw new IllegalArgumentException("Null 'categoryAnchor' argument.");
        }
        if (labelAnchor == null) {
            throw new IllegalArgumentException("Null 'labelAnchor' argument.");
        }
        if (rotationAnchor == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        if (widthType == null) {
            throw new IllegalArgumentException("Null 'widthType' argument.");
        }
        this.categoryAnchor = categoryAnchor;
        this.labelAnchor = labelAnchor;
        this.rotationAnchor = rotationAnchor;
        this.angle = angle;
        this.widthType = widthType;
        this.widthRatio = widthRatio;
    }
    
    public RectangleAnchor getCategoryAnchor() {
        return this.categoryAnchor;
    }
    
    public TextBlockAnchor getLabelAnchor() {
        return this.labelAnchor;
    }
    
    public TextAnchor getRotationAnchor() {
        return this.rotationAnchor;
    }
    
    public double getAngle() {
        return this.angle;
    }
    
    public CategoryLabelWidthType getWidthType() {
        return this.widthType;
    }
    
    public float getWidthRatio() {
        return this.widthRatio;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CategoryLabelPosition)) {
            return false;
        }
        final CategoryLabelPosition categoryLabelPosition = (CategoryLabelPosition)o;
        return this.categoryAnchor.equals(categoryLabelPosition.categoryAnchor) && this.labelAnchor.equals(categoryLabelPosition.labelAnchor) && this.rotationAnchor.equals(categoryLabelPosition.rotationAnchor) && this.angle == categoryLabelPosition.angle && this.widthType == categoryLabelPosition.widthType && this.widthRatio == categoryLabelPosition.widthRatio;
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * 19 + this.categoryAnchor.hashCode()) + this.labelAnchor.hashCode()) + this.rotationAnchor.hashCode();
    }
}
