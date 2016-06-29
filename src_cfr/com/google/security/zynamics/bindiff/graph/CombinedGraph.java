/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph$1;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.editmode.CombinedGraphEditMode;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.searchers.CombinedGraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;

public final class CombinedGraph
extends BinDiffGraph {
    private SelectionHistory selectionHistory;
    private GraphSearcher graphSearcher;

    public CombinedGraph(ZyGraph2DView zyGraph2DView, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, GraphSettings graphSettings, EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        this.selectionHistory = new SelectionHistory(this, 30);
        this.graphSearcher = new CombinedGraphSearcher();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CombinedDiffEdge buildDiffEdge(CombinedGraph combinedGraph, SuperViewEdge superViewEdge, SuperDiffEdge superDiffEdge) {
        CombinedGraph combinedGraph2;
        d d2 = null;
        RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(zyLabelContent, null, combinedGraph.getSettings());
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getSource());
        CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getTarget());
        q q2 = combinedDiffNode.getNode();
        q q3 = combinedDiffNode2.getNode();
        boolean bl2 = combinedDiffNode.getRawNode().isVisible();
        boolean bl3 = combinedDiffNode2.getRawNode().isVisible();
        combinedDiffNode.getRawNode().setVisible(true);
        combinedDiffNode2.getRawNode().setVisible(true);
        d2 = combinedGraph.getGraph().a(q2, q3);
        CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, d2, combinedEdgeRealizer, rawCombinedJump, superDiffEdge);
        CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
        combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
        combinedDiffNode.getRawNode().setVisible(bl2);
        combinedDiffNode2.getRawNode().setVisible(bl3);
        combinedGraph.addEdgeToMappings(combinedDiffEdge);
        if (bl2) {
            if (bl3) return combinedDiffEdge;
        }
        CombinedGraph combinedGraph3 = combinedGraph2 = combinedGraph;
        boolean bl4 = LayoutCommandHelper.deactiveAutoLayout(combinedGraph3);
        try {
            ProximityBrowserUnhideNode.executeStatic(combinedGraph3, bl2 ? combinedDiffNode : combinedDiffNode2);
            return combinedDiffEdge;
        }
        finally {
            LayoutCommandHelper.activateAutoLayout(combinedGraph3, bl4);
        }
    }

    public static CombinedDiffNode buildDiffNode(CombinedGraph combinedGraph, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, SuperDiffNode superDiffNode, RawCombinedBasicBlock rawCombinedBasicBlock) {
        ZyLabelContent zyLabelContent = null;
        if (singleDiffNode != null) {
            zyLabelContent = singleDiffNode.getRealizer().getNodeContent();
        }
        ZyLabelContent zyLabelContent2 = null;
        if (singleDiffNode2 != null) {
            zyLabelContent2 = singleDiffNode2.getRealizer().getNodeContent();
        }
        CombinedNodeRealizer combinedNodeRealizer = new CombinedNodeRealizer(zyLabelContent, zyLabelContent2);
        CodeNodeRealizerUpdater codeNodeRealizerUpdater = new CodeNodeRealizerUpdater();
        combinedNodeRealizer.setUpdater(codeNodeRealizerUpdater);
        codeNodeRealizerUpdater.setRealizer(combinedNodeRealizer);
        q q2 = combinedGraph.getGraph().d();
        CombinedDiffNode combinedDiffNode = new CombinedDiffNode(q2, combinedNodeRealizer, rawCombinedBasicBlock, superDiffNode);
        combinedNodeRealizer.setUserData(new ZyNodeData(combinedDiffNode));
        return combinedDiffNode;
    }

    @Override
    protected CombinedGraphEditMode createEditMode() {
        return new CombinedGraphEditMode(this);
    }

    @Override
    public void dispose() {
        this.selectionHistory.dispose();
        super.dispose();
        this.graphSearcher.clearResults();
        this.selectionHistory = null;
        this.graphSearcher = null;
    }

    @Override
    public GraphSearcher getGraphSearcher() {
        return this.graphSearcher;
    }

    @Override
    public Set getSelectedNodes() {
        return new HashSet(CollectionHelpers.filter(this.getNodes(), new CombinedGraph$1(this)));
    }

    public SelectionHistory getSelectionHistory() {
        return this.selectionHistory;
    }
}

