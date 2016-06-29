package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditModeMouseWheelListener$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.MoveFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ZoomHelpers;
import java.awt.event.MouseWheelEvent;
import java.util.Set;
import y.h.cQ;

public class ZyEditModeMouseWheelListener extends cQ {
   private static final double ZOOM_SUB_FACTOR = 0.02D;
   private static final double SCROLL_SUB_FACTOR = 0.6D;
   private final AbstractZyGraph m_zyGraph;

   public ZyEditModeMouseWheelListener(AbstractZyGraph var1) {
      Preconditions.checkNotNull(var1, "Error: Graph argument can\'t be null");
      this.m_zyGraph = var1;
      this.setCenterZooming(false);
   }

   private void centerZoom(double var1, boolean var3) {
      if(var3) {
         Set var4 = this.m_zyGraph.getSelectedNodes();
         if(var4.size() != 0) {
            MoveFunctions.centerNodes(this.m_zyGraph, var4);
         }
      }

      this.m_zyGraph.zoom(var1);
   }

   private void handleInMoveMode(MouseWheelEvent var1) {
      boolean var2 = var1.getUnitsToScroll() > 0;
      if(var1.isAltDown()) {
         this.moveVertical(var2);
      } else {
         this.moveHorizontal(var2);
      }

   }

   private void handleInZoomMode(MouseWheelEvent var1) {
      this.zoom(var1, var1.getUnitsToScroll() > 0, var1.isShiftDown());
   }

   private boolean hasSelectedNode() {
      return GraphHelpers.any(this.m_zyGraph, new ZyEditModeMouseWheelListener$1(this));
   }

   private void moveHorizontal(boolean var1) {
      if(var1) {
         MoveFunctions.pan(this.m_zyGraph, 0.0D, 0.6D * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
      } else {
         MoveFunctions.pan(this.m_zyGraph, 0.0D, -0.6D * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity());
      }

   }

   private void moveVertical(boolean var1) {
      if(var1) {
         MoveFunctions.pan(this.m_zyGraph, 0.6D * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0D);
      } else {
         MoveFunctions.pan(this.m_zyGraph, -0.6D * (double)this.m_zyGraph.getSettings().getMouseSettings().getScrollSensitivity(), 0.0D);
      }

   }

   private void zoom(MouseWheelEvent var1, boolean var2, boolean var3) {
      if(this.hasSelectedNode() && var3) {
         if(var2) {
            this.centerZoom(1.0D - (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02D, var3);
         } else {
            this.centerZoom(1.0D + (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02D, var3);
         }
      } else {
         super.mouseWheelMoved(var1);
      }

   }

   protected double calcZoom(double var1, int var3) {
      double var4;
      if(var3 > 0) {
         var4 = ZoomHelpers.getMinimumZoom(this.m_zyGraph.getView());
         this.setMinimumZoom(var4);
         double var6 = 1.0D - (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02D;
         if(var4 > 0.5D) {
            super.setMinimumZoom(0.75D);
            return this.m_zyGraph.getView().getZoom() * var6;
         } else {
            return Math.max(this.m_zyGraph.getView().getZoom() * var6, var4);
         }
      } else {
         var4 = 1.0D + (double)this.m_zyGraph.getSettings().getMouseSettings().getZoomSensitivity() * 0.02D;
         this.setMaximumZoom(3.0D);
         return this.m_zyGraph.getView().getZoom() * var4;
      }
   }

   public void mouseWheelMoved(MouseWheelEvent var1) {
      int var2 = Math.abs(var1.getUnitsToScroll());
      boolean var3 = var1.isControlDown();

      for(int var4 = 0; var4 < var2; ++var4) {
         if((this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() != MouseWheelAction.ZOOM || var3) && (this.m_zyGraph.getSettings().getMouseSettings().getMouseWheelAction() != MouseWheelAction.SCROLL || !var3)) {
            this.handleInMoveMode(var1);
         } else {
            this.handleInZoomMode(var1);
         }
      }

      this.m_zyGraph.updateViews();
   }
}
