/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeClickHandler;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CEdgeClickedLeftState;
import java.awt.event.MouseEvent;

public class CDefaultEdgeClickedLeftAction
implements IStateAction {
    protected void handleClick(CEdgeClickedLeftState cEdgeClickedLeftState, MouseEvent mouseEvent) {
        CEdgeClickHandler.handleEdgeClicks(cEdgeClickedLeftState.getGraph(), cEdgeClickedLeftState.getEdge(), mouseEvent);
    }

    public void execute(CEdgeClickedLeftState cEdgeClickedLeftState, MouseEvent mouseEvent) {
        this.handleClick(cEdgeClickedLeftState, mouseEvent);
    }
}

