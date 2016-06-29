/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;

public class CallGraphViewData
extends ViewData {
    private final RawCallGraph primaryRawGraph;
    private final RawCallGraph secondaryRawGraph;
    private final String priImageName;
    private final String secImageName;

    public CallGraphViewData(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2, GraphsContainer graphsContainer, String string, String string2, String string3, EViewType eViewType) {
        super(graphsContainer, string, eViewType);
        this.primaryRawGraph = (RawCallGraph)Preconditions.checkNotNull(rawCallGraph);
        this.secondaryRawGraph = rawCallGraph2;
        this.priImageName = string2;
        this.secImageName = string3;
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        return null;
    }

    public String getImageName(ESide eSide) {
        String string;
        if (eSide == ESide.PRIMARY) {
            string = this.priImageName;
            return string;
        }
        string = this.secImageName;
        return string;
    }

    @Override
    public RawCallGraph getRawGraph(ESide eSide) {
        RawCallGraph rawCallGraph;
        if (eSide == ESide.PRIMARY) {
            rawCallGraph = this.primaryRawGraph;
            return rawCallGraph;
        }
        rawCallGraph = this.secondaryRawGraph;
        return rawCallGraph;
    }

    @Override
    public boolean isCallgraphView() {
        return true;
    }

    @Override
    public boolean isFlowgraphView() {
        return false;
    }
}

