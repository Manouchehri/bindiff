/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.CStateFactory;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CEdgeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeHighlighter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeExitState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.List;
import y.c.i;
import y.c.q;
import y.h.ch;

public class CDefaultNodeExitAction
implements IStateAction {
    protected void clearTooltip(AbstractZyGraph abstractZyGraph) {
        abstractZyGraph.getView().setToolTipText(null);
    }

    protected void unhighlightEdges(q q2) {
        CEdgeHighlighter.highlightEdgesOfNode(q2, false);
    }

    protected void unhighlightNode(q q2) {
        CNodeHighlighter.highlightNode(q2, false);
    }

    public void execute(CNodeExitState cNodeExitState, MouseEvent mouseEvent) {
        ZyGraphNode zyGraphNode;
        this.clearTooltip(cNodeExitState.getGraph());
        if (cNodeExitState.getNode().e() != null) {
            this.unhighlightNode(cNodeExitState.getNode());
            this.unhighlightEdges(cNodeExitState.getNode());
        }
        if ((zyGraphNode = cNodeExitState.getGraph().getNode(cNodeExitState.getNode())) != null) {
            for (IZyEditModeListener iZyEditModeListener : cNodeExitState.getStateFactory().getListeners()) {
                try {
                    iZyEditModeListener.nodeLeft(zyGraphNode);
                }
                catch (Exception var6_6) {}
            }
        }
        cNodeExitState.getGraph().updateViews();
    }
}

