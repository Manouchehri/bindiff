package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import y.h.ch;
import y.h.fD;

public class ZyOverview extends fD implements IFineGrainedSloppyGraph2DView {
   private int _minEdgesForSloppyEdgeHiding;

   public ZyOverview(ch var1) {
      super(var1);
      this.setPaintDetailThreshold(0.0D);
      this.setMinEdgesForSloppyEdgeHiding(1000);
   }

   public boolean drawEdges() {
      return this.getGraph2D().g() < this._minEdgesForSloppyEdgeHiding;
   }

   public boolean isEdgeSloppyPaintMode() {
      return true;
   }

   public boolean isNodeSloppyPaintMode() {
      return true;
   }

   public void setEdgeSloppyThreshold(double var1) {
   }

   public void setMinEdgesForSloppyEdgeHiding(int var1) {
      this._minEdgesForSloppyEdgeHiding = var1;
   }

   public void setNodeSloppyThreshold(double var1) {
   }

   public void setSloppyEdgeHidingThreshold(double var1) {
   }
}
