/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphSelectionUpdater$1;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityRangeCalculator;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.d;
import y.h.aB;
import y.h.bu;

public final class GraphSelectionUpdater
implements ICommand {
    private final BinDiffGraph referenceGraph;

    public GraphSelectionUpdater(BinDiffGraph binDiffGraph) {
        Preconditions.checkNotNull(binDiffGraph);
        Preconditions.checkArgument(!(binDiffGraph instanceof SuperGraph), "Reference graph cannot be a super graph");
        this.referenceGraph = binDiffGraph;
    }

    private static void selectRawEdges(AbstractZyGraph abstractZyGraph) {
        ArrayList arrayList = new ArrayList();
        abstractZyGraph.iterateEdges(new GraphSelectionUpdater$1(arrayList));
        abstractZyGraph.getGraph().P();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ZyGraphEdge zyGraphEdge = (ZyGraphEdge)iterator.next();
            zyGraphEdge.getRawEdge().setSelected(true);
            abstractZyGraph.getGraph().i(zyGraphEdge.getEdge()).setSelected(true);
        }
    }

    private static void selectRawGraph(CombinedGraph combinedGraph, Collection collection, Collection collection2) {
        combinedGraph.selectNodes(collection, collection2);
        GraphSelectionUpdater.selectRawNodes(combinedGraph);
        GraphSelectionUpdater.selectRawEdges(combinedGraph);
    }

    private static void selectRawGraph(SingleGraph singleGraph, Collection collection, Collection collection2) {
        singleGraph.selectNodes(collection, collection2);
        GraphSelectionUpdater.selectRawNodes(singleGraph);
        GraphSelectionUpdater.selectRawEdges(singleGraph);
    }

    private static void selectRawGraph(SuperGraph superGraph, Collection collection, Collection collection2) {
        superGraph.selectNodes(collection, collection2);
        GraphSelectionUpdater.selectRawNodes(superGraph);
        GraphSelectionUpdater.selectRawEdges(superGraph);
    }

    private static void selectRawNodes(AbstractZyGraph abstractZyGraph) {
        Iterator iterator = abstractZyGraph.getSelectedNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode instanceof CombinedDiffNode) {
                ((CombinedDiffNode)zyGraphNode).getRawNode().setSelected(true);
            }
            if (!(zyGraphNode instanceof SuperDiffNode)) continue;
            ((SuperDiffNode)zyGraphNode).getRawNode().setSelected(true);
        }
    }

    private static boolean showVisibilityWarningDialog(BinDiffGraph binDiffGraph) {
        int n2 = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingChildren();
        int n3 = binDiffGraph.getSettings().getProximitySettings().getProximityBrowsingParents();
        List list = GraphNodeFilter.filterNodes(binDiffGraph, GraphNodeFilter$Criterium.VISIBLE);
        List list2 = GraphNodeFilter.filterNodes(binDiffGraph, GraphNodeFilter$Criterium.SELECTED_VISIBLE);
        Set set = ProximityRangeCalculator.getNeighbors(binDiffGraph, list2, n2, n3);
        HashSet<ZyGraphNode> hashSet = new HashSet<ZyGraphNode>();
        int n4 = 0;
        for (ZyGraphNode zyGraphNode : set) {
            if (!zyGraphNode.isVisible()) {
                ++n4;
                continue;
            }
            hashSet.add(zyGraphNode);
        }
        list.removeAll(list2);
        list.removeAll(hashSet);
        int n5 = list.size();
        int n6 = n4 - n5;
        int n7 = binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold();
        if (n6 < n7) return true;
        int n8 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", n6));
        if (n8 != 0) return false;
        return true;
    }

    private static void synchronizeNodesSelection(CombinedGraph combinedGraph, Set set) {
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<SuperDiffNode> arrayList3 = new ArrayList<SuperDiffNode>();
        ArrayList arrayList4 = new ArrayList();
        ArrayList<SingleDiffNode> arrayList5 = new ArrayList<SingleDiffNode>();
        ArrayList arrayList6 = new ArrayList();
        ArrayList<SingleDiffNode> arrayList7 = new ArrayList<SingleDiffNode>();
        ArrayList arrayList8 = new ArrayList();
        Iterator iterator = combinedGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                combinedGraph.selectNodes(arrayList, arrayList2);
                GraphSelectionUpdater.selectRawEdges(combinedGraph);
                GraphSelectionUpdater.selectRawGraph(combinedGraph.getSuperGraph(), arrayList3, arrayList4);
                GraphSelectionUpdater.selectRawGraph(combinedGraph.getPrimaryGraph(), arrayList5, arrayList6);
                GraphSelectionUpdater.selectRawGraph(combinedGraph.getSecondaryGraph(), arrayList7, arrayList8);
                GraphSelectionUpdater.updateAllGraphViews(combinedGraph);
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            boolean bl2 = set.contains(combinedDiffNode);
            SingleDiffNode singleDiffNode = combinedDiffNode.getPrimaryDiffNode();
            SingleDiffNode singleDiffNode2 = combinedDiffNode.getSecondaryDiffNode();
            SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            ArrayList<SuperDiffNode> arrayList9 = bl2 ? arrayList3 : arrayList4;
            ArrayList<CombinedDiffNode> arrayList10 = bl2 ? arrayList : arrayList2;
            ArrayList<SingleDiffNode> arrayList11 = bl2 ? arrayList5 : arrayList6;
            ArrayList<SingleDiffNode> arrayList12 = bl2 ? arrayList7 : arrayList8;
            arrayList10.add(combinedDiffNode);
            arrayList9.add(superDiffNode);
            if (singleDiffNode != null) {
                arrayList11.add(singleDiffNode);
            }
            if (singleDiffNode2 == null) continue;
            arrayList12.add(singleDiffNode2);
        } while (true);
    }

    private static void synchronizeNodesSelection(SingleGraph singleGraph, Set set) {
        ESide eSide = singleGraph.getSide();
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<SuperDiffNode> arrayList3 = new ArrayList<SuperDiffNode>();
        ArrayList arrayList4 = new ArrayList();
        ArrayList<SingleDiffNode> arrayList5 = new ArrayList<SingleDiffNode>();
        ArrayList arrayList6 = new ArrayList();
        Iterator iterator = singleGraph.getCombinedGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                GraphSelectionUpdater.selectRawGraph(singleGraph.getOtherSideGraph(), arrayList5, arrayList6);
                GraphSelectionUpdater.selectRawGraph(singleGraph.getCombinedGraph(), arrayList, arrayList2);
                GraphSelectionUpdater.selectRawGraph(singleGraph.getSuperGraph(), arrayList3, arrayList4);
                GraphSelectionUpdater.selectRawEdges(singleGraph);
                GraphSelectionUpdater.updateAllGraphViews(singleGraph);
                return;
            }
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            SingleDiffNode singleDiffNode = eSide == ESide.PRIMARY ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
            SingleDiffNode singleDiffNode2 = eSide == ESide.SECONDARY ? combinedDiffNode.getPrimaryDiffNode() : combinedDiffNode.getSecondaryDiffNode();
            SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            boolean bl2 = singleDiffNode == null && singleDiffNode2.isSelected() || singleDiffNode != null && set.contains(singleDiffNode);
            ArrayList<SuperDiffNode> arrayList7 = bl2 ? arrayList3 : arrayList4;
            ArrayList<CombinedDiffNode> arrayList8 = bl2 ? arrayList : arrayList2;
            ArrayList<SingleDiffNode> arrayList9 = bl2 ? arrayList5 : arrayList6;
            arrayList8.add(combinedDiffNode);
            arrayList7.add(superDiffNode);
            if (singleDiffNode2 == null) continue;
            arrayList9.add(singleDiffNode2);
        } while (true);
    }

    private static void updateAllGraphViews(BinDiffGraph binDiffGraph) {
        binDiffGraph.getPrimaryGraph().getGraph().T();
        binDiffGraph.getSecondaryGraph().getGraph().T();
        binDiffGraph.getSuperGraph().getGraph().T();
        binDiffGraph.getCombinedGraph().getGraph().T();
    }

    /*
     * Unable to fully structure code
     */
    private static boolean willChangeNodeVisibility(BinDiffGraph var0, Set var1_1) {
        var2_2 = var0.getSettings().getProximitySettings();
        if (var2_2.getProximityBrowsing() == false) return false;
        if (var2_2.getProximityBrowsingFrozen() != false) return false;
        var3_3 = var2_2.getProximityBrowsingChildren();
        var4_4 = var2_2.getProximityBrowsingParents();
        var5_5 = ProximityRangeCalculator.getNeighbors(var0, var1_1, var3_3, var4_4);
        var6_6 = var0.getNodes().iterator();
        do lbl-1000: // 3 sources:
        {
            if (var6_6.hasNext() == false) return false;
            var7_7 = (ZyGraphNode)var6_6.next();
            if (!var7_7.isVisible()) ** GOTO lbl14
            if (var1_1.contains(var7_7) || var5_5.contains(var7_7)) ** GOTO lbl-1000
            return true;
lbl14: // 1 sources:
            if (var1_1.contains(var7_7) != false) return true;
        } while (!var5_5.contains(var7_7));
        return true;
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            if (binDiffGraph instanceof SingleGraph) {
                GraphSelectionUpdater.synchronizeNodesSelection((SingleGraph)binDiffGraph, ((SingleGraph)binDiffGraph).getSelectedNodes());
            } else if (binDiffGraph instanceof CombinedGraph) {
                GraphSelectionUpdater.synchronizeNodesSelection((CombinedGraph)binDiffGraph, ((CombinedGraph)binDiffGraph).getSelectedNodes());
            }
            GraphSelectionUpdater.updateAllGraphViews(binDiffGraph);
        } else {
            if (binDiffGraph instanceof CombinedGraph) {
                CombinedGraph combinedGraph = (CombinedGraph)binDiffGraph;
                Set set = combinedGraph.getSelectedNodes();
                HashSet hashSet = new HashSet();
                hashSet.addAll(combinedGraph.getNodes());
                hashSet.removeAll(set);
                combinedGraph.selectNodes((Collection)set, hashSet);
            }
            GraphSelectionUpdater.selectRawEdges(binDiffGraph);
        }
        GraphsIntermediateListeners.notifyIntermediateSelectionListeners(binDiffGraph);
        if (!LayoutCommandHelper.hasSelectedNodes(binDiffGraph)) return;
        if (!GraphSelectionUpdater.willChangeNodeVisibility(binDiffGraph, binDiffGraph.getSelectedNodes())) return;
        if (!GraphSelectionUpdater.showVisibilityWarningDialog(binDiffGraph)) return;
        ProximityBrowserUpdater.executeStatic(binDiffGraph);
        if (!LayoutCommandHelper.isAutolayout(binDiffGraph)) return;
        if (LayoutCommandHelper.isProximityBrowsingFrozen(binDiffGraph)) return;
        GraphLayoutUpdater.executeStatic(binDiffGraph, true);
    }

    @Override
    public void execute() {
        GraphSelectionUpdater.executeStatic(this.referenceGraph);
    }
}

