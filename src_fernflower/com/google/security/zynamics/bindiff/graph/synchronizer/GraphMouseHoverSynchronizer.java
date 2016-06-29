package com.google.security.zynamics.bindiff.graph.synchronizer;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import java.util.HashSet;
import y.c.d;
import y.c.e;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public class GraphMouseHoverSynchronizer {
   private static void highlightEdge(d var0) {
      aB var1 = ((bu)var0.a()).i(var0);
      dr var2 = var1.getLineType();
      if(var2 == dr.b) {
         var1.setLineType(dr.e);
      } else if(var2 == dr.i) {
         var1.setLineType(dr.l);
      } else if(var2 == dr.n) {
         var1.setLineType(dr.q);
      } else if(var2 == dr.e) {
         var1.setLineType(dr.b);
      } else if(var2 == dr.l) {
         var1.setLineType(dr.i);
      } else if(var2 == dr.q) {
         var1.setLineType(dr.n);
      }

   }

   public static void adoptHoveredNodeState(SingleGraph var0, SingleDiffNode var1) {
      if(var0.getSettings().isSync()) {
         SingleDiffNode var2 = var1.getOtherSideDiffNode();
         if(var2 != null) {
            fj var3 = var1.getRealizer().getRealizer();
            fj var4 = var2.getRealizer().getRealizer();
            var4.setLineType(var3.getLineType());
            HashSet var5 = new HashSet();
            e var6 = var2.getNode().j();

            while(var6.f()) {
               if(!var5.contains(var6.a())) {
                  highlightEdge(var6.a());
               }

               var5.add(var6.a());
               var6.g();
            }
         }

         var0.getSecondaryGraph().updateViews();
         var0.getPrimaryGraph().updateViews();
      }

   }
}
