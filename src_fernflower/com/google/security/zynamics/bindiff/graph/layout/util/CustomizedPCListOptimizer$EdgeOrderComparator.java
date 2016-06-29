package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer;
import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$1;
import java.util.Comparator;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.c.a.aV;
import y.f.c.a.aX;

class CustomizedPCListOptimizer$EdgeOrderComparator implements Comparator {
   private final q node;
   private final c node2IsSameLayerDummy;
   private final int nodePos;
   private final aV ldp;
   // $FF: synthetic field
   final CustomizedPCListOptimizer this$0;

   private CustomizedPCListOptimizer$EdgeOrderComparator(CustomizedPCListOptimizer var1, c var2, q var3, aV var4) {
      this.this$0 = var1;
      this.node2IsSameLayerDummy = var2;
      this.node = var3;
      this.ldp = var4;
      this.nodePos = var4.a(var3).k();
   }

   private int getPositionOfOpposite(d var1) {
      q var2 = var1.a(this.node);
      if(!this.node2IsSameLayerDummy.d(var2)) {
         aX var5 = this.ldp.a(var2);
         return var5.k();
      } else {
         d var3 = null;
         e var4 = var2.j();

         while(var4.f()) {
            if(var4.a() != var1) {
               var3 = var4.a();
               break;
            }

            var4.g();
         }

         aX var6 = this.ldp.a(var3.a(var2));
         return var6.k();
      }
   }

   private boolean isSameLayerEdge(d var1) {
      return this.node2IsSameLayerDummy.d(var1.a(this.node));
   }

   public int compare(d var1, d var2) {
      int var5 = this.getPositionOfOpposite(var1);
      int var6 = this.getPositionOfOpposite(var2);
      return this.isSameLayerEdge(var1) && this.isSameLayerEdge(var2)?((this.nodePos <= var5 || this.nodePos <= var6) && (this.nodePos >= var5 || this.nodePos >= var6)?(var5 < var6?-1:1):var6 - var5):(this.isSameLayerEdge(var1)?(this.nodePos > var5?-1:1):(this.isSameLayerEdge(var2)?(this.nodePos > var6?1:-1):var5 - var6));
   }

   // $FF: synthetic method
   CustomizedPCListOptimizer$EdgeOrderComparator(CustomizedPCListOptimizer var1, c var2, q var3, aV var4, CustomizedPCListOptimizer$1 var5) {
      this(var1, var2, var3, var4);
   }
}
