package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.eventhandlers.EdgeClickEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedLeftState;
import java.awt.event.MouseEvent;

public class SingleEdgeClickLeftAction implements IStateAction {
   public void execute(CEdgeClickedLeftState var1, MouseEvent var2) {
      EdgeClickEventHandler.handleEdgeClicks(var1.getGraph(), var1.getEdge(), var2);
   }
}
