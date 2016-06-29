/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import org.jfree.chart.block.LengthConstraintType;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;

public class RectangleConstraint {
    public static final RectangleConstraint NONE = new RectangleConstraint(0.0, null, LengthConstraintType.NONE, 0.0, null, LengthConstraintType.NONE);
    private double width;
    private Range widthRange;
    private LengthConstraintType widthConstraintType;
    private double height;
    private Range heightRange;
    private LengthConstraintType heightConstraintType;

    public RectangleConstraint(double d2, double d3) {
        this(d2, null, LengthConstraintType.FIXED, d3, null, LengthConstraintType.FIXED);
    }

    public RectangleConstraint(Range range, Range range2) {
        this(0.0, range, LengthConstraintType.RANGE, 0.0, range2, LengthConstraintType.RANGE);
    }

    public RectangleConstraint(Range range, double d2) {
        this(0.0, range, LengthConstraintType.RANGE, d2, null, LengthConstraintType.FIXED);
    }

    public RectangleConstraint(double d2, Range range) {
        this(d2, null, LengthConstraintType.FIXED, 0.0, range, LengthConstraintType.RANGE);
    }

    public RectangleConstraint(double d2, Range range, LengthConstraintType lengthConstraintType, double d3, Range range2, LengthConstraintType lengthConstraintType2) {
        if (lengthConstraintType == null) {
            throw new IllegalArgumentException("Null 'widthType' argument.");
        }
        if (lengthConstraintType2 == null) {
            throw new IllegalArgumentException("Null 'heightType' argument.");
        }
        this.width = d2;
        this.widthRange = range;
        this.widthConstraintType = lengthConstraintType;
        this.height = d3;
        this.heightRange = range2;
        this.heightConstraintType = lengthConstraintType2;
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
        if (this.widthConstraintType != LengthConstraintType.NONE) return new RectangleConstraint(this.width, this.widthRange, LengthConstraintType.NONE, this.height, this.heightRange, this.heightConstraintType);
        return this;
    }

    public RectangleConstraint toUnconstrainedHeight() {
        if (this.heightConstraintType != LengthConstraintType.NONE) return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, 0.0, this.heightRange, LengthConstraintType.NONE);
        return this;
    }

    public RectangleConstraint toFixedWidth(double d2) {
        return new RectangleConstraint(d2, this.widthRange, LengthConstraintType.FIXED, this.height, this.heightRange, this.heightConstraintType);
    }

    public RectangleConstraint toFixedHeight(double d2) {
        return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, d2, this.heightRange, LengthConstraintType.FIXED);
    }

    public RectangleConstraint toRangeWidth(Range range) {
        if (range != null) return new RectangleConstraint(range.getUpperBound(), range, LengthConstraintType.RANGE, this.height, this.heightRange, this.heightConstraintType);
        throw new IllegalArgumentException("Null 'range' argument.");
    }

    public RectangleConstraint toRangeHeight(Range range) {
        if (range != null) return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, range.getUpperBound(), range, LengthConstraintType.RANGE);
        throw new IllegalArgumentException("Null 'range' argument.");
    }

    public String toString() {
        return new StringBuffer().append("RectangleConstraint[").append(this.widthConstraintType.toString()).append(": width=").append(this.width).append(", height=").append(this.height).append("]").toString();
    }

    public Size2D calculateConstrainedSize(Size2D size2D) {
        Size2D size2D2 = new Size2D();
        if (this.widthConstraintType == LengthConstraintType.NONE) {
            size2D2.width = size2D.width;
            if (this.heightConstraintType == LengthConstraintType.NONE) {
                size2D2.height = size2D.height;
                return size2D2;
            }
            if (this.heightConstraintType == LengthConstraintType.RANGE) {
                size2D2.height = this.heightRange.constrain(size2D.height);
                return size2D2;
            }
            if (this.heightConstraintType != LengthConstraintType.FIXED) return size2D2;
            size2D2.height = this.height;
            return size2D2;
        }
        if (this.widthConstraintType == LengthConstraintType.RANGE) {
            size2D2.width = this.widthRange.constrain(size2D.width);
            if (this.heightConstraintType == LengthConstraintType.NONE) {
                size2D2.height = size2D.height;
                return size2D2;
            }
            if (this.heightConstraintType == LengthConstraintType.RANGE) {
                size2D2.height = this.heightRange.constrain(size2D.height);
                return size2D2;
            }
            if (this.heightConstraintType != LengthConstraintType.FIXED) return size2D2;
            size2D2.height = this.height;
            return size2D2;
        }
        if (this.widthConstraintType != LengthConstraintType.FIXED) return size2D2;
        size2D2.width = this.width;
        if (this.heightConstraintType == LengthConstraintType.NONE) {
            size2D2.height = size2D.height;
            return size2D2;
        }
        if (this.heightConstraintType == LengthConstraintType.RANGE) {
            size2D2.height = this.heightRange.constrain(size2D.height);
            return size2D2;
        }
        if (this.heightConstraintType != LengthConstraintType.FIXED) return size2D2;
        size2D2.height = this.height;
        return size2D2;
    }
}

