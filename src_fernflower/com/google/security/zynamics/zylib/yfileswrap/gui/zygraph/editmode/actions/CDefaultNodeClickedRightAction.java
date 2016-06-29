package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedRightState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.c.q;

public class CDefaultNodeClickedRightAction implements IStateAction {
   public void execute(CNodeClickedRightState var1, MouseEvent var2) {
      CMouseCursorHelper.setDefaultCursor(var1.getGraph());
      AbstractZyGraph var3 = var1.getGraph();
      q var4 = var1.getNode();
      ZyGraphNode var5 = var3.getNode(var4);
      double var6 = var3.getEditMode().translateX(var2.getX());
      double var8 = var3.getEditMode().translateY(var2.getY());
      if(var3.getEditMode().getLabelEventHandler().isActive() && var3.getEditMode().getLabelEventHandler().hasEmptySelection()) {
         CEditNodeHelper.removeCaret(var3);
      }

      if(var5 == null) {
         ZyProximityNode var10 = ProximityHelper.getProximityNode(var3.getGraph(), var4);
         Iterator var11 = var1.getStateFactory().getListeners().iterator();

         while(var11.hasNext()) {
            IZyEditModeListener var12 = (IZyEditModeListener)var11.next();

            try {
               var12.proximityBrowserNodeClicked(var10, var2, var6, var8);
            } catch (Exception var15) {
               ;
            }
         }
      } else {
         Iterator var16 = var1.getStateFactory().getListeners().iterator();

         while(var16.hasNext()) {
            IZyEditModeListener var17 = (IZyEditModeListener)var16.next();

            try {
               var17.nodeClicked(var5, var2, var6, var8);
            } catch (Exception var14) {
               ;
            }
         }
      }

   }
}
