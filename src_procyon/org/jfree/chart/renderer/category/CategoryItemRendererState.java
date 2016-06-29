package org.jfree.chart.renderer.category;

import org.jfree.chart.renderer.*;
import org.jfree.chart.plot.*;

public class CategoryItemRendererState extends RendererState
{
    private double barWidth;
    private double seriesRunningTotal;
    
    public CategoryItemRendererState(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.barWidth = 0.0;
        this.seriesRunningTotal = 0.0;
    }
    
    public double getBarWidth() {
        return this.barWidth;
    }
    
    public void setBarWidth(final double barWidth) {
        this.barWidth = barWidth;
    }
    
    public double getSeriesRunningTotal() {
        return this.seriesRunningTotal;
    }
    
    void setSeriesRunningTotal(final double seriesRunningTotal) {
        this.seriesRunningTotal = seriesRunningTotal;
    }
}
