package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.bindiff.types.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import java.util.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.general.*;

public class BasicBlockMatchAdder
{
    private static BasicBlockMatchData createBasicblockMatchData(final RawCombinedBasicBlock rawCombinedBasicBlock, final RawCombinedBasicBlock rawCombinedBasicBlock2) {
        return new BasicBlockMatchData(rawCombinedBasicBlock.getAddress(ESide.PRIMARY).toLong(), rawCombinedBasicBlock2.getAddress(ESide.SECONDARY).toLong(), MatchesDatabase.UNSAVED_BASICBLOCKMATCH_ALGORITH_ID, new Matches(getNewInstructionMatches()));
    }
    
    private static List getNewInstructionMatches() {
        return new ArrayList();
    }
    
    private static RawCombinedFlowGraph getRawCombinedFlowgraph(final GraphsContainer graphsContainer, final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        return graphsContainer.getDiff().getViewManager().getFlowgraphViewData(((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getPrimaryFunctionAddress(), ((RawCombinedBasicBlock)combinedDiffNode2.getRawNode()).getSecondaryFunctionAddress()).getCombinedRawGraph();
    }
    
    private static void insertNewDiffEdges(final GraphsContainer graphsContainer, final SuperDiffNode superDiffNode) {
        final SuperGraph superGraph = graphsContainer.getSuperGraph();
        final CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        final SingleGraph primaryGraph = graphsContainer.getPrimaryGraph();
        final SingleGraph secondaryGraph = graphsContainer.getSecondaryGraph();
        final SuperViewNode rawNode = superDiffNode.getRawNode();
        final HashSet<SuperViewEdge> set = new HashSet<SuperViewEdge>();
        set.addAll((Collection<?>)rawNode.getIncomingEdges());
        set.addAll((Collection<?>)rawNode.getOutgoingEdges());
        for (final SuperViewEdge superViewEdge : set) {
            final SingleDiffEdge buildDiffEdge = SingleGraph.buildDiffEdge(primaryGraph, superViewEdge);
            final SingleDiffEdge buildDiffEdge2 = SingleGraph.buildDiffEdge(secondaryGraph, superViewEdge);
            final SuperDiffEdge buildDiffEdge3 = SuperGraph.buildDiffEdge(superGraph, superViewEdge, buildDiffEdge, buildDiffEdge2);
            final CombinedDiffEdge buildDiffEdge4 = CombinedGraph.buildDiffEdge(combinedGraph, superViewEdge, buildDiffEdge3);
            ZyEdgeRealizer realizer = null;
            ZyEdgeRealizer realizer2 = null;
            buildDiffEdge3.setCombinedDiffEdge(buildDiffEdge4);
            if (buildDiffEdge != null) {
                buildDiffEdge.setCombinedDiffEdge(buildDiffEdge4);
                realizer = buildDiffEdge.getRealizer();
            }
            if (buildDiffEdge2 != null) {
                buildDiffEdge2.setCombinedDiffEdge(buildDiffEdge4);
                realizer2 = buildDiffEdge2.getRealizer();
            }
            final RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
            ViewFlowGraphBuilder.colorizeJumps(rawCombinedJump, realizer, realizer2);
            ViewFlowGraphBuilder.stylizeJumps(rawCombinedJump, buildDiffEdge4.getRealizer(), realizer, realizer2);
        }
    }
    
    private static void insertNewDiffNodesAndEdges(final GraphsContainer graphsContainer, final RawCombinedFlowGraph rawCombinedFlowGraph, final SuperViewNode superViewNode) {
        final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)superViewNode.getCombinedNode();
        final CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        final SuperGraph superGraph = graphsContainer.getSuperGraph();
        final SingleGraph primaryGraph = graphsContainer.getPrimaryGraph();
        final SingleGraph secondaryGraph = graphsContainer.getSecondaryGraph();
        final FunctionMatchData functionMatch = graphsContainer.getDiff().getMatches().getFunctionMatch(rawCombinedBasicBlock.getPrimaryFunctionAddress(), ESide.PRIMARY);
        final SingleDiffNode buildDiffNode = SingleGraph.buildDiffNode(primaryGraph, functionMatch, rawCombinedFlowGraph, rawCombinedBasicBlock);
        final SingleDiffNode buildDiffNode2 = SingleGraph.buildDiffNode(secondaryGraph, functionMatch, rawCombinedFlowGraph, rawCombinedBasicBlock);
        final SuperDiffNode buildDiffNode3 = SuperGraph.buildDiffNode(superGraph, buildDiffNode, buildDiffNode2, superViewNode);
        final CombinedDiffNode buildDiffNode4 = CombinedGraph.buildDiffNode(combinedGraph, buildDiffNode, buildDiffNode2, buildDiffNode3, rawCombinedBasicBlock);
        buildDiffNode3.setCombinedDiffNode(buildDiffNode4);
        buildDiffNode.setCombinedDiffNode(buildDiffNode4);
        buildDiffNode2.setCombinedDiffNode(buildDiffNode4);
        primaryGraph.addNodeToMappings(buildDiffNode);
        secondaryGraph.addNodeToMappings(buildDiffNode2);
        combinedGraph.addNodeToMappings(buildDiffNode4);
        superGraph.addNodeToMappings(buildDiffNode3);
        buildDiffNode.getRealizer().getNodeContent().setLineEditor(new BasicBlockContentEditor(functionMatch, graphsContainer, ESide.PRIMARY));
        buildDiffNode2.getRealizer().getNodeContent().setLineEditor(new BasicBlockContentEditor(functionMatch, graphsContainer, ESide.SECONDARY));
        ViewFlowGraphBuilder.colorizeBasicblocks(functionMatch, rawCombinedBasicBlock);
        ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(combinedGraph.getNodes(), combinedGraph.getPrimaryGraph().getFunctionAddress(), combinedGraph.getSecondaryGraph().getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(primaryGraph.getNodes(), primaryGraph.getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(secondaryGraph.getNodes(), secondaryGraph.getFunctionAddress());
        superGraph.refreshSuperNodeSize(graphsContainer.getPrimaryGraph(), graphsContainer.getSecondaryGraph(), buildDiffNode3);
        insertNewDiffEdges(graphsContainer, buildDiffNode3);
    }
    
    private static void insertNewRawNodesAndEdges(final RawCombinedFlowGraph rawCombinedFlowGraph, final Set set, final SuperViewNode superViewNode, final SuperViewNode superViewNode2, final RawBasicBlock rawBasicBlock, final RawBasicBlock rawBasicBlock2, final RawCombinedBasicBlock rawCombinedBasicBlock, final SuperViewNode superViewNode3) {
        final RawFlowGraph primaryFlowgraph = rawCombinedFlowGraph.getPrimaryFlowgraph();
        final RawFlowGraph secondaryFlowgraph = rawCombinedFlowGraph.getSecondaryFlowgraph();
        primaryFlowgraph.addNode(rawBasicBlock);
        secondaryFlowgraph.addNode(rawBasicBlock2);
        rawCombinedFlowGraph.addNode(rawCombinedBasicBlock);
        final HashMap<Object, List<?>> hashMap = (HashMap<Object, List<?>>)new HashMap<Object, Object>();
        for (final SuperViewEdge superViewEdge : set) {
            SuperViewNode superViewNode4 = (SuperViewNode)superViewEdge.getSource();
            RawCombinedBasicBlock combinedSource = (RawCombinedBasicBlock)superViewNode4.getCombinedNode();
            RawBasicBlock rawNode = combinedSource.getRawNode(ESide.PRIMARY);
            RawBasicBlock rawNode2 = combinedSource.getRawNode(ESide.SECONDARY);
            SuperViewNode superTarget = (SuperViewNode)superViewEdge.getTarget();
            RawCombinedBasicBlock combinedTarget = (RawCombinedBasicBlock)superTarget.getCombinedNode();
            RawBasicBlock rawNode3 = combinedTarget.getRawNode(ESide.PRIMARY);
            RawBasicBlock rawNode4 = combinedTarget.getRawNode(ESide.SECONDARY);
            if (superTarget == superViewNode || superTarget == superViewNode2) {
                superTarget = superViewNode3;
                combinedTarget = rawCombinedBasicBlock;
                rawNode3 = rawBasicBlock;
                rawNode4 = rawBasicBlock2;
            }
            if (superViewNode4 == superViewNode || superViewNode4 == superViewNode2) {
                superViewNode4 = superViewNode3;
                combinedSource = rawCombinedBasicBlock;
                rawNode = rawBasicBlock;
                rawNode2 = rawBasicBlock2;
            }
            Object o = null;
            List<?> list = hashMap.get(superViewNode4);
            if (list != null) {
                for (final BasicBlockMatchAdder$InternalStruct basicBlockMatchAdder$InternalStruct : list) {
                    if (basicBlockMatchAdder$InternalStruct.superTarget == superTarget) {
                        o = basicBlockMatchAdder$InternalStruct;
                        break;
                    }
                }
            }
            if (o == null) {
                o = new BasicBlockMatchAdder$InternalStruct(null);
                ((BasicBlockMatchAdder$InternalStruct)o).superTarget = superTarget;
                ((BasicBlockMatchAdder$InternalStruct)o).combinedSource = combinedSource;
                ((BasicBlockMatchAdder$InternalStruct)o).combinedTarget = combinedTarget;
                ((BasicBlockMatchAdder$InternalStruct)o).priSource = rawNode;
                ((BasicBlockMatchAdder$InternalStruct)o).priTarget = rawNode3;
                ((BasicBlockMatchAdder$InternalStruct)o).secSource = rawNode2;
                ((BasicBlockMatchAdder$InternalStruct)o).secTarget = rawNode4;
                if (list == null) {
                    list = new ArrayList<Object>();
                    hashMap.put(superViewNode4, list);
                }
                list.add(o);
            }
            else if (rawNode != null && rawNode3 != null) {
                ((BasicBlockMatchAdder$InternalStruct)o).priSource = rawNode;
                ((BasicBlockMatchAdder$InternalStruct)o).priTarget = rawNode3;
            }
            else {
                ((BasicBlockMatchAdder$InternalStruct)o).secSource = rawNode2;
                ((BasicBlockMatchAdder$InternalStruct)o).secTarget = rawNode4;
            }
            if (superViewEdge.getSingleEdge(ESide.PRIMARY) != null) {
                ((BasicBlockMatchAdder$InternalStruct)o).priJumpType = ((RawJump)superViewEdge.getSingleEdge(ESide.PRIMARY)).getJumpType();
            }
            if (superViewEdge.getSingleEdge(ESide.SECONDARY) != null) {
                ((BasicBlockMatchAdder$InternalStruct)o).secJumpType = ((RawJump)superViewEdge.getSingleEdge(ESide.SECONDARY)).getJumpType();
            }
        }
        for (final Map.Entry<SuperViewNode, List<?>> entry : hashMap.entrySet()) {
            for (final BasicBlockMatchAdder$InternalStruct basicBlockMatchAdder$InternalStruct2 : entry.getValue()) {
                RawJump rawJump = null;
                if (basicBlockMatchAdder$InternalStruct2.priJumpType != null) {
                    rawJump = new RawJump(basicBlockMatchAdder$InternalStruct2.priSource, basicBlockMatchAdder$InternalStruct2.priTarget, basicBlockMatchAdder$InternalStruct2.priJumpType);
                    primaryFlowgraph.addEdge(rawJump);
                }
                RawJump rawJump2 = null;
                if (basicBlockMatchAdder$InternalStruct2.secJumpType != null) {
                    rawJump2 = new RawJump(basicBlockMatchAdder$InternalStruct2.secSource, basicBlockMatchAdder$InternalStruct2.secTarget, basicBlockMatchAdder$InternalStruct2.secJumpType);
                    secondaryFlowgraph.addEdge(rawJump2);
                }
                final RawCombinedJump rawCombinedJump = new RawCombinedJump(basicBlockMatchAdder$InternalStruct2.combinedSource, basicBlockMatchAdder$InternalStruct2.combinedTarget, rawJump, rawJump2);
                rawCombinedFlowGraph.addEdge(rawCombinedJump);
                new SuperViewEdge(rawCombinedJump, entry.getKey(), basicBlockMatchAdder$InternalStruct2.superTarget);
            }
        }
    }
    
    public static void addBasicblockMatch(final GraphsContainer graphsContainer, final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();
        try {
            final SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            final SuperDiffNode superDiffNode2 = combinedDiffNode2.getSuperDiffNode();
            final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
            final SingleDiffNode secondaryDiffNode = combinedDiffNode2.getSecondaryDiffNode();
            final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
            final RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)combinedDiffNode2.getRawNode();
            final RawBasicBlock rawBasicBlock = (RawBasicBlock)primaryDiffNode.getRawNode();
            final RawBasicBlock rawBasicBlock2 = (RawBasicBlock)secondaryDiffNode.getRawNode();
            final SuperViewNode rawNode = superDiffNode.getRawNode();
            final SuperViewNode rawNode2 = superDiffNode2.getRawNode();
            final RawCombinedFlowGraph rawCombinedFlowgraph = getRawCombinedFlowgraph(graphsContainer, combinedDiffNode, combinedDiffNode2);
            final RawFlowGraph primaryFlowgraph = rawCombinedFlowgraph.getPrimaryFlowgraph();
            final RawFlowGraph secondaryFlowgraph = rawCombinedFlowgraph.getSecondaryFlowgraph();
            BasicBlockMatchRemover.syncBasicblockVisibility(graphsContainer, combinedDiffNode);
            BasicBlockMatchRemover.syncBasicblockVisibility(graphsContainer, combinedDiffNode2);
            final HashSet set = new HashSet();
            set.addAll(rawNode.getIncomingEdges());
            set.addAll(rawNode.getOutgoingEdges());
            set.addAll(rawNode2.getIncomingEdges());
            set.addAll(rawNode2.getOutgoingEdges());
            rawCombinedFlowgraph.removeNode(rawCombinedBasicBlock);
            rawCombinedFlowgraph.removeNode(rawCombinedBasicBlock2);
            rawNode.removeNode();
            rawNode2.removeNode();
            primaryFlowgraph.removeNode(rawBasicBlock);
            secondaryFlowgraph.removeNode(rawBasicBlock2);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode2);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode2);
            graphsContainer.getPrimaryGraph().deleteNode(primaryDiffNode);
            graphsContainer.getSecondaryGraph().deleteNode(secondaryDiffNode);
            final BasicBlockMatchData basicblockMatchData = createBasicblockMatchData(rawCombinedBasicBlock, rawCombinedBasicBlock2);
            final RawBasicBlock clone = rawBasicBlock.clone(EMatchState.MATCHED);
            final RawBasicBlock clone2 = rawBasicBlock2.clone(EMatchState.MATCHED);
            final RawCombinedBasicBlock rawCombinedBasicBlock3 = new RawCombinedBasicBlock(clone, clone2, basicblockMatchData, clone.getFunctionAddr(), clone2.getFunctionAddr());
            final SuperViewNode superViewNode = new SuperViewNode(rawCombinedBasicBlock3);
            insertNewRawNodesAndEdges(rawCombinedFlowgraph, set, rawNode, rawNode2, clone, clone2, rawCombinedBasicBlock3, superViewNode);
            graphsContainer.getDiff().getMatches().getFunctionMatch(rawCombinedBasicBlock3.getPrimaryFunctionAddress(), ESide.PRIMARY).addBasicblockMatch(graphsContainer.getDiff(), basicblockMatchData, rawCombinedBasicBlock3);
            insertNewDiffNodesAndEdges(graphsContainer, rawCombinedFlowgraph, superViewNode);
            graphsContainer.getDiff().getMatches().notifyBasicblockMatchAddedListener(clone.getFunctionAddr(), clone2.getFunctionAddr(), clone.getAddress(), clone2.getAddress());
        }
        finally {
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
        }
        BasicBlockMatchRemover.doSynchronizedLayout(graphsContainer.getCombinedGraph());
    }
    
    public static Pair getAffectedCombinedNodes(final BinDiffGraph binDiffGraph) {
        CombinedDiffNode combinedDiffNode = null;
        CombinedDiffNode combinedDiffNode2 = null;
        int n = 0;
        if (binDiffGraph instanceof CombinedGraph) {
            for (final CombinedDiffNode combinedDiffNode3 : ((CombinedGraph)binDiffGraph).getSelectedNodes()) {
                if (combinedDiffNode3.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                    ++n;
                    combinedDiffNode = combinedDiffNode3;
                }
                else {
                    if (combinedDiffNode3.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) {
                        continue;
                    }
                    ++n;
                    combinedDiffNode2 = combinedDiffNode3;
                }
            }
            if (n == 2 && combinedDiffNode != null && combinedDiffNode2 != null && combinedDiffNode.isVisible() && combinedDiffNode2.isVisible()) {
                return new Pair(combinedDiffNode, combinedDiffNode2);
            }
        }
        else if (binDiffGraph instanceof SingleGraph) {
            final SingleGraph primaryGraph = binDiffGraph.getPrimaryGraph();
            final SingleGraph secondaryGraph = binDiffGraph.getSecondaryGraph();
            for (final SingleDiffNode singleDiffNode : primaryGraph.getSelectedNodes()) {
                if (singleDiffNode.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                    ++n;
                    combinedDiffNode = singleDiffNode.getCombinedDiffNode();
                }
            }
            if (n == 1) {
                for (final SingleDiffNode singleDiffNode2 : secondaryGraph.getSelectedNodes()) {
                    if (singleDiffNode2.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
                        ++n;
                        combinedDiffNode2 = singleDiffNode2.getCombinedDiffNode();
                    }
                }
            }
        }
        if (n == 2 && combinedDiffNode != null && combinedDiffNode2 != null && combinedDiffNode.getPrimaryDiffNode().isVisible() && combinedDiffNode2.getSecondaryDiffNode().isVisible()) {
            return new Pair(combinedDiffNode, combinedDiffNode2);
        }
        return null;
    }
    
    public static Pair getAffectedCombinedNodes(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        CombinedDiffNode combinedDiffNode = null;
        CombinedDiffNode combinedDiffNode2 = null;
        int n = 0;
        int n2 = 0;
        if (zyGraphNode instanceof CombinedDiffNode) {
            final CombinedDiffNode combinedDiffNode3 = (CombinedDiffNode)zyGraphNode;
            if (combinedDiffNode3.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
                combinedDiffNode = combinedDiffNode3;
                for (final CombinedDiffNode combinedDiffNode4 : binDiffGraph.getCombinedGraph().getSelectedNodes()) {
                    if (combinedDiffNode4 == combinedDiffNode) {
                        ++n;
                    }
                    else {
                        if (combinedDiffNode4.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) {
                            continue;
                        }
                        ++n2;
                        combinedDiffNode2 = combinedDiffNode4;
                    }
                }
            }
            else if (combinedDiffNode3.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
                combinedDiffNode2 = combinedDiffNode3;
                for (final CombinedDiffNode combinedDiffNode5 : binDiffGraph.getCombinedGraph().getSelectedNodes()) {
                    if (combinedDiffNode5.isVisible()) {
                        if (combinedDiffNode5 == combinedDiffNode2) {
                            ++n2;
                        }
                        else {
                            if (combinedDiffNode5.getRawNode().getMatchState() != EMatchState.PRIMARY_UNMATCHED) {
                                continue;
                            }
                            ++n;
                            combinedDiffNode = combinedDiffNode5;
                        }
                    }
                }
            }
        }
        else if (zyGraphNode instanceof SingleDiffNode) {
            final SingleDiffNode singleDiffNode = (SingleDiffNode)zyGraphNode;
            if (singleDiffNode.isSelected() && singleDiffNode.isVisible()) {
                if (singleDiffNode.getSide() == ESide.PRIMARY) {
                    combinedDiffNode = singleDiffNode.getCombinedDiffNode();
                    n = 1;
                    for (final SingleDiffNode singleDiffNode2 : binDiffGraph.getSecondaryGraph().getSelectedNodes()) {
                        if (singleDiffNode2.getRawNode().getMatchState() == EMatchState.SECONDRAY_UNMATCHED && singleDiffNode2.isVisible()) {
                            ++n2;
                            combinedDiffNode2 = singleDiffNode2.getCombinedDiffNode();
                        }
                    }
                }
                else {
                    combinedDiffNode2 = singleDiffNode.getCombinedDiffNode();
                    n2 = 1;
                    for (final SingleDiffNode singleDiffNode3 : binDiffGraph.getPrimaryGraph().getSelectedNodes()) {
                        if (singleDiffNode3.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED && singleDiffNode3.isVisible()) {
                            ++n;
                            combinedDiffNode = singleDiffNode3.getCombinedDiffNode();
                        }
                    }
                }
            }
        }
        if (n == 1 && n2 == 1 && combinedDiffNode != null && combinedDiffNode2 != null) {
            return new Pair(combinedDiffNode, combinedDiffNode2);
        }
        return null;
    }
}
