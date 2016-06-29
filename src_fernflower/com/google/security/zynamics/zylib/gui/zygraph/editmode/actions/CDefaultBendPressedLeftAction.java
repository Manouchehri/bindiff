package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendPressedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultBendPressedLeftAction implements IStateAction {
   public void execute(CBendPressedLeftState var1, MouseEvent var2) {
      if(var1.getGraph().getEditMode().getLabelEventHandler().isActive()) {
         CEditNodeHelper.removeCaret(var1.getGraph());
      }

   }
}
