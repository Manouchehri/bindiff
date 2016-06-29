package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public class FunctionNodeRealizerUpdater implements IRealizerUpdater {
   public void dispose() {
   }

   public void generateContent(IZyNodeRealizer var1, ZyLabelContent var2) {
      var2 = var1.getNodeContent();
   }

   public void setRealizer(IZyNodeRealizer var1) {
   }
}
