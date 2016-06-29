/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProximityBrowserInitializer {
    private static final int EDGE_COUNT_THRESHOLD = 3;

    private ProximityBrowserInitializer() {
    }

    private static SingleDiffNode getProximityBrowsingStartNode(SingleGraph singleGraph) {
        RawBasicBlock rawBasicBlock;
        SingleDiffNode singleDiffNode;
        SingleDiffNode singleDiffNode2 = null;
        IAddress iAddress = null;
        if (singleGraph.getGraphType() == EGraphType.CALLGRAPH) {
            Iterator iterator = singleGraph.getNodes().iterator();
            while (iterator.hasNext()) {
                SingleViewNode singleViewNode;
                SingleDiffNode singleDiffNode3 = (SingleDiffNode)iterator.next();
                if (singleDiffNode3.getRawNode().getMatchState() != EMatchState.MATCHED || (singleViewNode = singleDiffNode3.getRawNode()).getIncomingEdges().size() + singleViewNode.getOutgoingEdges().size() != 3) continue;
                IAddress iAddress2 = singleViewNode.getAddress();
                if (iAddress != null && iAddress.compareTo(iAddress2) <= 0) continue;
                iAddress = iAddress2;
                singleDiffNode2 = singleDiffNode3;
            }
            return singleDiffNode2;
        }
        Iterator iterator = singleGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) return singleDiffNode2;
        } while (!(rawBasicBlock = (RawBasicBlock)(singleDiffNode = (SingleDiffNode)iterator.next()).getRawNode()).getAddress().equals(rawBasicBlock.getFunctionAddr()));
        return singleDiffNode;
    }

    private static void getVisibleAndInvisibleNodeSets(BinDiffGraph binDiffGraph, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, Collection collection, Collection collection2, Collection collection3, Collection collection4) {
        collection4.addAll(binDiffGraph.getCombinedGraph().getNodes());
        collection2.addAll(binDiffGraph.getSuperGraph().getNodes());
        if (singleDiffNode == null && singleDiffNode2 == null) {
            return;
        }
        if (singleDiffNode == null) {
            singleDiffNode = singleDiffNode2.getOtherSideDiffNode();
        } else {
            singleDiffNode2 = singleDiffNode2 == null ? singleDiffNode.getOtherSideDiffNode() : singleDiffNode.getOtherSideDiffNode();
        }
        SuperDiffNode superDiffNode = singleDiffNode.getSuperDiffNode();
        collection2.remove(superDiffNode);
        collection.add(superDiffNode);
        CombinedDiffNode combinedDiffNode = singleDiffNode.getCombinedDiffNode();
        collection4.remove(combinedDiffNode);
        collection3.add(combinedDiffNode);
    }

    private static void initialProximityBrowsing(BinDiffGraph binDiffGraph) {
        GraphProximityBrowsingSettings graphProximityBrowsingSettings = binDiffGraph.getSettings().getProximitySettings();
        int n2 = graphProximityBrowsingSettings.getAutoProximityBrowsingActivationThreshold();
        Collection collection = binDiffGraph.getCombinedGraph().getNodes();
        int n3 = collection.size();
        if (n3 < n2) {
            return;
        }
        graphProximityBrowsingSettings.setProximityBrowsing(true);
        SingleDiffNode singleDiffNode = ProximityBrowserInitializer.getProximityBrowsingStartNode(binDiffGraph.getPrimaryGraph());
        SingleDiffNode singleDiffNode2 = ProximityBrowserInitializer.getProximityBrowsingStartNode(binDiffGraph.getSecondaryGraph());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ProximityBrowserInitializer.getVisibleAndInvisibleNodeSets(binDiffGraph, singleDiffNode, singleDiffNode2, arrayList3, arrayList4, arrayList, arrayList2);
        GraphLayoutSettings graphLayoutSettings = binDiffGraph.getSettings().getLayoutSettings();
        boolean bl2 = graphLayoutSettings.getAutomaticLayouting();
        graphLayoutSettings.setAutomaticLayouting(false);
        binDiffGraph.getSuperGraph().showNodes(arrayList3, arrayList4);
        binDiffGraph.getCombinedGraph().showNodes(arrayList, arrayList2);
        ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
        ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
        graphLayoutSettings.setAutomaticLayouting(bl2);
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        ProximityBrowserInitializer.initialProximityBrowsing(binDiffGraph);
        try {
            GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
            return;
        }
        catch (Exception var1_1) {
            throw new GraphLayoutException(var1_1, var1_1.getMessage());
        }
    }
}

