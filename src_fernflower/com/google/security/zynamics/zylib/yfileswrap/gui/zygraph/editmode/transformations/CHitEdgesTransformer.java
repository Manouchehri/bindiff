package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.cW;

public class CHitEdgesTransformer {
   public static IMouseStateChange changeEdge(CStateFactory var0, MouseEvent var1, cW var2, d var3) {
      d var4 = var2.k();
      if(var4 == var3) {
         return new CStateChange(var0.createEdgeHoverState(var4, var1), true);
      } else {
         var0.createEdgeExitState(var3, var1);
         return new CStateChange(var0.createEdgeEnterState(var4, var1), true);
      }
   }

   public static IMouseStateChange enterEdge(CStateFactory var0, MouseEvent var1, cW var2) {
      d var3 = var2.k();
      return new CStateChange(var0.createEdgeEnterState(var3, var1), true);
   }

   public static IMouseStateChange exitEdge(CStateFactory var0, MouseEvent var1, cW var2, IMouseState var3) {
      if(var2.t()) {
         return CHitNodesTransformer.enterNode(var0, var1, var2);
      } else if(var2.s()) {
         throw new IllegalStateException();
      } else {
         return (IMouseStateChange)(var2.r()?CHitEdgeLabelsTransformer.enterEdgeLabel(var0, var1, var2):(var2.v()?CHitBendsTransformer.enterBend(var0, var1, var2):(var2.q()?new CStateChange(var3, true):new CStateChange(var0.createDefaultState(), true))));
      }
   }
}
