/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.ColorsConfigItem;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedNodeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.FunctionNodeRealizerUpdater;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ZyNodeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNormalNodeRealizer;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import y.c.d;
import y.c.q;
import y.h.bu;
import y.h.dr;

public class ViewCallGraphBuilder {
    private static void buildCallgraphEdgeMaps(bu bu2, bu bu3, bu bu4, bu bu5, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, GraphSettings graphSettings, RawCombinedCallGraph rawCombinedCallGraph) {
        Iterator iterator = rawCombinedCallGraph.getEdges().iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object4;
            Object object2;
            Object object3;
            Object object5;
            RawCombinedCall rawCombinedCall = (RawCombinedCall)iterator.next();
            RawCombinedFunction rawCombinedFunction = rawCombinedCall.getSource();
            RawCombinedFunction rawCombinedFunction2 = rawCombinedCall.getTarget();
            SingleDiffEdge singleDiffEdge = null;
            d d2 = null;
            RawFunction rawFunction2 = rawCombinedFunction.getRawNode(ESide.PRIMARY);
            RawFunction rawFunction3 = rawCombinedFunction2.getRawNode(ESide.PRIMARY);
            IAddress iAddress = rawCombinedCall.getSource().getAddress(ESide.PRIMARY);
            IAddress iAddress2 = rawCombinedCall.getTarget().getAddress(ESide.PRIMARY);
            RawCall rawCall = rawCombinedCall.getPrimaryEdge();
            SingleEdgeRealizer singleEdgeRealizer = null;
            if (rawFunction2 != null && rawFunction3 != null && rawCall != null) {
                object4 = new ZyLabelContent(null);
                singleEdgeRealizer = new SingleEdgeRealizer((ZyLabelContent)object4, null, graphSettings);
                object3 = (SingleDiffNode)map5.get(iAddress);
                SingleDiffNode singleDiffNode = (SingleDiffNode)map5.get(iAddress2);
                d2 = bu2.a(object3.getNode(), singleDiffNode.getNode());
                singleDiffEdge = new SingleDiffEdge((SingleDiffNode)object3, singleDiffNode, d2, singleEdgeRealizer, rawCall, ESide.PRIMARY);
                SingleDiffNode.link((SingleDiffNode)object3, singleDiffNode);
                singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
                singleEdgeRealizer.setLineType(dr.b);
                map.put(d2, singleDiffEdge);
            }
            object4 = null;
            object3 = null;
            RawFunction rawFunction = rawCombinedFunction.getRawNode(ESide.SECONDARY);
            RawFunction rawFunction4 = rawCombinedFunction2.getRawNode(ESide.SECONDARY);
            RawCall rawCall2 = rawCombinedCall.getSecondaryEdge();
            IAddress iAddress3 = rawCombinedCall.getSource().getAddress(ESide.SECONDARY);
            IAddress iAddress4 = rawCombinedCall.getTarget().getAddress(ESide.SECONDARY);
            SingleEdgeRealizer singleEdgeRealizer2 = null;
            if (rawFunction != null && rawFunction4 != null && rawCall2 != null) {
                object2 = new ZyLabelContent(null);
                singleEdgeRealizer2 = new SingleEdgeRealizer((ZyLabelContent)object2, null, graphSettings);
                object = (SingleDiffNode)map6.get(iAddress3);
                object5 = (SingleDiffNode)map6.get(iAddress4);
                object3 = bu3.a(object.getNode(), object5.getNode());
                object4 = new SingleDiffEdge((SingleDiffNode)object, (SingleDiffNode)object5, (d)object3, singleEdgeRealizer2, rawCall2, ESide.SECONDARY);
                SingleDiffNode.link((SingleDiffNode)object, (SingleDiffNode)object5);
                singleEdgeRealizer2.setUserData(new ZyEdgeData(object4));
                singleEdgeRealizer2.setLineType(dr.b);
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
            SuperViewEdge superViewEdge = new SuperViewEdge(rawCombinedCall, superViewNode, superViewNode2);
            object2 = new SuperDiffEdge(superDiffNode, superDiffNode2, (d)object, zyEdgeRealizer, superViewEdge, singleDiffEdge, (SingleDiffEdge)object4);
            SuperDiffNode.link(superDiffNode, superDiffNode2);
            map3.put(object, object2);
            CombinedDiffEdge combinedDiffEdge = null;
            d d3 = null;
            ZyLabelContent zyLabelContent = new ZyLabelContent(null);
            CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(zyLabelContent, null, graphSettings);
            combinedEdgeRealizer.setLineType(dr.b);
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)map8.get(new Pair(iAddress, iAddress3));
            CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)map8.get(new Pair(iAddress2, iAddress4));
            q q4 = combinedDiffNode.getNode();
            q q5 = combinedDiffNode2.getNode();
            d3 = bu5.a(q4, q5);
            combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, d3, combinedEdgeRealizer, rawCombinedCall, (SuperDiffEdge)object2);
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
            ViewCallGraphBuilder.colorizeCalls(rawCombinedCall);
        }
    }

    private static void buildCallgraphNodeMaps(bu bu2, bu bu3, bu bu4, bu bu5, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, RawCombinedCallGraph rawCombinedCallGraph) {
        Iterator iterator = rawCombinedCallGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            Object object;
            Object object2;
            Object object3;
            RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)iterator.next();
            SingleDiffNode singleDiffNode = null;
            SingleDiffNode singleDiffNode2 = null;
            SuperDiffNode superDiffNode = null;
            CombinedDiffNode combinedDiffNode = null;
            q q2 = null;
            q q3 = null;
            q q4 = null;
            q q5 = null;
            RawFunction rawFunction = rawCombinedFunction.getRawNode(ESide.PRIMARY);
            RawFunction rawFunction2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
            IAddress iAddress = rawCombinedFunction.getAddress(ESide.PRIMARY);
            IAddress iAddress2 = rawCombinedFunction.getAddress(ESide.SECONDARY);
            ZyLabelContent zyLabelContent = null;
            if (rawFunction != null) {
                zyLabelContent = ViewCallGraphBuilder.buildNormalCallgraphLabelContent(rawFunction);
                object2 = new ZyNormalNodeRealizer(zyLabelContent);
                object3 = new FunctionNodeRealizerUpdater();
                object2.setUpdater((IRealizerUpdater)object3);
                object3.setRealizer((IZyNodeRealizer)object2);
                q2 = bu2.d();
                singleDiffNode = new SingleDiffNode(q2, (IZyNodeRealizer)object2, rawFunction, ESide.PRIMARY);
                map5.put(iAddress, singleDiffNode);
                object2.setUserData(new ZyNodeData(singleDiffNode));
                map.put(q2, singleDiffNode);
            }
            object2 = null;
            if (rawFunction2 != null) {
                object2 = ViewCallGraphBuilder.buildNormalCallgraphLabelContent(rawFunction2);
                object3 = new ZyNormalNodeRealizer((ZyLabelContent)object2);
                object = new FunctionNodeRealizerUpdater();
                object3.setUpdater((IRealizerUpdater)object);
                object.setRealizer((IZyNodeRealizer)object3);
                q3 = bu3.d();
                singleDiffNode2 = new SingleDiffNode(q3, (IZyNodeRealizer)object3, rawFunction2, ESide.SECONDARY);
                object3.setUserData(new ZyNodeData(singleDiffNode2));
                map6.put(iAddress2, singleDiffNode2);
                map2.put(q3, singleDiffNode2);
            }
            object3 = new ZyLabelContent(null);
            object = new ZyNormalNodeRealizer((ZyLabelContent)object3);
            q4 = bu4.d();
            SuperViewNode superViewNode = new SuperViewNode(rawCombinedFunction);
            superDiffNode = new SuperDiffNode(q4, (IZyNodeRealizer)object, superViewNode, singleDiffNode, singleDiffNode2);
            map7.put(new Pair(iAddress, iAddress2), superDiffNode);
            object.setUserData(new ZyNodeData(superDiffNode));
            map3.put(q4, superDiffNode);
            CombinedNodeRealizer combinedNodeRealizer = new CombinedNodeRealizer(zyLabelContent, (ZyLabelContent)object2);
            q5 = bu5.d();
            combinedDiffNode = new CombinedDiffNode(q5, combinedNodeRealizer, rawCombinedFunction, superDiffNode);
            combinedNodeRealizer.setUserData(new ZyNodeData(combinedDiffNode));
            map8.put(new Pair(iAddress, iAddress2), combinedDiffNode);
            map4.put(q5, combinedDiffNode);
            superDiffNode.setCombinedDiffNode(combinedDiffNode);
            if (singleDiffNode != null) {
                singleDiffNode.setCombinedDiffNode(combinedDiffNode);
            }
            if (singleDiffNode2 != null) {
                singleDiffNode2.setCombinedDiffNode(combinedDiffNode);
            }
            ViewCallGraphBuilder.colorizeFunctions(rawCombinedFunction);
        }
    }

    private static ZyLabelContent buildNormalCallgraphLabelContent(SingleViewNode singleViewNode) {
        RawFunction rawFunction = (RawFunction)singleViewNode;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        if (rawFunction == null) return zyLabelContent;
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        ColorsConfigItem colorsConfigItem = binDiffConfigFile.getColorSettings();
        Color color = colorsConfigItem.getAddressColor();
        Color color2 = colorsConfigItem.getMnemonicColor();
        String string = rawFunction.getAddress().toHexString();
        String string2 = rawFunction.getName();
        ArrayList<CStyleRunData> arrayList = new ArrayList<CStyleRunData>();
        arrayList.add(new CStyleRunData(0, string.length(), color));
        arrayList.add(new CStyleRunData(string.length() + 1, string2.length(), color2));
        String string3 = String.format("%s %s", string, string2);
        ZyLineContent zyLineContent = new ZyLineContent(string3, Fonts.NORMAL_FONT, arrayList, null);
        zyLabelContent.addLineContent(zyLineContent);
        return zyLabelContent;
    }

    private static Color getFunctionBorderColor(RawFunction rawFunction, RawFunction rawFunction2) {
        EFunctionType eFunctionType;
        Color[] arrcolor = new Color[]{Color.BLACK, Colors.FUNCTION_TYPE_LIBRARY.darker(), Colors.FUNCTION_TYPE_THUNK.darker(), Colors.FUNCTION_TYPE_IMPORTED.darker(), Colors.FUNCTION_TYPE_UNKNOWN, Colors.MIXED_BASE_COLOR};
        if (rawFunction != null && rawFunction2 != null && (eFunctionType = rawFunction.getFunctionType()) != rawFunction2.getFunctionType()) {
            return arrcolor[5];
        }
        if (rawFunction == null) return arrcolor[EFunctionType.getOrdinal(rawFunction2.getFunctionType())];
        return arrcolor[EFunctionType.getOrdinal(rawFunction.getFunctionType())];
    }

    public static GraphsContainer buildDiffCallgraphs(Diff diff, RawCombinedCallGraph rawCombinedCallGraph) {
        GraphSettings graphSettings = new GraphSettings(BinDiffConfigFile.getInstance().getInitialCallgraphSettings());
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
        ViewCallGraphBuilder.buildCallgraphNodeMaps(bu2, bu3, bu5, bu4, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, hashMap, hashMap2, hashMap4, hashMap3, rawCombinedCallGraph);
        ViewCallGraphBuilder.buildCallgraphEdgeMaps(bu2, bu3, bu5, bu4, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, hashMap, hashMap2, hashMap4, hashMap3, graphSettings, rawCombinedCallGraph);
        CombinedGraph combinedGraph = new CombinedGraph(zyGraph2DView3, linkedHashMap4, linkedHashMap8, graphSettings, EGraphType.CALLGRAPH);
        SingleGraph singleGraph = new SingleGraph(zyGraph2DView, null, linkedHashMap, linkedHashMap5, graphSettings, ESide.PRIMARY, EGraphType.CALLGRAPH);
        SingleGraph singleGraph2 = new SingleGraph(zyGraph2DView2, null, linkedHashMap2, linkedHashMap6, graphSettings, ESide.SECONDARY, EGraphType.CALLGRAPH);
        SuperGraph superGraph = new SuperGraph(zyGraph2DView4, linkedHashMap3, linkedHashMap7, singleGraph, singleGraph2, graphSettings, EGraphType.CALLGRAPH);
        GraphsContainer graphsContainer = new GraphsContainer(diff, superGraph, combinedGraph, singleGraph, singleGraph2);
        superGraph.refreshAllSuperNodesSizes(singleGraph, singleGraph2);
        return graphsContainer;
    }

    public static void colorizeCalls(RawCombinedCall rawCombinedCall) {
        EMatchState eMatchState = rawCombinedCall.getMatchState();
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedCall.setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_PRIMARY_UNMATCHED);
            rawCombinedCall.getPrimaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getPrimaryEdge().setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_PRIMARY_UNMATCHED);
            return;
        }
        if (eMatchState != EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedCall.setColor(Colors.CALL_MATCHED);
            rawCombinedCall.getPrimaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getSecondaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getPrimaryEdge().setColor(Colors.CALL_MATCHED);
            rawCombinedCall.getSecondaryEdge().setColor(Colors.CALL_MATCHED);
            return;
        }
        rawCombinedCall.setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_SECONDRAY_UNMATCHED);
        rawCombinedCall.getSecondaryEdge().setColor(Color.BLACK);
        rawCombinedCall.getSecondaryEdge().setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_SECONDRAY_UNMATCHED);
    }

    public static void colorizeFunctions(RawCombinedFunction rawCombinedFunction) {
        RawFunction rawFunction = rawCombinedFunction.getRawNode(ESide.PRIMARY);
        RawFunction rawFunction2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
        Color color = ViewCallGraphBuilder.getFunctionBorderColor(rawFunction, rawFunction2);
        rawCombinedFunction.setBorderColor(color);
        EMatchState eMatchState = rawCombinedFunction.getMatchState();
        if (eMatchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedFunction.setColor(Colors.PRIMARY_BASE);
            rawFunction.setColor(Colors.PRIMARY_BASE);
            rawFunction.setBorderColor(color);
            return;
        }
        if (eMatchState == EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedFunction.setColor(Colors.SECONDARY_BASE);
            rawFunction2.setColor(Colors.SECONDARY_BASE);
            rawFunction2.setBorderColor(color);
            return;
        }
        Color color2 = Colors.MATCHED_BASE;
        if (rawCombinedFunction.isChanged()) {
            color2 = MatchesGetter.isStructuralChangedFunctionPair(rawFunction, rawFunction2) ? Colors.CHANGED_BASE : Colors.INSTRUCTIONS_ONLY_CHANGED_COLOR;
        }
        rawCombinedFunction.setColor(color2);
        rawFunction.setColor(color2);
        rawFunction2.setColor(color2);
        rawFunction.setBorderColor(color);
        rawFunction2.setBorderColor(color);
    }
}

