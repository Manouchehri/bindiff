package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEditExitState;
import java.awt.event.MouseEvent;

public class CDefaultNodeEditExitAction implements IStateAction {
   public void execute(CNodeEditExitState var1, MouseEvent var2) {
      CEditNodeHelper.removeCaret(var1.getGraph());
   }
}
