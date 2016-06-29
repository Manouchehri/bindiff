package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEditNodeHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeClickedMiddleState;
import java.awt.event.MouseEvent;

public class CDefaultNodeClickedMiddleAction implements IStateAction {
   public void execute(CNodeClickedMiddleState var1, MouseEvent var2) {
      CEditNodeHelper.setCaretStart(var1.getGraph(), var1.getNode(), var2);
      CEditNodeHelper.setCaretEnd(var1.getGraph(), var1.getNode(), var2);
   }
}
