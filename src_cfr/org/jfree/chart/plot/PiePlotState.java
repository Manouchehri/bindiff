/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import java.awt.geom.Rectangle2D;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class PiePlotState
extends RendererState {
    private int passesRequired = 1;
    private double total = 0.0;
    private double latestAngle;
    private Rectangle2D explodedPieArea;
    private Rectangle2D pieArea;
    private double pieCenterX;
    private double pieCenterY;
    private double pieHRadius;
    private double pieWRadius;
    private Rectangle2D linkArea;

    public PiePlotState(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }

    public int getPassesRequired() {
        return this.passesRequired;
    }

    public void setPassesRequired(int n2) {
        this.passesRequired = n2;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double d2) {
        this.total = d2;
    }

    public double getLatestAngle() {
        return this.latestAngle;
    }

    public void setLatestAngle(double d2) {
        this.latestAngle = d2;
    }

    public Rectangle2D getPieArea() {
        return this.pieArea;
    }

    public void setPieArea(Rectangle2D rectangle2D) {
        this.pieArea = rectangle2D;
    }

    public Rectangle2D getExplodedPieArea() {
        return this.explodedPieArea;
    }

    public void setExplodedPieArea(Rectangle2D rectangle2D) {
        this.explodedPieArea = rectangle2D;
    }

    public double getPieCenterX() {
        return this.pieCenterX;
    }

    public void setPieCenterX(double d2) {
        this.pieCenterX = d2;
    }

    public double getPieCenterY() {
        return this.pieCenterY;
    }

    public void setPieCenterY(double d2) {
        this.pieCenterY = d2;
    }

    public Rectangle2D getLinkArea() {
        return this.linkArea;
    }

    public void setLinkArea(Rectangle2D rectangle2D) {
        this.linkArea = rectangle2D;
    }

    public double getPieHRadius() {
        return this.pieHRadius;
    }

    public void setPieHRadius(double d2) {
        this.pieHRadius = d2;
    }

    public double getPieWRadius() {
        return this.pieWRadius;
    }

    public void setPieWRadius(double d2) {
        this.pieWRadius = d2;
    }
}

