package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public interface IViewableNode {
   void calcUnionRect(Rectangle2D var1);

   Double getBoundingBox();
}
