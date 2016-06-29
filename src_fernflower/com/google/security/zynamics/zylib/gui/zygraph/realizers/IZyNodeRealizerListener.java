package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public interface IZyNodeRealizerListener {
   void changedLocation(IZyNodeRealizer var1, double var2, double var4);

   void changedSelection(IZyNodeRealizer var1);

   void changedSize(IZyNodeRealizer var1, double var2, double var4);

   void changedVisibility(IZyNodeRealizer var1);

   void regenerated(IZyNodeRealizer var1);
}
