package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public interface IZyEditModeListener {
   void edgeClicked(Object var1, MouseEvent var2, double var3, double var5);

   void edgeLabelEntered(aA var1, MouseEvent var2);

   void edgeLabelLeft(aA var1);

   void nodeClicked(Object var1, MouseEvent var2, double var3, double var5);

   void nodeEntered(Object var1, MouseEvent var2);

   void nodeHovered(Object var1, double var2, double var4);

   void nodeLeft(Object var1);

   void proximityBrowserNodeClicked(ZyProximityNode var1, MouseEvent var2, double var3, double var5);
}
