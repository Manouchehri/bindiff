package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;

public class RawCombinedFlowGraph extends MutableDirectedGraph
{
    private final RawFlowGraph primaryFlowgraph;
    private final RawFlowGraph secondaryFlowgraph;
    
    public RawCombinedFlowGraph(final List list, final List list2, final RawFlowGraph primaryFlowgraph, final RawFlowGraph secondaryFlowgraph) {
        super(list, list2);
        if (primaryFlowgraph == null && secondaryFlowgraph == null) {
            throw new IllegalArgumentException("Primary and secondary flow graphs cannot both be null.");
        }
        this.primaryFlowgraph = primaryFlowgraph;
        this.secondaryFlowgraph = secondaryFlowgraph;
    }
    
    public EMatchState getMatchState() {
        if (this.secondaryFlowgraph == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        if (this.primaryFlowgraph == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        return EMatchState.MATCHED;
    }
    
    public IAddress getPrimaryAddress() {
        if (this.primaryFlowgraph == null) {
            return null;
        }
        return this.primaryFlowgraph.getAddress();
    }
    
    public RawFlowGraph getPrimaryFlowgraph() {
        return this.primaryFlowgraph;
    }
    
    public String getPrimaryName() {
        if (this.primaryFlowgraph == null) {
            return "";
        }
        return this.primaryFlowgraph.getName();
    }
    
    public IAddress getSecondaryAddress() {
        if (this.secondaryFlowgraph == null) {
            return null;
        }
        return this.secondaryFlowgraph.getAddress();
    }
    
    public RawFlowGraph getSecondaryFlowgraph() {
        return this.secondaryFlowgraph;
    }
    
    public String getSecondaryName() {
        if (this.secondaryFlowgraph == null) {
            return "";
        }
        return this.secondaryFlowgraph.getName();
    }
    
    public void removeNode(final RawCombinedBasicBlock rawCombinedBasicBlock) {
        for (final CombinedViewEdge combinedViewEdge : rawCombinedBasicBlock.getIncomingEdges()) {
            CombinedViewNode.unlink((CombinedViewNode)combinedViewEdge.getSource(), (CombinedViewNode)combinedViewEdge.getTarget());
            ((CombinedViewNode)combinedViewEdge.getSource()).removeOutgoingEdge(combinedViewEdge);
            ((CombinedViewNode)combinedViewEdge.getTarget()).removeIncomingEdge(combinedViewEdge);
        }
        for (final CombinedViewEdge combinedViewEdge2 : rawCombinedBasicBlock.getOutgoingEdges()) {
            CombinedViewNode.unlink((CombinedViewNode)combinedViewEdge2.getSource(), (CombinedViewNode)combinedViewEdge2.getTarget());
            ((CombinedViewNode)combinedViewEdge2.getTarget()).removeIncomingEdge(combinedViewEdge2);
            ((CombinedViewNode)combinedViewEdge2.getSource()).removeOutgoingEdge(combinedViewEdge2);
        }
        super.removeNode(rawCombinedBasicBlock);
    }
}
