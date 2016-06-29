package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;

public class ZoomToNodeAction extends AbstractAction
{
    private final BinDiffGraph graph;
    private final ZyGraphNode node;
    
    public ZoomToNodeAction(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        super(getTitel(zyGraphNode));
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.node = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }
    
    private static String getTitel(final ZyGraphNode zyGraphNode) {
        if (zyGraphNode != null) {
            if (zyGraphNode.getRawNode() instanceof RawBasicBlock || zyGraphNode.getRawNode() instanceof RawCombinedBasicBlock) {
                return "Zoom to Basicblock";
            }
            if (zyGraphNode.getRawNode() instanceof RawFunction || zyGraphNode.getRawNode() instanceof RawCombinedFunction) {
                return "Zoom to Function";
            }
        }
        return "Zoom to Node";
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        GraphZoomer.zoomToNode(this.graph, this.node);
    }
}
