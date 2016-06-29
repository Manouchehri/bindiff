package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.h.aA;
import y.h.cW;

public class CHitEdgeLabelsTransformer {
   public static CStateChange changeEdgeLabel(CStateFactory var0, MouseEvent var1, cW var2, aA var3) {
      aA var4 = var2.m();
      if(var4 == var3) {
         return new CStateChange(var0.createEdgeLabelHoverState(var4, var1), true);
      } else {
         var0.createEdgeLabelExitState(var3, var1);
         return new CStateChange(var0.createEdgeLabelEnterState(var4, var1), true);
      }
   }

   public static IMouseStateChange enterEdgeLabel(CStateFactory var0, MouseEvent var1, cW var2) {
      aA var3 = var2.m();
      return new CStateChange(var0.createEdgeLabelEnterState(var3, var1), true);
   }
}
