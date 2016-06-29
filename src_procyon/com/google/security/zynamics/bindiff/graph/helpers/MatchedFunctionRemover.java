package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.realizers.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.builders.*;

public class MatchedFunctionRemover
{
    private static CombinedDiffEdge buildDiffEdge(final CombinedGraph combinedGraph, final RawCombinedCall rawCombinedCall, final SuperDiffEdge superDiffEdge) {
        final CombinedEdgeRealizer combinedEdgeRealizer = new CombinedEdgeRealizer(new ZyLabelContent(null), null, combinedGraph.getSettings());
        final CombinedDiffNode combinedDiffNode = (CombinedDiffNode)combinedGraph.getNode(rawCombinedCall.getSource());
        final CombinedDiffNode combinedDiffNode2 = (CombinedDiffNode)combinedGraph.getNode(rawCombinedCall.getTarget());
        final CombinedDiffEdge combinedDiffEdge = new CombinedDiffEdge(combinedDiffNode, combinedDiffNode2, combinedGraph.getGraph().a(combinedDiffNode.getNode(), combinedDiffNode2.getNode()), combinedEdgeRealizer, rawCombinedCall, superDiffEdge);
        CombinedDiffNode.link(combinedDiffNode, combinedDiffNode2);
        combinedEdgeRealizer.setUserData(new ZyEdgeData(combinedDiffEdge));
        combinedGraph.addEdgeToMappings(combinedDiffEdge);
        return combinedDiffEdge;
    }
    
    private static SingleDiffEdge buildDiffEdge(final SingleGraph singleGraph, final RawCombinedCall rawCombinedCall) {
        ZyGraphEdge zyGraphEdge = null;
        final RawFunction rawNode = rawCombinedCall.getSource().getRawNode(singleGraph.getSide());
        final RawFunction rawNode2 = rawCombinedCall.getTarget().getRawNode(singleGraph.getSide());
        final RawCall rawCall = (singleGraph.getSide() == ESide.PRIMARY) ? rawCombinedCall.getPrimaryEdge() : rawCombinedCall.getSecondaryEdge();
        if (rawNode != null && rawNode2 != null && rawCombinedCall != null && rawCall != null) {
            final SingleEdgeRealizer singleEdgeRealizer = new SingleEdgeRealizer(new ZyLabelContent(null), null, singleGraph.getSettings());
            final SingleDiffNode singleDiffNode = (SingleDiffNode)singleGraph.getNode(rawNode);
            final SingleDiffNode singleDiffNode2 = (SingleDiffNode)singleGraph.getNode(rawNode2);
            zyGraphEdge = new SingleDiffEdge(singleDiffNode, singleDiffNode2, singleGraph.getGraph().a(singleDiffNode.getNode(), singleDiffNode2.getNode()), singleEdgeRealizer, rawCall, singleGraph.getSide());
            SingleDiffNode.link(singleDiffNode, singleDiffNode2);
            singleEdgeRealizer.setUserData(new ZyEdgeData(zyGraphEdge));
            singleGraph.addEdgeToMappings(zyGraphEdge);
        }
        return (SingleDiffEdge)zyGraphEdge;
    }
    
    private static SuperDiffEdge buildDiffEdge(final SuperGraph superGraph, final RawCombinedCall rawCombinedCall, final SingleDiffEdge singleDiffEdge, final SingleDiffEdge singleDiffEdge2) {
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
        final SuperDiffEdge superDiffEdge = new SuperDiffEdge(superDiffNode, superDiffNode2, superGraph.getGraph().a(superDiffNode.getNode(), superDiffNode2.getNode()), zyEdgeRealizer, new SuperViewEdge(rawCombinedCall, superDiffNode.getRawNode(), superDiffNode2.getRawNode()), singleDiffEdge, singleDiffEdge2);
        SuperDiffNode.link(superDiffNode, superDiffNode2);
        zyEdgeRealizer.setUserData(new ZyEdgeData(superDiffEdge));
        superGraph.addEdgeToMappings(superDiffEdge);
        return superDiffEdge;
    }
    
    public static void buildCalls(final BinDiffGraph binDiffGraph, final RawCombinedCall rawCombinedCall) {
        final SingleGraph primaryGraph = binDiffGraph.getPrimaryGraph();
        final SingleGraph secondaryGraph = binDiffGraph.getSecondaryGraph();
        final SuperGraph superGraph = binDiffGraph.getSuperGraph();
        final CombinedGraph combinedGraph = binDiffGraph.getCombinedGraph();
        final SingleDiffEdge buildDiffEdge = buildDiffEdge(primaryGraph, rawCombinedCall);
        final SingleDiffEdge buildDiffEdge2 = buildDiffEdge(secondaryGraph, rawCombinedCall);
        final SuperDiffEdge buildDiffEdge3 = buildDiffEdge(superGraph, rawCombinedCall, buildDiffEdge, buildDiffEdge2);
        final CombinedDiffEdge buildDiffEdge4 = buildDiffEdge(combinedGraph, rawCombinedCall, buildDiffEdge3);
        buildDiffEdge3.setCombinedDiffEdge(buildDiffEdge4);
        if (buildDiffEdge != null) {
            buildDiffEdge.setCombinedDiffEdge(buildDiffEdge4);
        }
        if (buildDiffEdge2 != null) {
            buildDiffEdge2.setCombinedDiffEdge(buildDiffEdge4);
        }
        ViewCallGraphBuilder.colorizeCalls(rawCombinedCall);
    }
}
