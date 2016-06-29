/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph$1;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.editmode.SingleGraphEditMode;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffBasicBlockNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphMappings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;

public class SingleGraph
extends BinDiffGraph {
    private SelectionHistory selectionHistory;
    private GraphSearcher graphSearcher;
    private final IAddress functionAddress;
    private final ESide side;

    public SingleGraph(ZyGraph2DView zyGraph2DView, IAddress iAddress, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, GraphSettings graphSettings, ESide eSide, EGraphType eGraphType) {
        super(zyGraph2DView, linkedHashMap, linkedHashMap2, graphSettings, eGraphType);
        this.selectionHistory = new SelectionHistory(this, 30);
        this.graphSearcher = new GraphSearcher();
        Preconditions.checkNotNull((Object)eSide);
        this.functionAddress = iAddress;
        this.side = eSide;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static SingleDiffEdge buildDiffEdge(SingleGraph singleGraph, SuperViewEdge superViewEdge) {
        SingleGraph singleGraph2;
        RawJump rawJump;
        SingleDiffEdge singleDiffEdge = null;
        d d2 = null;
        RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        RawBasicBlock rawBasicBlock = rawCombinedJump.getSource().getRawNode(singleGraph.getSide());
        RawBasicBlock rawBasicBlock2 = rawCombinedJump.getTarget().getRawNode(singleGraph.getSide());
        RawJump rawJump2 = rawJump = singleGraph.getSide() == ESide.PRIMARY ? rawCombinedJump.getPrimaryEdge() : rawCombinedJump.getSecondaryEdge();
        if (rawJump == null) {
            return null;
        }
        SingleEdgeRealizer singleEdgeRealizer = null;
        if (rawBasicBlock == null) return singleDiffEdge;
        if (rawBasicBlock2 == null) return singleDiffEdge;
        if (rawJump == null) return singleDiffEdge;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        singleEdgeRealizer = new SingleEdgeRealizer(zyLabelContent, null, singleGraph.getSettings());
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(rawBasicBlock);
        SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleGraph.getNode(rawBasicBlock2);
        boolean bl2 = singleDiffNode.getRawNode().isVisible();
        boolean bl3 = singleDiffNode2.getRawNode().isVisible();
        singleDiffNode.getRawNode().setVisible(true);
        singleDiffNode2.getRawNode().setVisible(true);
        d2 = singleGraph.getGraph().a(singleDiffNode.getNode(), singleDiffNode2.getNode());
        singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, d2, singleEdgeRealizer, rawJump, singleGraph.getSide());
        SingleDiffNode.link(singleDiffNode, singleDiffNode2);
        singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
        singleDiffNode.getRawNode().setVisible(bl2);
        singleDiffNode2.getRawNode().setVisible(bl3);
        singleGraph.addEdgeToMappings(singleDiffEdge);
        if (bl2) {
            if (bl3) return singleDiffEdge;
        }
        SingleGraph singleGraph3 = singleGraph2 = singleGraph;
        boolean bl4 = LayoutCommandHelper.deactiveAutoLayout(singleGraph3);
        try {
            ProximityBrowserUnhideNode.executeStatic(singleGraph3, bl2 ? singleDiffNode : singleDiffNode2);
            return singleDiffEdge;
        }
        finally {
            LayoutCommandHelper.activateAutoLayout(singleGraph3, bl4);
        }
    }

    public static SingleDiffNode buildDiffNode(SingleGraph singleGraph, FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph, RawCombinedBasicBlock rawCombinedBasicBlock) {
        SingleDiffBasicBlockNode singleDiffBasicBlockNode = null;
        ZyLabelContent zyLabelContent = null;
        bu bu2 = singleGraph.getGraph();
        RawBasicBlock rawBasicBlock = rawCombinedBasicBlock.getRawNode(singleGraph.getSide());
        if (rawBasicBlock == null) return singleDiffBasicBlockNode;
        zyLabelContent = ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, singleGraph.getSide());
        ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(zyLabelContent);
        CodeNodeRealizerUpdater codeNodeRealizerUpdater = new CodeNodeRealizerUpdater();
        zyNormalNodeRealizer.setUpdater(codeNodeRealizerUpdater);
        codeNodeRealizerUpdater.setRealizer(zyNormalNodeRealizer);
        q q2 = bu2.d();
        singleDiffBasicBlockNode = new SingleDiffBasicBlockNode(q2, zyNormalNodeRealizer, rawBasicBlock, singleGraph.getSide());
        zyNormalNodeRealizer.setUserData(new ZyNodeData(singleDiffBasicBlockNode));
        return singleDiffBasicBlockNode;
    }

    @Override
    protected ZyEditMode createEditMode() {
        return new SingleGraphEditMode(this);
    }

    @Override
    public void dispose() {
        this.selectionHistory.dispose();
        super.dispose();
        this.graphSearcher.clearResults();
        this.selectionHistory = null;
        this.graphSearcher = null;
    }

    public IAddress getFunctionAddress() {
        return this.functionAddress;
    }

    @Override
    public GraphSearcher getGraphSearcher() {
        return this.graphSearcher;
    }

    public SingleGraph getOtherSideGraph() {
        SingleGraph singleGraph;
        if (this.side == ESide.PRIMARY) {
            singleGraph = this.getSecondaryGraph();
            return singleGraph;
        }
        singleGraph = this.getPrimaryGraph();
        return singleGraph;
    }

    @Override
    public Set getSelectedNodes() {
        return new HashSet(CollectionHelpers.filter(super.getMappings().getNodes(), new SingleGraph$1(this)));
    }

    public SelectionHistory getSelectionHistory() {
        return this.selectionHistory;
    }

    public ESide getSide() {
        return this.side;
    }
}

