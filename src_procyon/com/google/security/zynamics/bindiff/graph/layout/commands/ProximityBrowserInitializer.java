package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.exceptions.*;

public class ProximityBrowserInitializer
{
    private static final int EDGE_COUNT_THRESHOLD = 3;
    
    private static SingleDiffNode getProximityBrowsingStartNode(final SingleGraph singleGraph) {
        SingleDiffNode singleDiffNode = null;
        Comparable<IAddress> comparable = null;
        if (singleGraph.getGraphType() == EGraphType.CALLGRAPH) {
            for (final SingleDiffNode singleDiffNode2 : singleGraph.getNodes()) {
                if (singleDiffNode2.getRawNode().getMatchState() == EMatchState.MATCHED) {
                    final SingleViewNode rawNode = singleDiffNode2.getRawNode();
                    if (rawNode.getIncomingEdges().size() + rawNode.getOutgoingEdges().size() != 3) {
                        continue;
                    }
                    final IAddress address = rawNode.getAddress();
                    if (comparable != null && comparable.compareTo(address) <= 0) {
                        continue;
                    }
                    comparable = (Comparable<IAddress>)address;
                    singleDiffNode = singleDiffNode2;
                }
            }
        }
        else {
            for (final SingleDiffNode singleDiffNode3 : singleGraph.getNodes()) {
                final RawBasicBlock rawBasicBlock = (RawBasicBlock)singleDiffNode3.getRawNode();
                if (rawBasicBlock.getAddress().equals(rawBasicBlock.getFunctionAddr())) {
                    singleDiffNode = singleDiffNode3;
                    break;
                }
            }
        }
        return singleDiffNode;
    }
    
    private static void getVisibleAndInvisibleNodeSets(final BinDiffGraph binDiffGraph, SingleDiffNode otherSideDiffNode, SingleDiffNode singleDiffNode, final Collection collection, final Collection collection2, final Collection collection3, final Collection collection4) {
        collection4.addAll(binDiffGraph.getCombinedGraph().getNodes());
        collection2.addAll(binDiffGraph.getSuperGraph().getNodes());
        if (otherSideDiffNode == null && singleDiffNode == null) {
            return;
        }
        if (otherSideDiffNode == null) {
            otherSideDiffNode = singleDiffNode.getOtherSideDiffNode();
        }
        else if (singleDiffNode == null) {
            singleDiffNode = otherSideDiffNode.getOtherSideDiffNode();
        }
        else {
            singleDiffNode = otherSideDiffNode.getOtherSideDiffNode();
        }
        final SuperDiffNode superDiffNode = otherSideDiffNode.getSuperDiffNode();
        collection2.remove(superDiffNode);
        collection.add(superDiffNode);
        final CombinedDiffNode combinedDiffNode = otherSideDiffNode.getCombinedDiffNode();
        collection4.remove(combinedDiffNode);
        collection3.add(combinedDiffNode);
    }
    
    private static void initialProximityBrowsing(final BinDiffGraph binDiffGraph) {
        final GraphProximityBrowsingSettings proximitySettings = binDiffGraph.getSettings().getProximitySettings();
        if (binDiffGraph.getCombinedGraph().getNodes().size() < proximitySettings.getAutoProximityBrowsingActivationThreshold()) {
            return;
        }
        proximitySettings.setProximityBrowsing(true);
        final SingleDiffNode proximityBrowsingStartNode = getProximityBrowsingStartNode(binDiffGraph.getPrimaryGraph());
        final SingleDiffNode proximityBrowsingStartNode2 = getProximityBrowsingStartNode(binDiffGraph.getSecondaryGraph());
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final ArrayList list4 = new ArrayList();
        getVisibleAndInvisibleNodeSets(binDiffGraph, proximityBrowsingStartNode, proximityBrowsingStartNode2, list3, list4, list, list2);
        final GraphLayoutSettings layoutSettings = binDiffGraph.getSettings().getLayoutSettings();
        final boolean automaticLayouting = layoutSettings.getAutomaticLayouting();
        layoutSettings.setAutomaticLayouting(false);
        binDiffGraph.getSuperGraph().showNodes(list3, list4);
        binDiffGraph.getCombinedGraph().showNodes(list, list2);
        ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
        ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
        layoutSettings.setAutomaticLayouting(automaticLayouting);
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        initialProximityBrowsing(binDiffGraph);
        try {
            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        }
        catch (Exception ex) {
            throw new GraphLayoutException(ex, ex.getMessage());
        }
    }
}
