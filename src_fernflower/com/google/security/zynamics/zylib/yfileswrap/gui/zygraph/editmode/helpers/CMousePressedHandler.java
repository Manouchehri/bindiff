package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.CStateChange;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import y.c.d;
import y.c.q;
import y.h.cW;
import y.h.x;

public class CMousePressedHandler {
   public static IMouseStateChange handleMousePressed(CStateFactory var0, IMouseState var1, AbstractZyGraph var2, MouseEvent var3) {
      double var4 = var2.getEditMode().translateX(var3.getX());
      double var6 = var2.getEditMode().translateY(var3.getY());
      cW var8 = var2.getGraph().b(var4, var6);
      if(!var8.t()) {
         if(var8.s()) {
            throw new IllegalStateException("yFiles Labels are not in use...");
         } else if(var8.u()) {
            d var11 = var8.k();
            return SwingUtilities.isLeftMouseButton(var3)?new CStateChange(var0.createEdgePressedLeftState(var11, var3), true):(SwingUtilities.isRightMouseButton(var3)?new CStateChange(var0.createEdgePressedRightState(var11, var3), true):new CStateChange(var1, true));
         } else if(var8.r()) {
            return new CStateChange(var1, true);
         } else if(var8.v()) {
            x var10 = var8.j();
            return SwingUtilities.isLeftMouseButton(var3)?new CStateChange(var0.createBendPressedLeftState(var10, var3), true):new CStateChange(var1, true);
         } else {
            return var8.q()?new CStateChange(var0.createDefaultState(), true):(SwingUtilities.isLeftMouseButton(var3)?new CStateChange(var0.createBackgroundPressedLeftState(var3), true):(SwingUtilities.isRightMouseButton(var3)?new CStateChange(var0.createBackgroundPressedRightState(var3), true):new CStateChange(var0.createDefaultState(), true)));
         }
      } else {
         q var9 = var8.i();
         return SwingUtilities.isLeftMouseButton(var3) && !var3.isAltDown()?new CStateChange(var0.createNodePressedLeftState(var9, var3), true):(SwingUtilities.isRightMouseButton(var3)?new CStateChange(var0.createNodePressedRightState(var9, var3), true):(!SwingUtilities.isMiddleMouseButton(var3) && (!var3.isAltDown() || !SwingUtilities.isLeftMouseButton(var3))?new CStateChange(var1, true):new CStateChange(var0.createNodePressedMiddleState(var9, var3), false)));
      }
   }
}
