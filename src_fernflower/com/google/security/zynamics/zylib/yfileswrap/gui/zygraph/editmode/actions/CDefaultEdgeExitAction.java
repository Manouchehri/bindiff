package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeExitState;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.bu;

public class CDefaultEdgeExitAction implements IStateAction {
   protected void clearTooltip(AbstractZyGraph var1) {
      var1.getView().setToolTipText((String)null);
   }

   protected void unhighlightEdge(d var1) {
      CEdgeHighlighter.highlightEdge(((bu)var1.a()).i(var1), false);
   }

   public void execute(CEdgeExitState var1, MouseEvent var2) {
      this.clearTooltip(var1.getGraph());
      if(var1.getEdge().a() != null) {
         this.unhighlightEdge(var1.getEdge());
      }

      var1.getGraph().updateViews();
   }
}
