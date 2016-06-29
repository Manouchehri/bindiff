/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.realizers.CombinedEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.realizers.SingleEdgeRealizer;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.gui.zygraph.edges.ZyEdgeData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IEdgeRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;
import y.c.q;
import y.h.bu;

public class MatchedFunctionRemover {
    private static CombinedDiffEdge buildDiffEdge(CombinedGraph combinedGraph, RawCombinedCall rawCombinedCall, SuperDiffEdge superDiffEdge) {
        d d2 = null;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(zyLabelContent, null, combinedGraph.getSettings());
        CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(rawCombinedCall.getSource());
        CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(rawCombinedCall.getTarget());
        q q2 = combinedDiffNode.getNode();
        q q3 = combinedDiffNode2.getNode();
        d2 = combinedGraph.getGraph().a(q2, q3);
        CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, d2, combinedEdgeRealizer, rawCombinedCall, superDiffEdge);
        CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
        combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
        combinedGraph.addEdgeToMappings(combinedDiffEdge);
        return combinedDiffEdge;
    }

    private static SingleDiffEdge buildDiffEdge(SingleGraph singleGraph, RawCombinedCall rawCombinedCall) {
        SingleDiffEdge singleDiffEdge = null;
        d d2 = null;
        RawFunction rawFunction = rawCombinedCall.getSource().getRawNode(singleGraph.getSide());
        RawFunction rawFunction2 = rawCombinedCall.getTarget().getRawNode(singleGraph.getSide());
        RawCall rawCall = singleGraph.getSide() == ESide.PRIMARY ? rawCombinedCall.getPrimaryEdge() : rawCombinedCall.getSecondaryEdge();
        SingleEdgeRealizer singleEdgeRealizer = null;
        if (rawFunction == null) return singleDiffEdge;
        if (rawFunction2 == null) return singleDiffEdge;
        if (rawCombinedCall == null) return singleDiffEdge;
        if (rawCall == null) return singleDiffEdge;
        ZyLabelContent zyLabelContent = new ZyLabelContent(null);
        singleEdgeRealizer = new SingleEdgeRealizer(zyLabelContent, null, singleGraph.getSettings());
        SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(rawFunction);
        SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleGraph.getNode(rawFunction2);
        d2 = singleGraph.getGraph().a(singleDiffNode.getNode(), singleDiffNode2.getNode());
        singleDiffEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, d2, singleEdgeRealizer, rawCall, singleGraph.getSide());
        SingleDiffNode.link(singleDiffNode, singleDiffNode2);
        singleEdgeRealizer.setUserData(new ZyEdgeData(singleDiffEdge));
        singleGraph.addEdgeToMappings(singleDiffEdge);
        return singleDiffEdge;
    }

    private static SuperDiffEdge buildDiffEdge(SuperGraph superGraph, RawCombinedCall rawCombinedCall, SingleDiffEdge singleDiffEdge, SingleDiffEdge singleDiffEdge2) {
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
        d2 = superGraph.getGraph().a(q2, q3);
        SuperViewNode superViewNode = zyGraphNode.getRawNode();
        SuperViewNode superViewNode2 = zyGraphNode2.getRawNode();
        SuperViewEdge superViewEdge = new SuperViewEdge(rawCombinedCall, superViewNode, superViewNode2);
        SuperDiffEdge superDiffEdge = new SuperDiffEdge((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2, d2, zyEdgeRealizer, superViewEdge, singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link((SuperDiffNode)zyGraphNode, (SuperDiffNode)zyGraphNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }

    public static void buildCalls(BinDiffGraph binDiffGraph, RawCombinedCall rawCombinedCall) {
        SingleGraph singleGraph = binDiffGraph.getPrimaryGraph();
        SingleGraph singleGraph2 = binDiffGraph.getSecondaryGraph();
        SuperGraph superGraph = binDiffGraph.getSuperGraph();
        CombinedGraph combinedGraph = binDiffGraph.getCombinedGraph();
        SingleDiffEdge singleDiffEdge = MatchedFunctionRemover.buildDiffEdge(singleGraph, rawCombinedCall);
        SingleDiffEdge singleDiffEdge2 = MatchedFunctionRemover.buildDiffEdge(singleGraph2, rawCombinedCall);
        SuperDiffEdge superDiffEdge = MatchedFunctionRemover.buildDiffEdge(superGraph, rawCombinedCall, singleDiffEdge, singleDiffEdge2);
        CombinedDiffEdge combinedDiffEdge = MatchedFunctionRemover.buildDiffEdge(combinedGraph, rawCombinedCall, superDiffEdge);
        superDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
        if (singleDiffEdge != null) {
            singleDiffEdge.setCombinedDiffEdge(combinedDiffEdge);
        }
        if (singleDiffEdge2 != null) {
            singleDiffEdge2.setCombinedDiffEdge(combinedDiffEdge);
        }
        ViewCallGraphBuilder.colorizeCalls(rawCombinedCall);
    }
}

