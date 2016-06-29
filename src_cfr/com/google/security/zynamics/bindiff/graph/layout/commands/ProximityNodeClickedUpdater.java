/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphViewUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUpdater;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.q;
import y.c.x;
import y.h.bu;

public final class ProximityNodeClickedUpdater
implements ICommand {
    private final BinDiffGraph graph;
    private final ZyProximityNode proximityNode;

    public ProximityNodeClickedUpdater(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.proximityNode = (ZyProximityNode)Preconditions.checkNotNull(zyProximityNode);
    }

    private static Set getNodesToShow(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        q q2 = zyProximityNode.getNode();
        HashSet<ZyGraphNode> hashSet = new HashSet<ZyGraphNode>();
        q q3 = q2.m().e();
        ZyGraphNode zyGraphNode = binDiffGraph.getNode(q3);
        if (zyProximityNode.indegree() == 1) {
            for (ZyGraphNode zyGraphNode2 : zyGraphNode.getChildren()) {
                if (zyGraphNode2.isVisible() || ProximityHelper.isProximityNode(binDiffGraph.getGraph(), zyGraphNode2.getNode())) continue;
                hashSet.add(zyGraphNode2);
            }
        }
        if (zyProximityNode.outdegree() != 1) return hashSet;
        Iterator iterator = zyGraphNode.getParents().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode2;
            zyGraphNode2 = (ZyGraphNode)iterator.next();
            if (zyGraphNode2.isVisible() || ProximityHelper.isProximityNode(binDiffGraph.getGraph(), zyGraphNode2.getNode())) continue;
            hashSet.add(zyGraphNode2);
        }
        return hashSet;
    }

    private static boolean showProximityNodeClickedVisibilityWarningDialog(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        int n2;
        int n3 = ProximityNodeClickedUpdater.getNodesToShowCount(binDiffGraph, zyProximityNode);
        if (n3 <= (n2 = binDiffGraph.getSettings().getLayoutSettings().getVisibilityWarningThreshold())) return true;
        int n4 = CMessageBox.showYesNoQuestion(BinDiffGraph.getParentWindow(binDiffGraph), String.format("The selected operation makes %d more nodes visible. Do you want to continue?", n3));
        if (n4 != 0) return false;
        return true;
    }

    private static void updateVisibility(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        Set set = ProximityNodeClickedUpdater.getNodesToShow(binDiffGraph, zyProximityNode);
        if (!binDiffGraph.getSettings().isSync()) {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
                if (!(zyGraphNode instanceof SingleDiffNode) && !(zyGraphNode instanceof CombinedDiffNode)) continue;
                zyGraphNode.getRawNode().setVisible(true);
            }
            return;
        }
        HashSet<CombinedDiffNode> hashSet = new HashSet<CombinedDiffNode>();
        HashSet<SuperDiffNode> hashSet2 = new HashSet<SuperDiffNode>();
        Iterator iterator = set.iterator();
        do {
            if (!iterator.hasNext()) {
                binDiffGraph.getCombinedGraph().showNodes(hashSet, false);
                binDiffGraph.getSuperGraph().showNodes(hashSet2, false);
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode instanceof SingleDiffNode) {
                hashSet.add(((SingleDiffNode)zyGraphNode).getCombinedDiffNode());
                hashSet2.add(((SingleDiffNode)zyGraphNode).getSuperDiffNode());
                continue;
            }
            if (!(zyGraphNode instanceof CombinedDiffNode)) continue;
            hashSet.add((CombinedDiffNode)zyGraphNode);
            hashSet2.add(((CombinedDiffNode)zyGraphNode).getSuperDiffNode());
        } while (true);
    }

    protected static void updateProximityNodes(BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getCombinedGraph().getProximityBrowser().deleteProximityNodes();
            binDiffGraph.getSuperGraph().getProximityBrowser().deleteProximityNodes();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(binDiffGraph.getCombinedGraph().getNodes());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(binDiffGraph.getSuperGraph().getNodes());
            binDiffGraph.getCombinedGraph().getProximityBrowser().createProximityNodes(arrayList);
            binDiffGraph.getSuperGraph().getProximityBrowser().createProximityNodes(arrayList2);
            ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
            ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
            return;
        }
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph);
        if (binDiffGraph instanceof SingleGraph) {
            ProximityBrowserUpdater.createProximityNodesAndEdges((SingleGraph)binDiffGraph);
            return;
        }
        if (!(binDiffGraph instanceof CombinedGraph)) return;
        ProximityBrowserUpdater.createProximityNodesAndEdges((CombinedGraph)binDiffGraph);
    }

    public static void executeStatic(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        if (!ProximityNodeClickedUpdater.showProximityNodeClickedVisibilityWarningDialog(binDiffGraph, zyProximityNode)) return;
        ProximityNodeClickedUpdater.updateVisibility(binDiffGraph, zyProximityNode);
        ProximityNodeClickedUpdater.updateProximityNodes(binDiffGraph);
        GraphViewUpdater.updateViews(binDiffGraph);
        GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
        if (!LayoutCommandHelper.isAutolayout(binDiffGraph)) return;
        GraphLayoutUpdater.executeStatic(binDiffGraph, true);
    }

    public static int getNodesToShowCount(BinDiffGraph binDiffGraph, ZyProximityNode zyProximityNode) {
        return ProximityNodeClickedUpdater.getNodesToShow(binDiffGraph, zyProximityNode).size();
    }

    @Override
    public void execute() {
        ProximityNodeClickedUpdater.executeStatic(this.graph, this.proximityNode);
    }
}

