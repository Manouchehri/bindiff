package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.ui.Drawable;
import org.jfree.ui.Size2D;

public interface Block extends Drawable {
   String getID();

   void setID(String var1);

   Size2D arrange(Graphics2D var1);

   Size2D arrange(Graphics2D var1, RectangleConstraint var2);

   Rectangle2D getBounds();

   void setBounds(Rectangle2D var1);

   Object draw(Graphics2D var1, Rectangle2D var2, Object var3);
}
