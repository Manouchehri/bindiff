package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.editmode.helpers.EditCombinedNodeHelper;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedMiddleState;
import java.awt.event.MouseEvent;

public class CombinedNodeClickedMiddleAction implements IStateAction {
   public void execute(CNodeClickedMiddleState var1, MouseEvent var2) {
      EditCombinedNodeHelper.setActiveLabelContent((CombinedGraph)var1.getGraph(), var1.getNode(), var2);
      EditCombinedNodeHelper.setCaretStart(var1.getGraph(), var1.getNode(), var2);
      EditCombinedNodeHelper.setCaretEnd(var1.getGraph(), var1.getNode(), var2);
   }
}
