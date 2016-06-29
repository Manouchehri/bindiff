/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder$1;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.labelcontent.DiffLabelContent;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.lineeditor.BasicBlockContentEditor;
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
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedJump;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.dr;

public class ViewFlowGraphBuilder {
    protected static void addGraphEditors(FunctionMatchData functionMatchData, GraphsContainer graphsContainer) {
        Object object;
        Object object2;
        Object object3;
        SingleGraph singleGraph = graphsContainer.getPrimaryGraph();
        if (singleGraph != null) {
            object3 = singleGraph.getNodes().iterator();
            while (object3.hasNext()) {
                object = (SingleDiffNode)object3.next();
                object2 = new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.PRIMARY);
                object.getRealizer().getNodeContent().setLineEditor((IZyLineEditor)object2);
            }
        }
        if ((object3 = graphsContainer.getSecondaryGraph()) == null) return;
        object = object3.getNodes().iterator();
        while (object.hasNext()) {
            object2 = (SingleDiffNode)object.next();
            BasicBlockContentEditor basicBlockContentEditor = new BasicBlockContentEditor(functionMatchData, graphsContainer, ESide.SECONDARY);
            object2.getRealizer().getNodeContent().setLineEditor(basicBlockContentEditor);
        }
    }

    protected static void buildFlowgraphEdgeMaps(bu bu2, bu bu3, bu bu4, bu bu5, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, GraphSettings graphSettings, RawCombinedFlowGraph rawCombinedFlowGraph) {
        Iterator iterator = rawCombinedFlowGraph.getEdges().iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object4;
            Object object2;
            Object object3;
            Object object5;
            RawCombinedJump rawCombinedJump = (RawCombinedJump)iterator.next();
            RawCombinedBasicBlock rawCombinedBasicBlock = rawCombinedJump.getSource();
            RawCombinedBasicBlock rawCombinedBasicBlock2 = rawCombinedJump.getTarget();
            RawBasicBlock rawBasicBlock2 = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
            RawBasicBlock rawBasicBlock3 = rawCombinedBasicBlock2.getRawNode(ESide.PRIMARY);
            SingleDiffEdge singleDiffEdge = null;
            d d2 = null;
            IAddress iAddress = rawCombinedJump.getSource().getAddress(ESide.PRIMARY);
            IAddress iAddress2 = rawCombinedJump.getTarget().getAddress(ESide.PRIMARY);
            RawJump rawJump = rawCombinedJump.getPrimaryEdge();
            SingleEdgeRealizer singleEdgeRealizer = null;
            if (rawBasicBlock2 != null && rawBasicBlock3 != null && rawJump != null) {
                object4 = new ZyLabelContent(null);
                singleEdgeRealizer = new SingleEdgeRealizer((ZyLabelContent)object4, null, graphSettings);
                object3 = (SingleDiffNode)map5.get(iAddress);
                SingleDiffNode singleDiffNode = (SingleDiffNode)map5.get(iAddress2);
                d2 = bu2.a(object3.getNode(), singleDiffNode.getNode());
                singleDiffEdge = new SingleDiffEdge((SingleDiffNode)object3, singleDiffNode, d2, singleEdgeRealizer, rawJump, ESide.PRIMARY);
                SingleDiffNode.link((SingleDiffNode)object3, singleDiffNode);
                singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
                map.put(d2, singleDiffEdge);
            }
            object4 = null;
            object3 = null;
            RawBasicBlock rawBasicBlock = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
            RawBasicBlock rawBasicBlock4 = rawCombinedBasicBlock2.getRawNode(ESide.SECONDARY);
            RawJump rawJump2 = rawCombinedJump.getSecondaryEdge();
            IAddress iAddress3 = rawCombinedJump.getSource().getAddress(ESide.SECONDARY);
            IAddress iAddress4 = rawCombinedJump.getTarget().getAddress(ESide.SECONDARY);
            SingleEdgeRealizer singleEdgeRealizer2 = null;
            if (rawBasicBlock != null && rawBasicBlock4 != null && rawJump2 != null) {
                object2 = new ZyLabelContent(null);
                singleEdgeRealizer2 = new SingleEdgeRealizer((ZyLabelContent)object2, null, graphSettings);
                object = (SingleDiffNode)map6.get(iAddress3);
                object5 = (SingleDiffNode)map6.get(iAddress4);
                object3 = bu3.a(object.getNode(), object5.getNode());
                object4 = new SingleDiffEdge((SingleDiffNode)object, (SingleDiffNode)object5, (d)object3, singleEdgeRealizer2, rawJump2, ESide.SECONDARY);
                SingleDiffNode.link((SingleDiffNode)object, (SingleDiffNode)object5);
                singleEdgeRealizer2.setUserData(new ZyEdgeData(object4));
                map2.put(object3, object4);
            }
            object2 = null;
            object = null;
            object5 = new ZyLabelContent(null);
            ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer((ZyLabelContent)object5, null);
            SuperDiffNode superDiffNode = (SuperDiffNode)map7.get(new Pair(iAddress, iAddress3));
            SuperDiffNode superDiffNode2 = (SuperDiffNode)map7.get(new Pair(iAddress2, iAddress4));
            q q2 = superDiffNode.getNode();
            q q3 = superDiffNode2.getNode();
            object = bu4.a(q2, q3);
            SuperViewNode superViewNode = superDiffNode.getRawNode();
            SuperViewNode superViewNode2 = superDiffNode2.getRawNode();
            SuperViewEdge superViewEdge = new SuperViewEdge(rawCombinedJump, superViewNode, superViewNode2);
            object2 = new SuperDiffEdge(superDiffNode, superDiffNode2, (d)object, zyEdgeRealizer, superViewEdge, singleDiffEdge, (SingleDiffEdge)object4);
            SuperDiffNode.link(superDiffNode, superDiffNode2);
            zyEdgeRealizer.setUserData(new ZyEdgeData(object2));
            map3.put(object, object2);
            CombinedDiffEdge combinedDiffEdge = null;
            d d3 = null;
            ZyLabelContent zyLabelContent = new ZyLabelContent(null);
            CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(zyLabelContent, null, graphSettings);
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)map8.get(new Pair(iAddress, iAddress3));
            CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)map8.get(new Pair(iAddress2, iAddress4));
            q q4 = combinedDiffNode.getNode();
            q q5 = combinedDiffNode2.getNode();
            d3 = bu5.a(q4, q5);
            combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, d3, combinedEdgeRealizer, rawCombinedJump, (SuperDiffEdge)object2);
            CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
            map4.put(d3, combinedDiffEdge);
            combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
            object2.setCombinedDiffEdge(combinedDiffEdge);
            if (singleDiffEdge != null) {
                singleDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
            }
            if (object4 != null) {
                object4.setCombinedDiffEdge(combinedDiffEdge);
            }
            ViewFlowGraphBuilder.colorizeJumps(rawCombinedJump, singleEdgeRealizer, singleEdgeRealizer2);
            ViewFlowGraphBuilder.stylizeJumps(rawCombinedJump, combinedEdgeRealizer, singleEdgeRealizer, singleEdgeRealizer2);
        }
    }

    protected static void buildFlowgraphNodeMaps(FunctionMatchData functionMatchData, bu bu2, bu bu3, bu bu4, bu bu5, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, RawCombinedFlowGraph rawCombinedFlowGraph) {
        Iterator iterator = rawCombinedFlowGraph.iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object2;
            Object object3;
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)iterator.next();
            SingleDiffBasicBlockNode singleDiffBasicBlockNode = null;
            SingleDiffBasicBlockNode singleDiffBasicBlockNode2 = null;
            SuperDiffNode superDiffNode = null;
            CombinedDiffNode combinedDiffNode = null;
            q q2 = null;
            q q3 = null;
            q q4 = null;
            q q5 = null;
            IAddress iAddress = rawCombinedBasicBlock.getAddress(ESide.SECONDARY);
            IAddress iAddress2 = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
            RawBasicBlock rawBasicBlock = rawCombinedBasicBlock.getRawNode(ESide.PRIMARY);
            RawBasicBlock rawBasicBlock2 = rawCombinedBasicBlock.getRawNode(ESide.SECONDARY);
            ZyLabelContent zyLabelContent = null;
            if (rawBasicBlock != null) {
                zyLabelContent = ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, ESide.PRIMARY);
                object3 = new ZyNormalNodeRealizer(zyLabelContent);
                object = new CodeNodeRealizerUpdater();
                object3.setUpdater((IRealizerUpdater)object);
                object.setRealizer((IZyNodeRealizer)object3);
                q2 = bu2.d();
                singleDiffBasicBlockNode = new SingleDiffBasicBlockNode(q2, (IZyNodeRealizer)object3, rawBasicBlock, ESide.PRIMARY);
                object3.setUserData(new ZyNodeData(singleDiffBasicBlockNode));
                map5.put(iAddress2, singleDiffBasicBlockNode);
                map.put(q2, singleDiffBasicBlockNode);
            }
            object3 = null;
            if (rawBasicBlock2 != null) {
                object3 = ViewFlowGraphBuilder.buildSingleBasicblockLabelContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, ESide.SECONDARY);
                object = new ZyNormalNodeRealizer((ZyLabelContent)object3);
                object2 = new CodeNodeRealizerUpdater();
                object.setUpdater((IRealizerUpdater)object2);
                object2.setRealizer((IZyNodeRealizer)object);
                q3 = bu3.d();
                singleDiffBasicBlockNode2 = new SingleDiffBasicBlockNode(q3, (IZyNodeRealizer)object, rawBasicBlock2, ESide.SECONDARY);
                object.setUserData(new ZyNodeData(singleDiffBasicBlockNode2));
                map6.put(iAddress, singleDiffBasicBlockNode2);
                map2.put(q3, singleDiffBasicBlockNode2);
            }
            object = new ZyLabelContent(null);
            object2 = new ZyNormalNodeRealizer((ZyLabelContent)object);
            q4 = bu4.d();
            SuperViewNode superViewNode = new SuperViewNode(rawCombinedBasicBlock);
            superDiffNode = new SuperDiffNode(q4, (IZyNodeRealizer)object2, superViewNode, singleDiffBasicBlockNode, singleDiffBasicBlockNode2);
            object2.setUserData(new ZyNodeData(superDiffNode));
            map7.put(new Pair(iAddress2, iAddress), superDiffNode);
            map3.put(q4, superDiffNode);
            CombinedNodeRealizer combinedNodeRealizer = new CombinedNodeRealizer(zyLabelContent, (ZyLabelContent)object3);
            CodeNodeRealizerUpdater codeNodeRealizerUpdater = new CodeNodeRealizerUpdater();
            combinedNodeRealizer.setUpdater(codeNodeRealizerUpdater);
            codeNodeRealizerUpdater.setRealizer(combinedNodeRealizer);
            q5 = bu5.d();
            combinedDiffNode = new CombinedDiffNode(q5, combinedNodeRealizer, rawCombinedBasicBlock, superDiffNode);
            combinedNodeRealizer.setUserData(new ZyNodeData(combinedDiffNode));
            map8.put(new Pair(iAddress2, iAddress), combinedDiffNode);
            map4.put(q5, combinedDiffNode);
            superDiffNode.setCombinedDiffNode(combinedDiffNode);
            if (singleDiffBasicBlockNode != null) {
                singleDiffBasicBlockNode.setCombinedDiffNode(combinedDiffNode);
            }
            if (singleDiffBasicBlockNode2 != null) {
                singleDiffBasicBlockNode2.setCombinedDiffNode(combinedDiffNode);
            }
            ViewFlowGraphBuilder.colorizeBasicblocks(functionMatchData, rawCombinedBasicBlock);
        }
    }

    public static ZyLabelContent buildSingleBasicblockLabelContent(FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph, RawCombinedBasicBlock rawCombinedBasicBlock, ESide eSide) {
        BasicBlockLineObject basicBlockLineObject = new BasicBlockLineObject(rawCombinedBasicBlock.getRawNode(eSide));
        DiffLabelContent diffLabelContent = new DiffLabelContent(basicBlockLineObject, true, false);
        ViewCodeNodeBuilder.buildSingleCodeNodeContent(functionMatchData, rawCombinedFlowGraph, rawCombinedBasicBlock, diffLabelContent, eSide);
        return diffLabelContent;
    }

    public static GraphsContainer buildViewFlowgraphs(Diff diff, FunctionMatchData functionMatchData, RawCombinedFlowGraph rawCombinedFlowGraph) {
        GraphSettings graphSettings = new GraphSettings(BinDiffConfigFile.getInstance().getInitialFlowgraphSettings());
        ZyGraph2DView zyGraph2DView = new ZyGraph2DView();
        ZyGraph2DView zyGraph2DView2 = new ZyGraph2DView();
        ZyGraph2DView zyGraph2DView3 = new ZyGraph2DView();
        ZyGraph2DView zyGraph2DView4 = new ZyGraph2DView();
        bu bu2 = new bu();
        bu bu3 = new bu();
        bu bu4 = new bu();
        bu bu5 = new bu();
        zyGraph2DView.setGraph2D(bu2);
        zyGraph2DView2.setGraph2D(bu3);
        zyGraph2DView4.setGraph2D(bu5);
        zyGraph2DView3.setGraph2D(bu4);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ViewFlowGraphBuilder.buildFlowgraphNodeMaps(functionMatchData, bu2, bu3, bu5, bu4, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, hashMap, hashMap2, hashMap4, hashMap3, rawCombinedFlowGraph);
        ViewFlowGraphBuilder.buildFlowgraphEdgeMaps(bu2, bu3, bu5, bu4, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, hashMap, hashMap2, hashMap4, hashMap3, graphSettings, rawCombinedFlowGraph);
        IAddress iAddress = rawCombinedFlowGraph.getPrimaryAddress();
        IAddress iAddress2 = rawCombinedFlowGraph.getSecondaryAddress();
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(linkedHashMap.values(), iAddress);
        ViewFlowGraphBuilder.colorizeSingleNodeLineBorders(linkedHashMap2.values(), iAddress2);
        ViewFlowGraphBuilder.colorizeCombinedNodeLineBorders(linkedHashMap4.values(), iAddress, iAddress2);
        CombinedGraph combinedGraph = new CombinedGraph(zyGraph2DView3, linkedHashMap4, linkedHashMap8, graphSettings, EGraphType.FLOWGRAPH);
        SingleGraph singleGraph = new SingleGraph(zyGraph2DView, iAddress, linkedHashMap, linkedHashMap5, graphSettings, ESide.PRIMARY, EGraphType.FLOWGRAPH);
        SingleGraph singleGraph2 = new SingleGraph(zyGraph2DView2, iAddress2, linkedHashMap2, linkedHashMap6, graphSettings, ESide.SECONDARY, EGraphType.FLOWGRAPH);
        SuperGraph superGraph = new SuperGraph(zyGraph2DView4, linkedHashMap3, linkedHashMap7, singleGraph, singleGraph2, graphSettings, EGraphType.FLOWGRAPH);
        GraphsContainer graphsContainer = new GraphsContainer(diff, superGraph, combinedGraph, singleGraph, singleGraph2);
        superGraph.refreshAllSuperNodesSizes(singleGraph, singleGraph2);
        ViewFlowGraphBuilder.addGraphEditors(functionMatchData, graphsContainer);
        return graphsContainer;
    }

    public static void colorizeBasicblocks(FunctionMatchData functionMatchData, RawCombinedBasicBlock rawCombinedBasicBlock) {
        EMatchState eMatchState = rawCombinedBasicBlock.getMatchState();
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedBasicBlock.setColor(Colors.PRIMARY_BASE);
            rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).setColor(Colors.PRIMARY_BASE);
            return;
        }
        if (eMatchState == EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedBasicBlock.setColor(Colors.SECONDARY_BASE);
            rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).setColor(Colors.SECONDARY_BASE);
            return;
        }
        IAddress iAddress = rawCombinedBasicBlock.getAddress(ESide.PRIMARY);
        BasicBlockMatchData basicBlockMatchData = functionMatchData.getBasicblockMatch(iAddress, ESide.PRIMARY);
        int n2 = basicBlockMatchData.getSizeOfMatchedInstructions();
        Color color = Colors.MATCHED_BASE;
        if (rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).getInstructions().size() > n2 || rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).getInstructions().size() > n2) {
            color = Colors.CHANGED_BASE;
        }
        rawCombinedBasicBlock.setColor(color);
        rawCombinedBasicBlock.setColor(color);
        rawCombinedBasicBlock.getRawNode(ESide.PRIMARY).setColor(color);
        rawCombinedBasicBlock.getRawNode(ESide.SECONDARY).setColor(color);
    }

    public static void colorizeCombinedNodeLineBorders(Collection collection, IAddress iAddress, IAddress iAddress2) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            if (collection.size() == 1) {
                combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                return;
            }
            SingleViewNode singleViewNode = combinedDiffNode.getPrimaryRawNode();
            SingleViewNode singleViewNode2 = combinedDiffNode.getSecondaryRawNode();
            if (combinedDiffNode.getRawNode().getMatchState() == EMatchState.MATCHED) {
                if (singleViewNode.getAddress().equals(iAddress) && singleViewNode2.getAddress().equals(iAddress2)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                } else if (singleViewNode.getAddress().equals(iAddress) || singleViewNode2.getAddress().equals(iAddress2)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                }
                if (singleViewNode.getChildren().size() == 0 && singleViewNode2.getChildren().size() == 0) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
                    continue;
                }
                if (singleViewNode.getChildren().size() != 0 && singleViewNode2.getChildren().size() != 0) continue;
                combinedDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                continue;
            }
            if (singleViewNode != null) {
                if (singleViewNode.getAddress().equals(iAddress)) {
                    combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                }
                if (singleViewNode.getChildren().size() != 0) continue;
                combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
                continue;
            }
            if (singleViewNode2 == null) continue;
            if (singleViewNode2.getAddress().equals(iAddress2)) {
                combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
            }
            if (singleViewNode2.getChildren().size() != 0) continue;
            combinedDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void colorizeJumps(RawCombinedJump var0, ZyEdgeRealizer var1_1, ZyEdgeRealizer var2_2) {
        var3_3 = var0.getPrimaryEdge();
        if (var3_3 != null) {
            switch (ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[var3_3.getJumpType().ordinal()]) {
                case 1: {
                    var1_1.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
                    var0.setColor(Colors.JUMP_CONDITIONAL_TRUE);
                    ** break;
                }
                case 2: {
                    var1_1.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
                    var0.setColor(Colors.JUMP_CONDITIONAL_FALSE);
                    ** break;
                }
                case 3: {
                    var1_1.setLineColor(Colors.JUMP_SWITCH);
                    var0.setColor(Colors.JUMP_SWITCH);
                    ** break;
                }
            }
            var1_1.setLineColor(Colors.JUMP_UNCONDITIONAL);
            var0.setColor(Colors.JUMP_UNCONDITIONAL);
        }
lbl18: // 6 sources:
        if ((var4_4 = var0.getSecondaryEdge()) != null) {
            switch (ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[var4_4.getJumpType().ordinal()]) {
                case 1: {
                    var2_2.setLineColor(Colors.JUMP_CONDITIONAL_TRUE);
                    var0.setColor(Colors.JUMP_CONDITIONAL_TRUE);
                    ** break;
                }
                case 2: {
                    var2_2.setLineColor(Colors.JUMP_CONDITIONAL_FALSE);
                    var0.setColor(Colors.JUMP_CONDITIONAL_FALSE);
                    ** break;
                }
                case 3: {
                    var2_2.setLineColor(Colors.JUMP_SWITCH);
                    var0.setColor(Colors.JUMP_SWITCH);
                    ** break;
                }
            }
            var2_2.setLineColor(Colors.JUMP_UNCONDITIONAL);
            var0.setColor(Colors.JUMP_UNCONDITIONAL);
        }
lbl34: // 6 sources:
        if (var0.getMatchState() != EMatchState.MATCHED) return;
        if (var0.getPrimaryEdge().getJumpType() == var0.getSecondaryEdge().getJumpType()) return;
        var1_1.setLineColor(Colors.MIXED_BASE_COLOR);
        var2_2.setLineColor(Colors.MIXED_BASE_COLOR);
        var0.setColor(Colors.MIXED_BASE_COLOR);
    }

    public static void colorizeSingleNodeLineBorders(Collection collection, IAddress iAddress) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            SingleDiffNode singleDiffNode = (SingleDiffNode)iterator.next();
            if (collection.size() == 1) {
                singleDiffNode.getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
                return;
            }
            if (singleDiffNode.getRawNode().getAddress().equals(iAddress)) {
                singleDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_TRUE.darker());
                continue;
            }
            if (singleDiffNode.getRawNode().getChildren().size() != 0) continue;
            singleDiffNode.getRealizer().setLineColor(Colors.JUMP_CONDITIONAL_FALSE.darker());
        }
    }

    public static void stylizeJumps(RawCombinedJump rawCombinedJump, ZyEdgeRealizer zyEdgeRealizer, ZyEdgeRealizer zyEdgeRealizer2, ZyEdgeRealizer zyEdgeRealizer3) {
        zyEdgeRealizer.setReversedPathRenderingEnabled(true);
        if (rawCombinedJump.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            zyEdgeRealizer.setLineType(dr.i);
        } else if (rawCombinedJump.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            zyEdgeRealizer.setLineType(dr.n);
        } else {
            zyEdgeRealizer.setLineType(dr.b);
        }
        if (zyEdgeRealizer2 != null && zyEdgeRealizer3 == null) {
            zyEdgeRealizer2.setLineType(dr.i);
            return;
        }
        if (zyEdgeRealizer3 != null && zyEdgeRealizer2 == null) {
            zyEdgeRealizer3.setLineType(dr.i);
            return;
        }
        zyEdgeRealizer2.setLineType(dr.b);
        zyEdgeRealizer3.setLineType(dr.b);
    }
}

