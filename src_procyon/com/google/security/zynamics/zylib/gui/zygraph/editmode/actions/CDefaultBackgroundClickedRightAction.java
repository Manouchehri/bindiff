package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;

public class CDefaultBackgroundClickedRightAction implements IStateAction
{
    public void execute(final CBackgroundClickedRightState cBackgroundClickedRightState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cBackgroundClickedRightState.getGraph());
    }
}
