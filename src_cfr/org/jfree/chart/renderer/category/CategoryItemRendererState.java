/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.category;

import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class CategoryItemRendererState
extends RendererState {
    private double barWidth = 0.0;
    private double seriesRunningTotal = 0.0;

    public CategoryItemRendererState(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }

    public double getBarWidth() {
        return this.barWidth;
    }

    public void setBarWidth(double d2) {
        this.barWidth = d2;
    }

    public double getSeriesRunningTotal() {
        return this.seriesRunningTotal;
    }

    void setSeriesRunningTotal(double d2) {
        this.seriesRunningTotal = d2;
    }
}

