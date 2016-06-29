package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Set;
import y.c.d;
import y.c.e;
import y.h.x;
import y.h.y;

public class CNodeMover {
   public static boolean isDraggedFar(double var0, double var2, double var4, double var6) {
      double var8 = var0 - var4;
      double var10 = var2 - var6;
      return Math.abs(var8) > 15.0D || Math.abs(var10) > 15.0D;
   }

   public static void moveNode(AbstractZyGraph var0, ZyGraphNode var1, double var2, double var4, Set var6) {
      var0.getGraph().t(var1.getNode()).moveBy(var2, var4);
      e var7 = var1.getNode().j();

      while(var7.f()) {
         d var8 = var7.a();

         for(y var9 = var0.getGraph().i(var8).bends(); var9.f(); var9.g()) {
            x var10 = var9.a();
            if(!var6.contains(var10)) {
               var10.b(var2, var4);
               var6.add(var10);
            }
         }

         var7.g();
      }

   }
}
