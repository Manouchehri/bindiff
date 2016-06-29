package org.jfree.chart;

import java.awt.*;
import java.awt.geom.*;

public class DrawableLegendItem
{
    private LegendItem item;
    private double x;
    private double y;
    private double width;
    private double height;
    private Shape marker;
    private Line2D line;
    private Point2D labelPosition;
    
    public DrawableLegendItem(final LegendItem item) {
        this.item = item;
    }
    
    public LegendItem getItem() {
        return this.item;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
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
    
    public void setMarker(final Shape marker) {
        this.marker = marker;
    }
    
    public void setLine(final Line2D line) {
        this.line = line;
    }
    
    public Line2D getLine() {
        return this.line;
    }
    
    public Point2D getLabelPosition() {
        return this.labelPosition;
    }
    
    public void setLabelPosition(final Point2D labelPosition) {
        this.labelPosition = labelPosition;
    }
    
    public void setBounds(final double x, final double y, final double width, final double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
