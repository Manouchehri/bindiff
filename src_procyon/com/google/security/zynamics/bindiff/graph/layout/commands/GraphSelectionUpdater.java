package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.layout.*;

public final class GraphSelectionUpdater implements ICommand
{
    private final BinDiffGraph referenceGraph;
    
    public GraphSelectionUpdater(final BinDiffGraph referenceGraph) {
        Preconditions.checkNotNull(referenceGraph);
        Preconditions.checkArgument(!(referenceGraph instanceof SuperGraph), (Object)"Reference graph cannot be a super graph");
        this.referenceGraph = referenceGraph;
    }
    
    private static void selectRawEdges(final AbstractZyGraph abstractZyGraph) {
        final ArrayList<ZyGraphEdge> list = (ArrayList<ZyGraphEdge>)new ArrayList<Object>();
        abstractZyGraph.iterateEdges(new GraphSelectionUpdater$1(list));
        abstractZyGraph.getGraph().P();
        for (final ZyGraphEdge zyGraphEdge : list) {
            zyGraphEdge.getRawEdge().setSelected(true);
            abstractZyGraph.getGraph().i(zyGraphEdge.getEdge()).setSelected(true);
        }
    }
    
    private static void selectRawGraph(final CombinedGraph combinedGraph, final Collection collection, final Collection collection2) {
        combinedGraph.selectNodes(collection, collection2);
        selectRawNodes(combinedGraph);
        selectRawEdges(combinedGraph);
    }
    
    private static void selectRawGraph(final SingleGraph singleGraph, final Collection collection, final Collection collection2) {
        singleGraph.selectNodes(collection, collection2);
        selectRawNodes(singleGraph);
        selectRawEdges(singleGraph);
    }
    
    private static void selectRawGraph(final SuperGraph superGraph, final Collection collection, final Collection collection2) {
        superGraph.selectNodes(collection, collection2);
        selectRawNodes(superGraph);
        selectRawEdges(superGraph);
    }
    
    private static void selectRawNodes(final AbstractZyGraph abstractZyGraph) {
        for (final ZyGraphNode zyGraphNode : abstractZyGraph.getSelectedNodes()) {
            if (zyGraphNode instanceof CombinedDiffNode) {
                ((CombinedDiffNode)zyGraphNode).getRawNode().setSelected(true);
            }
            if (zyGraphNode instanceof SuperDiffNode) {
                ((SuperDiffNode)zyGraphNode).getRawNode().setSelected(true);
            }
        }
    }
    
    private static boolean showVisibilityWarningDialog(final BinDiffGraph binDiffGraph) {
        final int proximityBrowsingChildren = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingChildren();
        final int proximityBrowsingParents = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingParents();
        final List filterNodes = GraphNodeFilter.filterNodes(binDiffGraph, GraphNodeFilter$Criterium.VISIBLE);
        final List filterNodes2 = GraphNodeFilter.filterNodes(binDiffGraph, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
        final Set neighbors = ProximityRangeCalculator.getNeighbors(binDiffGraph, filterNodes2, proximityBrowsingChildren, proximityBrowsingParents);
        final HashSet<ZyGraphNode> set = new HashSet<ZyGraphNode>();
        int n = 0;
        for (final ZyGraphNode zyGraphNode : neighbors) {
            if (!zyGraphNode.isVisible()) {
                ++n;
            }
            else {
                set.add(zyGraphNode);
            }
        }
        filterNodes.removeAll(filterNodes2);
        filterNodes.removeAll(set);
        final int n2 = n - filterNodes.size();
        return n2 < binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold() || CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", n2)) == 0;
    }
    
    private static void synchronizeNodesSelection(final CombinedGraph combinedGraph, final Set set) {
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final ArrayList<SuperDiffNode> list3 = new ArrayList<SuperDiffNode>();
        final ArrayList<SuperDiffNode> list4 = new ArrayList<SuperDiffNode>();
        final ArrayList<SingleDiffNode> list5 = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list6 = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list7 = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list8 = new ArrayList<SingleDiffNode>();
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
            final boolean contains = set.contains(combinedDiffNode);
            final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
            final SingleDiffNode secondaryDiffNode = combinedDiffNode.getSecondaryDiffNode();
            final SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            final ArrayList<SuperDiffNode> list9 = contains ? list3 : list4;
            final ArrayList<CombinedDiffNode> list10 = contains ? list : list2;
            final ArrayList<SingleDiffNode> list11 = contains ? list5 : list6;
            final ArrayList<SingleDiffNode> list12 = contains ? list7 : list8;
            list10.add(combinedDiffNode);
            list9.add(superDiffNode);
            if (primaryDiffNode != null) {
                list11.add(primaryDiffNode);
            }
            if (secondaryDiffNode != null) {
                list12.add(secondaryDiffNode);
            }
        }
        combinedGraph.selectNodes(list, list2);
        selectRawEdges(combinedGraph);
        selectRawGraph(combinedGraph.getSuperGraph(), list3, list4);
        selectRawGraph(combinedGraph.getPrimaryGraph(), list5, list6);
        selectRawGraph(combinedGraph.getSecondaryGraph(), list7, list8);
        updateAllGraphViews(combinedGraph);
    }
    
    private static void synchronizeNodesSelection(final SingleGraph singleGraph, final Set set) {
        final ESide side = singleGraph.getSide();
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
        final ArrayList<SuperDiffNode> list3 = new ArrayList<SuperDiffNode>();
        final ArrayList<SuperDiffNode> list4 = new ArrayList<SuperDiffNode>();
        final ArrayList<SingleDiffNode> list5 = new ArrayList<SingleDiffNode>();
        final ArrayList<SingleDiffNode> list6 = new ArrayList<SingleDiffNode>();
        for (final CombinedDiffNode combinedDiffNode : singleGraph.getCombinedGraph().getNodes()) {
            final SingleDiffNode singleDiffNode = (side == ESide.PRIMARY) ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
            final SingleDiffNode singleDiffNode2 = (side == ESide.SECONDARY) ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
            final SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            final boolean b = (singleDiffNode == null && singleDiffNode2.isSelected()) || (singleDiffNode != null && set.contains(singleDiffNode));
            final ArrayList<SuperDiffNode> list7 = b ? list3 : list4;
            final ArrayList<CombinedDiffNode> list8 = b ? list : list2;
            final ArrayList<SingleDiffNode> list9 = b ? list5 : list6;
            list8.add(combinedDiffNode);
            list7.add(superDiffNode);
            if (singleDiffNode2 != null) {
                list9.add(singleDiffNode2);
            }
        }
        selectRawGraph(singleGraph.getOtherSideGraph(), list5, list6);
        selectRawGraph(singleGraph.getCombinedGraph(), list, list2);
        selectRawGraph(singleGraph.getSuperGraph(), list3, list4);
        selectRawEdges(singleGraph);
        updateAllGraphViews(singleGraph);
    }
    
    private static void updateAllGraphViews(final BinDiffGraph binDiffGraph) {
        binDiffGraph.getPrimaryGraph().getGraph().T();
        binDiffGraph.getSecondaryGraph().getGraph().T();
        binDiffGraph.getSuperGraph().getGraph().T();
        binDiffGraph.getCombinedGraph().getGraph().T();
    }
    
    private static boolean willChangeNodeVisibility(final BinDiffGraph binDiffGraph, final Set set) {
        final GraphProximityBrowsingSettings proximitySettings = binDiffGraph.getSettings().getProximitySettings();
        if (proximitySettings.getProximityBrowsing() && !proximitySettings.getProximityBrowsingFrozen()) {
            final Set neighbors = ProximityRangeCalculator.getNeighbors(binDiffGraph, set, proximitySettings.getProximityBrowsingChildren(), proximitySettings.getProximityBrowsingParents());
            for (final ZyGraphNode zyGraphNode : binDiffGraph.getNodes()) {
                if (zyGraphNode.isVisible()) {
                    if (!set.contains(zyGraphNode) && !neighbors.contains(zyGraphNode)) {
                        return true;
                    }
                    continue;
                }
                else {
                    if (set.contains(zyGraphNode) || neighbors.contains(zyGraphNode)) {
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            if (binDiffGraph instanceof SingleGraph) {
                synchronizeNodesSelection((SingleGraph)binDiffGraph, ((SingleGraph)binDiffGraph).getSelectedNodes());
            }
            else if (binDiffGraph instanceof CombinedGraph) {
                synchronizeNodesSelection((CombinedGraph)binDiffGraph, ((CombinedGraph)binDiffGraph).getSelectedNodes());
            }
            updateAllGraphViews(binDiffGraph);
        }
        else {
            if (binDiffGraph instanceof CombinedGraph) {
                final CombinedGraph combinedGraph = (CombinedGraph)binDiffGraph;
                final Set selectedNodes = combinedGraph.getSelectedNodes();
                final HashSet set = new HashSet();
                set.addAll(combinedGraph.getNodes());
                set.removeAll(selectedNodes);
                combinedGraph.selectNodes(selectedNodes, set);
            }
            selectRawEdges(binDiffGraph);
        }
        GraphsIntermediateListeners.notifyIntermediateSelectionListeners(binDiffGraph);
        if (LayoutCommandHelper.hasSelectedNodes(binDiffGraph) && willChangeNodeVisibility(binDiffGraph, binDiffGraph.getSelectedNodes()) && showVisibilityWarningDialog(binDiffGraph)) {
            ProximityBrowserUpdater.executeStatic(binDiffGraph);
            if (LayoutCommandHelper.isAutolayout(binDiffGraph) && !LayoutCommandHelper.isProximityBrowsingFrozen(binDiffGraph)) {
                GraphLayoutUpdater.executeStatic(binDiffGraph, true);
            }
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.referenceGraph);
    }
}
