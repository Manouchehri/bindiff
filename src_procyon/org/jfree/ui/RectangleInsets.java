package org.jfree.ui;

import java.io.*;
import org.jfree.util.*;
import java.awt.geom.*;

public class RectangleInsets implements Serializable
{
    private static final long serialVersionUID = 1902273207559319996L;
    public static final RectangleInsets ZERO_INSETS;
    private UnitType unitType;
    private double top;
    private double left;
    private double bottom;
    private double right;
    
    public RectangleInsets() {
        this(1.0, 1.0, 1.0, 1.0);
    }
    
    public RectangleInsets(final double n, final double n2, final double n3, final double n4) {
        this(UnitType.ABSOLUTE, n, n2, n3, n4);
    }
    
    public RectangleInsets(final UnitType unitType, final double top, final double left, final double bottom, final double right) {
        if (unitType == null) {
            throw new IllegalArgumentException("Null 'unitType' argument.");
        }
        this.unitType = unitType;
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
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
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RectangleInsets)) {
            return false;
        }
        final RectangleInsets rectangleInsets = (RectangleInsets)o;
        return rectangleInsets.unitType == this.unitType && this.left == rectangleInsets.left && this.right == rectangleInsets.right && this.top == rectangleInsets.top && this.bottom == rectangleInsets.bottom;
    }
    
    public int hashCode() {
        final int n = (this.unitType != null) ? this.unitType.hashCode() : 0;
        final long n2 = (this.top != 0.0) ? Double.doubleToLongBits(this.top) : 0L;
        final int n3 = 29 * n + (int)(n2 ^ n2 >>> 32);
        final long n4 = (this.bottom != 0.0) ? Double.doubleToLongBits(this.bottom) : 0L;
        final int n5 = 29 * n3 + (int)(n4 ^ n4 >>> 32);
        final long n6 = (this.left != 0.0) ? Double.doubleToLongBits(this.left) : 0L;
        final int n7 = 29 * n5 + (int)(n6 ^ n6 >>> 32);
        final long n8 = (this.right != 0.0) ? Double.doubleToLongBits(this.right) : 0L;
        return 29 * n7 + (int)(n8 ^ n8 >>> 32);
    }
    
    public String toString() {
        return "RectangleInsets[t=" + this.top + ",l=" + this.left + ",b=" + this.bottom + ",r=" + this.right + "]";
    }
    
    public Rectangle2D createAdjustedRectangle(final Rectangle2D rectangle2D, final LengthAdjustmentType lengthAdjustmentType, final LengthAdjustmentType lengthAdjustmentType2) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double x = rectangle2D.getX();
        double y = rectangle2D.getY();
        double width = rectangle2D.getWidth();
        double height = rectangle2D.getHeight();
        if (lengthAdjustmentType == LengthAdjustmentType.EXPAND) {
            final double calculateLeftOutset = this.calculateLeftOutset(width);
            x -= calculateLeftOutset;
            width = width + calculateLeftOutset + this.calculateRightOutset(width);
        }
        else if (lengthAdjustmentType == LengthAdjustmentType.CONTRACT) {
            final double calculateLeftInset = this.calculateLeftInset(width);
            x += calculateLeftInset;
            width = width - calculateLeftInset - this.calculateRightInset(width);
        }
        if (lengthAdjustmentType2 == LengthAdjustmentType.EXPAND) {
            final double calculateTopOutset = this.calculateTopOutset(height);
            y -= calculateTopOutset;
            height = height + calculateTopOutset + this.calculateBottomOutset(height);
        }
        else if (lengthAdjustmentType2 == LengthAdjustmentType.CONTRACT) {
            final double calculateTopInset = this.calculateTopInset(height);
            y += calculateTopInset;
            height = height - calculateTopInset - this.calculateBottomInset(height);
        }
        return new Rectangle2D.Double(x, y, width, height);
    }
    
    public Rectangle2D createInsetRectangle(final Rectangle2D rectangle2D) {
        return this.createInsetRectangle(rectangle2D, true, true);
    }
    
    public Rectangle2D createInsetRectangle(final Rectangle2D rectangle2D, final boolean b, final boolean b2) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double calculateTopInset = 0.0;
        double calculateBottomInset = 0.0;
        if (b2) {
            calculateTopInset = this.calculateTopInset(rectangle2D.getHeight());
            calculateBottomInset = this.calculateBottomInset(rectangle2D.getHeight());
        }
        double calculateLeftInset = 0.0;
        double calculateRightInset = 0.0;
        if (b) {
            calculateLeftInset = this.calculateLeftInset(rectangle2D.getWidth());
            calculateRightInset = this.calculateRightInset(rectangle2D.getWidth());
        }
        return new Rectangle2D.Double(rectangle2D.getX() + calculateLeftInset, rectangle2D.getY() + calculateTopInset, rectangle2D.getWidth() - calculateLeftInset - calculateRightInset, rectangle2D.getHeight() - calculateTopInset - calculateBottomInset);
    }
    
    public Rectangle2D createOutsetRectangle(final Rectangle2D rectangle2D) {
        return this.createOutsetRectangle(rectangle2D, true, true);
    }
    
    public Rectangle2D createOutsetRectangle(final Rectangle2D rectangle2D, final boolean b, final boolean b2) {
        if (rectangle2D == null) {
            throw new IllegalArgumentException("Null 'base' argument.");
        }
        double calculateTopOutset = 0.0;
        double calculateBottomOutset = 0.0;
        if (b2) {
            calculateTopOutset = this.calculateTopOutset(rectangle2D.getHeight());
            calculateBottomOutset = this.calculateBottomOutset(rectangle2D.getHeight());
        }
        double calculateLeftOutset = 0.0;
        double calculateRightOutset = 0.0;
        if (b) {
            calculateLeftOutset = this.calculateLeftOutset(rectangle2D.getWidth());
            calculateRightOutset = this.calculateRightOutset(rectangle2D.getWidth());
        }
        return new Rectangle2D.Double(rectangle2D.getX() - calculateLeftOutset, rectangle2D.getY() - calculateTopOutset, rectangle2D.getWidth() + calculateLeftOutset + calculateRightOutset, rectangle2D.getHeight() + calculateTopOutset + calculateBottomOutset);
    }
    
    public double calculateTopInset(final double n) {
        double top = this.top;
        if (this.unitType == UnitType.RELATIVE) {
            top = this.top * n;
        }
        return top;
    }
    
    public double calculateTopOutset(final double n) {
        double top = this.top;
        if (this.unitType == UnitType.RELATIVE) {
            top = n / (1.0 - this.top - this.bottom) * this.top;
        }
        return top;
    }
    
    public double calculateBottomInset(final double n) {
        double bottom = this.bottom;
        if (this.unitType == UnitType.RELATIVE) {
            bottom = this.bottom * n;
        }
        return bottom;
    }
    
    public double calculateBottomOutset(final double n) {
        double bottom = this.bottom;
        if (this.unitType == UnitType.RELATIVE) {
            bottom = n / (1.0 - this.top - this.bottom) * this.bottom;
        }
        return bottom;
    }
    
    public double calculateLeftInset(final double n) {
        double left = this.left;
        if (this.unitType == UnitType.RELATIVE) {
            left = this.left * n;
        }
        return left;
    }
    
    public double calculateLeftOutset(final double n) {
        double left = this.left;
        if (this.unitType == UnitType.RELATIVE) {
            left = n / (1.0 - this.left - this.right) * this.left;
        }
        return left;
    }
    
    public double calculateRightInset(final double n) {
        double right = this.right;
        if (this.unitType == UnitType.RELATIVE) {
            right = this.right * n;
        }
        return right;
    }
    
    public double calculateRightOutset(final double n) {
        double right = this.right;
        if (this.unitType == UnitType.RELATIVE) {
            right = n / (1.0 - this.left - this.right) * this.right;
        }
        return right;
    }
    
    public double trimWidth(final double n) {
        return n - this.calculateLeftInset(n) - this.calculateRightInset(n);
    }
    
    public double extendWidth(final double n) {
        return n + this.calculateLeftOutset(n) + this.calculateRightOutset(n);
    }
    
    public double trimHeight(final double n) {
        return n - this.calculateTopInset(n) - this.calculateBottomInset(n);
    }
    
    public double extendHeight(final double n) {
        return n + this.calculateTopOutset(n) + this.calculateBottomOutset(n);
    }
    
    public void trim(final Rectangle2D rectangle2D) {
        final double width = rectangle2D.getWidth();
        final double height = rectangle2D.getHeight();
        final double calculateLeftInset = this.calculateLeftInset(width);
        final double calculateRightInset = this.calculateRightInset(width);
        final double calculateTopInset = this.calculateTopInset(height);
        rectangle2D.setRect(rectangle2D.getX() + calculateLeftInset, rectangle2D.getY() + calculateTopInset, width - calculateLeftInset - calculateRightInset, height - calculateTopInset - this.calculateBottomInset(height));
    }
    
    static {
        ZERO_INSETS = new RectangleInsets(UnitType.ABSOLUTE, 0.0, 0.0, 0.0, 0.0);
    }
}
