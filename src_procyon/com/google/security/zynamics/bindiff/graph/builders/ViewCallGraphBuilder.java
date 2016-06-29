package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import y.h.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import y.c.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.config.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;

public class ViewCallGraphBuilder
{
    private static void buildCallgraphEdgeMaps(final bu bu, final bu bu2, final bu bu3, final bu bu4, final Map map, final Map map2, final Map map3, final Map map4, final Map map5, final Map map6, final Map map7, final Map map8, final GraphSettings graphSettings, final RawCombinedCallGraph rawCombinedCallGraph) {
        for (final RawCombinedCall rawCombinedCall : rawCombinedCallGraph.getEdges()) {
            final RawCombinedFunction source = rawCombinedCall.getSource();
            final RawCombinedFunction target = rawCombinedCall.getTarget();
            SingleDiffEdge singleDiffEdge = null;
            final RawFunction rawNode = source.getRawNode(ESide.PRIMARY);
            final RawFunction rawNode2 = target.getRawNode(ESide.PRIMARY);
            final IAddress address = rawCombinedCall.getSource().getAddress(ESide.PRIMARY);
            final IAddress address2 = rawCombinedCall.getTarget().getAddress(ESide.PRIMARY);
            final RawCall primaryEdge = rawCombinedCall.getPrimaryEdge();
            if (rawNode != null && rawNode2 != null && primaryEdge != null) {
                final SingleEdgeRealizer singleEdgeRealizer = new SingleEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
                final SingleDiffNode singleDiffNode = map5.get(address);
                final SingleDiffNode singleDiffNode2 = map5.get(address2);
                final d a = bu.a(singleDiffNode.getNode(), singleDiffNode2.getNode());
                singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, a, singleEdgeRealizer, primaryEdge, ESide.PRIMARY);
                SingleDiffNode.link(singleDiffNode, singleDiffNode2);
                singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
                singleEdgeRealizer.setLineType(dr.b);
                map.put(a, singleDiffEdge);
            }
            SingleDiffEdge singleDiffEdge2 = null;
            final RawFunction rawNode3 = source.getRawNode(ESide.SECONDARY);
            final RawFunction rawNode4 = target.getRawNode(ESide.SECONDARY);
            final RawCall secondaryEdge = rawCombinedCall.getSecondaryEdge();
            final IAddress address3 = rawCombinedCall.getSource().getAddress(ESide.SECONDARY);
            final IAddress address4 = rawCombinedCall.getTarget().getAddress(ESide.SECONDARY);
            if (rawNode3 != null && rawNode4 != null && secondaryEdge != null) {
                final SingleEdgeRealizer singleEdgeRealizer2 = new SingleEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
                final SingleDiffNode singleDiffNode3 = map6.get(address3);
                final SingleDiffNode singleDiffNode4 = map6.get(address4);
                final d a2 = bu2.a(singleDiffNode3.getNode(), singleDiffNode4.getNode());
                singleDiffEdge2 = new SingleDiffEdge(singleDiffNode3, singleDiffNode4, a2, singleEdgeRealizer2, secondaryEdge, ESide.SECONDARY);
                SingleDiffNode.link(singleDiffNode3, singleDiffNode4);
                singleEdgeRealizer2.setUserData(new ZyEdgeData(singleDiffEdge2));
                singleEdgeRealizer2.setLineType(dr.b);
                map2.put(a2, singleDiffEdge2);
            }
            final ZyEdgeRealizer zyEdgeRealizer = new ZyEdgeRealizer(new ZyLabelContent(null), null);
            final SuperDiffNode superDiffNode = map7.get(new Pair(address, address3));
            final SuperDiffNode superDiffNode2 = map7.get(new Pair(address2, address4));
            final d a3 = bu3.a(superDiffNode.getNode(), superDiffNode2.getNode());
            final SuperDiffEdge superDiffEdge = new SuperDiffEdge(superDiffNode, superDiffNode2, a3, zyEdgeRealizer, new SuperViewEdge(rawCombinedCall, superDiffNode.getRawNode(), superDiffNode2.getRawNode()), singleDiffEdge, singleDiffEdge2);
            SuperDiffNode.link(superDiffNode, superDiffNode2);
            map3.put(a3, superDiffEdge);
            final CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(new ZyLabelContent(null), null, graphSettings);
            combinedEdgeRealizer.setLineType(dr.b);
            final CombinedDiffNode combinedDiffNode = map8.get(new Pair(address, address3));
            final CombinedDiffNode combinedDiffNode2 = map8.get(new Pair(address2, address4));
            final d a4 = bu4.a(combinedDiffNode.getNode(), combinedDiffNode2.getNode());
            final CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, a4, combinedEdgeRealizer, rawCombinedCall, superDiffEdge);
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
            colorizeCalls(rawCombinedCall);
        }
    }
    
    private static void buildCallgraphNodeMaps(final bu bu, final bu bu2, final bu bu3, final bu bu4, final Map map, final Map map2, final Map map3, final Map map4, final Map map5, final Map map6, final Map map7, final Map map8, final RawCombinedCallGraph rawCombinedCallGraph) {
        for (final RawCombinedFunction rawCombinedFunction : rawCombinedCallGraph.getNodes()) {
            SingleDiffNode singleDiffNode = null;
            SingleDiffNode singleDiffNode2 = null;
            final RawFunction rawNode = rawCombinedFunction.getRawNode(ESide.PRIMARY);
            final RawFunction rawNode2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
            final IAddress address = rawCombinedFunction.getAddress(ESide.PRIMARY);
            final IAddress address2 = rawCombinedFunction.getAddress(ESide.SECONDARY);
            ZyLabelContent buildNormalCallgraphLabelContent = null;
            if (rawNode != null) {
                buildNormalCallgraphLabelContent = buildNormalCallgraphLabelContent(rawNode);
                final ZyNormalNodeRealizer realizer = new ZyNormalNodeRealizer(buildNormalCallgraphLabelContent);
                final FunctionNodeRealizerUpdater updater = new FunctionNodeRealizerUpdater();
                realizer.setUpdater(updater);
                updater.setRealizer(realizer);
                final q d = bu.d();
                singleDiffNode = new SingleDiffNode(d, realizer, rawNode, ESide.PRIMARY);
                map5.put(address, singleDiffNode);
                realizer.setUserData(new ZyNodeData(singleDiffNode));
                map.put(d, singleDiffNode);
            }
            ZyLabelContent buildNormalCallgraphLabelContent2 = null;
            if (rawNode2 != null) {
                buildNormalCallgraphLabelContent2 = buildNormalCallgraphLabelContent(rawNode2);
                final ZyNormalNodeRealizer realizer2 = new ZyNormalNodeRealizer(buildNormalCallgraphLabelContent2);
                final FunctionNodeRealizerUpdater updater2 = new FunctionNodeRealizerUpdater();
                realizer2.setUpdater(updater2);
                updater2.setRealizer(realizer2);
                final q d2 = bu2.d();
                singleDiffNode2 = new SingleDiffNode(d2, realizer2, rawNode2, ESide.SECONDARY);
                realizer2.setUserData(new ZyNodeData(singleDiffNode2));
                map6.put(address2, singleDiffNode2);
                map2.put(d2, singleDiffNode2);
            }
            final ZyNormalNodeRealizer zyNormalNodeRealizer = new ZyNormalNodeRealizer(new ZyLabelContent(null));
            final q d3 = bu3.d();
            final SuperDiffNode superDiffNode = new SuperDiffNode(d3, zyNormalNodeRealizer, new SuperViewNode(rawCombinedFunction), singleDiffNode, singleDiffNode2);
            map7.put(new Pair(address, address2), superDiffNode);
            zyNormalNodeRealizer.setUserData(new ZyNodeData(superDiffNode));
            map3.put(d3, superDiffNode);
            final CombinedNodeRealizer combinedNodeRealizer = new CombinedNodeRealizer(buildNormalCallgraphLabelContent, buildNormalCallgraphLabelContent2);
            final q d4 = bu4.d();
            final CombinedDiffNode combinedDiffNode = new CombinedDiffNode(d4, combinedNodeRealizer, rawCombinedFunction, superDiffNode);
            combinedNodeRealizer.setUserData(new ZyNodeData(combinedDiffNode));
            map8.put(new Pair(address, address2), combinedDiffNode);
            map4.put(d4, combinedDiffNode);
            superDiffNode.setCombinedDiffNode(combinedDiffNode);
            if (singleDiffNode != null) {
                singleDiffNode.setCombinedDiffNode(combinedDiffNode);
            }
            if (singleDiffNode2 != null) {
                singleDiffNode2.setCombinedDiffNode(combinedDiffNode);
            }
            colorizeFunctions(rawCombinedFunction);
        }
    }
    
    private static ZyLabelContent buildNormalCallgraphLabelContent(final SingleViewNode singleViewNode) {
        final RawFunction rawFunction = (RawFunction)singleViewNode;
        final ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        if (rawFunction != null) {
            final ColorsConfigItem colorSettings = BinDiffConfigFile.getInstance().getColorSettings();
            final Color addressColor = colorSettings.getAddressColor();
            final Color mnemonicColor = colorSettings.getMnemonicColor();
            final String hexString = rawFunction.getAddress().toHexString();
            final String name = rawFunction.getName();
            final ArrayList<CStyleRunData> list = new ArrayList<CStyleRunData>();
            list.add(new CStyleRunData(0, hexString.length(), addressColor));
            list.add(new CStyleRunData(hexString.length() + 1, name.length(), mnemonicColor));
            zyLabelContent.addLineContent(new ZyLineContent(String.format("%s %s", hexString, name), Fonts.NORMAL_FONT, list, null));
        }
        return zyLabelContent;
    }
    
    private static Color getFunctionBorderColor(final RawFunction rawFunction, final RawFunction rawFunction2) {
        final Color[] array = { Color.BLACK, Colors.FUNCTION_TYPE_LIBRARY.darker(), Colors.FUNCTION_TYPE_THUNK.darker(), Colors.FUNCTION_TYPE_IMPORTED.darker(), Colors.FUNCTION_TYPE_UNKNOWN, Colors.MIXED_BASE_COLOR };
        if (rawFunction != null && rawFunction2 != null && rawFunction.getFunctionType() != rawFunction2.getFunctionType()) {
            return array[5];
        }
        if (rawFunction != null) {
            return array[EFunctionType.getOrdinal(rawFunction.getFunctionType())];
        }
        return array[EFunctionType.getOrdinal(rawFunction2.getFunctionType())];
    }
    
    public static GraphsContainer buildDiffCallgraphs(final Diff diff, final RawCombinedCallGraph rawCombinedCallGraph) {
        final GraphSettings graphSettings = new GraphSettings(BinDiffConfigFile.getInstance().getInitialCallgraphSettings());
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
        buildCallgraphNodeMaps(graph2D, graph2D2, graph2D4, graph2D3, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, hashMap, hashMap2, hashMap4, hashMap3, rawCombinedCallGraph);
        buildCallgraphEdgeMaps(graph2D, graph2D2, graph2D4, graph2D3, linkedHashMap5, linkedHashMap6, linkedHashMap7, linkedHashMap8, hashMap, hashMap2, hashMap4, hashMap3, graphSettings, rawCombinedCallGraph);
        final CombinedGraph combinedGraph = new CombinedGraph(zyGraph2DView3, linkedHashMap4, linkedHashMap8, graphSettings, EGraphType.CALLGRAPH);
        final SingleGraph singleGraph = new SingleGraph(zyGraph2DView, null, linkedHashMap, linkedHashMap5, graphSettings, ESide.PRIMARY, EGraphType.CALLGRAPH);
        final SingleGraph singleGraph2 = new SingleGraph(zyGraph2DView2, null, linkedHashMap2, linkedHashMap6, graphSettings, ESide.SECONDARY, EGraphType.CALLGRAPH);
        final SuperGraph superGraph = new SuperGraph(zyGraph2DView4, linkedHashMap3, linkedHashMap7, singleGraph, singleGraph2, graphSettings, EGraphType.CALLGRAPH);
        final GraphsContainer graphsContainer = new GraphsContainer(diff, superGraph, combinedGraph, singleGraph, singleGraph2);
        superGraph.refreshAllSuperNodesSizes(singleGraph, singleGraph2);
        return graphsContainer;
    }
    
    public static void colorizeCalls(final RawCombinedCall rawCombinedCall) {
        final EMatchState matchState = rawCombinedCall.getMatchState();
        if (matchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedCall.setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_PRIMARY_UNMATCHED);
            rawCombinedCall.getPrimaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getPrimaryEdge().setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_PRIMARY_UNMATCHED);
        }
        else if (matchState == EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedCall.setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_SECONDRAY_UNMATCHED);
            rawCombinedCall.getSecondaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getSecondaryEdge().setColor(rawCombinedCall.isChanged() ? Colors.MIXED_BASE_COLOR : Colors.CALL_SECONDRAY_UNMATCHED);
        }
        else {
            rawCombinedCall.setColor(Colors.CALL_MATCHED);
            rawCombinedCall.getPrimaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getSecondaryEdge().setColor(Color.BLACK);
            rawCombinedCall.getPrimaryEdge().setColor(Colors.CALL_MATCHED);
            rawCombinedCall.getSecondaryEdge().setColor(Colors.CALL_MATCHED);
        }
    }
    
    public static void colorizeFunctions(final RawCombinedFunction rawCombinedFunction) {
        final RawFunction rawNode = rawCombinedFunction.getRawNode(ESide.PRIMARY);
        final RawFunction rawNode2 = rawCombinedFunction.getRawNode(ESide.SECONDARY);
        final Color functionBorderColor = getFunctionBorderColor(rawNode, rawNode2);
        rawCombinedFunction.setBorderColor(functionBorderColor);
        final EMatchState matchState = rawCombinedFunction.getMatchState();
        if (matchState == EMatchState.PRIMARY_UNMATCHED) {
            rawCombinedFunction.setColor(Colors.PRIMARY_BASE);
            rawNode.setColor(Colors.PRIMARY_BASE);
            rawNode.setBorderColor(functionBorderColor);
        }
        else if (matchState == EMatchState.SECONDRAY_UNMATCHED) {
            rawCombinedFunction.setColor(Colors.SECONDARY_BASE);
            rawNode2.setColor(Colors.SECONDARY_BASE);
            rawNode2.setBorderColor(functionBorderColor);
        }
        else {
            Color color = Colors.MATCHED_BASE;
            if (rawCombinedFunction.isChanged()) {
                if (MatchesGetter.isStructuralChangedFunctionPair(rawNode, rawNode2)) {
                    color = Colors.CHANGED_BASE;
                }
                else {
                    color = Colors.INSTRUCTIONS_ONLY_CHANGED_COLOR;
                }
            }
            rawCombinedFunction.setColor(color);
            rawNode.setColor(color);
            rawNode2.setColor(color);
            rawNode.setBorderColor(functionBorderColor);
            rawNode2.setBorderColor(functionBorderColor);
        }
    }
}
