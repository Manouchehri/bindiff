package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.types.graphs.*;

public class CallGraphViewData extends ViewData
{
    private final RawCallGraph primaryRawGraph;
    private final RawCallGraph secondaryRawGraph;
    private final String priImageName;
    private final String secImageName;
    
    public CallGraphViewData(final RawCallGraph rawCallGraph, final RawCallGraph secondaryRawGraph, final GraphsContainer graphsContainer, final String s, final String priImageName, final String secImageName, final EViewType eViewType) {
        super(graphsContainer, s, eViewType);
        this.primaryRawGraph = (RawCallGraph)Preconditions.checkNotNull(rawCallGraph);
        this.secondaryRawGraph = secondaryRawGraph;
        this.priImageName = priImageName;
        this.secImageName = secImageName;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        return null;
    }
    
    public String getImageName(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.priImageName : this.secImageName;
    }
    
    @Override
    public RawCallGraph getRawGraph(final ESide eSide) {
        return (eSide == ESide.PRIMARY) ? this.primaryRawGraph : this.secondaryRawGraph;
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
