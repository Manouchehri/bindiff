package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

public class ProximityBrowserUnhideNode implements ICommand
{
    private final BinDiffGraph graph;
    private final ZyGraphNode nodeToShow;
    
    public ProximityBrowserUnhideNode(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.nodeToShow = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }
    
    private static void updateVisibility(final BinDiffGraph binDiffGraph, final Set set) {
        for (final ZyGraphNode zyGraphNode : set) {
            if (zyGraphNode.isVisible()) {
                continue;
            }
            if (zyGraphNode instanceof SingleDiffNode) {
                final q node = ((SingleDiffNode)zyGraphNode).getCombinedDiffNode().getNode();
                final q node2 = ((SingleDiffNode)zyGraphNode).getSuperDiffNode().getNode();
                if (!((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(node)).getRawNode().isVisible()) {
                    ((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(node)).getRawNode().setVisible(true);
                }
                if (((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(node2)).getRawNode().isVisible()) {
                    continue;
                }
                ((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(node2)).getRawNode().setVisible(true);
            }
            else {
                if (!(zyGraphNode instanceof CombinedDiffNode)) {
                    continue;
                }
                final q node3 = ((CombinedDiffNode)zyGraphNode).getNode();
                final q node4 = ((CombinedDiffNode)zyGraphNode).getSuperDiffNode().getNode();
                if (!((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(node3)).getRawNode().isVisible()) {
                    ((CombinedDiffNode)binDiffGraph.getCombinedGraph().getNode(node3)).getRawNode().setVisible(true);
                }
                if (((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(node4)).getRawNode().isVisible()) {
                    continue;
                }
                ((SuperDiffNode)binDiffGraph.getSuperGraph().getNode(node4)).getRawNode().setVisible(true);
            }
        }
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        final HashSet<ZyGraphNode> set = new HashSet<ZyGraphNode>();
        set.add(zyGraphNode);
        final GraphProximityBrowsingSettings proximitySettings = binDiffGraph.getSettings().getProximitySettings();
        updateVisibility(binDiffGraph, ProximityRangeCalculator.getNeighbors(binDiffGraph, set, proximitySettings.getProximityBrowsingChildren(), proximitySettings.getProximityBrowsingParents()));
        ProximityNodeClickedUpdater.updateProximityNodes(binDiffGraph);
        GraphViewUpdater.updateViews(binDiffGraph);
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (LayoutCommandHelper.isAutolayout(binDiffGraph)) {
            GraphLayoutUpdater.executeStatic(binDiffGraph, true);
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.graph, this.nodeToShow);
    }
}
