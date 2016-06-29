package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import java.util.Collection;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.q;
import y.f.X;
import y.f.ax;
import y.f.c.M;
import y.h.bu;

public class PortConstraints {
   private static Collection createLeftPorts(q var0, X var1) {
      double var2 = var1.p(var0) * 0.5D;
      double var4 = var1.q(var0) * 0.5D;
      D var6 = new D();
      var6.add(ax.a(-var2, -var4, 1));
      var6.add(ax.a(-var2, var4, 2));
      return var6;
   }

   private static Collection createMiddlePorts(q var0, X var1) {
      double var2 = var1.q(var0) * 0.5D;
      D var4 = new D();
      var4.add(ax.a(0.0D, -var2, 1));
      var4.add(ax.a(0.0D, var2, 2));
      return var4;
   }

   private static Collection createRightPorts(q var0, X var1) {
      double var2 = var1.p(var0) * 0.5D;
      double var4 = var1.q(var0) * 0.5D;
      D var6 = new D();
      var6.add(ax.a(var2, -var4, 1));
      var6.add(ax.a(var2, var4, 2));
      return var6;
   }

   public static void configureConstraints(CombinedGraph var0) {
      GraphLayoutSettings var1 = var0.getSettings().getLayoutSettings();
      if(var1.getCurrentLayouter() instanceof M && var1.getHierarchicOrientation() == ELayoutOrientation.HORIZONTAL) {
         bu var2 = var0.getGraph();
         h var3 = y.g.M.b();
         var2.a((Object)ax.a, (c)var3);
         h var4 = y.g.M.b();
         var2.a((Object)ax.b, (c)var4);

         for(e var5 = var2.p(); var5.f(); var5.g()) {
            d var6 = var5.a();
            CombinedDiffNode var7 = (CombinedDiffNode)var0.getNode(var6.c());
            CombinedDiffNode var8 = (CombinedDiffNode)var0.getNode(var6.d());
            if(var7 != null && var8 != null) {
               CombinedDiffEdge var9 = (CombinedDiffEdge)var0.getEdge(var6);
               EMatchState var10 = ((CombinedViewEdge)var9.getRawEdge()).getMatchState();
               if(var7.getPrimaryDiffNode() != null && var7.getSecondaryDiffNode() != null) {
                  if(var10 == EMatchState.MATCHED) {
                     var3.a(var6, createMiddlePorts(var6.c(), var2));
                  } else if(var10 == EMatchState.PRIMARY_UNMATCHED) {
                     var3.a(var6, createLeftPorts(var6.c(), var2));
                  } else {
                     var3.a(var6, createRightPorts(var6.c(), var2));
                  }
               } else {
                  var3.a(var6, createMiddlePorts(var6.c(), var2));
               }

               if(var8.getPrimaryDiffNode() != null && var8.getSecondaryDiffNode() != null) {
                  if(var10 == EMatchState.MATCHED) {
                     var4.a(var6, createMiddlePorts(var6.d(), var2));
                  } else if(var10 == EMatchState.PRIMARY_UNMATCHED) {
                     var4.a(var6, createLeftPorts(var6.d(), var2));
                  } else {
                     var4.a(var6, createRightPorts(var6.d(), var2));
                  }
               } else {
                  var4.a(var6, createMiddlePorts(var6.d(), var2));
               }
            } else {
               var3.a(var6, createMiddlePorts(var6.c(), var2));
               var4.a(var6, createMiddlePorts(var6.d(), var2));
            }
         }
      }

   }
}
