package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;

public class CDefaultEdgeClickedLeftAction implements IStateAction
{
    protected void handleClick(final CEdgeClickedLeftState cEdgeClickedLeftState, final MouseEvent mouseEvent) {
        CEdgeClickHandler.handleEdgeClicks(cEdgeClickedLeftState.getGraph(), cEdgeClickedLeftState.getEdge(), mouseEvent);
    }
    
    public void execute(final CEdgeClickedLeftState cEdgeClickedLeftState, final MouseEvent mouseEvent) {
        this.handleClick(cEdgeClickedLeftState, mouseEvent);
    }
}
