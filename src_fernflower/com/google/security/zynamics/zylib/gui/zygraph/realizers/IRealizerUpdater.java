package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public interface IRealizerUpdater {
   void dispose();

   void generateContent(IZyNodeRealizer var1, ZyLabelContent var2);

   void setRealizer(IZyNodeRealizer var1);
}
