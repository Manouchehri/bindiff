/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;

public class ModuloAxis
extends NumberAxis {
    private Range fixedRange;
    private double displayStart;
    private double displayEnd;

    public ModuloAxis(String string, Range range) {
        super(string);
        this.fixedRange = range;
        this.displayStart = 270.0;
        this.displayEnd = 90.0;
    }

    public double getDisplayStart() {
        return this.displayStart;
    }

    public double getDisplayEnd() {
        return this.displayEnd;
    }

    public void setDisplayRange(double d2, double d3) {
        this.displayStart = this.mapValueToFixedRange(d2);
        this.displayEnd = this.mapValueToFixedRange(d3);
        if (this.displayStart < this.displayEnd) {
            this.setRange(this.displayStart, this.displayEnd);
        } else {
            this.setRange(this.displayStart, this.fixedRange.getUpperBound() + (this.displayEnd - this.fixedRange.getLowerBound()));
        }
        this.notifyListeners(new AxisChangeEvent(this));
    }

    @Override
    protected void autoAdjustRange() {
        this.setRange(this.fixedRange, false, false);
    }

    @Override
    public double valueToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = 0.0;
        double d4 = this.mapValueToFixedRange(d2);
        if (this.displayStart < this.displayEnd) {
            return this.trans(d4, rectangle2D, rectangleEdge);
        }
        double d5 = (this.displayStart + this.displayEnd) / 2.0;
        double d6 = this.fixedRange.getUpperBound() - this.displayStart;
        double d7 = this.displayEnd - this.fixedRange.getLowerBound();
        if (d4 <= d5) return this.transEnd(d4, rectangle2D, rectangleEdge, d6, d7);
        return this.transStart(d4, rectangle2D, rectangleEdge, d6, d7);
    }

    private double trans(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = 0.0;
        double d4 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d3 = rectangle2D.getX();
            d4 = rectangle2D.getX() + rectangle2D.getWidth();
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d3 = rectangle2D.getMaxY();
            d4 = rectangle2D.getMaxY() - rectangle2D.getHeight();
        }
        if (!this.isInverted()) return d3 + (d2 - this.displayStart) / (this.displayEnd - this.displayStart) * (d4 - d3);
        return d4 - (d2 - this.displayStart) / (this.displayEnd - this.displayStart) * (d4 - d3);
    }

    private double transStart(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, double d3, double d4) {
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d5 = rectangle2D.getX();
            d6 = rectangle2D.getX() + rectangle2D.getWidth() * d3 / (d3 + d4);
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d5 = rectangle2D.getMaxY();
            d6 = rectangle2D.getMaxY() - rectangle2D.getHeight() * d3 / (d3 + d4);
        }
        if (!this.isInverted()) return d5 + (d2 - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (d6 - d5);
        return d6 - (d2 - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (d6 - d5);
    }

    private double transEnd(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge, double d3, double d4) {
        double d5 = 0.0;
        double d6 = 0.0;
        if (RectangleEdge.isTopOrBottom(rectangleEdge)) {
            d6 = rectangle2D.getMaxX();
            d5 = rectangle2D.getMaxX() - rectangle2D.getWidth() * d4 / (d3 + d4);
        } else if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d6 = rectangle2D.getMinY();
            d5 = rectangle2D.getMinY() + rectangle2D.getHeight() * d4 / (d3 + d4);
        }
        if (!this.isInverted()) return d5 + (d2 - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (d6 - d5);
        return d6 - (d2 - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (d6 - d5);
    }

    private double mapValueToFixedRange(double d2) {
        double d3 = this.fixedRange.getLowerBound();
        double d4 = this.fixedRange.getLength();
        if (d2 >= d3) return d3 + (d2 - d3) % d4;
        return d3 + d4 + (d2 - d3) % d4;
    }

    @Override
    public double java2DToValue(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = 0.0;
        if (this.displayStart >= this.displayEnd) return d3;
        return super.java2DToValue(d2, rectangle2D, rectangleEdge);
    }

    private double getDisplayLength() {
        if (this.displayStart >= this.displayEnd) return this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
        return this.displayEnd - this.displayStart;
    }

    private double getDisplayCentralValue() {
        return this.mapValueToFixedRange(this.displayStart + this.getDisplayLength() / 2.0);
    }

    @Override
    public void resizeRange(double d2) {
        this.resizeRange(d2, this.getDisplayCentralValue());
    }

    @Override
    public void resizeRange(double d2, double d3) {
        if (d2 > 0.0) {
            double d4 = this.getDisplayLength() * d2 / 2.0;
            this.setDisplayRange(d3 - d4, d3 + d4);
            return;
        }
        this.setAutoRange(true);
    }

    @Override
    public double lengthToJava2D(double d2, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        double d3 = 0.0;
        d3 = this.displayEnd > this.displayStart ? this.displayEnd - this.displayStart : this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
        double d4 = 0.0;
        if (RectangleEdge.isLeftOrRight(rectangleEdge)) {
            d4 = rectangle2D.getHeight();
            return d2 / d3 * d4;
        }
        d4 = rectangle2D.getWidth();
        return d2 / d3 * d4;
    }
}

