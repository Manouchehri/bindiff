package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import java.awt.Graphics2D;
import y.h.O;
import y.h.aB;
import y.h.bu;
import y.h.fj;

public class ZyGraphFineGrainedRenderer extends O {
   protected IFineGrainedSloppyGraph2DView m_view;
   private boolean m_drawEdges = true;

   public ZyGraphFineGrainedRenderer(IFineGrainedSloppyGraph2DView var1) {
      this.m_view = var1;
   }

   protected void paint(Graphics2D var1, aB var2) {
      if(this.m_drawEdges) {
         if(this.m_view.isEdgeSloppyPaintMode()) {
            var2.paintSloppy(var1);
         } else {
            var2.paint(var1);
         }

      }
   }

   protected void paint(Graphics2D var1, fj var2) {
      if(this.m_view.isNodeSloppyPaintMode()) {
         var2.paintSloppy(var1);
      } else {
         var2.paint(var1);
      }

   }

   protected void paintLayered(Graphics2D var1, int var2, aB var3) {
      super.paintLayered(var1, var2, var3);
   }

   protected void paintLayered(Graphics2D var1, int var2, fj var3) {
      super.paintLayered(var1, var2, var3);
   }

   protected void paintSloppy(Graphics2D var1, aB var2) {
      assert false : "The sloppy paint methods should not be called";

   }

   protected void paintSloppy(Graphics2D var1, fj var2) {
      assert false : "The sloppy paint methods should not be called";

   }

   protected void paintSloppyLayered(Graphics2D var1, int var2, aB var3) {
      assert false : "The sloppy paint methods should not be called";

   }

   protected void paintSloppyLayered(Graphics2D var1, int var2, fj var3) {
      assert false : "The sloppy paint methods should not be called";

   }

   public void paint(Graphics2D var1, bu var2) {
      this.m_drawEdges = this.m_view.drawEdges();
      super.paint(var1, var2);
   }
}
