package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;

public class SingleEdgeClickLeftAction implements IStateAction
{
    public void execute(final CEdgeClickedLeftState cEdgeClickedLeftState, final MouseEvent mouseEvent) {
        EdgeClickEventHandler.handleEdgeClicks(cEdgeClickedLeftState.getGraph(), cEdgeClickedLeftState.getEdge(), mouseEvent);
    }
}
