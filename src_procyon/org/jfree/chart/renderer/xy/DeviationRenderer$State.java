package org.jfree.chart.renderer.xy;

import org.jfree.chart.plot.*;
import java.util.*;

public class DeviationRenderer$State extends XYLineAndShapeRenderer$State
{
    public List upperCoordinates;
    public List lowerCoordinates;
    
    public DeviationRenderer$State(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.lowerCoordinates = new ArrayList();
        this.upperCoordinates = new ArrayList();
    }
}
