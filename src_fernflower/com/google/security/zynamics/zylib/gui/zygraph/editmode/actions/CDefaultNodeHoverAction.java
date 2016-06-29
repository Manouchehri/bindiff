package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeHoverState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class CDefaultNodeHoverAction implements IStateAction {
   public void execute(CNodeHoverState var1, MouseEvent var2) {
      AbstractZyGraph var3 = var1.getGraph();
      CMouseCursorHelper.setDefaultCursor(var3);
      double var4 = var3.getEditMode().translateX(var2.getX());
      double var6 = var3.getEditMode().translateY(var2.getY());
      ZyGraphNode var8 = var3.getNode(var1.getNode());
      if(var8 != null) {
         Iterator var9 = var1.getStateFactory().getListeners().iterator();

         while(var9.hasNext()) {
            IZyEditModeListener var10 = (IZyEditModeListener)var9.next();

            try {
               var10.nodeHovered(var8, var4, var6);
            } catch (Exception var12) {
               ;
            }
         }
      }

   }
}
