package org.jfree.chart.block;

import org.jfree.data.*;
import org.jfree.ui.*;

public class RectangleConstraint
{
    public static final RectangleConstraint NONE;
    private double width;
    private Range widthRange;
    private LengthConstraintType widthConstraintType;
    private double height;
    private Range heightRange;
    private LengthConstraintType heightConstraintType;
    
    public RectangleConstraint(final double n, final double n2) {
        this(n, null, LengthConstraintType.FIXED, n2, null, LengthConstraintType.FIXED);
    }
    
    public RectangleConstraint(final Range range, final Range range2) {
        this(0.0, range, LengthConstraintType.RANGE, 0.0, range2, LengthConstraintType.RANGE);
    }
    
    public RectangleConstraint(final Range range, final double n) {
        this(0.0, range, LengthConstraintType.RANGE, n, null, LengthConstraintType.FIXED);
    }
    
    public RectangleConstraint(final double n, final Range range) {
        this(n, null, LengthConstraintType.FIXED, 0.0, range, LengthConstraintType.RANGE);
    }
    
    public RectangleConstraint(final double width, final Range widthRange, final LengthConstraintType widthConstraintType, final double height, final Range heightRange, final LengthConstraintType heightConstraintType) {
        if (widthConstraintType == null) {
            throw new IllegalArgumentException("Null 'widthType' argument.");
        }
        if (heightConstraintType == null) {
            throw new IllegalArgumentException("Null 'heightType' argument.");
        }
        this.width = width;
        this.widthRange = widthRange;
        this.widthConstraintType = widthConstraintType;
        this.height = height;
        this.heightRange = heightRange;
        this.heightConstraintType = heightConstraintType;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public Range getWidthRange() {
        return this.widthRange;
    }
    
    public LengthConstraintType getWidthConstraintType() {
        return this.widthConstraintType;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public Range getHeightRange() {
        return this.heightRange;
    }
    
    public LengthConstraintType getHeightConstraintType() {
        return this.heightConstraintType;
    }
    
    public RectangleConstraint toUnconstrainedWidth() {
        if (this.widthConstraintType == LengthConstraintType.NONE) {
            return this;
        }
        return new RectangleConstraint(this.width, this.widthRange, LengthConstraintType.NONE, this.height, this.heightRange, this.heightConstraintType);
    }
    
    public RectangleConstraint toUnconstrainedHeight() {
        if (this.heightConstraintType == LengthConstraintType.NONE) {
            return this;
        }
        return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, 0.0, this.heightRange, LengthConstraintType.NONE);
    }
    
    public RectangleConstraint toFixedWidth(final double n) {
        return new RectangleConstraint(n, this.widthRange, LengthConstraintType.FIXED, this.height, this.heightRange, this.heightConstraintType);
    }
    
    public RectangleConstraint toFixedHeight(final double n) {
        return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, n, this.heightRange, LengthConstraintType.FIXED);
    }
    
    public RectangleConstraint toRangeWidth(final Range range) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        return new RectangleConstraint(range.getUpperBound(), range, LengthConstraintType.RANGE, this.height, this.heightRange, this.heightConstraintType);
    }
    
    public RectangleConstraint toRangeHeight(final Range range) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, range.getUpperBound(), range, LengthConstraintType.RANGE);
    }
    
    public String toString() {
        return "RectangleConstraint[" + this.widthConstraintType.toString() + ": width=" + this.width + ", height=" + this.height + "]";
    }
    
    public Size2D calculateConstrainedSize(final Size2D size2D) {
        final Size2D size2D2 = new Size2D();
        if (this.widthConstraintType == LengthConstraintType.NONE) {
            size2D2.width = size2D.width;
            if (this.heightConstraintType == LengthConstraintType.NONE) {
                size2D2.height = size2D.height;
            }
            else if (this.heightConstraintType == LengthConstraintType.RANGE) {
                size2D2.height = this.heightRange.constrain(size2D.height);
            }
            else if (this.heightConstraintType == LengthConstraintType.FIXED) {
                size2D2.height = this.height;
            }
        }
        else if (this.widthConstraintType == LengthConstraintType.RANGE) {
            size2D2.width = this.widthRange.constrain(size2D.width);
            if (this.heightConstraintType == LengthConstraintType.NONE) {
                size2D2.height = size2D.height;
            }
            else if (this.heightConstraintType == LengthConstraintType.RANGE) {
                size2D2.height = this.heightRange.constrain(size2D.height);
            }
            else if (this.heightConstraintType == LengthConstraintType.FIXED) {
                size2D2.height = this.height;
            }
        }
        else if (this.widthConstraintType == LengthConstraintType.FIXED) {
            size2D2.width = this.width;
            if (this.heightConstraintType == LengthConstraintType.NONE) {
                size2D2.height = size2D.height;
            }
            else if (this.heightConstraintType == LengthConstraintType.RANGE) {
                size2D2.height = this.heightRange.constrain(size2D.height);
            }
            else if (this.heightConstraintType == LengthConstraintType.FIXED) {
                size2D2.height = this.height;
            }
        }
        return size2D2;
    }
    
    static {
        NONE = new RectangleConstraint(0.0, null, LengthConstraintType.NONE, 0.0, null, LengthConstraintType.NONE);
    }
}
