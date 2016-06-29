package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeClickedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedLeftState;
import java.awt.event.MouseEvent;

public class CombinedNodeClickedLeftAction implements IStateAction {
   public void execute(CNodeClickedLeftState var1, MouseEvent var2) {
      (new CDefaultNodeClickedLeftAction()).execute(var1, var2);
   }
}
