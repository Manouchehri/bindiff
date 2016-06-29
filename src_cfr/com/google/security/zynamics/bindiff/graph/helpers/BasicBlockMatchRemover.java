/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
import com.google.security.zynamics.bindiff.graph.layout.LayoutCommandHelper;
import com.google.security.zynamics.bindiff.graph.layout.commands.GraphLayoutUpdater;
import com.google.security.zynamics.bindiff.graph.layout.commands.ProximityBrowserUnhideNode;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffBasicBlockNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CodeNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.h.bu;

public class BasicBlockMatchRemover {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static CombinedDiffEdge buildDiffEdge(CombinedGraph combinedGraph, SuperViewEdge superViewEdge, SuperDiffEdge superDiffEdge) {
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static SingleDiffEdge buildDiffEdge(SingleGraph singleGraph, SuperViewEdge superViewEdge) {
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

    private static SuperDiffEdge buildDiffEdge(SuperGraph superGraph, SuperViewEdge superViewEdge, SingleDiffEdge singleDiffEdge, SingleDiffEdge singleDiffEdge2) {
        d d2 = null;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(zyLabelContent, null);
        ZyGraphNode zyGraphNode = null;
        ZyGraphNode zyGraphNode2 = null;
        if (singleDiffEdge != null) {
            zyGraphNode = ((SingleDiffNode)singleDiffEdge.getSource()).getSuperDiffNode();
            zyGraphNode2 = ((SingleDiffNode)singleDiffEdge.getTarget()).getSuperDiffNode();
        } else if (singleDiffEdge2 != null) {
            zyGraphNode = ((SingleDiffNode)singleDiffEdge2.getSource()).getSuperDiffNode();
            zyGraphNode2 = ((SingleDiffNode)singleDiffEdge2.getTarget()).getSuperDiffNode();
        }
        q q2 = zyGraphNode.getNode();
        q q3 = zyGraphNode2.getNode();
        boolean bl2 = zyGraphNode.getRawNode().isVisible();
        boolean bl3 = zyGraphNode2.getRawNode().isVisible();
        zyGraphNode.getRawNode().setVisible(true);
        zyGraphNode2.getRawNode().setVisible(true);
        d2 = superGraph.getGraph().a(q2, q3);
        SuperDiffEdge superDiffEdge = new SuperDiffEdge((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2, d2, zyEdgeRealizer, superViewEdge, singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        zyGraphNode.getRawNode().setVisible(bl2);
        zyGraphNode2.getRawNode().setVisible(bl3);
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }

    private static CombinedDiffNode buildDiffNode(CombinedGraph combinedGraph, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, SuperDiffNode superDiffNode, RawCombinedBasicBlock rawCombinedBasicBlock) {
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

    private static SingleDiffNode buildDiffNode(SingleGraph singleGraph, FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph, RawCombinedBasicBlock rawCombinedBasicBlock) {
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

    private static SuperDiffNode buildDiffNode(SuperGraph superGraph, SingleDiffNode singleDiffNode, SingleDiffNode singleDiffNode2, SuperViewNode superViewNode) {
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(zyLabelContent);
        q q2 = superGraph.getGraph().d();
        SuperDiffNode superDiffNode = new SuperDiffNode(q2, zyNormalNodeRealizer, superViewNode, singleDiffNode, singleDiffNode2);
        zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
        return superDiffNode;
    }

    private static RawCombinedFlowGraph getRawCombinedFlowgraph(GraphsContainer graphsContainer, CombinedDiffNode combinedDiffNode) {
        IAddress iAddress = ((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getPrimaryFunctionAddress();
        IAddress iAddress2 = ((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getSecondaryFunctionAddress();
        ViewManager viewManager = graphsContainer.getDiff().getViewManager();
        FlowGraphViewData flowGraphViewData = viewManager.getFlowgraphViewData(iAddress, iAddress2);
        return flowGraphViewData.getCombinedRawGraph();
    }

    private static void insertNewDiffEdges(GraphsContainer graphsContainer, SuperDiffNode superDiffNode) {
        SuperGraph superGraph = graphsContainer.getSuperGraph();
        CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        SingleGraph singleGraph = graphsContainer.getPrimaryGraph();
        SingleGraph singleGraph2 = graphsContainer.getSecondaryGraph();
        SuperViewNode superViewNode = superDiffNode.getRawNode();
        HashSet hashSet = new HashSet();
        hashSet.addAll(superViewNode.getIncomingEdges());
        hashSet.addAll(superViewNode.getOutgoingEdges());
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            SuperViewEdge superViewEdge = (SuperViewEdge)iterator.next();
            SingleDiffEdge singleDiffEdge = BasicBlockMatchRemover.buildDiffEdge(singleGraph, superViewEdge);
            SingleDiffEdge singleDiffEdge2 = BasicBlockMatchRemover.buildDiffEdge(singleGraph2, superViewEdge);
            SuperDiffEdge superDiffEdge = BasicBlockMatchRemover.buildDiffEdge(superGraph, superViewEdge, singleDiffEdge, singleDiffEdge2);
            CombinedDiffEdge combinedDiffEdge = BasicBlockMatchRemover.buildDiffEdge(combinedGraph, superViewEdge, superDiffEdge);
            ZyEdgeRealizer zyEdgeRealizer = null;
            ZyEdgeRealizer zyEdgeRealizer2 = null;
            superDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
            if (singleDiffEdge != null) {
                singleDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
                zyEdgeRealizer = singleDiffEdge.getRealizer();
            }
            if (singleDiffEdge2 != null) {
                singleDiffEdge2.setCombinedDiffEdge(combinedDiffEdge);
                zyEdgeRealizer2 = singleDiffEdge2.getRealizer();
            }
            RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
            ViewFlowGraphBuilder.colorizeJumps(rawCombinedJump, zyEdgeRealizer, zyEdgeRealizer2);
            ViewFlowGraphBuilder.stylizeJumps(rawCombinedJump, combinedDiffEdge.getRealizer(), zyEdgeRealizer, zyEdgeRealizer2);
        }
    }

    private static void insertNewDiffNodes(GraphsContainer graphsContainer, RawCombinedFlowGraph rawCombinedFlowGraph, SuperViewNode superViewNode) {
        RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)superViewNode.getCombinedNode();
        ESide eSide = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY) != null ? ESide.PRIMARY : ESide.SECONDARY;
        CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        SingleGraph singleGraph = eSide == ESide.PRIMARY ? graphsContainer.getPrimaryGraph() : graphsContainer.getSecondaryGraph();
        SuperGraph superGraph = graphsContainer.getSuperGraph();
        MatchData matchData = graphsContainer.getDiff().getMatches();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(eSide == ESide.PRIMARY ? rawCombinedBasicBlock.getPrimaryFunctionAddress() : rawCombinedBasicBlock.getSecondaryFunctionAddress(), eSide);
        SingleDiffNode singleDiffNode = BasicBlockMatchRemover.buildDiffNode(singleGraph, functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock);
        SuperDiffNode superDiffNode = BasicBlockMatchRemover.buildDiffNode(superGraph, eSide == ESide.PRIMARY ? singleDiffNode : null, eSide == ESide.SECONDARY ? singleDiffNode : null, superViewNode);
        CombinedDiffNode combinedDiffNode = BasicBlockMatchRemover.buildDiffNode(combinedGraph, eSide == ESide.PRIMARY ? singleDiffNode : null, eSide == ESide.SECONDARY ? singleDiffNode : null, superDiffNode, rawCombinedBasicBlock);
        superDiffNode.setCombinedDiffNode(combinedDiffNode);
        singleDiffNode.setCombinedDiffNode(combinedDiffNode);
        singleGraph.addNodeToMappings(singleDiffNode);
        BasicBlockContentEditor basicBlockContentEditor = new BasicBlockContentEditor(functionMatchData, graphsContainer, eSide);
        singleDiffNode.getRealizer().getNodeContent().setLineEditor(basicBlockContentEditor);
        combinedGraph.addNodeToMappings(combinedDiffNode);
        superGraph.addNodeToMappings(superDiffNode);
        ViewFlowGraphBuilder.colorizeBasicblocks(functionMatchData, rawCombinedBasicBlock);
        ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(combinedGraph.getNodes(), combinedGraph.getPrimaryGraph().getFunctionAddress(), combinedGraph.getSecondaryGraph().getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(singleGraph.getNodes(), singleGraph.getFunctionAddress());
        superGraph.refreshSuperNodeSize(graphsContainer.getPrimaryGraph(), graphsContainer.getSecondaryGraph(), superDiffNode);
        BasicBlockMatchRemover.insertNewDiffEdges(graphsContainer, superDiffNode);
    }

    private static void insertNewRawNodes(RawCombinedFlowGraph rawCombinedFlowGraph, RawFlowGraph rawFlowGraph, Set set, SuperViewNode superViewNode, RawBasicBlock rawBasicBlock, RawCombinedBasicBlock rawCombinedBasicBlock, SuperViewNode superViewNode2) {
        rawCombinedFlowGraph.addNode(rawCombinedBasicBlock);
        rawFlowGraph.addNode(rawBasicBlock);
        ESide eSide = rawFlowGraph.getSide();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            SuperViewEdge superViewEdge = (SuperViewEdge)iterator.next();
            if (superViewEdge.getSingleEdge(eSide) == null) continue;
            SuperViewNode superViewNode3 = (SuperViewNode)superViewEdge.getSource();
            RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)superViewNode3.getCombinedNode();
            RawBasicBlock rawBasicBlock2 = rawCombinedBasicBlock2.getRawNode(eSide);
            SuperViewNode superViewNode4 = (SuperViewNode)superViewEdge.getTarget();
            RawCombinedBasicBlock rawCombinedBasicBlock3 = (RawCombinedBasicBlock)superViewNode4.getCombinedNode();
            RawBasicBlock rawBasicBlock3 = rawCombinedBasicBlock3.getRawNode(eSide);
            if (superViewNode4 == superViewNode) {
                superViewNode4 = superViewNode2;
                rawCombinedBasicBlock3 = rawCombinedBasicBlock;
                rawBasicBlock3 = rawBasicBlock;
            }
            if (superViewNode3 == superViewNode) {
                superViewNode3 = superViewNode2;
                rawCombinedBasicBlock2 = rawCombinedBasicBlock;
                rawBasicBlock2 = rawBasicBlock;
            }
            RawJump rawJump = null;
            EJumpType eJumpType = ((RawJump)superViewEdge.getSingleEdge(eSide)).getJumpType();
            rawJump = new RawJump(rawBasicBlock2, rawBasicBlock3, eJumpType);
            rawFlowGraph.addEdge(rawJump);
            RawCombinedJump rawCombinedJump = new RawCombinedJump(rawCombinedBasicBlock2, rawCombinedBasicBlock3, eSide == ESide.PRIMARY ? rawJump : null, eSide == ESide.SECONDARY ? rawJump : null);
            rawCombinedFlowGraph.addEdge(rawCombinedJump);
            new SuperViewEdge(rawCombinedJump, superViewNode3, superViewNode4);
        }
    }

    private static void removeBasicblockMatch(GraphsContainer graphsContainer, RawCombinedBasicBlock rawCombinedBasicBlock) {
        MatchData matchData = graphsContainer.getDiff().getMatches();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(rawCombinedBasicBlock.getPrimaryFunctionAddress(), ESide.PRIMARY);
        functionMatchData.removeBasicblockMatch(graphsContainer.getDiff(), rawCombinedBasicBlock);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static void syncBasicblockVisibility(GraphsContainer graphsContainer, CombinedDiffNode combinedDiffNode) {
        GraphSettings graphSettings = graphsContainer.getSettings();
        if (!graphSettings.isAsync()) return;
        boolean bl2 = LayoutCommandHelper.deactiveAutoLayout(graphsContainer.getCombinedGraph());
        try {
            if (graphSettings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
                combinedDiffNode.getPrimaryRawNode().setVisible(true);
                combinedDiffNode.getSecondaryRawNode().setVisible(true);
                combinedDiffNode.getSuperRawNode().setVisible(true);
                return;
            }
            if (graphSettings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
            combinedDiffNode.getRawNode().setVisible(true);
            combinedDiffNode.getPrimaryRawNode().setVisible(true);
            combinedDiffNode.getSecondaryRawNode().setVisible(true);
            combinedDiffNode.getSuperRawNode().setVisible(true);
            return;
        }
        finally {
            LayoutCommandHelper.activateAutoLayout(graphsContainer.getCombinedGraph(), bl2);
        }
    }

    public static void doSynchronizedLayout(CombinedGraph combinedGraph) {
        if (!LayoutCommandHelper.isAutolayout(combinedGraph)) return;
        GraphSettings graphSettings = combinedGraph.getSettings();
        if (graphSettings.isSync() || graphSettings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            GraphLayoutUpdater.executeStatic(combinedGraph, true);
            return;
        }
        if (graphSettings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
        if (graphSettings.getFocus() == ESide.PRIMARY) {
            GraphLayoutUpdater.executeStatic(combinedGraph.getPrimaryGraph(), true);
        }
        if (graphSettings.getFocus() != ESide.SECONDARY) return;
        GraphLayoutUpdater.executeStatic(combinedGraph.getSecondaryGraph(), true);
    }

    public static List getAffectedCombinedNodes(BinDiffGraph binDiffGraph) {
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        if (binDiffGraph instanceof CombinedGraph) {
            for (CombinedDiffNode combinedDiffNode : ((CombinedGraph)binDiffGraph).getSelectedNodes()) {
                if (combinedDiffNode.getRawNode().getMatchState() != EMatchState.MATCHED) continue;
                arrayList.add(combinedDiffNode);
            }
        } else if (binDiffGraph instanceof SingleGraph) {
            for (SingleDiffNode singleDiffNode : ((SingleGraph)binDiffGraph).getSelectedNodes()) {
                if (singleDiffNode.getRawNode().getMatchState() != EMatchState.MATCHED || !singleDiffNode.isSelected() || !singleDiffNode.isVisible() || !singleDiffNode.getOtherSideDiffNode().isSelected() || !singleDiffNode.getOtherSideDiffNode().isVisible()) continue;
                arrayList.add(singleDiffNode.getCombinedDiffNode());
            }
        }
        if (arrayList.size() == 0) return null;
        return arrayList;
    }

    public static List getAffectedCombinedNodes(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        if (!zyGraphNode.isSelected()) return null;
        return BasicBlockMatchRemover.getAffectedCombinedNodes(binDiffGraph);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeBasicblockMatch(GraphsContainer graphsContainer, CombinedDiffNode combinedDiffNode) {
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();
        try {
            SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            SingleDiffNode singleDiffNode = combinedDiffNode.getPrimaryDiffNode();
            SingleDiffNode singleDiffNode2 = combinedDiffNode.getSecondaryDiffNode();
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
            SuperViewNode superViewNode = superDiffNode.getRawNode();
            RawBasicBlock rawBasicBlock = (RawBasicBlock)singleDiffNode.getRawNode();
            RawBasicBlock rawBasicBlock2 = (RawBasicBlock)singleDiffNode2.getRawNode();
            RawCombinedFlowGraph rawCombinedFlowGraph = BasicBlockMatchRemover.getRawCombinedFlowgraph(graphsContainer, combinedDiffNode);
            RawFlowGraph rawFlowGraph = rawCombinedFlowGraph.getPrimaryFlowgraph();
            RawFlowGraph rawFlowGraph2 = rawCombinedFlowGraph.getSecondaryFlowgraph();
            BasicBlockMatchRemover.syncBasicblockVisibility(graphsContainer, combinedDiffNode);
            HashSet hashSet = new HashSet();
            hashSet.addAll(superViewNode.getIncomingEdges());
            hashSet.addAll(superViewNode.getOutgoingEdges());
            rawCombinedFlowGraph.removeNode(rawCombinedBasicBlock);
            superViewNode.removeNode();
            rawFlowGraph.removeNode(rawBasicBlock);
            rawFlowGraph2.removeNode(rawBasicBlock2);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode);
            graphsContainer.getPrimaryGraph().deleteNode(singleDiffNode);
            graphsContainer.getSecondaryGraph().deleteNode(singleDiffNode2);
            RawBasicBlock rawBasicBlock3 = rawBasicBlock.clone(EMatchState.PRIMARY_UNMATCHED);
            RawBasicBlock rawBasicBlock4 = rawBasicBlock2.clone(EMatchState.SECONDRAY_UNMATCHED);
            RawCombinedBasicBlock rawCombinedBasicBlock2 = new RawCombinedBasicBlock(rawBasicBlock3, null, null, rawBasicBlock.getFunctionAddr(), null);
            RawCombinedBasicBlock rawCombinedBasicBlock3 = new RawCombinedBasicBlock(null, rawBasicBlock4, null, null, rawBasicBlock2.getFunctionAddr());
            SuperViewNode superViewNode2 = new SuperViewNode(rawCombinedBasicBlock2);
            SuperViewNode superViewNode3 = new SuperViewNode(rawCombinedBasicBlock3);
            BasicBlockMatchRemover.insertNewRawNodes(rawCombinedFlowGraph, rawFlowGraph, hashSet, superViewNode, rawBasicBlock3, rawCombinedBasicBlock2, superViewNode2);
            BasicBlockMatchRemover.insertNewRawNodes(rawCombinedFlowGraph, rawFlowGraph2, hashSet, superViewNode, rawBasicBlock4, rawCombinedBasicBlock3, superViewNode3);
            BasicBlockMatchRemover.removeBasicblockMatch(graphsContainer, rawCombinedBasicBlock);
            BasicBlockMatchRemover.insertNewDiffNodes(graphsContainer, rawCombinedFlowGraph, superViewNode2);
            BasicBlockMatchRemover.insertNewDiffNodes(graphsContainer, rawCombinedFlowGraph, superViewNode3);
            graphsContainer.getDiff().getMatches().notifyBasicblockMatchRemovedListener(rawBasicBlock3.getFunctionAddr(), rawBasicBlock4.getFunctionAddr(), rawBasicBlock3.getAddress(), rawBasicBlock4.getAddress());
        }
        finally {
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
        }
        BasicBlockMatchRemover.doSynchronizedLayout(graphsContainer.getCombinedGraph());
    }
}

