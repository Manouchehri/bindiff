package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.cW;

public final class CHitNodesTransformer {
   public static CStateChange changeNode(CStateFactory var0, MouseEvent var1, cW var2, q var3) {
      q var4 = var2.i();
      if(var4 == var3) {
         return new CStateChange(var0.createNodeHoverState(var4, var1), false);
      } else {
         var0.createNodeExitState(var3, var1);
         return new CStateChange(var0.createNodeEnterState(var4, var1), true);
      }
   }

   public static IMouseStateChange enterNode(CStateFactory var0, MouseEvent var1, cW var2) {
      q var3 = var2.i();
      return new CStateChange(var0.createNodeEnterState(var3, var1), true);
   }

   public static IMouseStateChange exitNode(CStateFactory var0, MouseEvent var1, cW var2, IMouseState var3) {
      if(var2.s()) {
         throw new IllegalStateException();
      } else {
         return (IMouseStateChange)(var2.u()?CHitEdgesTransformer.enterEdge(var0, var1, var2):(var2.r()?CHitEdgeLabelsTransformer.enterEdgeLabel(var0, var1, var2):(var2.v()?CHitBendsTransformer.enterBend(var0, var1, var2):(var2.q()?new CStateChange(var3, true):new CStateChange(var0.createDefaultState(), false)))));
      }
   }
}
