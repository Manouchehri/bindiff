package org.jfree.chart.axis;

import org.jfree.data.*;
import org.jfree.chart.event.*;
import java.awt.geom.*;
import org.jfree.ui.*;

public class ModuloAxis extends NumberAxis
{
    private Range fixedRange;
    private double displayStart;
    private double displayEnd;
    
    public ModuloAxis(final String s, final Range fixedRange) {
        super(s);
        this.fixedRange = fixedRange;
        this.displayStart = 270.0;
        this.displayEnd = 90.0;
    }
    
    public double getDisplayStart() {
        return this.displayStart;
    }
    
    public double getDisplayEnd() {
        return this.displayEnd;
    }
    
    public void setDisplayRange(final double n, final double n2) {
        this.displayStart = this.mapValueToFixedRange(n);
        this.displayEnd = this.mapValueToFixedRange(n2);
        if (this.displayStart < this.displayEnd) {
            this.setRange(this.displayStart, this.displayEnd);
        }
        else {
            this.setRange(this.displayStart, this.fixedRange.getUpperBound() + (this.displayEnd - this.fixedRange.getLowerBound()));
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }
    
    protected void autoAdjustRange() {
        this.setRange(this.fixedRange, false, false);
    }
    
    public double valueToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        final double mapValueToFixedRange = this.mapValueToFixedRange(n);
        double n2;
        if (this.displayStart < this.displayEnd) {
            n2 = this.trans(mapValueToFixedRange, rectangle2D, rectangleEdge);
        }
        else {
            final double n3 = (this.displayStart + this.displayEnd) / 2.0;
            final double n4 = this.fixedRange.getUpperBound() - this.displayStart;
            final double n5 = this.displayEnd - this.fixedRange.getLowerBound();
            if (mapValueToFixedRange > n3) {
                n2 = this.transStart(mapValueToFixedRange, rectangle2D, rectangleEdge, n4, n5);
            }
            else {
                n2 = this.transEnd(mapValueToFixedRange, rectangle2D, rectangleEdge, n4, n5);
            }
        }
        return n2;
    }
    
    private double trans(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2 = 0.0;
        double n3 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n2 = rectangle2D.getX();
            n3 = rectangle2D.getX() + rectangle2D.getWidth();
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n2 = rectangle2D.getMaxY();
            n3 = rectangle2D.getMaxY() - rectangle2D.getHeight();
        }
        if (this.isInverted()) {
            return n3 - (n - this.displayStart) / (this.displayEnd - this.displayStart) * (n3 - n2);
        }
        return n2 + (n - this.displayStart) / (this.displayEnd - this.displayStart) * (n3 - n2);
    }
    
    private double transStart(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, final double n2, final double n3) {
        double n4 = 0.0;
        double n5 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n4 = rectangle2D.getX();
            n5 = rectangle2D.getX() + rectangle2D.getWidth() * n2 / (n2 + n3);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n4 = rectangle2D.getMaxY();
            n5 = rectangle2D.getMaxY() - rectangle2D.getHeight() * n2 / (n2 + n3);
        }
        if (this.isInverted()) {
            return n5 - (n - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (n5 - n4);
        }
        return n4 + (n - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (n5 - n4);
    }
    
    private double transEnd(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge, final double n2, final double n3) {
        double n4 = 0.0;
        double n5 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            n5 = rectangle2D.getMaxX();
            n4 = rectangle2D.getMaxX() - rectangle2D.getWidth() * n3 / (n2 + n3);
        }
        else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n5 = rectangle2D.getMinY();
            n4 = rectangle2D.getMinY() + rectangle2D.getHeight() * n3 / (n2 + n3);
        }
        if (this.isInverted()) {
            return n5 - (n - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (n5 - n4);
        }
        return n4 + (n - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (n5 - n4);
    }
    
    private double mapValueToFixedRange(final double n) {
        final double lowerBound = this.fixedRange.getLowerBound();
        final double length = this.fixedRange.getLength();
        if (n < lowerBound) {
            return lowerBound + length + (n - lowerBound) % length;
        }
        return lowerBound + (n - lowerBound) % length;
    }
    
    public double java2DToValue(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double java2DToValue = 0.0;
        if (this.displayStart < this.displayEnd) {
            java2DToValue = super.java2DToValue(n, rectangle2D, rectangleEdge);
        }
        return java2DToValue;
    }
    
    private double getDisplayLength() {
        if (this.displayStart < this.displayEnd) {
            return this.displayEnd - this.displayStart;
        }
        return this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
    }
    
    private double getDisplayCentralValue() {
        return this.mapValueToFixedRange(this.displayStart + this.getDisplayLength() / 2.0);
    }
    
    public void resizeRange(final double n) {
        this.resizeRange(n, this.getDisplayCentralValue());
    }
    
    public void resizeRange(final double n, final double n2) {
        if (n > 0.0) {
            final double n3 = this.getDisplayLength() * n / 2.0;
            this.setDisplayRange(n2 - n3, n2 + n3);
        }
        else {
            this.setAutoRange(true);
        }
    }
    
    public double lengthToJava2D(final double n, final Rectangle2D rectangle2D, final RectangleEdge rectangleEdge) {
        double n2;
        if (this.displayEnd > this.displayStart) {
            n2 = this.displayEnd - this.displayStart;
        }
        else {
            n2 = this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
        }
        double n3;
        if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            n3 = rectangle2D.getHeight();
        }
        else {
            n3 = rectangle2D.getWidth();
        }
        return n / n2 * n3;
    }
}
