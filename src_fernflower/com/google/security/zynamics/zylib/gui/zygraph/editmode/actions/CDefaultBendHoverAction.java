package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CBendHoverState;
import java.awt.event.MouseEvent;

public class CDefaultBendHoverAction implements IStateAction {
   public void execute(CBendHoverState var1, MouseEvent var2) {
      CMouseCursorHelper.setHandCursor(var1.getGraph());
   }
}
