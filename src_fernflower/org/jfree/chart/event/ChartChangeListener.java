package org.jfree.chart.event;

import java.util.EventListener;
import org.jfree.chart.event.ChartChangeEvent;

public interface ChartChangeListener extends EventListener {
   void chartChanged(ChartChangeEvent var1);
}
