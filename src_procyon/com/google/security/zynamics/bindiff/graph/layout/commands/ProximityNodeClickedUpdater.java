package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.layout.*;

public final class ProximityNodeClickedUpdater implements ICommand
{
    private final BinDiffGraph graph;
    private final ZyProximityNode proximityNode;
    
    public ProximityNodeClickedUpdater(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.proximityNode = (ZyProximityNode)Preconditions.checkNotNull(zyProximityNode);
    }
    
    private static Set getNodesToShow(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        final q node = zyProximityNode.getNode();
        final HashSet<ZyGraphNode> set = new HashSet<ZyGraphNode>();
        final ZyGraphNode node2 = binDiffGraph.getNode(node.m().e());
        if (zyProximityNode.indegree() == 1) {
            for (final ZyGraphNode zyGraphNode : node2.getChildren()) {
                if (!zyGraphNode.isVisible() && !ProximityHelper.isProximityNode(binDiffGraph.getGraph(), zyGraphNode.getNode())) {
                    set.add(zyGraphNode);
                }
            }
        }
        if (zyProximityNode.outdegree() == 1) {
            for (final ZyGraphNode zyGraphNode2 : node2.getParents()) {
                if (!zyGraphNode2.isVisible() && !ProximityHelper.isProximityNode(binDiffGraph.getGraph(), zyGraphNode2.getNode())) {
                    set.add(zyGraphNode2);
                }
            }
        }
        return set;
    }
    
    private static boolean showProximityNodeClickedVisibilityWarningDialog(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        final int nodesToShowCount = getNodesToShowCount(binDiffGraph, zyProximityNode);
        return nodesToShowCount <= binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold() || CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", nodesToShowCount)) == 0;
    }
    
    private static void updateVisibility(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        final Set nodesToShow = getNodesToShow(binDiffGraph, zyProximityNode);
        if (binDiffGraph.getSettings().isSync()) {
            final HashSet<CombinedDiffNode> set = new HashSet<CombinedDiffNode>();
            final HashSet<SuperDiffNode> set2 = new HashSet<SuperDiffNode>();
            for (final ZyGraphNode zyGraphNode : nodesToShow) {
                if (zyGraphNode instanceof SingleDiffNode) {
                    set.add(((SingleDiffNode)zyGraphNode).getCombinedDiffNode());
                    set2.add(((SingleDiffNode)zyGraphNode).getSuperDiffNode());
                }
                else {
                    if (!(zyGraphNode instanceof CombinedDiffNode)) {
                        continue;
                    }
                    set.add((CombinedDiffNode)zyGraphNode);
                    set2.add(((CombinedDiffNode)zyGraphNode).getSuperDiffNode());
                }
            }
            binDiffGraph.getCombinedGraph().showNodes(set, false);
            binDiffGraph.getSuperGraph().showNodes(set2, false);
        }
        else {
            for (final ZyGraphNode zyGraphNode2 : nodesToShow) {
                if (zyGraphNode2 instanceof SingleDiffNode || zyGraphNode2 instanceof CombinedDiffNode) {
                    zyGraphNode2.getRawNode().setVisible(true);
                }
            }
        }
    }
    
    protected static void updateProximityNodes(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
            binDiffGraph.getSuperGraph().getProximityBrowser().deleteProximityNodes();
            final ArrayList list = new ArrayList();
            list.addAll(binDiffGraph.getCombinedGraph().getNodes());
            final ArrayList list2 = new ArrayList();
            list2.addAll(binDiffGraph.getSuperGraph().getNodes());
            binDiffGraph.getCombinedGraph().getProximityBrowser().createProximityNodes(list);
            binDiffGraph.getSuperGraph().getProximityBrowser().createProximityNodes(list2);
            ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
            ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
        }
        else {
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph);
            if (binDiffGraph instanceof SingleGraph) {
                ProximityBrowserUpdater.createProximityNodesAndEdges((SingleGraph)binDiffGraph);
            }
            else if (binDiffGraph instanceof CombinedGraph) {
                ProximityBrowserUpdater.createProximityNodesAndEdges((CombinedGraph)binDiffGraph);
            }
        }
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        if (showProximityNodeClickedVisibilityWarningDialog(binDiffGraph, zyProximityNode)) {
            updateVisibility(binDiffGraph, zyProximityNode);
            updateProximityNodes(binDiffGraph);
            GraphViewUpdater.updateViews(binDiffGraph);
            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
            if (LayoutCommandHelper.isAutolayout(binDiffGraph)) {
                GraphLayoutUpdater.executeStatic(binDiffGraph, true);
            }
        }
    }
    
    public static int getNodesToShowCount(final BinDiffGraph binDiffGraph, final ZyProximityNode zyProximityNode) {
        return getNodesToShow(binDiffGraph, zyProximityNode).size();
    }
    
    @Override
    public void execute() {
        executeStatic(this.graph, this.proximityNode);
    }
}
