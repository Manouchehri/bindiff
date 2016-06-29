/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.geom.Point2D;
import org.jfree.chart.plot.PlotOrientation;

public class CrosshairState {
    private boolean calculateDistanceInDataSpace = false;
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

    public CrosshairState(boolean bl2) {
        this.calculateDistanceInDataSpace = bl2;
    }

    public double getCrosshairDistance() {
        return this.distance;
    }

    public void setCrosshairDistance(double d2) {
        this.distance = d2;
    }

    public void updateCrosshairPoint(double d2, double d3, double d4, double d5, PlotOrientation plotOrientation) {
        this.updateCrosshairPoint(d2, d3, 0, 0, d4, d5, plotOrientation);
    }

    public void updateCrosshairPoint(double d2, double d3, int n2, int n3, double d4, double d5, PlotOrientation plotOrientation) {
        if (this.anchor == null) return;
        double d6 = 0.0;
        if (this.calculateDistanceInDataSpace) {
            d6 = (d2 - this.anchorX) * (d2 - this.anchorX) + (d3 - this.anchorY) * (d3 - this.anchorY);
        } else {
            double d7 = this.anchor.getX();
            double d8 = this.anchor.getY();
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                double d9 = d8;
                d8 = d7;
                d7 = d9;
            }
            d6 = (d4 - d7) * (d4 - d7) + (d5 - d8) * (d5 - d8);
        }
        if (d6 >= this.distance) return;
        this.crosshairX = d2;
        this.crosshairY = d3;
        this.domainAxisIndex = n2;
        this.rangeAxisIndex = n3;
        this.distance = d6;
    }

    public void updateCrosshairX(double d2) {
        this.updateCrosshairX(d2, 0);
    }

    public void updateCrosshairX(double d2, int n2) {
        double d3 = Math.abs(d2 - this.anchorX);
        if (d3 >= this.distance) return;
        this.crosshairX = d2;
        this.domainAxisIndex = n2;
        this.distance = d3;
    }

    public void updateCrosshairY(double d2) {
        this.updateCrosshairY(d2, 0);
    }

    public void updateCrosshairY(double d2, int n2) {
        double d3 = Math.abs(d2 - this.anchorY);
        if (d3 >= this.distance) return;
        this.crosshairY = d2;
        this.rangeAxisIndex = n2;
        this.distance = d3;
    }

    public Point2D getAnchor() {
        return this.anchor;
    }

    public void setAnchor(Point2D point2D) {
        this.anchor = point2D;
    }

    public double getAnchorX() {
        return this.anchorX;
    }

    public void setAnchorX(double d2) {
        this.anchorX = d2;
    }

    public double getAnchorY() {
        return this.anchorY;
    }

    public void setAnchorY(double d2) {
        this.anchorY = d2;
    }

    public double getCrosshairX() {
        return this.crosshairX;
    }

    public void setCrosshairX(double d2) {
        this.crosshairX = d2;
    }

    public double getCrosshairY() {
        return this.crosshairY;
    }

    public void setCrosshairY(double d2) {
        this.crosshairY = d2;
    }

    public int getDomainAxisIndex() {
        return this.domainAxisIndex;
    }

    public int getRangeAxisIndex() {
        return this.rangeAxisIndex;
    }
}

