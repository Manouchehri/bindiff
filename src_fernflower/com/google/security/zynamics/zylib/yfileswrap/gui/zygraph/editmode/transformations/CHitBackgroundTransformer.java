package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitBendsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgeLabelsTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitEdgesTransformer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations.CHitNodesTransformer;
import java.awt.event.MouseEvent;
import y.h.cW;

public class CHitBackgroundTransformer {
   public static IMouseStateChange exitBackground(CStateFactory var0, MouseEvent var1, AbstractZyGraph var2, IMouseState var3) {
      double var4 = var2.getEditMode().translateX(var1.getX());
      double var6 = var2.getEditMode().translateY(var1.getY());
      cW var8 = var2.getGraph().b(var4, var6);
      if(var8.t()) {
         return CHitNodesTransformer.enterNode(var0, var1, var8);
      } else if(var8.s()) {
         throw new IllegalStateException();
      } else {
         return (IMouseStateChange)(var8.u()?CHitEdgesTransformer.enterEdge(var0, var1, var8):(var8.r()?CHitEdgeLabelsTransformer.enterEdgeLabel(var0, var1, var8):(var8.v()?CHitBendsTransformer.enterBend(var0, var1, var8):(var8.q()?new CStateChange(var3, true):new CStateChange(var0.createDefaultState(), true)))));
      }
   }
}
