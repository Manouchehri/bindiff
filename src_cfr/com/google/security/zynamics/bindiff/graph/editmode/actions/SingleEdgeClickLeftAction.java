/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.eventhandlers.EdgeClickEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedLeftState;
import java.awt.event.MouseEvent;

public class SingleEdgeClickLeftAction
implements IStateAction {
    public void execute(CEdgeClickedLeftState cEdgeClickedLeftState, MouseEvent mouseEvent) {
        EdgeClickEventHandler.handleEdgeClicks(cEdgeClickedLeftState.getGraph(), cEdgeClickedLeftState.getEdge(), mouseEvent);
    }
}

