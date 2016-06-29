package org.jfree.chart.renderer.xy;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import org.jfree.chart.plot.*;

class StackedXYAreaRenderer$StackedXYAreaRendererState extends XYItemRendererState
{
    private Polygon seriesArea;
    private Line2D line;
    private Stack lastSeriesPoints;
    private Stack currentSeriesPoints;
    
    public StackedXYAreaRenderer$StackedXYAreaRendererState(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.seriesArea = null;
        this.line = new Line2D.Double();
        this.lastSeriesPoints = new Stack();
        this.currentSeriesPoints = new Stack();
    }
    
    public Polygon getSeriesArea() {
        return this.seriesArea;
    }
    
    public void setSeriesArea(final Polygon seriesArea) {
        this.seriesArea = seriesArea;
    }
    
    public Line2D getLine() {
        return this.line;
    }
    
    public Stack getCurrentSeriesPoints() {
        return this.currentSeriesPoints;
    }
    
    public void setCurrentSeriesPoints(final Stack currentSeriesPoints) {
        this.currentSeriesPoints = currentSeriesPoints;
    }
    
    public Stack getLastSeriesPoints() {
        return this.lastSeriesPoints;
    }
    
    public void setLastSeriesPoints(final Stack lastSeriesPoints) {
        this.lastSeriesPoints = lastSeriesPoints;
    }
}
