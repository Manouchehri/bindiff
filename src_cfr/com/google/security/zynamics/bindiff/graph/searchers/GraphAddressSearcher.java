/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import java.util.Iterator;

public class GraphAddressSearcher {
    public static CombinedDiffNode searchAddress(CombinedGraph combinedGraph, ESide eSide, IAddress iAddress) {
        CombinedDiffNode combinedDiffNode;
        SingleViewNode singleViewNode;
        CombinedViewNode combinedViewNode;
        Iterator iterator = combinedGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!((combinedViewNode = (combinedDiffNode = (CombinedDiffNode)iterator.next()).getRawNode()) instanceof RawCombinedBasicBlock ? (singleViewNode = ((RawCombinedBasicBlock)combinedViewNode).getRawNode(eSide)) != null && singleViewNode.getInstruction(iAddress) != null : (singleViewNode = ((RawCombinedFunction)combinedViewNode).getRawNode(eSide)) != null && singleViewNode.getAddress().equals(iAddress)));
        return combinedDiffNode;
    }

    public static SingleDiffNode searchAddress(SingleGraph singleGraph, IAddress iAddress) {
        SingleViewNode singleViewNode;
        SingleDiffNode singleDiffNode;
        Iterator iterator = singleGraph.getNodes().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!((singleViewNode = (singleDiffNode = (SingleDiffNode)iterator.next()).getRawNode()) instanceof RawBasicBlock ? ((RawBasicBlock)singleViewNode).getInstruction(iAddress) != null : singleDiffNode.getRawNode().getAddress().equals(iAddress)));
        return singleDiffNode;
    }
}

