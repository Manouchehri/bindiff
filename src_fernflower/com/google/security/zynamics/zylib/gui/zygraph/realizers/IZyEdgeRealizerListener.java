package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;

public interface IZyEdgeRealizerListener {
   void addedBend(double var1, double var3);

   void bendChanged(int var1, double var2, double var4);

   void changedLocation(ZyEdgeRealizer var1);

   void changedVisibility(ZyEdgeRealizer var1);

   void clearedBends();

   void insertedBend(int var1, double var2, double var4);

   void regenerated(ZyEdgeRealizer var1);

   void removedBend(ZyEdgeRealizer var1, int var2);
}
