/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Iterator;
import java.util.List;

public class RawCombinedFlowGraph
extends MutableDirectedGraph {
    private final RawFlowGraph primaryFlowgraph;
    private final RawFlowGraph secondaryFlowgraph;

    public RawCombinedFlowGraph(List list, List list2, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2) {
        super(list, list2);
        if (rawFlowGraph == null && rawFlowGraph2 == null) {
            throw new IllegalArgumentException("Primary and secondary flow graphs cannot both be null.");
        }
        this.primaryFlowgraph = rawFlowGraph;
        this.secondaryFlowgraph = rawFlowGraph2;
    }

    public EMatchState getMatchState() {
        if (this.secondaryFlowgraph == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        if (this.primaryFlowgraph != null) return EMatchState.MATCHED;
        return EMatchState.SECONDRAY_UNMATCHED;
    }

    public IAddress getPrimaryAddress() {
        if (this.primaryFlowgraph != null) return this.primaryFlowgraph.getAddress();
        return null;
    }

    public RawFlowGraph getPrimaryFlowgraph() {
        return this.primaryFlowgraph;
    }

    public String getPrimaryName() {
        if (this.primaryFlowgraph != null) return this.primaryFlowgraph.getName();
        return "";
    }

    public IAddress getSecondaryAddress() {
        if (this.secondaryFlowgraph != null) return this.secondaryFlowgraph.getAddress();
        return null;
    }

    public RawFlowGraph getSecondaryFlowgraph() {
        return this.secondaryFlowgraph;
    }

    public String getSecondaryName() {
        if (this.secondaryFlowgraph != null) return this.secondaryFlowgraph.getName();
        return "";
    }

    public void removeNode(RawCombinedBasicBlock rawCombinedBasicBlock) {
        for (CombinedViewEdge combinedViewEdge2 : rawCombinedBasicBlock.getIncomingEdges()) {
            CombinedViewNode.unlink((CombinedViewNode)combinedViewEdge2.getSource(), (CombinedViewNode)combinedViewEdge2.getTarget());
            ((CombinedViewNode)combinedViewEdge2.getSource()).removeOutgoingEdge(combinedViewEdge2);
            ((CombinedViewNode)combinedViewEdge2.getTarget()).removeIncomingEdge(combinedViewEdge2);
        }
        Iterator iterator = rawCombinedBasicBlock.getOutgoingEdges().iterator();
        do {
            CombinedViewEdge combinedViewEdge2;
            if (!iterator.hasNext()) {
                super.removeNode(rawCombinedBasicBlock);
                return;
            }
            combinedViewEdge2 = (CombinedViewEdge)iterator.next();
            CombinedViewNode.unlink((CombinedViewNode)combinedViewEdge2.getSource(), (CombinedViewNode)combinedViewEdge2.getTarget());
            ((CombinedViewNode)combinedViewEdge2.getTarget()).removeIncomingEdge(combinedViewEdge2);
            ((CombinedViewNode)combinedViewEdge2.getSource()).removeOutgoingEdge(combinedViewEdge2);
        } while (true);
    }
}

