package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedRightState;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class CDefaultEdgeClickedRightAction implements IStateAction {
   public void execute(CEdgeClickedRightState var1, MouseEvent var2) {
      CMouseCursorHelper.setDefaultCursor(var1.getGraph());
      AbstractZyGraph var3 = var1.getGraph();
      ZyGraphEdge var4 = var1.getEdge();
      if(!(var4 instanceof ZyInfoEdge)) {
         double var5 = var3.getEditMode().translateX(var2.getX());
         double var7 = var3.getEditMode().translateY(var2.getY());
         Iterator var9 = var1.getStateFactory().getListeners().iterator();

         while(var9.hasNext()) {
            IZyEditModeListener var10 = (IZyEditModeListener)var9.next();

            try {
               var10.edgeClicked(var4, var2, var5, var7);
            } catch (Exception var12) {
               ;
            }
         }

      }
   }
}
