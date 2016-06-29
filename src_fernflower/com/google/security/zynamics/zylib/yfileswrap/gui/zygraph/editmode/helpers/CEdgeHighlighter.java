package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.c.d;
import y.c.e;
import y.c.q;
import y.h.aB;
import y.h.bu;
import y.h.dr;

public final class CEdgeHighlighter {
   public static void highlightEdge(aB var0, boolean var1) {
      if(var1) {
         if(var0.getLineType() == dr.b) {
            var0.setLineType(dr.e);
         } else if(var0.getLineType() == dr.n) {
            var0.setLineType(dr.q);
         } else if(var0.getLineType() == dr.i) {
            var0.setLineType(dr.l);
         } else if(var0.getLineType() == dr.s) {
            var0.setLineType(dr.v);
         }
      } else {
         if(var0 == null) {
            return;
         }

         if(var0.getLineType() == dr.e) {
            var0.setLineType(dr.b);
         } else if(var0.getLineType() == dr.q) {
            var0.setLineType(dr.n);
         } else if(var0.getLineType() == dr.l) {
            var0.setLineType(dr.i);
         } else if(var0.getLineType() == dr.v) {
            var0.setLineType(dr.s);
         }
      }

   }

   public static void highlightEdgesOfNode(q var0, boolean var1) {
      e var2 = var0.j();
      int var3 = var0.a();

      for(d var4 = var2.a(); var3 > 0; --var3) {
         aB var5 = ((bu)var0.e()).i(var4);
         highlightEdge(var5, var1);
         var2.b();
         var4 = var2.a();
      }

   }
}
