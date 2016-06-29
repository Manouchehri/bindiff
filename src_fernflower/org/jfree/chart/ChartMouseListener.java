package org.jfree.chart;

import java.util.EventListener;
import org.jfree.chart.ChartMouseEvent;

public interface ChartMouseListener extends EventListener {
   void chartMouseClicked(ChartMouseEvent var1);

   void chartMouseMoved(ChartMouseEvent var1);
}
