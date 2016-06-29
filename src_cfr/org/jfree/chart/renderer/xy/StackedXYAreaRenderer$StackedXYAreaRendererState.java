/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.Stack;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

class StackedXYAreaRenderer$StackedXYAreaRendererState
extends XYItemRendererState {
    private Polygon seriesArea = null;
    private Line2D line = new Line2D.Double();
    private Stack lastSeriesPoints = new Stack();
    private Stack currentSeriesPoints = new Stack();

    public StackedXYAreaRenderer$StackedXYAreaRendererState(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }

    public Polygon getSeriesArea() {
        return this.seriesArea;
    }

    public void setSeriesArea(Polygon polygon) {
        this.seriesArea = polygon;
    }

    public Line2D getLine() {
        return this.line;
    }

    public Stack getCurrentSeriesPoints() {
        return this.currentSeriesPoints;
    }

    public void setCurrentSeriesPoints(Stack stack) {
        this.currentSeriesPoints = stack;
    }

    public Stack getLastSeriesPoints() {
        return this.lastSeriesPoints;
    }

    public void setLastSeriesPoints(Stack stack) {
        this.lastSeriesPoints = stack;
    }
}

