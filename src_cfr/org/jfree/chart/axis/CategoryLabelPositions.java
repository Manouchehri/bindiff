/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class CategoryLabelPositions
implements Serializable {
    private static final long serialVersionUID = -8999557901920364580L;
    public static final CategoryLabelPositions STANDARD = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_CENTER), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.CENTER_RIGHT, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, CategoryLabelWidthType.RANGE, 0.3f));
    public static final CategoryLabelPositions UP_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, -1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, -1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, -1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, -1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f));
    public static final CategoryLabelPositions DOWN_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, 1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, 1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, 1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f));
    public static final CategoryLabelPositions UP_45 = CategoryLabelPositions.createUpRotationLabelPositions(0.7853981633974483);
    public static final CategoryLabelPositions DOWN_45 = CategoryLabelPositions.createDownRotationLabelPositions(0.7853981633974483);
    private CategoryLabelPosition positionForAxisAtTop;
    private CategoryLabelPosition positionForAxisAtBottom;
    private CategoryLabelPosition positionForAxisAtLeft;
    private CategoryLabelPosition positionForAxisAtRight;

    public static CategoryLabelPositions createUpRotationLabelPositions(double d2) {
        return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, - d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, - d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, - d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, - d2, CategoryLabelWidthType.RANGE, 0.5f));
    }

    public static CategoryLabelPositions createDownRotationLabelPositions(double d2) {
        return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, d2, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, d2, CategoryLabelWidthType.RANGE, 0.5f));
    }

    public CategoryLabelPositions() {
        this.positionForAxisAtTop = new CategoryLabelPosition();
        this.positionForAxisAtBottom = new CategoryLabelPosition();
        this.positionForAxisAtLeft = new CategoryLabelPosition();
        this.positionForAxisAtRight = new CategoryLabelPosition();
    }

    public CategoryLabelPositions(CategoryLabelPosition categoryLabelPosition, CategoryLabelPosition categoryLabelPosition2, CategoryLabelPosition categoryLabelPosition3, CategoryLabelPosition categoryLabelPosition4) {
        if (categoryLabelPosition == null) {
            throw new IllegalArgumentException("Null 'top' argument.");
        }
        if (categoryLabelPosition2 == null) {
            throw new IllegalArgumentException("Null 'bottom' argument.");
        }
        if (categoryLabelPosition3 == null) {
            throw new IllegalArgumentException("Null 'left' argument.");
        }
        if (categoryLabelPosition4 == null) {
            throw new IllegalArgumentException("Null 'right' argument.");
        }
        this.positionForAxisAtTop = categoryLabelPosition;
        this.positionForAxisAtBottom = categoryLabelPosition2;
        this.positionForAxisAtLeft = categoryLabelPosition3;
        this.positionForAxisAtRight = categoryLabelPosition4;
    }

    public CategoryLabelPosition getLabelPosition(RectangleEdge rectangleEdge) {
        CategoryLabelPosition categoryLabelPosition = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            return this.positionForAxisAtTop;
        }
        if (rectangleEdge == RectangleEdge.BOTTOM) {
            return this.positionForAxisAtBottom;
        }
        if (rectangleEdge == RectangleEdge.LEFT) {
            return this.positionForAxisAtLeft;
        }
        if (rectangleEdge != RectangleEdge.RIGHT) return categoryLabelPosition;
        return this.positionForAxisAtRight;
    }

    public static CategoryLabelPositions replaceTopPosition(CategoryLabelPositions categoryLabelPositions, CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition != null) return new CategoryLabelPositions(categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
        throw new IllegalArgumentException("Null 'top' argument.");
    }

    public static CategoryLabelPositions replaceBottomPosition(CategoryLabelPositions categoryLabelPositions, CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition != null) return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
        throw new IllegalArgumentException("Null 'bottom' argument.");
    }

    public static CategoryLabelPositions replaceLeftPosition(CategoryLabelPositions categoryLabelPositions, CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition != null) return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
        throw new IllegalArgumentException("Null 'left' argument.");
    }

    public static CategoryLabelPositions replaceRightPosition(CategoryLabelPositions categoryLabelPositions, CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition != null) return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPosition);
        throw new IllegalArgumentException("Null 'right' argument.");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CategoryLabelPositions)) {
            return false;
        }
        CategoryLabelPositions categoryLabelPositions = (CategoryLabelPositions)object;
        if (!this.positionForAxisAtTop.equals(categoryLabelPositions.positionForAxisAtTop)) {
            return false;
        }
        if (!this.positionForAxisAtBottom.equals(categoryLabelPositions.positionForAxisAtBottom)) {
            return false;
        }
        if (!this.positionForAxisAtLeft.equals(categoryLabelPositions.positionForAxisAtLeft)) {
            return false;
        }
        if (this.positionForAxisAtRight.equals(categoryLabelPositions.positionForAxisAtRight)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 19;
        n2 = 37 * n2 + this.positionForAxisAtTop.hashCode();
        n2 = 37 * n2 + this.positionForAxisAtBottom.hashCode();
        n2 = 37 * n2 + this.positionForAxisAtLeft.hashCode();
        return 37 * n2 + this.positionForAxisAtRight.hashCode();
    }
}

