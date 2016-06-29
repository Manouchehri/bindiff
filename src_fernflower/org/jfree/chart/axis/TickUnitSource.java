package org.jfree.chart.axis;

import org.jfree.chart.axis.TickUnit;

public interface TickUnitSource {
   TickUnit getLargerTickUnit(TickUnit var1);

   TickUnit getCeilingTickUnit(TickUnit var1);

   TickUnit getCeilingTickUnit(double var1);
}
