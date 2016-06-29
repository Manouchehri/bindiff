package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;

public class CDefaultBackgroundDraggedRightAction implements IStateAction
{
    public void execute(final CBackgroundDraggedRightState cBackgroundDraggedRightState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setMoveCursor(cBackgroundDraggedRightState.getGraph());
    }
}
