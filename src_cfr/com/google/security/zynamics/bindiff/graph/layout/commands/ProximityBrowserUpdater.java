/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.types.common.ICommand;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.awt.Font;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.x;
import y.h.aB;
import y.h.bu;
import y.h.dr;
import y.h.fj;

public final class ProximityBrowserUpdater
implements ICommand {
    private final BinDiffGraph referenceGraph;

    public ProximityBrowserUpdater(BinDiffGraph binDiffGraph) {
        this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }

    private static void createNewProximityNodeAndEdge(bu bu2, CombinedDiffNode zyGraphNode, int n2, boolean bl2) {
        if (n2 == 0) {
            return;
        }
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n2), new Font("New Courier", 0, 12), null));
        ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        q q2 = bu2.a(zyProximityNodeRealizer);
        ZyGraphNode zyGraphNode2 = new ZyProximityNode(q2, zyProximityNodeRealizer, zyGraphNode, bl2);
        ZyNodeData zyNodeData = new ZyNodeData(zyGraphNode2);
        zyProximityNodeRealizer.setUserData(zyNodeData);
        ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        d d2 = bu2.a(bl2 ? zyGraphNode.getNode() : zyGraphNode2.getNode(), bl2 ? zyGraphNode2.getNode() : zyGraphNode.getNode(), zyEdgeRealizer);
        ZyInfoEdge zyInfoEdge = new ZyInfoEdge(bl2 ? zyGraphNode : zyGraphNode2, bl2 ? zyGraphNode2 : zyGraphNode, d2, zyEdgeRealizer);
        ZyEdgeData zyEdgeData = new ZyEdgeData(zyInfoEdge);
        zyEdgeRealizer.setUserData(zyEdgeData);
    }

    private static void createNewProximityNodeAndEdge(bu bu2, SingleDiffNode zyGraphNode, int n2, boolean bl2) {
        if (n2 == 0) {
            return;
        }
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n2), new Font("New Courier", 0, 12), null));
        ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        q q2 = bu2.a(zyProximityNodeRealizer);
        ZyGraphNode zyGraphNode2 = new ZyProximityNode(q2, zyProximityNodeRealizer, zyGraphNode, bl2);
        ZyNodeData zyNodeData = new ZyNodeData(zyGraphNode2);
        zyProximityNodeRealizer.setUserData(zyNodeData);
        ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        d d2 = bu2.a(bl2 ? zyGraphNode.getNode() : zyGraphNode2.getNode(), bl2 ? zyGraphNode2.getNode() : zyGraphNode.getNode(), zyEdgeRealizer);
        ZyInfoEdge zyInfoEdge = new ZyInfoEdge(bl2 ? zyGraphNode : zyGraphNode2, bl2 ? zyGraphNode2 : zyGraphNode, d2, zyEdgeRealizer);
        ZyEdgeData zyEdgeData = new ZyEdgeData(zyInfoEdge);
        zyEdgeRealizer.setUserData(zyEdgeData);
    }

    private static void unhideAllNodes(BinDiffGraph binDiffGraph) {
        Iterator iterator = binDiffGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            if (zyGraphNode.isVisible()) continue;
            zyGraphNode.getRawNode().setVisible(true);
        }
    }

    private static void updateGraphVisibility(BinDiffGraph binDiffGraph) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(binDiffGraph.getNodes());
        hashSet.addAll(binDiffGraph.getSelectedNodes());
        hashSet2.removeAll(hashSet);
        binDiffGraph.showNodes(hashSet, hashSet2);
    }

    private static void updateProximityBrowserInAsyncMode(BinDiffGraph binDiffGraph) {
        if (binDiffGraph instanceof CombinedGraph) {
            ProximityBrowserUpdater.updateGraphVisibility(binDiffGraph);
            ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph);
            ProximityBrowserUpdater.createProximityNodesAndEdges((CombinedGraph)binDiffGraph);
            return;
        }
        if (!(binDiffGraph instanceof SingleGraph)) return;
        ProximityBrowserUpdater.updateGraphVisibility(binDiffGraph);
        ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph);
        ProximityBrowserUpdater.createProximityNodesAndEdges((SingleGraph)binDiffGraph);
    }

    protected static void adoptSuperGraphVisibility(SuperGraph superGraph) {
        Object object;
        Object object2;
        for (Object object32 : superGraph.getNodes()) {
            object2 = object32.getPrimaryDiffNode();
            if (object2 != null) {
                object2.getRawNode().setVisible(object32.isVisible());
            }
            if ((object = object32.getSecondaryDiffNode()) == null) continue;
            object.getRawNode().setVisible(object32.isVisible());
        }
        Iterator iterator = superGraph.getEdges().iterator();
        while (iterator.hasNext()) {
            Object object32;
            object32 = (SuperDiffEdge)iterator.next();
            object2 = object32.getPrimaryDiffEdge();
            object = object32.getSecondaryDiffEdge();
            if (object2 != null) {
                ((SingleViewEdge)object32.getPrimaryDiffEdge().getRawEdge()).setVisible(object32.isVisible());
            }
            if (object == null) continue;
            ((SingleViewEdge)object32.getSecondaryDiffEdge().getRawEdge()).setVisible(object32.isVisible());
        }
    }

    protected static void createProximityNodesAndEdges(CombinedGraph combinedGraph) {
        bu bu2 = combinedGraph.getGraph();
        Iterator iterator = combinedGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            Object object2;
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            if (!combinedDiffNode.isVisible()) continue;
            HashSet<CombinedDiffNode> hashSet = new HashSet<CombinedDiffNode>();
            for (Object object2 : combinedDiffNode.getParents()) {
                if (object2.isVisible()) continue;
                hashSet.add((CombinedDiffNode)object2);
            }
            ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, combinedDiffNode, hashSet.size(), false);
            HashSet hashSet2 = new HashSet();
            object2 = combinedDiffNode.getChildren().iterator();
            while (object2.hasNext()) {
                CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)object2.next();
                if (combinedDiffNode2.isVisible()) continue;
                hashSet2.add(combinedDiffNode2);
            }
            ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, combinedDiffNode, hashSet2.size(), true);
        }
    }

    protected static void createProximityNodesAndEdges(SingleGraph singleGraph) {
        bu bu2 = singleGraph.getGraph();
        Iterator iterator = singleGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            Object object2;
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            if (!singleDiffNode.isVisible()) continue;
            HashSet<SingleDiffNode> hashSet = new HashSet<SingleDiffNode>();
            for (Object object2 : singleDiffNode.getParents()) {
                if (object2.isVisible()) continue;
                hashSet.add((SingleDiffNode)object2);
            }
            ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, singleDiffNode, hashSet.size(), false);
            HashSet hashSet2 = new HashSet();
            object2 = singleDiffNode.getChildren().iterator();
            while (object2.hasNext()) {
                SingleDiffNode singleDiffNode2 = (SingleDiffNode)object2.next();
                if (singleDiffNode2.isVisible()) continue;
                hashSet2.add(singleDiffNode2);
            }
            ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, singleDiffNode, hashSet2.size(), true);
        }
    }

    static void createProximityNodesAndEdges(SuperGraph superGraph) {
        bu bu2 = superGraph.getPrimaryGraph().getGraph();
        bu bu3 = superGraph.getSecondaryGraph().getGraph();
        if (!superGraph.getSettings().getProximitySettings().getProximityBrowsing()) return;
        q[] arrq = superGraph.getGraph().m();
        int n2 = arrq.length;
        int n3 = 0;
        while (n3 < n2) {
            q q2 = arrq[n3];
            fj fj2 = superGraph.getGraph().t(q2);
            if (fj2 instanceof ZyProximityNodeRealizer) {
                SingleDiffNode singleDiffNode;
                SuperDiffNode superDiffNode;
                int n4;
                q q3;
                int n5;
                SingleDiffNode singleDiffNode2;
                d d2;
                if (q2.b() == 0 && q2.c() == 1) {
                    d2 = q2.f();
                    q3 = d2.d();
                    superDiffNode = (SuperDiffNode)superGraph.getNode(q3);
                    n5 = 0;
                    singleDiffNode2 = superDiffNode.getPrimaryDiffNode();
                    if (singleDiffNode2 != null) {
                        n5 = NodeHelpers.countInvisibleIndegreeNeighbours(singleDiffNode2.getRawNode());
                        ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, singleDiffNode2, n5, false);
                    }
                    n4 = 0;
                    singleDiffNode = superDiffNode.getSecondaryDiffNode();
                    if (singleDiffNode != null) {
                        n4 = NodeHelpers.countInvisibleIndegreeNeighbours(singleDiffNode.getRawNode());
                        ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu3, singleDiffNode, n4, false);
                    }
                } else if (q2.b() == 1 && q2.c() == 0) {
                    d2 = q2.g();
                    q3 = d2.c();
                    superDiffNode = (SuperDiffNode)superGraph.getNode(q3);
                    n5 = 0;
                    singleDiffNode2 = superDiffNode.getPrimaryDiffNode();
                    if (singleDiffNode2 != null) {
                        n5 = NodeHelpers.countInvisibleOutdegreeNeighbours(singleDiffNode2.getRawNode());
                        ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu2, singleDiffNode2, n5, true);
                    }
                    n4 = 0;
                    singleDiffNode = superDiffNode.getSecondaryDiffNode();
                    if (singleDiffNode != null) {
                        n4 = NodeHelpers.countInvisibleOutdegreeNeighbours(singleDiffNode.getRawNode());
                        ProximityBrowserUpdater.createNewProximityNodeAndEdge(bu3, singleDiffNode, n4, true);
                    }
                } else {
                    Logger.logSevere("Malformed graph. Super proximity node without incoming or outgoing edge.", new Object[0]);
                }
            }
            ++n3;
        }
    }

    static void deleteAllProximityNodes(BinDiffGraph binDiffGraph) {
        bu bu2 = binDiffGraph.getGraph();
        try {
            bu2.r();
            binDiffGraph.getProximityBrowser().deleteProximityNodes();
            x x2 = bu2.o();
            while (x2.f()) {
                if (bu2.t(x2.e()) instanceof ZyProximityNodeRealizer) {
                    if (x2.e().e() != bu2) throw new GraphLayoutException("Delete proximity node failed. Couldn't update proximity browsing.");
                    bu2.a(x2.e());
                }
                x2.g();
            }
            return;
        }
        finally {
            bu2.s();
        }
    }

    public static void executeStatic(BinDiffGraph binDiffGraph) {
        try {
            GraphProximityBrowsingSettings graphProximityBrowsingSettings = binDiffGraph.getSettings().getProximitySettings();
            if (graphProximityBrowsingSettings.getProximityBrowsing() && !graphProximityBrowsingSettings.getProximityBrowsingFrozen()) {
                boolean bl2 = binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting();
                binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(false);
                if (binDiffGraph.getSettings().isSync()) {
                    ProximityBrowserUpdater.updateGraphVisibility(binDiffGraph.getCombinedGraph());
                    ProximityBrowserUpdater.updateGraphVisibility(binDiffGraph.getSuperGraph());
                    ProximityBrowserUpdater.adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
                    ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
                    ProximityBrowserUpdater.deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
                    ProximityBrowserUpdater.createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
                } else {
                    ProximityBrowserUpdater.updateProximityBrowserInAsyncMode(binDiffGraph);
                }
                GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
                binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(bl2);
                return;
            }
            if (graphProximityBrowsingSettings.getProximityBrowsing()) return;
            try {
                ProximityBrowserUpdater.unhideAllNodes(binDiffGraph.getSuperGraph());
                ProximityBrowserUpdater.unhideAllNodes(binDiffGraph.getPrimaryGraph());
                ProximityBrowserUpdater.unhideAllNodes(binDiffGraph.getSecondaryGraph());
                ProximityBrowserUpdater.unhideAllNodes(binDiffGraph.getCombinedGraph());
                return;
            }
            catch (Exception var2_5) {
                throw new GraphLayoutException(var2_5, "Failed to unhide node. Couldn't update proximity browser.");
            }
        }
        catch (GraphLayoutException var1_2) {
            throw var1_2;
        }
        catch (Exception var1_3) {
            throw new GraphLayoutException(var1_3, "Failed to update proximity browser.");
        }
    }

    @Override
    public void execute() {
        ProximityBrowserUpdater.executeStatic(this.referenceGraph);
    }
}

