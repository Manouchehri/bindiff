/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import org.jfree.chart.LegendItem;

public class DrawableLegendItem {
    private LegendItem item;
    private double x;
    private double y;
    private double width;
    private double height;
    private Shape marker;
    private Line2D line;
    private Point2D labelPosition;

    public DrawableLegendItem(LegendItem legendItem) {
        this.item = legendItem;
    }

    public LegendItem getItem() {
        return this.item;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double d2) {
        this.x = d2;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double d2) {
        this.y = d2;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getMaxX() {
        return this.getX() + this.getWidth();
    }

    public double getMaxY() {
        return this.getY() + this.getHeight();
    }

    public Shape getMarker() {
        return this.marker;
    }

    public void setMarker(Shape shape) {
        this.marker = shape;
    }

    public void setLine(Line2D line2D) {
        this.line = line2D;
    }

    public Line2D getLine() {
        return this.line;
    }

    public Point2D getLabelPosition() {
        return this.labelPosition;
    }

    public void setLabelPosition(Point2D point2D) {
        this.labelPosition = point2D;
    }

    public void setBounds(double d2, double d3, double d4, double d5) {
        this.x = d2;
        this.y = d3;
        this.width = d4;
        this.height = d5;
    }
}

