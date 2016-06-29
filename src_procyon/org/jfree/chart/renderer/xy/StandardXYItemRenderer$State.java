package org.jfree.chart.renderer.xy;

import java.awt.geom.*;
import org.jfree.chart.plot.*;

public class StandardXYItemRenderer$State extends XYItemRendererState
{
    public GeneralPath seriesPath;
    private int seriesIndex;
    private boolean lastPointGood;
    
    public StandardXYItemRenderer$State(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }
    
    public boolean isLastPointGood() {
        return this.lastPointGood;
    }
    
    public void setLastPointGood(final boolean lastPointGood) {
        this.lastPointGood = lastPointGood;
    }
    
    public int getSeriesIndex() {
        return this.seriesIndex;
    }
    
    public void setSeriesIndex(final int seriesIndex) {
        this.seriesIndex = seriesIndex;
    }
    
    static int access$002(final StandardXYItemRenderer$State standardXYItemRenderer$State, final int seriesIndex) {
        return standardXYItemRenderer$State.seriesIndex = seriesIndex;
    }
    
    static boolean access$102(final StandardXYItemRenderer$State standardXYItemRenderer$State, final boolean lastPointGood) {
        return standardXYItemRenderer$State.lastPointGood = lastPointGood;
    }
    
    static int access$000(final StandardXYItemRenderer$State standardXYItemRenderer$State) {
        return standardXYItemRenderer$State.seriesIndex;
    }
}
