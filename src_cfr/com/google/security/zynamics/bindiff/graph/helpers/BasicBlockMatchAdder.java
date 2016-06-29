/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.database.MatchesDatabase;
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
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder$1;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder$InternalStruct;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchRemover;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
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
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicBlockMatchAdder {
    private static BasicBlockMatchData createBasicblockMatchData(RawCombinedBasicBlock rawCombinedBasicBlock, RawCombinedBasicBlock rawCombinedBasicBlock2) {
        long l2 = rawCombinedBasicBlock.getAddress(ESide.PRIMARY).toLong();
        long l3 = rawCombinedBasicBlock2.getAddress(ESide.SECONDARY).toLong();
        int n2 = MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID;
        Matches matches = new Matches(BasicBlockMatchAdder.getNewInstructionMatches());
        return new BasicBlockMatchData(l2, l3, n2, matches);
    }

    private static List getNewInstructionMatches() {
        return new ArrayList();
    }

    private static RawCombinedFlowGraph getRawCombinedFlowgraph(GraphsContainer graphsContainer, CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        IAddress iAddress = ((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getPrimaryFunctionAddress();
        IAddress iAddress2 = ((RawCombinedBasicBlock)combinedDiffNode2.getRawNode()).getSecondaryFunctionAddress();
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
            SingleDiffEdge singleDiffEdge = SingleGraph.buildDiffEdge(singleGraph, superViewEdge);
            SingleDiffEdge singleDiffEdge2 = SingleGraph.buildDiffEdge(singleGraph2, superViewEdge);
            SuperDiffEdge superDiffEdge = SuperGraph.buildDiffEdge(superGraph, superViewEdge, singleDiffEdge, singleDiffEdge2);
            CombinedDiffEdge combinedDiffEdge = CombinedGraph.buildDiffEdge(combinedGraph, superViewEdge, superDiffEdge);
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

    private static void insertNewDiffNodesAndEdges(GraphsContainer graphsContainer, RawCombinedFlowGraph rawCombinedFlowGraph, SuperViewNode superViewNode) {
        RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)superViewNode.getCombinedNode();
        CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        SuperGraph superGraph = graphsContainer.getSuperGraph();
        SingleGraph singleGraph = graphsContainer.getPrimaryGraph();
        SingleGraph singleGraph2 = graphsContainer.getSecondaryGraph();
        MatchData matchData = graphsContainer.getDiff().getMatches();
        FunctionMatchData functionMatchData = matchData.getFunctionMatch(rawCombinedBasicBlock.getPrimaryFunctionAddress(), ESide.PRIMARY);
        SingleDiffNode singleDiffNode = SingleGraph.buildDiffNode(singleGraph, functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock);
        SingleDiffNode singleDiffNode2 = SingleGraph.buildDiffNode(singleGraph2, functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock);
        SuperDiffNode superDiffNode = SuperGraph.buildDiffNode(superGraph, singleDiffNode, singleDiffNode2, superViewNode);
        CombinedDiffNode combinedDiffNode = CombinedGraph.buildDiffNode(combinedGraph, singleDiffNode, singleDiffNode2, superDiffNode, rawCombinedBasicBlock);
        superDiffNode.setCombinedDiffNode(combinedDiffNode);
        singleDiffNode.setCombinedDiffNode(combinedDiffNode);
        singleDiffNode2.setCombinedDiffNode(combinedDiffNode);
        singleGraph.addNodeToMappings(singleDiffNode);
        singleGraph2.addNodeToMappings(singleDiffNode2);
        combinedGraph.addNodeToMappings(combinedDiffNode);
        superGraph.addNodeToMappings(superDiffNode);
        BasicBlockContentEditor basicBlockContentEditor = new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.PRIMARY);
        singleDiffNode.getRealizer().getNodeContent().setLineEditor(basicBlockContentEditor);
        BasicBlockContentEditor basicBlockContentEditor2 = new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.SECONDARY);
        singleDiffNode2.getRealizer().getNodeContent().setLineEditor(basicBlockContentEditor2);
        ViewFlowGraphBuilder.colorizeBasicblocks(functionMatchData, rawCombinedBasicBlock);
        ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(combinedGraph.getNodes(), combinedGraph.getPrimaryGraph().getFunctionAddress(), combinedGraph.getSecondaryGraph().getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(singleGraph.getNodes(), singleGraph.getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(singleGraph2.getNodes(), singleGraph2.getFunctionAddress());
        superGraph.refreshSuperNodeSize(graphsContainer.getPrimaryGraph(), graphsContainer.getSecondaryGraph(), superDiffNode);
        BasicBlockMatchAdder.insertNewDiffEdges(graphsContainer, superDiffNode);
    }

    /*
     * Unable to fully structure code
     */
    private static void insertNewRawNodesAndEdges(RawCombinedFlowGraph var0, Set var1_1, SuperViewNode var2_2, SuperViewNode var3_3, RawBasicBlock var4_4, RawBasicBlock var5_5, RawCombinedBasicBlock var6_6, SuperViewNode var7_7) {
        var8_8 = var0.getPrimaryFlowgraph();
        var9_9 = var0.getSecondaryFlowgraph();
        var8_8.addNode(var4_4);
        var9_9.addNode(var5_5);
        var0.addNode(var6_6);
        var10_10 = new HashMap<Object, ArrayList<BasicBlockMatchAdder$InternalStruct>>();
        for (Object var12_12 : var1_1) {
            var13_13 = (SuperViewNode)var12_12.getSource();
            var14_14 = (RawCombinedBasicBlock)var13_13.getCombinedNode();
            var15_15 = var14_14.getRawNode(ESide.PRIMARY);
            var16_16 = var14_14.getRawNode(ESide.SECONDARY);
            var17_17 = (SuperViewNode)var12_12.getTarget();
            var18_18 = (RawCombinedBasicBlock)var17_17.getCombinedNode();
            var19_19 = var18_18.getRawNode(ESide.PRIMARY);
            var20_20 = var18_18.getRawNode(ESide.SECONDARY);
            if (var17_17 == var2_2 || var17_17 == var3_3) {
                var17_17 = var7_7;
                var18_18 = var6_6;
                var19_19 = var4_4;
                var20_20 = var5_5;
            }
            if (var13_13 == var2_2 || var13_13 == var3_3) {
                var13_13 = var7_7;
                var14_14 = var6_6;
                var15_15 = var4_4;
                var16_16 = var5_5;
            }
            var21_21 = null;
            var22_22 = (ArrayList<BasicBlockMatchAdder$InternalStruct>)var10_10.get(var13_13);
            if (var22_22 == null) ** GOTO lbl-1000
            for (BasicBlockMatchAdder$InternalStruct var24_24 : var22_22) {
                if (var24_24.superTarget != var17_17) continue;
                var21_21 = var24_24;
                break;
            }
            if (var21_21 == null) lbl-1000: // 2 sources:
            {
                var21_21 = new BasicBlockMatchAdder$InternalStruct(null);
                var21_21.superTarget = var17_17;
                var21_21.combinedSource = var14_14;
                var21_21.combinedTarget = var18_18;
                var21_21.priSource = var15_15;
                var21_21.priTarget = var19_19;
                var21_21.secSource = var16_16;
                var21_21.secTarget = var20_20;
                if (var22_22 == null) {
                    var22_22 = new ArrayList<BasicBlockMatchAdder$InternalStruct>();
                    var10_10.put(var13_13, var22_22);
                }
                var22_22.add(var21_21);
            } else if (var15_15 != null && var19_19 != null) {
                var21_21.priSource = var15_15;
                var21_21.priTarget = var19_19;
            } else {
                var21_21.secSource = var16_16;
                var21_21.secTarget = var20_20;
            }
            if (var12_12.getSingleEdge(ESide.PRIMARY) != null) {
                var21_21.priJumpType = ((RawJump)var12_12.getSingleEdge(ESide.PRIMARY)).getJumpType();
            }
            if (var12_12.getSingleEdge(ESide.SECONDARY) == null) continue;
            var21_21.secJumpType = ((RawJump)var12_12.getSingleEdge(ESide.SECONDARY)).getJumpType();
        }
        var11_11 = var10_10.entrySet().iterator();
        block2 : do {
            if (var11_11.hasNext() == false) return;
            var12_12 = (Map.Entry)var11_11.next();
            var13_13 = ((List)var12_12.getValue()).iterator();
            do {
                if (!var13_13.hasNext()) continue block2;
                var14_14 = (BasicBlockMatchAdder$InternalStruct)var13_13.next();
                var15_15 = null;
                if (var14_14.priJumpType != null) {
                    var15_15 = new RawJump(var14_14.priSource, var14_14.priTarget, var14_14.priJumpType);
                    var8_8.addEdge((RawJump)var15_15);
                }
                var16_16 = null;
                if (var14_14.secJumpType != null) {
                    var16_16 = new RawJump(var14_14.secSource, var14_14.secTarget, var14_14.secJumpType);
                    var9_9.addEdge((RawJump)var16_16);
                }
                var17_17 = new RawCombinedJump(var14_14.combinedSource, var14_14.combinedTarget, (RawJump)var15_15, (RawJump)var16_16);
                var0.addEdge((IGraphEdge)var17_17);
                new SuperViewEdge((CombinedViewEdge)var17_17, (SuperViewNode)var12_12.getKey(), var14_14.superTarget);
            } while (true);
            break;
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void addBasicblockMatch(GraphsContainer graphsContainer, CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();
        try {
            SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            SuperDiffNode superDiffNode2 = combinedDiffNode2.getSuperDiffNode();
            SingleDiffNode singleDiffNode = combinedDiffNode.getPrimaryDiffNode();
            SingleDiffNode singleDiffNode2 = combinedDiffNode2.getSecondaryDiffNode();
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
            RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)combinedDiffNode2.getRawNode();
            RawBasicBlock rawBasicBlock = (RawBasicBlock)singleDiffNode.getRawNode();
            RawBasicBlock rawBasicBlock2 = (RawBasicBlock)singleDiffNode2.getRawNode();
            SuperViewNode superViewNode = superDiffNode.getRawNode();
            SuperViewNode superViewNode2 = superDiffNode2.getRawNode();
            RawCombinedFlowGraph rawCombinedFlowGraph = BasicBlockMatchAdder.getRawCombinedFlowgraph(graphsContainer, combinedDiffNode, combinedDiffNode2);
            RawFlowGraph rawFlowGraph = rawCombinedFlowGraph.getPrimaryFlowgraph();
            RawFlowGraph rawFlowGraph2 = rawCombinedFlowGraph.getSecondaryFlowgraph();
            BasicBlockMatchRemover.syncBasicblockVisibility(graphsContainer, combinedDiffNode);
            BasicBlockMatchRemover.syncBasicblockVisibility(graphsContainer, combinedDiffNode2);
            HashSet hashSet = new HashSet();
            hashSet.addAll(superViewNode.getIncomingEdges());
            hashSet.addAll(superViewNode.getOutgoingEdges());
            hashSet.addAll(superViewNode2.getIncomingEdges());
            hashSet.addAll(superViewNode2.getOutgoingEdges());
            rawCombinedFlowGraph.removeNode(rawCombinedBasicBlock);
            rawCombinedFlowGraph.removeNode(rawCombinedBasicBlock2);
            superViewNode.removeNode();
            superViewNode2.removeNode();
            rawFlowGraph.removeNode(rawBasicBlock);
            rawFlowGraph2.removeNode(rawBasicBlock2);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode2);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode2);
            graphsContainer.getPrimaryGraph().deleteNode(singleDiffNode);
            graphsContainer.getSecondaryGraph().deleteNode(singleDiffNode2);
            BasicBlockMatchData basicBlockMatchData = BasicBlockMatchAdder.createBasicblockMatchData(rawCombinedBasicBlock, rawCombinedBasicBlock2);
            RawBasicBlock rawBasicBlock3 = rawBasicBlock.clone(EMatchState.MATCHED);
            RawBasicBlock rawBasicBlock4 = rawBasicBlock2.clone(EMatchState.MATCHED);
            RawCombinedBasicBlock rawCombinedBasicBlock3 = new RawCombinedBasicBlock(rawBasicBlock3, rawBasicBlock4, basicBlockMatchData, rawBasicBlock3.getFunctionAddr(), rawBasicBlock4.getFunctionAddr());
            SuperViewNode superViewNode3 = new SuperViewNode(rawCombinedBasicBlock3);
            BasicBlockMatchAdder.insertNewRawNodesAndEdges(rawCombinedFlowGraph, hashSet, superViewNode, superViewNode2, rawBasicBlock3, rawBasicBlock4, rawCombinedBasicBlock3, superViewNode3);
            FunctionMatchData functionMatchData = graphsContainer.getDiff().getMatches().getFunctionMatch(rawCombinedBasicBlock3.getPrimaryFunctionAddress(), ESide.PRIMARY);
            functionMatchData.addBasicblockMatch(graphsContainer.getDiff(), basicBlockMatchData, rawCombinedBasicBlock3);
            BasicBlockMatchAdder.insertNewDiffNodesAndEdges(graphsContainer, rawCombinedFlowGraph, superViewNode3);
            graphsContainer.getDiff().getMatches().notifyBasicblockMatchAddedListener(rawBasicBlock3.getFunctionAddr(), rawBasicBlock4.getFunctionAddr(), rawBasicBlock3.getAddress(), rawBasicBlock4.getAddress());
        }
        finally {
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
        }
        BasicBlockMatchRemover.doSynchronizedLayout(graphsContainer.getCombinedGraph());
    }

    public static Pair getAffectedCombinedNodes(BinDiffGraph binDiffGraph) {
        CombinedDiffNode combinedDiffNode = null;
        CombinedDiffNode combinedDiffNode2 = null;
        int n2 = 0;
        if (!(binDiffGraph instanceof CombinedGraph)) {
            if (binDiffGraph instanceof SingleGraph) {
                SingleGraph singleGraph = binDiffGraph.getPrimaryGraph();
                SingleGraph singleGraph2 = binDiffGraph.getSecondaryGraph();
                for (SingleDiffNode singleDiffNode2 : singleGraph.getSelectedNodes()) {
                    if (singleDiffNode2.getRawNode().getMatchState() != EMatchState.PRIMARY_UNMATCHED) continue;
                    ++n2;
                    combinedDiffNode = singleDiffNode2.getCombinedDiffNode();
                }
                if (n2 == 1) {
                    for (SingleDiffNode singleDiffNode2 : singleGraph2.getSelectedNodes()) {
                        if (singleDiffNode2.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) continue;
                        ++n2;
                        combinedDiffNode2 = singleDiffNode2.getCombinedDiffNode();
                    }
                }
            }
        } else {
            for (CombinedDiffNode combinedDiffNode3 : ((CombinedGraph)binDiffGraph).getSelectedNodes()) {
                if (combinedDiffNode3.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                    ++n2;
                    combinedDiffNode = combinedDiffNode3;
                    continue;
                }
                if (combinedDiffNode3.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) continue;
                ++n2;
                combinedDiffNode2 = combinedDiffNode3;
            }
            if (n2 == 2 && combinedDiffNode != null && combinedDiffNode2 != null && combinedDiffNode.isVisible() && combinedDiffNode2.isVisible()) {
                return new Pair(combinedDiffNode, combinedDiffNode2);
            }
        }
        if (n2 != 2) return null;
        if (combinedDiffNode == null) return null;
        if (combinedDiffNode2 == null) return null;
        if (!combinedDiffNode.getPrimaryDiffNode().isVisible()) return null;
        if (!combinedDiffNode2.getSecondaryDiffNode().isVisible()) return null;
        return new Pair(combinedDiffNode, combinedDiffNode2);
    }

    /*
     * Unable to fully structure code
     */
    public static Pair getAffectedCombinedNodes(BinDiffGraph var0, ZyGraphNode var1_1) {
        var2_2 = null;
        var3_3 = null;
        var4_4 = 0;
        var5_5 = 0;
        if (!(var1_1 instanceof CombinedDiffNode)) ** GOTO lbl15
        var6_6 = (CombinedDiffNode)var1_1;
        if (var6_6.getRawNode().getMatchState() != EMatchState.PRIMARY_UNMATCHED) ** GOTO lbl11
        var2_2 = var6_6;
        var7_8 = var0.getCombinedGraph().getSelectedNodes().iterator();
        ** GOTO lbl34
lbl11: // 1 sources:
        if (var6_6.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) ** GOTO lbl54
        var3_3 = var6_6;
        var7_9 = var0.getCombinedGraph().getSelectedNodes().iterator();
        ** GOTO lbl44
lbl15: // 1 sources:
        if (var1_1 instanceof SingleDiffNode && (var6_7 = (SingleDiffNode)var1_1).isSelected() && var6_7.isVisible()) {
            if (var6_7.getSide() == ESide.PRIMARY) {
                var2_2 = var6_7.getCombinedDiffNode();
                var4_4 = 1;
                for (SingleDiffNode var8_14 : var0.getSecondaryGraph().getSelectedNodes()) {
                    if (var8_14.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED || !var8_14.isVisible()) continue;
                    ++var5_5;
                    var3_3 = var8_14.getCombinedDiffNode();
                }
            } else {
                var3_3 = var6_7.getCombinedDiffNode();
                var5_5 = 1;
                for (SingleDiffNode var8_15 : var0.getPrimaryGraph().getSelectedNodes()) {
                    if (var8_15.getRawNode().getMatchState() != EMatchState.PRIMARY_UNMATCHED || !var8_15.isVisible()) continue;
                    ++var4_4;
                    var2_2 = var8_15.getCombinedDiffNode();
                }
            }
        }
        ** GOTO lbl54
lbl34: // 4 sources:
        while (var7_8.hasNext()) {
            var8_12 = (CombinedDiffNode)var7_8.next();
            if (var8_12 == var2_2) {
                ++var4_4;
                continue;
            }
            if (var8_12.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) continue;
            ++var5_5;
            var3_3 = var8_12;
        }
        ** GOTO lbl54
lbl44: // 5 sources:
        while (var7_9.hasNext()) {
            var8_13 = (CombinedDiffNode)var7_9.next();
            if (!var8_13.isVisible()) continue;
            if (var8_13 == var3_3) {
                ++var5_5;
                continue;
            }
            if (var8_13.getRawNode().getMatchState() != EMatchState.PRIMARY_UNMATCHED) continue;
            ++var4_4;
            var2_2 = var8_13;
        }
lbl54: // 5 sources:
        if (var4_4 != true) return null;
        if (var5_5 != true) return null;
        if (var2_2 == null) return null;
        if (var3_3 == null) return null;
        return new Pair(var2_2, var3_3);
    }
}

