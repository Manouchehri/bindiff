package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.states.*;
import java.awt.event.*;

public class CDefaultBackgroundClickedLeftAction implements IStateAction
{
    protected void unselectAll(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.selectNodes(abstractZyGraph.getNodes(), false);
    }
    
    public void execute(final CBackgroundClickedLeftState cBackgroundClickedLeftState, final MouseEvent mouseEvent) {
        this.unselectAll(cBackgroundClickedLeftState.getGraph());
    }
}
