package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.grouping;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.bu;

public class GroupHelpers {
   public static void expandParents(IViewNode var0) {
      if(var0.getParentGroup() != null) {
         expandParents(var0.getParentGroup());
      }

      if(var0 instanceof IGroupNode) {
         IGroupNode var1 = (IGroupNode)var0;
         if(var1.isCollapsed()) {
            var1.setCollapsed(false);
         }
      }

   }

   public static void extractFolder(bu var0, q var1) {
      i var2 = var0.C().m(var1);
      y var3 = new y(var2.o());
      var0.C().a(var2, var3);
   }

   public static void extractGroup(bu var0, q var1) {
      x var2 = var0.C().p(var1);

      while(var2.f()) {
         var0.C().c(var2.e(), var0.C().n(var1));
         var2.g();
      }

   }

   public static boolean isExpanded(IGroupNode var0) {
      return !var0.isCollapsed() && (var0.getParentGroup() == null || isExpanded(var0.getParentGroup()));
   }
}
