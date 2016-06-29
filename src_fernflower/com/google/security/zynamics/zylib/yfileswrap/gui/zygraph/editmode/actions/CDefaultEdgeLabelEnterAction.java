package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelEnterState;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.h.aA;

public class CDefaultEdgeLabelEnterAction implements IStateAction {
   protected void highlightEdge(aA var1) {
      CEdgeHighlighter.highlightEdge(var1.getOwner(), true);
   }

   public void execute(CEdgeLabelEnterState var1, MouseEvent var2) {
      this.highlightEdge(var1.getLabel());
      AbstractZyGraph var3 = var1.getGraph();
      aA var4 = var1.getLabel();
      Iterator var5 = var1.getStateFactory().getListeners().iterator();

      while(var5.hasNext()) {
         IZyEditModeListener var6 = (IZyEditModeListener)var5.next();

         try {
            var6.edgeLabelEntered(var4, var2);
         } catch (Exception var8) {
            ;
         }
      }

      var3.updateViews();
   }
}
