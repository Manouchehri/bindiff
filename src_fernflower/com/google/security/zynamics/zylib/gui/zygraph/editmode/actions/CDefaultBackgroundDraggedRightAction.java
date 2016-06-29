package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.CBackgroundDraggedRightState;
import java.awt.event.MouseEvent;

public class CDefaultBackgroundDraggedRightAction implements IStateAction {
   public void execute(CBackgroundDraggedRightState var1, MouseEvent var2) {
      CMouseCursorHelper.setMoveCursor(var1.getGraph());
   }
}
