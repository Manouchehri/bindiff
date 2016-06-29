/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

public class CategoryLabelPosition
implements Serializable {
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

    public CategoryLabelPosition(RectangleAnchor rectangleAnchor, TextBlockAnchor textBlockAnchor) {
        this(rectangleAnchor, textBlockAnchor, TextAnchor.CENTER, 0.0, CategoryLabelWidthType.CATEGORY, 0.95f);
    }

    public CategoryLabelPosition(RectangleAnchor rectangleAnchor, TextBlockAnchor textBlockAnchor, CategoryLabelWidthType categoryLabelWidthType, float f2) {
        this(rectangleAnchor, textBlockAnchor, TextAnchor.CENTER, 0.0, categoryLabelWidthType, f2);
    }

    public CategoryLabelPosition(RectangleAnchor rectangleAnchor, TextBlockAnchor textBlockAnchor, TextAnchor textAnchor, double d2, CategoryLabelWidthType categoryLabelWidthType, float f2) {
        if (rectangleAnchor == null) {
            throw new IllegalArgumentException("Null 'categoryAnchor' argument.");
        }
        if (textBlockAnchor == null) {
            throw new IllegalArgumentException("Null 'labelAnchor' argument.");
        }
        if (textAnchor == null) {
            throw new IllegalArgumentException("Null 'rotationAnchor' argument.");
        }
        if (categoryLabelWidthType == null) {
            throw new IllegalArgumentException("Null 'widthType' argument.");
        }
        this.categoryAnchor = rectangleAnchor;
        this.labelAnchor = textBlockAnchor;
        this.rotationAnchor = textAnchor;
        this.angle = d2;
        this.widthType = categoryLabelWidthType;
        this.widthRatio = f2;
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

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CategoryLabelPosition)) {
            return false;
        }
        CategoryLabelPosition categoryLabelPosition = (CategoryLabelPosition)object;
        if (!this.categoryAnchor.equals(categoryLabelPosition.categoryAnchor)) {
            return false;
        }
        if (!this.labelAnchor.equals(categoryLabelPosition.labelAnchor)) {
            return false;
        }
        if (!this.rotationAnchor.equals(categoryLabelPosition.rotationAnchor)) {
            return false;
        }
        if (this.angle != categoryLabelPosition.angle) {
            return false;
        }
        if (this.widthType != categoryLabelPosition.widthType) {
            return false;
        }
        if (this.widthRatio == categoryLabelPosition.widthRatio) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 19;
        n2 = 37 * n2 + this.categoryAnchor.hashCode();
        n2 = 37 * n2 + this.labelAnchor.hashCode();
        return 37 * n2 + this.rotationAnchor.hashCode();
    }
}

