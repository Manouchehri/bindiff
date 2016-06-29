/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.PlotRenderingInfo;

public class RendererState {
    private PlotRenderingInfo info;

    public RendererState(PlotRenderingInfo plotRenderingInfo) {
        this.info = plotRenderingInfo;
    }

    public PlotRenderingInfo getInfo() {
        return this.info;
    }

    public EntityCollection getEntityCollection() {
        EntityCollection entityCollection = null;
        if (this.info == null) return entityCollection;
        ChartRenderingInfo chartRenderingInfo = this.info.getOwner();
        if (chartRenderingInfo == null) return entityCollection;
        return chartRenderingInfo.getEntityCollection();
    }
}

