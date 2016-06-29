package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;

public interface IEdgeRealizerUpdater {
   ZyLabelContent generateContent(ZyEdgeRealizer var1);

   void setRealizer(ZyEdgeRealizer var1);
}
