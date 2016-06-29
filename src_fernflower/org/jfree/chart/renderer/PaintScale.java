package org.jfree.chart.renderer;

import java.awt.Paint;

public interface PaintScale {
   double getLowerBound();

   double getUpperBound();

   Paint getPaint(double var1);
}
