package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import y.c.q;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class CNodeHighlighter {
   public static void highlightNode(q var0, boolean var1) {
      fj var2 = ((bu)var0.e()).t(var0);
      if(var2 != null) {
         if(var1) {
            if(var2.getLineType() == dr.b) {
               var2.setLineType(dr.e);
            }
         } else if(var2.getLineType() == dr.e) {
            var2.setLineType(dr.b);
         }

      }
   }
}
