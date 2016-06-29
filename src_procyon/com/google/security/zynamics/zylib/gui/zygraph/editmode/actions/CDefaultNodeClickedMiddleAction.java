package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public class CDefaultNodeClickedMiddleAction implements IStateAction
{
    public void execute(final CNodeClickedMiddleState cNodeClickedMiddleState, final MouseEvent mouseEvent) {
        CEditNodeHelper.setCaretStart(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
        CEditNodeHelper.setCaretEnd(cNodeClickedMiddleState.getGraph(), cNodeClickedMiddleState.getNode(), mouseEvent);
    }
}
