package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.types.graphs.*;

public class FlowGraphViewData extends ViewData
{
    private final RawFlowGraph primaryRawGraph;
    private final RawFlowGraph secondaryRawGraph;
    private final RawCombinedFlowGraph combinedRawFlowgraph;
    
    public FlowGraphViewData(final RawFlowGraph primaryRawGraph, final RawFlowGraph secondaryRawGraph, final RawCombinedFlowGraph rawCombinedFlowGraph, final GraphsContainer graphsContainer, final String s, final EViewType eViewType) {
        super(graphsContainer, s, eViewType);
        Preconditions.checkArgument(primaryRawGraph != null || secondaryRawGraph != null, (Object)"Raw primary and secondary flow graphs cannot both be null");
        this.combinedRawFlowgraph = (RawCombinedFlowGraph)Preconditions.checkNotNull(rawCombinedFlowGraph);
        this.primaryRawGraph = primaryRawGraph;
        this.secondaryRawGraph = secondaryRawGraph;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            if (this.primaryRawGraph == null) {
                return null;
            }
            return this.primaryRawGraph.getAddress();
        }
        else {
            if (this.secondaryRawGraph == null) {
                return null;
            }
            return this.secondaryRawGraph.getAddress();
        }
    }
    
    public RawCombinedFlowGraph getCombinedRawGraph() {
        return this.combinedRawFlowgraph;
    }
    
    public String getFunctionName(final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            if (this.primaryRawGraph == null) {
                return null;
            }
            return this.primaryRawGraph.getName();
        }
        else {
            if (this.secondaryRawGraph == null) {
                return null;
            }
            return this.secondaryRawGraph.getName();
        }
    }
    
    @Override
    public RawFlowGraph getRawGraph(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryRawGraph : this.secondaryRawGraph;
    }
    
    @Override
    public boolean isCallgraphView() {
        return false;
    }
    
    public boolean isChangedOnlyInstructions() {
        final RawFunction function = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        return function != null && function.isChangedInstructionsOnlyMatch();
    }
    
    public boolean isChangedStructural() {
        final RawFunction function = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        return function != null && function.isChangedStructuralMatch();
    }
    
    @Override
    public boolean isFlowgraphView() {
        return true;
    }
    
    public boolean isMatched() {
        final RawFunction function = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        return function != null && function.getMatchedFunction() != null;
    }
    
    public boolean isMatchedIdentical() {
        final RawFunction function = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        return function != null && function.isIdenticalMatch();
    }
}
