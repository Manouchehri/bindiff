package org.jfree.chart.plot;

import java.awt.geom.*;

public class CrosshairState
{
    private boolean calculateDistanceInDataSpace;
    private double anchorX;
    private double anchorY;
    private Point2D anchor;
    private double crosshairX;
    private double crosshairY;
    private int domainAxisIndex;
    private int rangeAxisIndex;
    private double distance;
    
    public CrosshairState() {
        this(false);
    }
    
    public CrosshairState(final boolean calculateDistanceInDataSpace) {
        this.calculateDistanceInDataSpace = false;
        this.calculateDistanceInDataSpace = calculateDistanceInDataSpace;
    }
    
    public double getCrosshairDistance() {
        return this.distance;
    }
    
    public void setCrosshairDistance(final double distance) {
        this.distance = distance;
    }
    
    public void updateCrosshairPoint(final double n, final double n2, final double n3, final double n4, final PlotOrientation plotOrientation) {
        this.updateCrosshairPoint(n, n2, 0, 0, n3, n4, plotOrientation);
    }
    
    public void updateCrosshairPoint(final double crosshairX, final double crosshairY, final int domainAxisIndex, final int rangeAxisIndex, final double n, final double n2, final PlotOrientation plotOrientation) {
        if (this.anchor != null) {
            double distance;
            if (this.calculateDistanceInDataSpace) {
                distance = (crosshairX - this.anchorX) * (crosshairX - this.anchorX) + (crosshairY - this.anchorY) * (crosshairY - this.anchorY);
            }
            else {
                double x = this.anchor.getX();
                double y = this.anchor.getY();
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    final double n3 = y;
                    y = x;
                    x = n3;
                }
                distance = (n - x) * (n - x) + (n2 - y) * (n2 - y);
            }
            if (distance < this.distance) {
                this.crosshairX = crosshairX;
                this.crosshairY = crosshairY;
                this.domainAxisIndex = domainAxisIndex;
                this.rangeAxisIndex = rangeAxisIndex;
                this.distance = distance;
            }
        }
    }
    
    public void updateCrosshairX(final double n) {
        this.updateCrosshairX(n, 0);
    }
    
    public void updateCrosshairX(final double crosshairX, final int domainAxisIndex) {
        final double abs = Math.abs(crosshairX - this.anchorX);
        if (abs < this.distance) {
            this.crosshairX = crosshairX;
            this.domainAxisIndex = domainAxisIndex;
            this.distance = abs;
        }
    }
    
    public void updateCrosshairY(final double n) {
        this.updateCrosshairY(n, 0);
    }
    
    public void updateCrosshairY(final double crosshairY, final int rangeAxisIndex) {
        final double abs = Math.abs(crosshairY - this.anchorY);
        if (abs < this.distance) {
            this.crosshairY = crosshairY;
            this.rangeAxisIndex = rangeAxisIndex;
            this.distance = abs;
        }
    }
    
    public Point2D getAnchor() {
        return this.anchor;
    }
    
    public void setAnchor(final Point2D anchor) {
        this.anchor = anchor;
    }
    
    public double getAnchorX() {
        return this.anchorX;
    }
    
    public void setAnchorX(final double anchorX) {
        this.anchorX = anchorX;
    }
    
    public double getAnchorY() {
        return this.anchorY;
    }
    
    public void setAnchorY(final double anchorY) {
        this.anchorY = anchorY;
    }
    
    public double getCrosshairX() {
        return this.crosshairX;
    }
    
    public void setCrosshairX(final double crosshairX) {
        this.crosshairX = crosshairX;
    }
    
    public double getCrosshairY() {
        return this.crosshairY;
    }
    
    public void setCrosshairY(final double crosshairY) {
        this.crosshairY = crosshairY;
    }
    
    public int getDomainAxisIndex() {
        return this.domainAxisIndex;
    }
    
    public int getRangeAxisIndex() {
        return this.rangeAxisIndex;
    }
}
