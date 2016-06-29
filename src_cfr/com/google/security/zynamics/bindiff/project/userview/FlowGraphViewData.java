/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;

public class FlowGraphViewData
extends ViewData {
    private final RawFlowGraph primaryRawGraph;
    private final RawFlowGraph secondaryRawGraph;
    private final RawCombinedFlowGraph combinedRawFlowgraph;

    public FlowGraphViewData(RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawCombinedFlowGraph rawCombinedFlowGraph, GraphsContainer graphsContainer, String string, EViewType eViewType) {
        super(graphsContainer, string, eViewType);
        Preconditions.checkArgument(rawFlowGraph != null || rawFlowGraph2 != null, "Raw primary and secondary flow graphs cannot both be null");
        this.combinedRawFlowgraph = (RawCombinedFlowGraph)Preconditions.checkNotNull(rawCombinedFlowGraph);
        this.primaryRawGraph = rawFlowGraph;
        this.secondaryRawGraph = rawFlowGraph2;
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            if (this.primaryRawGraph != null) return this.primaryRawGraph.getAddress();
            return null;
        }
        if (this.secondaryRawGraph != null) return this.secondaryRawGraph.getAddress();
        return null;
    }

    public RawCombinedFlowGraph getCombinedRawGraph() {
        return this.combinedRawFlowgraph;
    }

    public String getFunctionName(ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            if (this.primaryRawGraph != null) return this.primaryRawGraph.getName();
            return null;
        }
        if (this.secondaryRawGraph != null) return this.secondaryRawGraph.getName();
        return null;
    }

    @Override
    public RawFlowGraph getRawGraph(ESide eSide) {
        RawFlowGraph rawFlowGraph;
        if (eSide == ESide.PRIMARY) {
            rawFlowGraph = this.primaryRawGraph;
            return rawFlowGraph;
        }
        rawFlowGraph = this.secondaryRawGraph;
        return rawFlowGraph;
    }

    @Override
    public boolean isCallgraphView() {
        return false;
    }

    public boolean isChangedOnlyInstructions() {
        RawFunction rawFunction = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        if (rawFunction == null) return false;
        if (!rawFunction.isChangedInstructionsOnlyMatch()) return false;
        return true;
    }

    public boolean isChangedStructural() {
        RawFunction rawFunction = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        if (rawFunction == null) return false;
        if (!rawFunction.isChangedStructuralMatch()) return false;
        return true;
    }

    @Override
    public boolean isFlowgraphView() {
        return true;
    }

    public boolean isMatched() {
        RawFunction rawFunction = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        if (rawFunction == null) return false;
        if (rawFunction.getMatchedFunction() == null) return false;
        return true;
    }

    public boolean isMatchedIdentical() {
        RawFunction rawFunction = this.getGraphs().getDiff().getCallgraph(ESide.PRIMARY).getFunction(this.getAddress(ESide.PRIMARY));
        if (rawFunction == null) return false;
        if (!rawFunction.isIdenticalMatch()) return false;
        return true;
    }
}

