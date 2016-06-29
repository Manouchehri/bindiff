package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import java.awt.Cursor;
import y.h.bu;
import y.h.ch;

public class ZyGraph2DView extends ch implements IFineGrainedSloppyGraph2DView {
   private static final long serialVersionUID = 9194672642118308276L;
   private double m_nodeSloppyThreshold;
   private double m_edgeSloppyThreshold;
   private int m_minEdgesForSloppyEdgeHiding;
   private double m_sloppyEdgeHidingThreshold;

   public ZyGraph2DView() {
      this.initDefaults();
   }

   public ZyGraph2DView(bu var1) {
      super(var1);
      this.initDefaults();
   }

   private void initDefaults() {
      this.m_nodeSloppyThreshold = this.getPaintDetailThreshold();
      this.m_edgeSloppyThreshold = 0.2D;
      this.m_minEdgesForSloppyEdgeHiding = 3000;
      this.m_sloppyEdgeHidingThreshold = 0.1D;
      this.setPaintDetailThreshold(0.0D);
   }

   public boolean drawEdges() {
      return this.m_minEdgesForSloppyEdgeHiding >= this.getGraph2D().g()?true:this.m_sloppyEdgeHidingThreshold <= this.getZoom();
   }

   public boolean isEdgeSloppyPaintMode() {
      return this.getZoom() < this.m_edgeSloppyThreshold;
   }

   public boolean isNodeSloppyPaintMode() {
      return this.getZoom() < this.m_nodeSloppyThreshold;
   }

   public void setCrossCursor(boolean var1) {
      if(var1) {
         super.setViewCursor(Cursor.getPredefinedCursor(13));
      } else {
         super.setViewCursor(Cursor.getDefaultCursor());
      }

   }

   public void setEdgeSloppyThreshold(double var1) {
      this.m_edgeSloppyThreshold = var1;
   }

   public void setMinEdgesForSloppyEdgeHiding(int var1) {
      this.m_minEdgesForSloppyEdgeHiding = var1;
   }

   public void setNodeSloppyThreshold(double var1) {
      this.m_nodeSloppyThreshold = var1;
   }

   public void setSloppyEdgeHidingThreshold(double var1) {
      this.m_sloppyEdgeHidingThreshold = var1;
   }

   public void setViewCursor(Cursor var1) {
   }
}
