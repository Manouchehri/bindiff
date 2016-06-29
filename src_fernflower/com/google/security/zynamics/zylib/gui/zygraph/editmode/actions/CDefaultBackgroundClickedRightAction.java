package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundClickedRightState;
import java.awt.event.MouseEvent;

public class CDefaultBackgroundClickedRightAction implements IStateAction {
   public void execute(CBackgroundClickedRightState var1, MouseEvent var2) {
      CMouseCursorHelper.setDefaultCursor(var1.getGraph());
   }
}
