package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.*;
import com.google.security.zynamics.bindiff.graph.labelcontent.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.*;
import y.h.*;

public class ViewFlowGraphBuilder
{
    protected static void addGraphEditors(final FunctionMatchData functionMatchData, final GraphsContainer graphsContainer) {
        final SingleGraph primaryGraph = graphsContainer.getPrimaryGraph();
        if (primaryGraph != null) {
            final Iterator iterator = primaryGraph.getNodes().iterator();
            while (iterator.hasNext()) {
                iterator.next().getRealizer().getNodeContent().setLineEditor(new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.PRIMARY));
            }
        }
        final SingleGraph secondaryGraph = graphsContainer.getSecondaryGraph();
        if (secondaryGraph != null) {
            final Iterator iterator2 = secondaryGraph.getNodes().iterator();
            while (iterator2.hasNext()) {
                iterator2.next().getRealizer().getNodeContent().setLineEditor(new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.SECONDARY));
            }
        }
    }
    
    protected static void buildFlowgraphEdgeMaps(final bu bu, final bu bu2, final bu bu3, final bu bu4, final Map map, final Map map2, final Map map3, final Map map4, final Map map5, final Map map6, final Map map7, final Map map8, final GraphSettings graphSettings, final RawCombinedFlowGraph rawCombinedFlowGraph) {
        for (final RawCombinedJump rawCombinedJump : rawCombinedFlowGraph.getEdges()) {
            final RawCombinedBasicBlock source = rawCombinedJump.getSource();
            final RawCombinedBasicBlock target = rawCombinedJump.getTarget();
            final RawBasicBlock rawNode = source.getRawNode(ESide.PRIMARY);
            final RawBasicBlock rawNode2 = target.getRawNode(ESide.PRIMARY);
            SingleDiffEdge singleDiffEdge = null;
            final IAddress address = rawCombinedJump.getSource().getAddress(ESide.PRIMARY);
            final IAddress address2 = rawCombinedJump.getTarget().getAddress(ESide.PRIMARY);
            final RawJump primaryEdge = rawCombinedJump.getPrimaryEdge();
            ZyEdgeRealizer zyEdgeRealizer = null;
            if (rawNode != null && rawNode2 != null && primaryEdge != null) {
                zyEdgeRealizer = new SingleEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
                final SingleDiffNode singleDiffNode = map5.get(address);
                final SingleDiffNode singleDiffNode2 = map5.get(address2);
                final d a = bu.a(singleDiffNode.getNode(), singleDiffNode2.getNode());
                singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, a, zyEdgeRealizer, primaryEdge, ESide.PRIMARY);
                SingleDiffNode.link(singleDiffNode, singleDiffNode2);
                zyEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
                map.put(a, singleDiffEdge);
            }
            SingleDiffEdge singleDiffEdge2 = null;
            final RawBasicBlock rawNode3 = source.getRawNode(ESide.SECONDARY);
            final RawBasicBlock rawNode4 = target.getRawNode(ESide.SECONDARY);
            final RawJump secondaryEdge = rawCombinedJump.getSecondaryEdge();
            final IAddress address3 = rawCombinedJump.getSource().getAddress(ESide.SECONDARY);
            final IAddress address4 = rawCombinedJump.getTarget().getAddress(ESide.SECONDARY);
            ZyEdgeRealizer zyEdgeRealizer2 = null;
            if (rawNode3 != null && rawNode4 != null && secondaryEdge != null) {
                zyEdgeRealizer2 = new SingleEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
                final SingleDiffNode singleDiffNode3 = map6.get(address3);
                final SingleDiffNode singleDiffNode4 = map6.get(address4);
                final d a2 = bu2.a(singleDiffNode3.getNode(), singleDiffNode4.getNode());
                singleDiffEdge2 = new SingleDiffEdge(singleDiffNode3, singleDiffNode4, a2, zyEdgeRealizer2, secondaryEdge, ESide.SECONDARY);
                SingleDiffNode.link(singleDiffNode3, singleDiffNode4);
                zyEdgeRealizer2.setUserData(new ZyEdgeData(singleDiffEdge2));
                map2.put(a2, singleDiffEdge2);
            }
            final ZyEdgeRealizer zyEdgeRealizer3 = new ZyEdgeRealizer(new ZyLabelContent(null), null);
            final SuperDiffNode superDiffNode = map7.get(new Pair(address, address3));
            final SuperDiffNode superDiffNode2 = map7.get(new Pair(address2, address4));
            final d a3 = bu3.a(superDiffNode.getNode(), superDiffNode2.getNode());
            final SuperDiffEdge superDiffEdge = new SuperDiffEdge(superDiffNode, superDiffNode2, a3, zyEdgeRealizer3, new SuperViewEdge(rawCombinedJump, superDiffNode.getRawNode(), superDiffNode2.getRawNode()), singleDiffEdge, singleDiffEdge2);
            SuperDiffNode.link(superDiffNode, superDiffNode2);
            zyEdgeRealizer3.setUserData(new ZyEdgeData(superDiffEdge));
            map3.put(a3, superDiffEdge);
            final CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
            final CombinedDiffNode combinedDiffNode = map8.get(new Pair(address, address3));
            final CombinedDiffNode combinedDiffNode2 = map8.get(new Pair(address2, address4));
            final d a4 = bu4.a(combinedDiffNode.getNode(), combinedDiffNode2.getNode());
            final CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, a4, combinedEdgeRealizer, rawCombinedJump, superDiffEdge);
            CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
            map4.put(a4, combinedDiffEdge);
            combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
            superDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
            if (singleDiffEdge != null) {
                singleDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
            }
            if (singleDiffEdge2 != null) {
                singleDiffEdge2.setCombinedDiffEdge(combinedDiffEdge);
            }
            colorizeJumps(rawCombinedJump, zyEdgeRealizer, zyEdgeRealizer2);
            stylizeJumps(rawCombinedJump, combinedEdgeRealizer, zyEdgeRealizer, zyEdgeRealizer2);
        }
    }
    
    protected static void buildFlowgraphNodeMaps(final FunctionMatchData functionMatchData, final bu bu, final bu bu2, final bu bu3, final bu bu4, final Map map, final Map map2, final Map map3, final Map map4, final Map map5, final Map map6, final Map map7, final Map map8, final RawCombinedFlowGraph rawCombinedFlowGraph) {
        for (final RawCombinedBasicBlock rawCombinedBasicBlock : rawCombinedFlowGraph) {
            SingleDiffNode singleDiffNode = null;
            SingleDiffNode singleDiffNode2 = null;
            final IAddress address = rawCombinedBasicBlock.getAddress(ESide.SECONDARY);
            final IAddress address2 = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
            final RawBasicBlock rawNode = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
            final RawBasicBlock rawNode2 = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
            ZyLabelContent buildSingleBasicblockLabelContent = null;
            if (rawNode != null) {
                buildSingleBasicblockLabelContent = buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, ESide.PRIMARY);
                final ZyNormalNodeRealizer realizer = new ZyNormalNodeRealizer(buildSingleBasicblockLabelContent);
                final CodeNodeRealizerUpdater updater = new CodeNodeRealizerUpdater();
                realizer.setUpdater(updater);
                updater.setRealizer(realizer);
                final q d = bu.d();
                singleDiffNode = new SingleDiffBasicBlockNode(d, realizer, rawNode, ESide.PRIMARY);
                realizer.setUserData(new ZyNodeData(singleDiffNode));
                map5.put(address2, singleDiffNode);
                map.put(d, singleDiffNode);
            }
            ZyLabelContent buildSingleBasicblockLabelContent2 = null;
            if (rawNode2 != null) {
                buildSingleBasicblockLabelContent2 = buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, ESide.SECONDARY);
                final ZyNormalNodeRealizer realizer2 = new ZyNormalNodeRealizer(buildSingleBasicblockLabelContent2);
                final CodeNodeRealizerUpdater updater2 = new CodeNodeRealizerUpdater();
                realizer2.setUpdater(updater2);
                updater2.setRealizer(realizer2);
                final q d2 = bu2.d();
                singleDiffNode2 = new SingleDiffBasicBlockNode(d2, realizer2, rawNode2, ESide.SECONDARY);
                realizer2.setUserData(new ZyNodeData(singleDiffNode2));
                map6.put(address, singleDiffNode2);
                map2.put(d2, singleDiffNode2);
            }
            final ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(new ZyLabelContent(null));
            final q d3 = bu3.d();
            final SuperDiffNode superDiffNode = new SuperDiffNode(d3, zyNormalNodeRealizer, new SuperViewNode(rawCombinedBasicBlock), singleDiffNode, singleDiffNode2);
            zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
            map7.put(new Pair(address2, address), superDiffNode);
            map3.put(d3, superDiffNode);
            final CombinedNodeRealizer realizer3 = new CombinedNodeRealizer(buildSingleBasicblockLabelContent, buildSingleBasicblockLabelContent2);
            final CodeNodeRealizerUpdater updater3 = new CodeNodeRealizerUpdater();
            realizer3.setUpdater(updater3);
            updater3.setRealizer(realizer3);
            final q d4 = bu4.d();
            final CombinedDiffNode combinedDiffNode = new CombinedDiffNode(d4, realizer3, rawCombinedBasicBlock, superDiffNode);
            realizer3.setUserData(new ZyNodeData(combinedDiffNode));
            map8.put(new Pair(address2, address), combinedDiffNode);
            map4.put(d4, combinedDiffNode);
            superDiffNode.setCombinedDiffNode(combinedDiffNode);
            if (singleDiffNode != null) {
                singleDiffNode.setCombinedDiffNode(combinedDiffNode);
            }
            if (singleDiffNode2 != null) {
                singleDiffNode2.setCombinedDiffNode(combinedDiffNode);
            }
            colorizeBasicblocks(functionMatchData, rawCombinedBasicBlock);
        }
    }
    
    public static ZyLabelContent buildSingleBasicblockLabelContent(final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph, final RawCombinedBasicBlock rawCombinedBasicBlock, final ESide eSide) {
        final DiffLabelContent diffLabelContent = new DiffLabelContent(new BasicBlockLineObject(rawCombinedBasicBlock.getRawNode(eSide)), true, false);
        ViewCodeNodeBuilder.buildSingleCodeNodeContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, diffLabelContent, eSide);
        return diffLabelContent;
    }
    
    public static GraphsContainer buildViewFlowgraphs(final Diff diff, final FunctionMatchData functionMatchData, final RawCombinedFlowGraph rawCombinedFlowGraph) {
        final GraphSettings graphSettings = new GraphSettings(BinDiffConfigFile.getInstance().getInitialFlowgraphSettings());
        final ZyGraph2DView zyGraph2DView = new ZyGraph2DView();
        final ZyGraph2DView zyGraph2DView2 = new ZyGraph2DView();
        final ZyGraph2DView zyGraph2DView3 = new ZyGraph2DView();
        final ZyGraph2DView zyGraph2DView4 = new ZyGraph2DView();
        final bu graph2D = new bu();
        final bu graph2D2 = new bu();
        final bu graph2D3 = new bu();
        final bu graph2D4 = new bu();
        zyGraph2DView.setGraph2D(graph2D);
        zyGraph2DView2.setGraph2D(graph2D2);
        zyGraph2DView4.setGraph2D(graph2D4);
        zyGraph2DView3.setGraph2D(graph2D3);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        final LinkedHashMap linkedHashMap8 = new LinkedHashMap();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final HashMap hashMap3 = new HashMap();
        final HashMap hashMap4 = new HashMap();
        buildFlowgraphNodeMaps(functionMatchData, graph2D, graph2D2, graph2D4, graph2D3, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, hashMap, hashMap2, hashMap4, hashMap3, rawCombinedFlowGraph);
        buildFlowgraphEdgeMaps(graph2D, graph2D2, graph2D4, graph2D3, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, hashMap, hashMap2, hashMap4, hashMap3, graphSettings, rawCombinedFlowGraph);
        final IAddress primaryAddress = rawCombinedFlowGraph.getPrimaryAddress();
        final IAddress secondaryAddress = rawCombinedFlowGraph.getSecondaryAddress();
        colorizeSingleNodeLineBorders(linkedHashMap.values(), primaryAddress);
        colorizeSingleNodeLineBorders(linkedHashMap2.values(), secondaryAddress);
        colorizeCombinedNodeLineBorders(linkedHashMap4.values(), primaryAddress, secondaryAddress);
        final CombinedGraph combinedGraph = new CombinedGraph(zyGraph2DView3, linkedHashMap4, linkedHashMap8, graphSettings, EGraphType.FLOWGRAPH);
        final SingleGraph singleGraph = new SingleGraph(zyGraph2DView, primaryAddress, linkedHashMap, linkedHashMap5, graphSettings, ESide.PRIMARY, EGraphType.FLOWGRAPH);
        final SingleGraph singleGraph2 = new SingleGraph(zyGraph2DView2, secondaryAddress, linkedHashMap2, linkedHashMap6, graphSettings, ESide.SECONDARY, EGraphType.FLOWGRAPH);
        final SuperGraph superGraph = new SuperGraph(zyGraph2DView4, linkedHashMap3, linkedHashMap7, singleGraph, singleGraph2, graphSettings, EGraphType.FLOWGRAPH);
        final GraphsContainer graphsContainer = new GraphsContainer(diff, superGraph, combinedGraph, singleGraph, singleGraph2);
        superGraph.refreshAllSuperNodesSizes(singleGraph, singleGraph2);
        addGraphEditors(functionMatchData, graphsContainer);
        return graphsContainer;
    }
    
    public static void colorizeBasicblocks(final FunctionMatchData functionMatchData, final RawCombinedBasicBlock rawCombinedBasicBlock) {
        final EMatchState matchState = rawCombinedBasicBlock.getMatchState();
        if (matchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedBasicBlock.setColor(Colors.PRIMARY_BASE);
            rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).setColor(Colors.PRIMARY_BASE);
        }
        else if (matchState == EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedBasicBlock.setColor(Colors.SECONDARY_BASE);
            rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).setColor(Colors.SECONDARY_BASE);
        }
        else {
            final int sizeOfMatchedInstructions = functionMatchData.getBasicblockMatch(rawCombinedBasicBlock.getAddress(ESide.PRIMARY), ESide.PRIMARY).getSizeOfMatchedInstructions();
            Color color = Colors.MATCHED_BASE;
            if (rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).getInstructions().size() > sizeOfMatchedInstructions || rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).getInstructions().size() > sizeOfMatchedInstructions) {
                color = Colors.CHANGED_BASE;
            }
            rawCombinedBasicBlock.setColor(color);
            rawCombinedBasicBlock.setColor(color);
            rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).setColor(color);
            rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).setColor(color);
        }
    }
    
    public static void colorizeCombinedNodeLineBorders(final Collection collection, final IAddress address, final IAddress address2) {
        for (final CombinedDiffNode combinedDiffNode : collection) {
            if (collection.size() == 1) {
                combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                break;
            }
            final SingleViewNode primaryRawNode = combinedDiffNode.getPrimaryRawNode();
            final SingleViewNode secondaryRawNode = combinedDiffNode.getSecondaryRawNode();
            if (combinedDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                if (primaryRawNode.getAddress().equals(address) && secondaryRawNode.getAddress().equals(address2)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                }
                else if (primaryRawNode.getAddress().equals(address) || secondaryRawNode.getAddress().equals(address2)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                }
                if (primaryRawNode.getChildren().size() == 0 && secondaryRawNode.getChildren().size() == 0) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
                }
                else {
                    if (primaryRawNode.getChildren().size() != 0 && secondaryRawNode.getChildren().size() != 0) {
                        continue;
                    }
                    combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                }
            }
            else if (primaryRawNode != null) {
                if (primaryRawNode.getAddress().equals(address)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                }
                if (primaryRawNode.getChildren().size() != 0) {
                    continue;
                }
                combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
            }
            else {
                if (secondaryRawNode == null) {
                    continue;
                }
                if (secondaryRawNode.getAddress().equals(address2)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                }
                if (secondaryRawNode.getChildren().size() != 0) {
                    continue;
                }
                combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
            }
        }
    }
    
    public static void colorizeJumps(final RawCombinedJump rawCombinedJump, final ZyEdgeRealizer zyEdgeRealizer, final ZyEdgeRealizer zyEdgeRealizer2) {
        final RawJump primaryEdge = rawCombinedJump.getPrimaryEdge();
        if (primaryEdge != null) {
            switch (ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[primaryEdge.getJumpType().ordinal()]) {
                case 1: {
                    zyEdgeRealizer.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
                    rawCombinedJump.setColor(Colors.JUMP_CONDITIONAL_TRUE);
                    break;
                }
                case 2: {
                    zyEdgeRealizer.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
                    rawCombinedJump.setColor(Colors.JUMP_CONDITIONAL_FALSE);
                    break;
                }
                case 3: {
                    zyEdgeRealizer.setLineColor(Colors.JUMP_SWITCH);
                    rawCombinedJump.setColor(Colors.JUMP_SWITCH);
                    break;
                }
                default: {
                    zyEdgeRealizer.setLineColor(Colors.JUMP_UNCONDITIONAL);
                    rawCombinedJump.setColor(Colors.JUMP_UNCONDITIONAL);
                    break;
                }
            }
        }
        final RawJump secondaryEdge = rawCombinedJump.getSecondaryEdge();
        if (secondaryEdge != null) {
            switch (ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[secondaryEdge.getJumpType().ordinal()]) {
                case 1: {
                    zyEdgeRealizer2.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
                    rawCombinedJump.setColor(Colors.JUMP_CONDITIONAL_TRUE);
                    break;
                }
                case 2: {
                    zyEdgeRealizer2.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
                    rawCombinedJump.setColor(Colors.JUMP_CONDITIONAL_FALSE);
                    break;
                }
                case 3: {
                    zyEdgeRealizer2.setLineColor(Colors.JUMP_SWITCH);
                    rawCombinedJump.setColor(Colors.JUMP_SWITCH);
                    break;
                }
                default: {
                    zyEdgeRealizer2.setLineColor(Colors.JUMP_UNCONDITIONAL);
                    rawCombinedJump.setColor(Colors.JUMP_UNCONDITIONAL);
                    break;
                }
            }
        }
        if (rawCombinedJump.getMatchState() == EMatchState.MATCHED && rawCombinedJump.getPrimaryEdge().getJumpType() != rawCombinedJump.getSecondaryEdge().getJumpType()) {
            zyEdgeRealizer.setLineColor(Colors.MIXED_BASE_COLOR);
            zyEdgeRealizer2.setLineColor(Colors.MIXED_BASE_COLOR);
            rawCombinedJump.setColor(Colors.MIXED_BASE_COLOR);
        }
    }
    
    public static void colorizeSingleNodeLineBorders(final Collection collection, final IAddress address) {
        for (final SingleDiffNode singleDiffNode : collection) {
            if (collection.size() == 1) {
                singleDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                break;
            }
            if (singleDiffNode.getRawNode().getAddress().equals(address)) {
                singleDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
            }
            else {
                if (singleDiffNode.getRawNode().getChildren().size() != 0) {
                    continue;
                }
                singleDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
            }
        }
    }
    
    public static void stylizeJumps(final RawCombinedJump rawCombinedJump, final ZyEdgeRealizer zyEdgeRealizer, final ZyEdgeRealizer zyEdgeRealizer2, final ZyEdgeRealizer zyEdgeRealizer3) {
        zyEdgeRealizer.setReversedPathRenderingEnabled(true);
        if (rawCombinedJump.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            zyEdgeRealizer.setLineType(dr.i);
        }
        else if (rawCombinedJump.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            zyEdgeRealizer.setLineType(dr.n);
        }
        else {
            zyEdgeRealizer.setLineType(dr.b);
        }
        if (zyEdgeRealizer2 != null && zyEdgeRealizer3 == null) {
            zyEdgeRealizer2.setLineType(dr.i);
        }
        else if (zyEdgeRealizer3 != null && zyEdgeRealizer2 == null) {
            zyEdgeRealizer3.setLineType(dr.i);
        }
        else {
            zyEdgeRealizer2.setLineType(dr.b);
            zyEdgeRealizer3.setLineType(dr.b);
        }
    }
}
