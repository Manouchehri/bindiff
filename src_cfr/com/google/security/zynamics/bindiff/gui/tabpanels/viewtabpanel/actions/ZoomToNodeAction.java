/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ZoomToNodeAction
extends AbstractAction {
    private final BinDiffGraph graph;
    private final ZyGraphNode node;

    public ZoomToNodeAction(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        super(ZoomToNodeAction.getTitel(zyGraphNode));
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.node = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }

    private static String getTitel(ZyGraphNode zyGraphNode) {
        if (zyGraphNode == null) return "Zoom to Node";
        if (zyGraphNode.getRawNode() instanceof RawBasicBlock) return "Zoom to Basicblock";
        if (zyGraphNode.getRawNode() instanceof RawCombinedBasicBlock) {
            return "Zoom to Basicblock";
        }
        if (zyGraphNode.getRawNode() instanceof RawFunction) return "Zoom to Function";
        if (!(zyGraphNode.getRawNode() instanceof RawCombinedFunction)) return "Zoom to Node";
        return "Zoom to Function";
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GraphZoomer.zoomToNode(this.graph, this.node);
    }
}

