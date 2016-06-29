/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import java.awt.geom.GeneralPath;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class StandardXYItemRenderer$State
extends XYItemRendererState {
    public GeneralPath seriesPath;
    private int seriesIndex;
    private boolean lastPointGood;

    public StandardXYItemRenderer$State(PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }

    public boolean isLastPointGood() {
        return this.lastPointGood;
    }

    public void setLastPointGood(boolean bl2) {
        this.lastPointGood = bl2;
    }

    public int getSeriesIndex() {
        return this.seriesIndex;
    }

    public void setSeriesIndex(int n2) {
        this.seriesIndex = n2;
    }

    static int access$002(StandardXYItemRenderer$State standardXYItemRenderer$State, int n2) {
        standardXYItemRenderer$State.seriesIndex = n2;
        return standardXYItemRenderer$State.seriesIndex;
    }

    static boolean access$102(StandardXYItemRenderer$State standardXYItemRenderer$State, boolean bl2) {
        standardXYItemRenderer$State.lastPointGood = bl2;
        return standardXYItemRenderer$State.lastPointGood;
    }

    static int access$000(StandardXYItemRenderer$State standardXYItemRenderer$State) {
        return standardXYItemRenderer$State.seriesIndex;
    }
}

