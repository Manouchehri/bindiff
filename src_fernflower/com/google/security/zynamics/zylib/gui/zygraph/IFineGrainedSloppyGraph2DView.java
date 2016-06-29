package com.google.security.zynamics.zylib.gui.zygraph;

public interface IFineGrainedSloppyGraph2DView {
   boolean drawEdges();

   boolean isEdgeSloppyPaintMode();

   boolean isNodeSloppyPaintMode();

   void setEdgeSloppyThreshold(double var1);

   void setMinEdgesForSloppyEdgeHiding(int var1);

   void setNodeSloppyThreshold(double var1);

   void setSloppyEdgeHidingThreshold(double var1);
}
