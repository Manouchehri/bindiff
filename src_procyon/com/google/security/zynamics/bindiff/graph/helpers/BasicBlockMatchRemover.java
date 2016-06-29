package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.layout.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import y.h.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.graph.layout.commands.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class BasicBlockMatchRemover
{
    private static CombinedDiffEdge buildDiffEdge(final CombinedGraph combinedGraph, final SuperViewEdge superViewEdge, final SuperDiffEdge superDiffEdge) {
        final RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        final CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(new ZyLabelContent(null), null, combinedGraph.getSettings());
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getSource());
        final CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(rawCombinedJump.getTarget());
        final q node = combinedDiffNode.getNode();
        final q node2 = combinedDiffNode2.getNode();
        final boolean visible = combinedDiffNode.getRawNode().isVisible();
        final boolean visible2 = combinedDiffNode2.getRawNode().isVisible();
        combinedDiffNode.getRawNode().setVisible(true);
        combinedDiffNode2.getRawNode().setVisible(true);
        final CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, combinedGraph.getGraph().a(node, node2), combinedEdgeRealizer, rawCombinedJump, superDiffEdge);
        CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
        combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
        combinedDiffNode.getRawNode().setVisible(visible);
        combinedDiffNode2.getRawNode().setVisible(visible2);
        combinedGraph.addEdgeToMappings(combinedDiffEdge);
        if (!visible || !visible2) {
            final boolean deactiveAutoLayout = LayoutCommandHelper.deactiveAutoLayout(combinedGraph);
            try {
                ProximityBrowserUnhideNode.executeStatic(combinedGraph, visible ? combinedDiffNode : combinedDiffNode2);
            }
            finally {
                LayoutCommandHelper.activateAutoLayout(combinedGraph, deactiveAutoLayout);
            }
        }
        return combinedDiffEdge;
    }
    
    private static SingleDiffEdge buildDiffEdge(final SingleGraph singleGraph, final SuperViewEdge superViewEdge) {
        SingleDiffEdge singleDiffEdge = null;
        final RawCombinedJump rawCombinedJump = (RawCombinedJump)superViewEdge.getCombinedEdge();
        final RawBasicBlock rawNode = rawCombinedJump.getSource().getRawNode(singleGraph.getSide());
        final RawBasicBlock rawNode2 = rawCombinedJump.getTarget().getRawNode(singleGraph.getSide());
        final RawJump rawJump = (singleGraph.getSide() == ESide.PRIMARY) ? rawCombinedJump.getPrimaryEdge() : rawCombinedJump.getSecondaryEdge();
        if (rawJump == null) {
            return null;
        }
        if (rawNode != null && rawNode2 != null && rawJump != null) {
            final SingleEdgeRealizer singleEdgeRealizer = new SingleEdgeRealizer(new ZyLabelContent(null), null, singleGraph.getSettings());
            final SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(rawNode);
            final SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleGraph.getNode(rawNode2);
            final boolean visible = singleDiffNode.getRawNode().isVisible();
            final boolean visible2 = singleDiffNode2.getRawNode().isVisible();
            singleDiffNode.getRawNode().setVisible(true);
            singleDiffNode2.getRawNode().setVisible(true);
            singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, singleGraph.getGraph().a(singleDiffNode.getNode(), singleDiffNode2.getNode()), singleEdgeRealizer, rawJump, singleGraph.getSide());
            SingleDiffNode.link(singleDiffNode, singleDiffNode2);
            singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
            singleDiffNode.getRawNode().setVisible(visible);
            singleDiffNode2.getRawNode().setVisible(visible2);
            singleGraph.addEdgeToMappings(singleDiffEdge);
            if (!visible || !visible2) {
                final boolean deactiveAutoLayout = LayoutCommandHelper.deactiveAutoLayout(singleGraph);
                try {
                    ProximityBrowserUnhideNode.executeStatic(singleGraph, visible ? singleDiffNode : singleDiffNode2);
                }
                finally {
                    LayoutCommandHelper.activateAutoLayout(singleGraph, deactiveAutoLayout);
                }
            }
        }
        return singleDiffEdge;
    }
    
    private static SuperDiffEdge buildDiffEdge(final SuperGraph superGraph, final SuperViewEdge superViewEdge, final SingleDiffEdge singleDiffEdge, final SingleDiffEdge singleDiffEdge2) {
        final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
        SuperDiffNode superDiffNode = null;
        SuperDiffNode superDiffNode2 = null;
        if (singleDiffEdge != null) {
            superDiffNode = ((SingleDiffNode)singleDiffEdge.getSource()).getSuperDiffNode();
            superDiffNode2 = ((SingleDiffNode)singleDiffEdge.getTarget()).getSuperDiffNode();
        }
        else if (singleDiffEdge2 != null) {
            superDiffNode = ((SingleDiffNode)singleDiffEdge2.getSource()).getSuperDiffNode();
            superDiffNode2 = ((SingleDiffNode)singleDiffEdge2.getTarget()).getSuperDiffNode();
        }
        final q node = superDiffNode.getNode();
        final q node2 = superDiffNode2.getNode();
        final boolean visible = superDiffNode.getRawNode().isVisible();
        final boolean visible2 = superDiffNode2.getRawNode().isVisible();
        superDiffNode.getRawNode().setVisible(true);
        superDiffNode2.getRawNode().setVisible(true);
        final SuperDiffEdge superDiffEdge = new SuperDiffEdge(superDiffNode, superDiffNode2, superGraph.getGraph().a(node, node2), zyEdgeRealizer, superViewEdge, singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link(superDiffNode, superDiffNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        superDiffNode.getRawNode().setVisible(visible);
        superDiffNode2.getRawNode().setVisible(visible2);
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }
    
    private static CombinedDiffNode buildDiffNode(final CombinedGraph combinedGraph, final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final SuperDiffNode superDiffNode, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        ZyLabelContent nodeContent = null;
        if (singleDiffNode != null) {
            nodeContent = singleDiffNode.getRealizer().getNodeContent();
        }
        ZyLabelContent nodeContent2 = null;
        if (singleDiffNode2 != null) {
            nodeContent2 = singleDiffNode2.getRealizer().getNodeContent();
        }
        final CombinedNodeRealizer realizer = new CombinedNodeRealizer(nodeContent, nodeContent2);
        final CodeNodeRealizerUpdater updater = new CodeNodeRealizerUpdater();
        realizer.setUpdater(updater);
        updater.setRealizer(realizer);
        final CombinedDiffNode combinedDiffNode = new CombinedDiffNode(combinedGraph.getGraph().d(), realizer, rawCombinedBasicBlock, superDiffNode);
        realizer.setUserData(new ZyNodeData(combinedDiffNode));
        return combinedDiffNode;
    }
    
    private static SingleDiffNode buildDiffNode(final SingleGraph singleGraph, final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        ZyGraphNode zyGraphNode = null;
        final bu graph = singleGraph.getGraph();
        final RawBasicBlock rawNode = rawCombinedBasicBlock.getRawNode(singleGraph.getSide());
        if (rawNode != null) {
            final ZyNormalNodeRealizer realizer = new ZyNormalNodeRealizer(ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, singleGraph.getSide()));
            final CodeNodeRealizerUpdater updater = new CodeNodeRealizerUpdater();
            realizer.setUpdater(updater);
            updater.setRealizer(realizer);
            zyGraphNode = new SingleDiffBasicBlockNode(graph.d(), realizer, rawNode, singleGraph.getSide());
            realizer.setUserData(new ZyNodeData(zyGraphNode));
        }
        return (SingleDiffNode)zyGraphNode;
    }
    
    private static SuperDiffNode buildDiffNode(final SuperGraph superGraph, final SingleDiffNode singleDiffNode, final SingleDiffNode singleDiffNode2, final SuperViewNode superViewNode) {
        final ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(new ZyLabelContent(null));
        final SuperDiffNode superDiffNode = new SuperDiffNode(superGraph.getGraph().d(), zyNormalNodeRealizer, superViewNode, singleDiffNode, singleDiffNode2);
        zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
        return superDiffNode;
    }
    
    private static RawCombinedFlowGraph getRawCombinedFlowgraph(final GraphsContainer graphsContainer, final CombinedDiffNode combinedDiffNode) {
        return graphsContainer.getDiff().getViewManager().getFlowgraphViewData(((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getPrimaryFunctionAddress(), ((RawCombinedBasicBlock)combinedDiffNode.getRawNode()).getSecondaryFunctionAddress()).getCombinedRawGraph();
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
            final SingleDiffEdge buildDiffEdge = buildDiffEdge(primaryGraph, superViewEdge);
            final SingleDiffEdge buildDiffEdge2 = buildDiffEdge(secondaryGraph, superViewEdge);
            final SuperDiffEdge buildDiffEdge3 = buildDiffEdge(superGraph, superViewEdge, buildDiffEdge, buildDiffEdge2);
            final CombinedDiffEdge buildDiffEdge4 = buildDiffEdge(combinedGraph, superViewEdge, buildDiffEdge3);
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
    
    private static void insertNewDiffNodes(final GraphsContainer graphsContainer, final RawCombinedFlowGraph rawCombinedFlowGraph, final SuperViewNode superViewNode) {
        final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)superViewNode.getCombinedNode();
        final ESide eSide = (rawCombinedBasicBlock.getRawNode(ESide.PRIMARY) != null) ? ESide.PRIMARY : ESide.SECONDARY;
        final CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        final SingleGraph singleGraph = (eSide == ESide.PRIMARY) ? graphsContainer.getPrimaryGraph() : graphsContainer.getSecondaryGraph();
        final SuperGraph superGraph = graphsContainer.getSuperGraph();
        final FunctionMatchData functionMatch = graphsContainer.getDiff().getMatches().getFunctionMatch((eSide == ESide.PRIMARY) ? rawCombinedBasicBlock.getPrimaryFunctionAddress() : rawCombinedBasicBlock.getSecondaryFunctionAddress(), eSide);
        final SingleDiffNode buildDiffNode = buildDiffNode(singleGraph, functionMatch, rawCombinedFlowGraph, rawCombinedBasicBlock);
        final SuperDiffNode buildDiffNode2 = buildDiffNode(superGraph, (eSide == ESide.PRIMARY) ? buildDiffNode : null, (eSide == ESide.SECONDARY) ? buildDiffNode : null, superViewNode);
        final CombinedDiffNode buildDiffNode3 = buildDiffNode(combinedGraph, (eSide == ESide.PRIMARY) ? buildDiffNode : null, (eSide == ESide.SECONDARY) ? buildDiffNode : null, buildDiffNode2, rawCombinedBasicBlock);
        buildDiffNode2.setCombinedDiffNode(buildDiffNode3);
        buildDiffNode.setCombinedDiffNode(buildDiffNode3);
        singleGraph.addNodeToMappings(buildDiffNode);
        buildDiffNode.getRealizer().getNodeContent().setLineEditor(new BasicBlockContentEditor(functionMatch, graphsContainer, eSide));
        combinedGraph.addNodeToMappings(buildDiffNode3);
        superGraph.addNodeToMappings(buildDiffNode2);
        ViewFlowGraphBuilder.colorizeBasicblocks(functionMatch, rawCombinedBasicBlock);
        ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(combinedGraph.getNodes(), combinedGraph.getPrimaryGraph().getFunctionAddress(), combinedGraph.getSecondaryGraph().getFunctionAddress());
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(singleGraph.getNodes(), singleGraph.getFunctionAddress());
        superGraph.refreshSuperNodeSize(graphsContainer.getPrimaryGraph(), graphsContainer.getSecondaryGraph(), buildDiffNode2);
        insertNewDiffEdges(graphsContainer, buildDiffNode2);
    }
    
    private static void insertNewRawNodes(final RawCombinedFlowGraph rawCombinedFlowGraph, final RawFlowGraph rawFlowGraph, final Set set, final SuperViewNode superViewNode, final RawBasicBlock rawBasicBlock, final RawCombinedBasicBlock rawCombinedBasicBlock, final SuperViewNode superViewNode2) {
        rawCombinedFlowGraph.addNode(rawCombinedBasicBlock);
        rawFlowGraph.addNode(rawBasicBlock);
        final ESide side = rawFlowGraph.getSide();
        for (final SuperViewEdge superViewEdge : set) {
            if (superViewEdge.getSingleEdge(side) == null) {
                continue;
            }
            SuperViewNode superViewNode3 = (SuperViewNode)superViewEdge.getSource();
            RawCombinedBasicBlock rawCombinedBasicBlock2 = (RawCombinedBasicBlock)superViewNode3.getCombinedNode();
            RawBasicBlock rawNode = rawCombinedBasicBlock2.getRawNode(side);
            SuperViewNode superViewNode4 = (SuperViewNode)superViewEdge.getTarget();
            RawCombinedBasicBlock rawCombinedBasicBlock3 = (RawCombinedBasicBlock)superViewNode4.getCombinedNode();
            RawBasicBlock rawNode2 = rawCombinedBasicBlock3.getRawNode(side);
            if (superViewNode4 == superViewNode) {
                superViewNode4 = superViewNode2;
                rawCombinedBasicBlock3 = rawCombinedBasicBlock;
                rawNode2 = rawBasicBlock;
            }
            if (superViewNode3 == superViewNode) {
                superViewNode3 = superViewNode2;
                rawCombinedBasicBlock2 = rawCombinedBasicBlock;
                rawNode = rawBasicBlock;
            }
            final RawJump rawJump = new RawJump(rawNode, rawNode2, ((RawJump)superViewEdge.getSingleEdge(side)).getJumpType());
            rawFlowGraph.addEdge(rawJump);
            final RawCombinedJump rawCombinedJump = new RawCombinedJump(rawCombinedBasicBlock2, rawCombinedBasicBlock3, (side == ESide.PRIMARY) ? rawJump : null, (side == ESide.SECONDARY) ? rawJump : null);
            rawCombinedFlowGraph.addEdge(rawCombinedJump);
            new SuperViewEdge(rawCombinedJump, superViewNode3, superViewNode4);
        }
    }
    
    private static void removeBasicblockMatch(final GraphsContainer graphsContainer, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        graphsContainer.getDiff().getMatches().getFunctionMatch(rawCombinedBasicBlock.getPrimaryFunctionAddress(), ESide.PRIMARY).removeBasicblockMatch(graphsContainer.getDiff(), rawCombinedBasicBlock);
    }
    
    protected static void syncBasicblockVisibility(final GraphsContainer graphsContainer, final CombinedDiffNode combinedDiffNode) {
        final GraphSettings settings = graphsContainer.getSettings();
        if (settings.isAsync()) {
            final boolean deactiveAutoLayout = LayoutCommandHelper.deactiveAutoLayout(graphsContainer.getCombinedGraph());
            try {
                if (settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
                    combinedDiffNode.getPrimaryRawNode().setVisible(true);
                    combinedDiffNode.getSecondaryRawNode().setVisible(true);
                    combinedDiffNode.getSuperRawNode().setVisible(true);
                }
                else if (settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                    combinedDiffNode.getRawNode().setVisible(true);
                    combinedDiffNode.getPrimaryRawNode().setVisible(true);
                    combinedDiffNode.getSecondaryRawNode().setVisible(true);
                    combinedDiffNode.getSuperRawNode().setVisible(true);
                }
            }
            finally {
                LayoutCommandHelper.activateAutoLayout(graphsContainer.getCombinedGraph(), deactiveAutoLayout);
            }
        }
    }
    
    public static void doSynchronizedLayout(final CombinedGraph combinedGraph) {
        if (LayoutCommandHelper.isAutolayout(combinedGraph)) {
            final GraphSettings settings = combinedGraph.getSettings();
            if (settings.isSync() || settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
                GraphLayoutUpdater.executeStatic(combinedGraph, true);
            }
            else if (settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                if (settings.getFocus() == ESide.PRIMARY) {
                    GraphLayoutUpdater.executeStatic(combinedGraph.getPrimaryGraph(), true);
                }
                if (settings.getFocus() == ESide.SECONDARY) {
                    GraphLayoutUpdater.executeStatic(combinedGraph.getSecondaryGraph(), true);
                }
            }
        }
    }
    
    public static List getAffectedCombinedNodes(final BinDiffGraph binDiffGraph) {
        final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
        if (binDiffGraph instanceof CombinedGraph) {
            for (final CombinedDiffNode combinedDiffNode : ((CombinedGraph)binDiffGraph).getSelectedNodes()) {
                if (combinedDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                    list.add(combinedDiffNode);
                }
            }
        }
        else if (binDiffGraph instanceof SingleGraph) {
            for (final SingleDiffNode singleDiffNode : ((SingleGraph)binDiffGraph).getSelectedNodes()) {
                if (singleDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED && singleDiffNode.isSelected() && singleDiffNode.isVisible() && singleDiffNode.getOtherSideDiffNode().isSelected() && singleDiffNode.getOtherSideDiffNode().isVisible()) {
                    list.add(singleDiffNode.getCombinedDiffNode());
                }
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }
    
    public static List getAffectedCombinedNodes(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        if (zyGraphNode.isSelected()) {
            return getAffectedCombinedNodes(binDiffGraph);
        }
        return null;
    }
    
    public static void removeBasicblockMatch(final GraphsContainer graphsContainer, final CombinedDiffNode combinedDiffNode) {
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibVisibilityListeners();
        graphsContainer.getCombinedGraph().getIntermediateListeners().blockZyLibSelectionListeners();
        try {
            final SuperDiffNode superDiffNode = combinedDiffNode.getSuperDiffNode();
            final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
            final SingleDiffNode secondaryDiffNode = combinedDiffNode.getSecondaryDiffNode();
            final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
            final SuperViewNode rawNode = superDiffNode.getRawNode();
            final RawBasicBlock rawBasicBlock = (RawBasicBlock)primaryDiffNode.getRawNode();
            final RawBasicBlock rawBasicBlock2 = (RawBasicBlock)secondaryDiffNode.getRawNode();
            final RawCombinedFlowGraph rawCombinedFlowgraph = getRawCombinedFlowgraph(graphsContainer, combinedDiffNode);
            final RawFlowGraph primaryFlowgraph = rawCombinedFlowgraph.getPrimaryFlowgraph();
            final RawFlowGraph secondaryFlowgraph = rawCombinedFlowgraph.getSecondaryFlowgraph();
            syncBasicblockVisibility(graphsContainer, combinedDiffNode);
            final HashSet set = new HashSet();
            set.addAll(rawNode.getIncomingEdges());
            set.addAll(rawNode.getOutgoingEdges());
            rawCombinedFlowgraph.removeNode(rawCombinedBasicBlock);
            rawNode.removeNode();
            primaryFlowgraph.removeNode(rawBasicBlock);
            secondaryFlowgraph.removeNode(rawBasicBlock2);
            graphsContainer.getCombinedGraph().deleteNode(combinedDiffNode);
            graphsContainer.getSuperGraph().deleteNode(superDiffNode);
            graphsContainer.getPrimaryGraph().deleteNode(primaryDiffNode);
            graphsContainer.getSecondaryGraph().deleteNode(secondaryDiffNode);
            final RawBasicBlock clone = rawBasicBlock.clone(EMatchState.PRIMARY_UNMATCHED);
            final RawBasicBlock clone2 = rawBasicBlock2.clone(EMatchState.SECONDRAY_UNMATCHED);
            final RawCombinedBasicBlock rawCombinedBasicBlock2 = new RawCombinedBasicBlock(clone, null, null, rawBasicBlock.getFunctionAddr(), null);
            final RawCombinedBasicBlock rawCombinedBasicBlock3 = new RawCombinedBasicBlock(null, clone2, null, null, rawBasicBlock2.getFunctionAddr());
            final SuperViewNode superViewNode = new SuperViewNode(rawCombinedBasicBlock2);
            final SuperViewNode superViewNode2 = new SuperViewNode(rawCombinedBasicBlock3);
            insertNewRawNodes(rawCombinedFlowgraph, primaryFlowgraph, set, rawNode, clone, rawCombinedBasicBlock2, superViewNode);
            insertNewRawNodes(rawCombinedFlowgraph, secondaryFlowgraph, set, rawNode, clone2, rawCombinedBasicBlock3, superViewNode2);
            removeBasicblockMatch(graphsContainer, rawCombinedBasicBlock);
            insertNewDiffNodes(graphsContainer, rawCombinedFlowgraph, superViewNode);
            insertNewDiffNodes(graphsContainer, rawCombinedFlowgraph, superViewNode2);
            graphsContainer.getDiff().getMatches().notifyBasicblockMatchRemovedListener(clone.getFunctionAddr(), clone2.getFunctionAddr(), clone.getAddress(), clone2.getAddress());
        }
        finally {
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibVisibilityListeners();
            graphsContainer.getCombinedGraph().getIntermediateListeners().freeZyLibSelectionListeners();
        }
        doSynchronizedLayout(graphsContainer.getCombinedGraph());
    }
}
