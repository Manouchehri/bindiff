/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

class XYAreaRenderer$XYAreaRendererState
extends XYItemRendererState {
    public Polygon area = new Polygon();
    public Line2D line = new Line2D.Double();

    public XYAreaRenderer$XYAreaRendererState(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }
}

