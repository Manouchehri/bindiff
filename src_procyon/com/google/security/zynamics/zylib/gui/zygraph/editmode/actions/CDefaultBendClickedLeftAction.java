package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.*;

public class CDefaultBendClickedLeftAction implements IStateAction
{
    public void execute(final CBendClickedLeftState cBendClickedLeftState, final MouseEvent mouseEvent) {
        CMouseCursorHelper.setDefaultCursor(cBendClickedLeftState.getGraph());
    }
}
