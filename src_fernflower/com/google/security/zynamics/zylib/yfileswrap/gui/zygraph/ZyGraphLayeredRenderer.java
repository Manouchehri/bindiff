package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.IFineGrainedSloppyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphFineGrainedRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyGroupNodeRealizer;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.a.v;

public class ZyGraphLayeredRenderer extends ZyGraphFineGrainedRenderer {
   private q m_node = null;

   public ZyGraphLayeredRenderer(IFineGrainedSloppyGraph2DView var1) {
      super(var1);
      this.setLayeredPainting(true);
   }

   private boolean isAnyParentNodeSelected(q var1) {
      bu var2 = (bu)var1.e();
      v var3 = var2.C();
      if(var3 == null) {
         return false;
      } else {
         boolean var4 = false;

         for(q var5 = var3.n(var1); var5 != null; var5 = var3.n(var5)) {
            if(var2.v(var5)) {
               var4 = true;
               break;
            }
         }

         return var4;
      }
   }

   protected int getLayer(bu var1, d var2) {
      return 2;
   }

   protected int getLayer(bu var1, q var2) {
      boolean var3 = var1.t(var2) instanceof ZyGroupNodeRealizer;
      return (var1.v(var2) || this.isAnyParentNodeSelected(var2)) && !var3?3:(this.m_node == var2 && !var3?4:(var3?1:2));
   }

   public void bringNodeToFront(q var1) {
      this.m_node = var1;
   }
}
