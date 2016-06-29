package org.jfree.chart.renderer.xy;

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer$State;

public class DeviationRenderer$State extends XYLineAndShapeRenderer$State {
   public List upperCoordinates = new ArrayList();
   public List lowerCoordinates = new ArrayList();

   public DeviationRenderer$State(PlotRenderingInfo var1) {
      super(var1);
   }
}
