package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;

public class CDefaultNodeEnterAction implements IStateAction
{
    protected void highlightEdges(final q q) {
        CEdgeHighlighter.highlightEdgesOfNode(q, true);
    }
    
    protected void highlightNode(final q q) {
        CNodeHighlighter.highlightNode(q, true);
    }
    
    protected void updateTooltip(final AbstractZyGraph abstractZyGraph, final q q) {
        CTooltipUpdater.updateNodeTooltip(abstractZyGraph, q);
    }
    
    public void execute(final CNodeEnterState cNodeEnterState, final MouseEvent mouseEvent) {
        this.highlightNode(cNodeEnterState.getNode());
        this.highlightEdges(cNodeEnterState.getNode());
        this.updateTooltip(cNodeEnterState.getGraph(), cNodeEnterState.getNode());
        final AbstractZyGraph graph = cNodeEnterState.getGraph();
        final ZyGraphNode node = graph.getNode(cNodeEnterState.getNode());
        for (final IZyEditModeListener zyEditModeListener : cNodeEnterState.getStateFactory().getListeners()) {
            try {
                zyEditModeListener.nodeEntered(node, mouseEvent);
            }
            catch (Exception ex) {}
        }
        graph.updateViews();
    }
}
