package org.jfree.chart.renderer.xy;

import java.awt.geom.*;
import org.jfree.chart.plot.*;

public class XYLineAndShapeRenderer$State extends XYItemRendererState
{
    public GeneralPath seriesPath;
    private boolean lastPointGood;
    
    public XYLineAndShapeRenderer$State(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
    }
    
    public boolean isLastPointGood() {
        return this.lastPointGood;
    }
    
    public void setLastPointGood(final boolean lastPointGood) {
        this.lastPointGood = lastPointGood;
    }
    
    static boolean access$002(final XYLineAndShapeRenderer$State xyLineAndShapeRenderer$State, final boolean lastPointGood) {
        return xyLineAndShapeRenderer$State.lastPointGood = lastPointGood;
    }
}
