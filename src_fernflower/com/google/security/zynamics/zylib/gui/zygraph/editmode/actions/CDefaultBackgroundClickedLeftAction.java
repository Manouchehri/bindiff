package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundClickedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.event.MouseEvent;

public class CDefaultBackgroundClickedLeftAction implements IStateAction {
   protected void unselectAll(AbstractZyGraph var1) {
      var1.selectNodes(var1.getNodes(), false);
   }

   public void execute(CBackgroundClickedLeftState var1, MouseEvent var2) {
      this.unselectAll(var1.getGraph());
   }
}
