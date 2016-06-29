/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.editmode.actions;

import com.google.security.zynamics.bindiff.graph.editmode.helpers.EditCombinedNodeHelper;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IStateAction;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.helpers.CMouseCursorHelper;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphLayeredRenderer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers.CNodeMover;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.states.CNodeDraggedLeftState;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import y.c.q;
import y.h.cd;
import y.h.ch;

public class CombinedNodeDraggedLeftAction
implements IStateAction {
    protected void moveToFront(ZyGraphLayeredRenderer zyGraphLayeredRenderer, q q2) {
        zyGraphLayeredRenderer.bringNodeToFront(q2);
    }

    public void execute(CNodeDraggedLeftState cNodeDraggedLeftState, MouseEvent mouseEvent) {
        this.moveToFront((ZyGraphLayeredRenderer)cNodeDraggedLeftState.getGraph().getView().getGraph2DRenderer(), cNodeDraggedLeftState.getNode());
        AbstractZyGraph abstractZyGraph = cNodeDraggedLeftState.getGraph();
        CMouseCursorHelper.setHandCursor(abstractZyGraph);
        HashSet hashSet = new HashSet();
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(cNodeDraggedLeftState.getNode());
        ZyLabelContent zyLabelContent = zyGraphNode.getRealizer().getNodeContent();
        if (abstractZyGraph.getEditMode().getLabelEventHandler().isActiveLabel(zyLabelContent)) {
            EditCombinedNodeHelper.setCaretEnd(abstractZyGraph, cNodeDraggedLeftState.getNode(), mouseEvent);
            EditCombinedNodeHelper.select(abstractZyGraph, cNodeDraggedLeftState.getNode(), mouseEvent);
        } else if (zyGraphNode.isSelected()) {
            for (ZyGraphNode zyGraphNode2 : abstractZyGraph.getSelectedNodes()) {
                CNodeMover.moveNode(abstractZyGraph, zyGraphNode2, cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY(), hashSet);
            }
        } else {
            CNodeMover.moveNode(abstractZyGraph, zyGraphNode, cNodeDraggedLeftState.getDistanceX(), cNodeDraggedLeftState.getDistanceY(), hashSet);
        }
        abstractZyGraph.updateViews();
    }
}

