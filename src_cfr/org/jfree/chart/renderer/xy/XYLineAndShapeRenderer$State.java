/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.geom.GeneralPath;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class XYLineAndShapeRenderer$State
extends XYItemRendererState {
    public GeneralPath seriesPath;
    private boolean lastPointGood;

    public XYLineAndShapeRenderer$State(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }

    public boolean isLastPointGood() {
        return this.lastPointGood;
    }

    public void setLastPointGood(boolean bl2) {
        this.lastPointGood = bl2;
    }

    static boolean access$002(XYLineAndShapeRenderer$State xYLineAndShapeRenderer$State, boolean bl2) {
        xYLineAndShapeRenderer$State.lastPointGood = bl2;
        return xYLineAndShapeRenderer$State.lastPointGood;
    }
}

