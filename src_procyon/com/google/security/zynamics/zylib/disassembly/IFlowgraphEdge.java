package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.types.graphs.*;

public interface IFlowgraphEdge extends IGraphEdge
{
    int getDestination();
    
    IAddress getParentFunction();
    
    IBasicBlock getSource();
}
