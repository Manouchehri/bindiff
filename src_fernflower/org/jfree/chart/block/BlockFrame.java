package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.ui.RectangleInsets;

public interface BlockFrame {
   RectangleInsets getInsets();

   void draw(Graphics2D var1, Rectangle2D var2);
}
