package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyRegenerateableRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;

public class ZyRegenerateableNodeRealizer implements IZyRegenerateableRealizer {
   private final IZyNodeRealizer realizer;

   public ZyRegenerateableNodeRealizer(IZyNodeRealizer var1) {
      this.realizer = (IZyNodeRealizer)Preconditions.checkNotNull(var1, "Error: Node realizer can\'t be null.");
   }

   public void regenerate() {
      this.realizer.regenerate();
   }

   public void repaint() {
      this.realizer.repaint();
   }
}
