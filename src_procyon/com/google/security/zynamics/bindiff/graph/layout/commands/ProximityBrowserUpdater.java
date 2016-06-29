package com.google.security.zynamics.bindiff.graph.layout.commands;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.graph.settings.*;

public final class ProximityBrowserUpdater implements ICommand
{
    private final BinDiffGraph referenceGraph;
    
    public ProximityBrowserUpdater(final BinDiffGraph binDiffGraph) {
        this.referenceGraph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }
    
    private static void createNewProximityNodeAndEdge(final bu bu, final CombinedDiffNode combinedDiffNode, final int n, final boolean b) {
        if (n == 0) {
            return;
        }
        final ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n), new Font("New Courier", 0, 12), null));
        final ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        final ZyProximityNode zyProximityNode = new ZyProximityNode(bu.a(zyProximityNodeRealizer), zyProximityNodeRealizer, combinedDiffNode, b);
        zyProximityNodeRealizer.setUserData(new ZyNodeData(zyProximityNode));
        final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        zyEdgeRealizer.setUserData(new ZyEdgeData(new ZyInfoEdge(b ? combinedDiffNode : zyProximityNode, b ? zyProximityNode : combinedDiffNode, bu.a(b ? combinedDiffNode.getNode() : zyProximityNode.getNode(), b ? zyProximityNode.getNode() : combinedDiffNode.getNode(), zyEdgeRealizer), zyEdgeRealizer)));
    }
    
    private static void createNewProximityNodeAndEdge(final bu bu, final SingleDiffNode singleDiffNode, final int n, final boolean b) {
        if (n == 0) {
            return;
        }
        final ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        zyLabelContent.addLineContent(new ZyLineContent(String.valueOf(n), new Font("New Courier", 0, 12), null));
        final ZyProximityNodeRealizer zyProximityNodeRealizer = new ZyProximityNodeRealizer(zyLabelContent);
        final ZyProximityNode zyProximityNode = new ZyProximityNode(bu.a(zyProximityNodeRealizer), zyProximityNodeRealizer, singleDiffNode, b);
        zyProximityNodeRealizer.setUserData(new ZyNodeData(zyProximityNode));
        final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        zyEdgeRealizer.setLineType(dr.b);
        zyEdgeRealizer.setUserData(new ZyEdgeData(new ZyInfoEdge(b ? singleDiffNode : zyProximityNode, b ? zyProximityNode : singleDiffNode, bu.a(b ? singleDiffNode.getNode() : zyProximityNode.getNode(), b ? zyProximityNode.getNode() : singleDiffNode.getNode(), zyEdgeRealizer), zyEdgeRealizer)));
    }
    
    private static void unhideAllNodes(final BinDiffGraph binDiffGraph) {
        for (final ZyGraphNode zyGraphNode : binDiffGraph.getNodes()) {
            if (!zyGraphNode.isVisible()) {
                zyGraphNode.getRawNode().setVisible(true);
            }
        }
    }
    
    private static void updateGraphVisibility(final BinDiffGraph binDiffGraph) {
        final HashSet set = new HashSet();
        final HashSet set2 = new HashSet();
        set2.addAll(binDiffGraph.getNodes());
        set.addAll(binDiffGraph.getSelectedNodes());
        set2.removeAll(set);
        binDiffGraph.showNodes(set, set2);
    }
    
    private static void updateProximityBrowserInAsyncMode(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph instanceof CombinedGraph) {
            updateGraphVisibility(binDiffGraph);
            deleteAllProximityNodes(binDiffGraph);
            createProximityNodesAndEdges((CombinedGraph)binDiffGraph);
        }
        else if (binDiffGraph instanceof SingleGraph) {
            updateGraphVisibility(binDiffGraph);
            deleteAllProximityNodes(binDiffGraph);
            createProximityNodesAndEdges((SingleGraph)binDiffGraph);
        }
    }
    
    protected static void adoptSuperGraphVisibility(final SuperGraph superGraph) {
        for (final SuperDiffNode superDiffNode : superGraph.getNodes()) {
            final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
            if (primaryDiffNode != null) {
                primaryDiffNode.getRawNode().setVisible(superDiffNode.isVisible());
            }
            final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
            if (secondaryDiffNode != null) {
                secondaryDiffNode.getRawNode().setVisible(superDiffNode.isVisible());
            }
        }
        for (final SuperDiffEdge superDiffEdge : superGraph.getEdges()) {
            final SingleDiffEdge primaryDiffEdge = superDiffEdge.getPrimaryDiffEdge();
            final SingleDiffEdge secondaryDiffEdge = superDiffEdge.getSecondaryDiffEdge();
            if (primaryDiffEdge != null) {
                ((SingleViewEdge)superDiffEdge.getPrimaryDiffEdge().getRawEdge()).setVisible(superDiffEdge.isVisible());
            }
            if (secondaryDiffEdge != null) {
                ((SingleViewEdge)superDiffEdge.getSecondaryDiffEdge().getRawEdge()).setVisible(superDiffEdge.isVisible());
            }
        }
    }
    
    protected static void createProximityNodesAndEdges(final CombinedGraph combinedGraph) {
        final bu graph = combinedGraph.getGraph();
        for (final CombinedDiffNode combinedDiffNode : combinedGraph.getNodes()) {
            if (combinedDiffNode.isVisible()) {
                final HashSet<CombinedDiffNode> set = new HashSet<CombinedDiffNode>();
                for (final CombinedDiffNode combinedDiffNode2 : combinedDiffNode.getParents()) {
                    if (!combinedDiffNode2.isVisible()) {
                        set.add(combinedDiffNode2);
                    }
                }
                createNewProximityNodeAndEdge(graph, combinedDiffNode, set.size(), false);
                final HashSet<CombinedDiffNode> set2 = new HashSet<CombinedDiffNode>();
                for (final CombinedDiffNode combinedDiffNode3 : combinedDiffNode.getChildren()) {
                    if (!combinedDiffNode3.isVisible()) {
                        set2.add(combinedDiffNode3);
                    }
                }
                createNewProximityNodeAndEdge(graph, combinedDiffNode, set2.size(), true);
            }
        }
    }
    
    protected static void createProximityNodesAndEdges(final SingleGraph singleGraph) {
        final bu graph = singleGraph.getGraph();
        for (final SingleDiffNode singleDiffNode : singleGraph.getNodes()) {
            if (singleDiffNode.isVisible()) {
                final HashSet<SingleDiffNode> set = new HashSet<SingleDiffNode>();
                for (final SingleDiffNode singleDiffNode2 : singleDiffNode.getParents()) {
                    if (!singleDiffNode2.isVisible()) {
                        set.add(singleDiffNode2);
                    }
                }
                createNewProximityNodeAndEdge(graph, singleDiffNode, set.size(), false);
                final HashSet<SingleDiffNode> set2 = new HashSet<SingleDiffNode>();
                for (final SingleDiffNode singleDiffNode3 : singleDiffNode.getChildren()) {
                    if (!singleDiffNode3.isVisible()) {
                        set2.add(singleDiffNode3);
                    }
                }
                createNewProximityNodeAndEdge(graph, singleDiffNode, set2.size(), true);
            }
        }
    }
    
    static void createProximityNodesAndEdges(final SuperGraph superGraph) {
        final bu graph = superGraph.getPrimaryGraph().getGraph();
        final bu graph2 = superGraph.getSecondaryGraph().getGraph();
        if (superGraph.getSettings().getProximitySettings().getProximityBrowsing()) {
            for (final q q : superGraph.getGraph().m()) {
                if (superGraph.getGraph().t(q) instanceof ZyProximityNodeRealizer) {
                    if (q.b() == 0 && q.c() == 1) {
                        final SuperDiffNode superDiffNode = (SuperDiffNode)superGraph.getNode(q.f().d());
                        final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
                        if (primaryDiffNode != null) {
                            createNewProximityNodeAndEdge(graph, primaryDiffNode, NodeHelpers.countInvisibleIndegreeNeighbours(primaryDiffNode.getRawNode()), false);
                        }
                        final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
                        if (secondaryDiffNode != null) {
                            createNewProximityNodeAndEdge(graph2, secondaryDiffNode, NodeHelpers.countInvisibleIndegreeNeighbours(secondaryDiffNode.getRawNode()), false);
                        }
                    }
                    else if (q.b() == 1 && q.c() == 0) {
                        final SuperDiffNode superDiffNode2 = (SuperDiffNode)superGraph.getNode(q.g().c());
                        final SingleDiffNode primaryDiffNode2 = superDiffNode2.getPrimaryDiffNode();
                        if (primaryDiffNode2 != null) {
                            createNewProximityNodeAndEdge(graph, primaryDiffNode2, NodeHelpers.countInvisibleOutdegreeNeighbours(primaryDiffNode2.getRawNode()), true);
                        }
                        final SingleDiffNode secondaryDiffNode2 = superDiffNode2.getSecondaryDiffNode();
                        if (secondaryDiffNode2 != null) {
                            createNewProximityNodeAndEdge(graph2, secondaryDiffNode2, NodeHelpers.countInvisibleOutdegreeNeighbours(secondaryDiffNode2.getRawNode()), true);
                        }
                    }
                    else {
                        Logger.logSevere("Malformed graph. Super proximity node without incoming or outgoing edge.", new Object[0]);
                    }
                }
            }
        }
    }
    
    static void deleteAllProximityNodes(final BinDiffGraph binDiffGraph) {
        final bu graph = binDiffGraph.getGraph();
        try {
            graph.r();
            binDiffGraph.getProximityBrowser().deleteProximityNodes();
            final x o = graph.o();
            while (o.f()) {
                if (graph.t(o.e()) instanceof ZyProximityNodeRealizer) {
                    if (o.e().e() != graph) {
                        throw new GraphLayoutException("Delete proximity node failed. Couldn't update proximity browsing.");
                    }
                    graph.a(o.e());
                }
                o.g();
            }
        }
        finally {
            graph.s();
        }
    }
    
    public static void executeStatic(final BinDiffGraph binDiffGraph) {
        try {
            final GraphProximityBrowsingSettings proximitySettings = binDiffGraph.getSettings().getProximitySettings();
            if (proximitySettings.getProximityBrowsing() && !proximitySettings.getProximityBrowsingFrozen()) {
                final boolean automaticLayouting = binDiffGraph.getSettings().getLayoutSettings().getAutomaticLayouting();
                binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(false);
                if (binDiffGraph.getSettings().isSync()) {
                    updateGraphVisibility(binDiffGraph.getCombinedGraph());
                    updateGraphVisibility(binDiffGraph.getSuperGraph());
                    adoptSuperGraphVisibility(binDiffGraph.getSuperGraph());
                    deleteAllProximityNodes(binDiffGraph.getPrimaryGraph());
                    deleteAllProximityNodes(binDiffGraph.getSecondaryGraph());
                    createProximityNodesAndEdges(binDiffGraph.getSuperGraph());
                }
                else {
                    updateProximityBrowserInAsyncMode(binDiffGraph);
                }
                GraphsIntermediateListeners.notifyIntermediateVisibilityListeners(binDiffGraph);
                binDiffGraph.getSettings().getLayoutSettings().setAutomaticLayouting(automaticLayouting);
            }
            else if (!proximitySettings.getProximityBrowsing()) {
                try {
                    unhideAllNodes(binDiffGraph.getSuperGraph());
                    unhideAllNodes(binDiffGraph.getPrimaryGraph());
                    unhideAllNodes(binDiffGraph.getSecondaryGraph());
                    unhideAllNodes(binDiffGraph.getCombinedGraph());
                }
                catch (Exception ex) {
                    throw new GraphLayoutException(ex, "Failed to unhide node. Couldn't update proximity browser.");
                }
            }
        }
        catch (GraphLayoutException ex2) {
            throw ex2;
        }
        catch (Exception ex3) {
            throw new GraphLayoutException(ex3, "Failed to update proximity browser.");
        }
    }
    
    @Override
    public void execute() {
        executeStatic(this.referenceGraph);
    }
}
