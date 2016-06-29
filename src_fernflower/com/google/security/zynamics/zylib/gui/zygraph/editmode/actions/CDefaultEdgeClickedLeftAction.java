package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeClickHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultEdgeClickedLeftAction implements IStateAction {
   protected void handleClick(CEdgeClickedLeftState var1, MouseEvent var2) {
      CEdgeClickHandler.handleEdgeClicks(var1.getGraph(), var1.getEdge(), var2);
   }

   public void execute(CEdgeClickedLeftState var1, MouseEvent var2) {
      this.handleClick(var1, var2);
   }
}
