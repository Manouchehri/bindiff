package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgePressedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultEdgePressedLeftAction implements IStateAction {
   public void execute(CEdgePressedLeftState var1, MouseEvent var2) {
      if(var1.getGraph().getEditMode().getLabelEventHandler().isActive()) {
         CEditNodeHelper.removeCaret(var1.getGraph());
      }

   }
}
