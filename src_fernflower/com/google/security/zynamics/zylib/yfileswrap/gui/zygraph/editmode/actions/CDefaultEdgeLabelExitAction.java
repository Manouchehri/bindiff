package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeLabelExitState;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.h.aB;

public class CDefaultEdgeLabelExitAction implements IStateAction {
   protected void unhighlightEdges(aB var1) {
      CEdgeHighlighter.highlightEdge(var1, false);
   }

   public void execute(CEdgeLabelExitState var1, MouseEvent var2) {
      this.unhighlightEdges(var1.getLabel().getOwner());
      if(var1.getLabel() != null) {
         this.unhighlightEdges(var1.getLabel().getOwner());
         Iterator var3 = var1.getStateFactory().getListeners().iterator();

         while(var3.hasNext()) {
            IZyEditModeListener var4 = (IZyEditModeListener)var3.next();

            try {
               var4.edgeLabelLeft(var1.getLabel());
            } catch (Exception var6) {
               ;
            }
         }
      }

      var1.getGraph().updateViews();
   }
}
