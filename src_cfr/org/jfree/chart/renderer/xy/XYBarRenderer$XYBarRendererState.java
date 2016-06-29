/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class XYBarRenderer$XYBarRendererState
extends XYItemRendererState {
    private double g2Base;
    private final XYBarRenderer this$0;

    public XYBarRenderer$XYBarRendererState(XYBarRenderer xYBarRenderer, PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.this$0 = xYBarRenderer;
    }

    public double getG2Base() {
        return this.g2Base;
    }

    public void setG2Base(double d2) {
        this.g2Base = d2;
    }
}

