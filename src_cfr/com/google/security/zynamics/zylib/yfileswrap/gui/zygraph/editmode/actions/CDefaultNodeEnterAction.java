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
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CTooltipUpdater;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeEnterState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import y.c.q;

public class CDefaultNodeEnterAction
implements IStateAction {
    protected void highlightEdges(q q2) {
        CEdgeHighlighter.highlightEdgesOfNode(q2, true);
    }

    protected void highlightNode(q q2) {
        CNodeHighlighter.highlightNode(q2, true);
    }

    protected void updateTooltip(AbstractZyGraph abstractZyGraph, q q2) {
        CTooltipUpdater.updateNodeTooltip(abstractZyGraph, q2);
    }

    public void execute(CNodeEnterState cNodeEnterState, MouseEvent mouseEvent) {
        this.highlightNode(cNodeEnterState.getNode());
        this.highlightEdges(cNodeEnterState.getNode());
        this.updateTooltip(cNodeEnterState.getGraph(), cNodeEnterState.getNode());
        AbstractZyGraph abstractZyGraph = cNodeEnterState.getGraph();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(cNodeEnterState.getNode());
        Iterator iterator = cNodeEnterState.getStateFactory().getListeners().iterator();
        do {
            if (!iterator.hasNext()) {
                abstractZyGraph.updateViews();
                return;
            }
            IZyEditModeListener iZyEditModeListener = (IZyEditModeListener)iterator.next();
            try {
                iZyEditModeListener.nodeEntered(zyGraphNode, mouseEvent);
            }
            catch (Exception var7_7) {
            }
        } while (true);
    }
}

