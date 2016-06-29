package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public class CDefaultBendPressedLeftAction implements IStateAction
{
    public void execute(final CBendPressedLeftState cBendPressedLeftState, final MouseEvent mouseEvent) {
        if (cBendPressedLeftState.getGraph().getEditMode().getLabelEventHandler().isActive()) {
            CEditNodeHelper.removeCaret(cBendPressedLeftState.getGraph());
        }
    }
}
