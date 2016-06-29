/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.helpers.GraphElementMover;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.actions.CDefaultNodeDraggedLeftAction;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeDraggedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import y.c.q;
import y.h.cd;
import y.h.ch;

public class SingleGraphNodeDraggedLeftAction
implements IStateAction {
    protected void moveToFront(ZyGraphLayeredRenderer zyGraphLayeredRenderer, q q2) {
        zyGraphLayeredRenderer.bringNodeToFront(q2);
    }

    public void execute(CNodeDraggedLeftState cNodeDraggedLeftState, MouseEvent mouseEvent) {
        new CDefaultNodeDraggedLeftAction().execute(cNodeDraggedLeftState, mouseEvent);
        AbstractZyGraph abstractZyGraph = cNodeDraggedLeftState.getGraph();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(cNodeDraggedLeftState.getNode());
        ZyLabelContent zyLabelContent = zyGraphNode.getRealizer().getNodeContent();
        if (abstractZyGraph.getEditMode().getLabelEventHandler().isActiveLabel(zyLabelContent)) return;
        q q2 = cNodeDraggedLeftState.getNode();
        this.moveToFront((ZyGraphLayeredRenderer)abstractZyGraph.getView().getGraph2DRenderer(), q2);
        GraphElementMover.moveNodes(abstractZyGraph, q2, cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY());
    }
}

