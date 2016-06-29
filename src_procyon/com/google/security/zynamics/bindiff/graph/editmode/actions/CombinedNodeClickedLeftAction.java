package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.*;

public class CombinedNodeClickedLeftAction implements IStateAction
{
    public void execute(final CNodeClickedLeftState cNodeClickedLeftState, final MouseEvent mouseEvent) {
        new CDefaultNodeClickedLeftAction().execute(cNodeClickedLeftState, mouseEvent);
    }
}
