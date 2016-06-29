/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.disassembly.IBasicBlock;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;

public interface IFlowgraphEdge
extends IGraphEdge {
    public int getDestination();

    public IAddress getParentFunction();

    @Override
    public IBasicBlock getSource();
}

