package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public class CDefaultNodeEditExitAction implements IStateAction
{
    public void execute(final CNodeEditExitState cNodeEditExitState, final MouseEvent mouseEvent) {
        CEditNodeHelper.removeCaret(cNodeEditExitState.getGraph());
    }
}
