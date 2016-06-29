package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.*;
import y.c.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;

public class CDefaultNodeExitAction implements IStateAction
{
    protected void clearTooltip(final AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().setToolTipText(null);
    }
    
    protected void unhighlightEdges(final q q) {
        CEdgeHighlighter.highlightEdgesOfNode(q, false);
    }
    
    protected void unhighlightNode(final q q) {
        CNodeHighlighter.highlightNode(q, false);
    }
    
    public void execute(final CNodeExitState cNodeExitState, final MouseEvent mouseEvent) {
        this.clearTooltip(cNodeExitState.getGraph());
        if (cNodeExitState.getNode().e() != null) {
            this.unhighlightNode(cNodeExitState.getNode());
            this.unhighlightEdges(cNodeExitState.getNode());
        }
        final ZyGraphNode node = cNodeExitState.getGraph().getNode(cNodeExitState.getNode());
        if (node != null) {
            for (final IZyEditModeListener zyEditModeListener : cNodeExitState.getStateFactory().getListeners()) {
                try {
                    zyEditModeListener.nodeLeft(node);
                }
                catch (Exception ex) {}
            }
        }
        cNodeExitState.getGraph().updateViews();
    }
}
