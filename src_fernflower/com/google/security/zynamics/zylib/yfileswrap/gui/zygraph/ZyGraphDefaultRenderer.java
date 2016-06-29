package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyGroupNodeRealizer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import y.c.q;
import y.c.x;
import y.h.O;
import y.h.bu;
import y.h.fj;

public class ZyGraphDefaultRenderer extends O {
   private final LinkedHashSet m_nodesInDrawingOrder = new LinkedHashSet();

   public ZyGraphDefaultRenderer() {
      this.setLayeredPainting(true);
   }

   protected int getLayer(bu var1, q var2) {
      if(var1.t(var2) instanceof ZyGroupNodeRealizer) {
         return super.getLayer(var1, var2);
      } else {
         int var3 = 1;

         for(Iterator var4 = this.m_nodesInDrawingOrder.iterator(); var4.hasNext(); ++var3) {
            q var5 = (q)var4.next();
            if(var5 == var2) {
               return var3;
            }
         }

         return super.getLayer(var1, var2);
      }
   }

   public void bringNodeToFront(q var1) {
      bu var2 = (bu)var1.e();
      fj var3 = var2.t(var1);
      if(var3.isSelected()) {
         x var4 = var2.J();

         while(var4.f()) {
            this.m_nodesInDrawingOrder.remove(var4.e());
            this.m_nodesInDrawingOrder.add(var4.e());
            var4.g();
         }
      } else {
         this.m_nodesInDrawingOrder.remove(var1);
         this.m_nodesInDrawingOrder.add(var1);
      }

   }
}
