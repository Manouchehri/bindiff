package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeEnterState;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.bu;

public class CDefaultEdgeEnterAction implements IStateAction {
   protected void highlightEdge(d var1) {
      CEdgeHighlighter.highlightEdge(((bu)var1.a()).i(var1), true);
   }

   protected void updateTooltip(AbstractZyGraph var1, d var2) {
      CTooltipUpdater.updateEdgeTooltip(var1, var2);
   }

   public void execute(CEdgeEnterState var1, MouseEvent var2) {
      this.highlightEdge(var1.getEdge());
      this.updateTooltip(var1.getGraph(), var1.getEdge());
      var1.getGraph().updateViews();
   }
}
