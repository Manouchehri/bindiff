package org.jfree.chart.axis;

import java.io.*;
import org.jfree.text.*;
import org.jfree.ui.*;

public class CategoryLabelPositions implements Serializable
{
    private static final long serialVersionUID = -8999557901920364580L;
    public static final CategoryLabelPositions STANDARD;
    public static final CategoryLabelPositions UP_90;
    public static final CategoryLabelPositions DOWN_90;
    public static final CategoryLabelPositions UP_45;
    public static final CategoryLabelPositions DOWN_45;
    private CategoryLabelPosition positionForAxisAtTop;
    private CategoryLabelPosition positionForAxisAtBottom;
    private CategoryLabelPosition positionForAxisAtLeft;
    private CategoryLabelPosition positionForAxisAtRight;
    
    public static CategoryLabelPositions createUpRotationLabelPositions(final double n) {
        return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, -n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, -n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, -n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, -n, CategoryLabelWidthType.RANGE, 0.5f));
    }
    
    public static CategoryLabelPositions createDownRotationLabelPositions(final double n) {
        return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, n, CategoryLabelWidthType.RANGE, 0.5f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, n, CategoryLabelWidthType.RANGE, 0.5f));
    }
    
    public CategoryLabelPositions() {
        this.positionForAxisAtTop = new CategoryLabelPosition();
        this.positionForAxisAtBottom = new CategoryLabelPosition();
        this.positionForAxisAtLeft = new CategoryLabelPosition();
        this.positionForAxisAtRight = new CategoryLabelPosition();
    }
    
    public CategoryLabelPositions(final CategoryLabelPosition positionForAxisAtTop, final CategoryLabelPosition positionForAxisAtBottom, final CategoryLabelPosition positionForAxisAtLeft, final CategoryLabelPosition positionForAxisAtRight) {
        if (positionForAxisAtTop == null) {
            throw new IllegalArgumentException("Null 'top' argument.");
        }
        if (positionForAxisAtBottom == null) {
            throw new IllegalArgumentException("Null 'bottom' argument.");
        }
        if (positionForAxisAtLeft == null) {
            throw new IllegalArgumentException("Null 'left' argument.");
        }
        if (positionForAxisAtRight == null) {
            throw new IllegalArgumentException("Null 'right' argument.");
        }
        this.positionForAxisAtTop = positionForAxisAtTop;
        this.positionForAxisAtBottom = positionForAxisAtBottom;
        this.positionForAxisAtLeft = positionForAxisAtLeft;
        this.positionForAxisAtRight = positionForAxisAtRight;
    }
    
    public CategoryLabelPosition getLabelPosition(final RectangleEdge rectangleEdge) {
        CategoryLabelPosition categoryLabelPosition = null;
        if (rectangleEdge == RectangleEdge.TOP) {
            categoryLabelPosition = this.positionForAxisAtTop;
        }
        else if (rectangleEdge == RectangleEdge.BOTTOM) {
            categoryLabelPosition = this.positionForAxisAtBottom;
        }
        else if (rectangleEdge == RectangleEdge.LEFT) {
            categoryLabelPosition = this.positionForAxisAtLeft;
        }
        else if (rectangleEdge == RectangleEdge.RIGHT) {
            categoryLabelPosition = this.positionForAxisAtRight;
        }
        return categoryLabelPosition;
    }
    
    public static CategoryLabelPositions replaceTopPosition(final CategoryLabelPositions categoryLabelPositions, final CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition == null) {
            throw new IllegalArgumentException("Null 'top' argument.");
        }
        return new CategoryLabelPositions(categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
    }
    
    public static CategoryLabelPositions replaceBottomPosition(final CategoryLabelPositions categoryLabelPositions, final CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition == null) {
            throw new IllegalArgumentException("Null 'bottom' argument.");
        }
        return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
    }
    
    public static CategoryLabelPositions replaceLeftPosition(final CategoryLabelPositions categoryLabelPositions, final CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition == null) {
            throw new IllegalArgumentException("Null 'left' argument.");
        }
        return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPosition, categoryLabelPositions.getLabelPosition(RectangleEdge.RIGHT));
    }
    
    public static CategoryLabelPositions replaceRightPosition(final CategoryLabelPositions categoryLabelPositions, final CategoryLabelPosition categoryLabelPosition) {
        if (categoryLabelPositions == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        if (categoryLabelPosition == null) {
            throw new IllegalArgumentException("Null 'right' argument.");
        }
        return new CategoryLabelPositions(categoryLabelPositions.getLabelPosition(RectangleEdge.TOP), categoryLabelPositions.getLabelPosition(RectangleEdge.BOTTOM), categoryLabelPositions.getLabelPosition(RectangleEdge.LEFT), categoryLabelPosition);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CategoryLabelPositions)) {
            return false;
        }
        final CategoryLabelPositions categoryLabelPositions = (CategoryLabelPositions)o;
        return this.positionForAxisAtTop.equals(categoryLabelPositions.positionForAxisAtTop) && this.positionForAxisAtBottom.equals(categoryLabelPositions.positionForAxisAtBottom) && this.positionForAxisAtLeft.equals(categoryLabelPositions.positionForAxisAtLeft) && this.positionForAxisAtRight.equals(categoryLabelPositions.positionForAxisAtRight);
    }
    
    public int hashCode() {
        return 37 * (37 * (37 * (37 * 19 + this.positionForAxisAtTop.hashCode()) + this.positionForAxisAtBottom.hashCode()) + this.positionForAxisAtLeft.hashCode()) + this.positionForAxisAtRight.hashCode();
    }
    
    static {
        STANDARD = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_CENTER), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.CENTER_RIGHT, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, CategoryLabelWidthType.RANGE, 0.3f));
        UP_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, -1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, -1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, -1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, -1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f));
        DOWN_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, 1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 1.5707963267948966, CategoryLabelWidthType.RANGE, 0.3f), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, 1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, 1.5707963267948966, CategoryLabelWidthType.CATEGORY, 0.9f));
        UP_45 = createUpRotationLabelPositions(0.7853981633974483);
        DOWN_45 = createDownRotationLabelPositions(0.7853981633974483);
    }
}
