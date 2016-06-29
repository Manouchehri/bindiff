package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public class CDefaultEdgePressedLeftAction implements IStateAction
{
    public void execute(final CEdgePressedLeftState cEdgePressedLeftState, final MouseEvent mouseEvent) {
        if (cEdgePressedLeftState.getGraph().getEditMode().getLabelEventHandler().isActive()) {
            CEditNodeHelper.removeCaret(cEdgePressedLeftState.getGraph());
        }
    }
}
