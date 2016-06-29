package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.IBasicBlock;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;

public interface IFlowgraphEdge extends IGraphEdge {
   int getDestination();

   IAddress getParentFunction();

   IBasicBlock getSource();
}
