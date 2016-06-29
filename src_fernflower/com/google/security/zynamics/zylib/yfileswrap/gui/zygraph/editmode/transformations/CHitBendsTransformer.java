package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.transformations;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import y.h.cW;
import y.h.x;

public class CHitBendsTransformer {
   public static CStateChange changeBend(CStateFactory var0, MouseEvent var1, cW var2, x var3) {
      x var4 = var2.j();
      if(var4 == var3) {
         return new CStateChange(var0.createBendHoverState(var4, var1), true);
      } else {
         var0.createBendExitState(var3, var1);
         return new CStateChange(var0.createBendEnterState(var4, var1), true);
      }
   }

   public static IMouseStateChange enterBend(CStateFactory var0, MouseEvent var1, cW var2) {
      x var3 = var2.j();
      return new CStateChange(var0.createBendEnterState(var3, var1), true);
   }
}
