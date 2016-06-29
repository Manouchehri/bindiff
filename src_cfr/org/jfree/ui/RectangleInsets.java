/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.util.UnitType;

public class RectangleInsets
implements Serializable {
    private static final long serialVersionUID = 1902273207559319996L;
    public static final RectangleInsets ZERO_INSETS = new RectangleInsets(UnitType.ABSOLUTE, 0.0, 0.0, 0.0, 0.0);
    private UnitType unitType;
    private double top;
    private double left;
    private double bottom;
    private double right;

    public RectangleInsets() {
        this(1.0, 1.0, 1.0, 1.0);
    }

    public RectangleInsets(double d2, double d3, double d4, double d5) {
        this(UnitType.ABSOLUTE, d2, d3, d4, d5);
    }

    public RectangleInsets(UnitType unitType, double d2, double d3, double d4, double d5) {
        if (unitType == null) {
            throw new IllegalArgumentException("Null 'unitType' argument.");
        }
        this.unitType = unitType;
        this.top = d2;
        this.bottom = d4;
        this.left = d3;
        this.right = d5;
    }

    public UnitType getUnitType() {
        return this.unitType;
    }

    public double getTop() {
        return this.top;
    }

    public double getBottom() {
        return this.bottom;
    }

    public double getLeft() {
        return this.left;
    }

    public double getRight() {
        return this.right;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RectangleInsets)) {
            return false;
        }
        RectangleInsets rectangleInsets = (RectangleInsets)object;
        if (rectangleInsets.unitType != this.unitType) {
            return false;
        }
        if (this.left != rectangleInsets.left) {
            return false;
        }
        if (this.right != rectangleInsets.right) {
            return false;
        }
        if (this.top != rectangleInsets.top) {
            return false;
        }
        if (this.bottom == rectangleInsets.bottom) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.unitType != null ? this.unitType.hashCode() : 0;
        long l2 = this.top != 0.0 ? Double.doubleToLongBits(this.top) : 0;
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.bottom != 0.0 ? Double.doubleToLongBits(this.bottom) : 0;
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.left != 0.0 ? Double.doubleToLongBits(this.left) : 0;
        n2 = 29 * n2 + (int)(l2 ^ l2 >>> 32);
        l2 = this.right != 0.0 ? Double.doubleToLongBits(this.right) : 0;
        return 29 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        return new StringBuffer().append("RectangleInsets[t=").append(this.top).append(",l=").append(this.left).append(",b=").append(this.bottom).append(",r=").append(this.right).append("]").toString();
    }

    public Rectangle2D createAdjustedRectangle(Rectangle2D rectangle2D, LengthAdjustmentType lengthAdjustmentType, LengthAdjustmentType lengthAdjustmentType2) {
        double d2;
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double d3 = rectangle2D.getX();
        double d4 = rectangle2D.getY();
        double d5 = rectangle2D.getWidth();
        double d6 = rectangle2D.getHeight();
        if (lengthAdjustmentType == LengthAdjustmentType.EXPAND) {
            d2 = this.calculateLeftOutset(d5);
            d3 -= d2;
            d5 = d5 + d2 + this.calculateRightOutset(d5);
        } else if (lengthAdjustmentType == LengthAdjustmentType.CONTRACT) {
            d2 = this.calculateLeftInset(d5);
            d3 += d2;
            d5 = d5 - d2 - this.calculateRightInset(d5);
        }
        if (lengthAdjustmentType2 == LengthAdjustmentType.EXPAND) {
            d2 = this.calculateTopOutset(d6);
            d6 = d6 + d2 + this.calculateBottomOutset(d6);
            return new Rectangle2D.Double(d3, d4 -= d2, d5, d6);
        }
        if (lengthAdjustmentType2 != LengthAdjustmentType.CONTRACT) return new Rectangle2D.Double(d3, d4, d5, d6);
        d2 = this.calculateTopInset(d6);
        d4 += d2;
        d6 = d6 - d2 - this.calculateBottomInset(d6);
        return new Rectangle2D.Double(d3, d4, d5, d6);
    }

    public Rectangle2D createInsetRectangle(Rectangle2D rectangle2D) {
        return this.createInsetRectangle(rectangle2D, true, true);
    }

    public Rectangle2D createInsetRectangle(Rectangle2D rectangle2D, boolean bl2, boolean bl3) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        if (bl3) {
            d2 = this.calculateTopInset(rectangle2D.getHeight());
            d3 = this.calculateBottomInset(rectangle2D.getHeight());
        }
        double d4 = 0.0;
        double d5 = 0.0;
        if (!bl2) return new Rectangle2D.Double(rectangle2D.getX() + d4, rectangle2D.getY() + d2, rectangle2D.getWidth() - d4 - d5, rectangle2D.getHeight() - d2 - d3);
        d4 = this.calculateLeftInset(rectangle2D.getWidth());
        d5 = this.calculateRightInset(rectangle2D.getWidth());
        return new Rectangle2D.Double(rectangle2D.getX() + d4, rectangle2D.getY() + d2, rectangle2D.getWidth() - d4 - d5, rectangle2D.getHeight() - d2 - d3);
    }

    public Rectangle2D createOutsetRectangle(Rectangle2D rectangle2D) {
        return this.createOutsetRectangle(rectangle2D, true, true);
    }

    public Rectangle2D createOutsetRectangle(Rectangle2D rectangle2D, boolean bl2, boolean bl3) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double d2 = 0.0;
        double d3 = 0.0;
        if (bl3) {
            d2 = this.calculateTopOutset(rectangle2D.getHeight());
            d3 = this.calculateBottomOutset(rectangle2D.getHeight());
        }
        double d4 = 0.0;
        double d5 = 0.0;
        if (!bl2) return new Rectangle2D.Double(rectangle2D.getX() - d4, rectangle2D.getY() - d2, rectangle2D.getWidth() + d4 + d5, rectangle2D.getHeight() + d2 + d3);
        d4 = this.calculateLeftOutset(rectangle2D.getWidth());
        d5 = this.calculateRightOutset(rectangle2D.getWidth());
        return new Rectangle2D.Double(rectangle2D.getX() - d4, rectangle2D.getY() - d2, rectangle2D.getWidth() + d4 + d5, rectangle2D.getHeight() + d2 + d3);
    }

    public double calculateTopInset(double d2) {
        double d3 = this.top;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return this.top * d2;
    }

    public double calculateTopOutset(double d2) {
        double d3 = this.top;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return d2 / (1.0 - this.top - this.bottom) * this.top;
    }

    public double calculateBottomInset(double d2) {
        double d3 = this.bottom;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return this.bottom * d2;
    }

    public double calculateBottomOutset(double d2) {
        double d3 = this.bottom;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return d2 / (1.0 - this.top - this.bottom) * this.bottom;
    }

    public double calculateLeftInset(double d2) {
        double d3 = this.left;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return this.left * d2;
    }

    public double calculateLeftOutset(double d2) {
        double d3 = this.left;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return d2 / (1.0 - this.left - this.right) * this.left;
    }

    public double calculateRightInset(double d2) {
        double d3 = this.right;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return this.right * d2;
    }

    public double calculateRightOutset(double d2) {
        double d3 = this.right;
        if (this.unitType != UnitType.RELATIVE) return d3;
        return d2 / (1.0 - this.left - this.right) * this.right;
    }

    public double trimWidth(double d2) {
        return d2 - this.calculateLeftInset(d2) - this.calculateRightInset(d2);
    }

    public double extendWidth(double d2) {
        return d2 + this.calculateLeftOutset(d2) + this.calculateRightOutset(d2);
    }

    public double trimHeight(double d2) {
        return d2 - this.calculateTopInset(d2) - this.calculateBottomInset(d2);
    }

    public double extendHeight(double d2) {
        return d2 + this.calculateTopOutset(d2) + this.calculateBottomOutset(d2);
    }

    public void trim(Rectangle2D rectangle2D) {
        double d2 = rectangle2D.getWidth();
        double d3 = rectangle2D.getHeight();
        double d4 = this.calculateLeftInset(d2);
        double d5 = this.calculateRightInset(d2);
        double d6 = this.calculateTopInset(d3);
        double d7 = this.calculateBottomInset(d3);
        rectangle2D.setRect(rectangle2D.getX() + d4, rectangle2D.getY() + d6, d2 - d4 - d5, d3 - d6 - d7);
    }
}

