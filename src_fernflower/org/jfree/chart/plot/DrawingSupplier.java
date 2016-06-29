package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;

public interface DrawingSupplier {
   Paint getNextPaint();

   Paint getNextOutlinePaint();

   Stroke getNextStroke();

   Stroke getNextOutlineStroke();

   Shape getNextShape();
}
