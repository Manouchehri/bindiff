/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.geom.Line2D;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class XYItemRendererState
extends RendererState {
    public Line2D workingLine = new Line2D.Double();

    public XYItemRendererState(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }
}

