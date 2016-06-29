package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;

public class RawCombinedFunction extends CombinedViewNode
{
    private final RawFunction primaryFunction;
    private final RawFunction secondaryFunction;
    
    public RawCombinedFunction(final RawFunction primaryFunction, final RawFunction secondaryFunction) {
        Preconditions.checkArgument(primaryFunction != null || secondaryFunction != null, (Object)"Primary function and seconday function cannot both be null");
        this.primaryFunction = primaryFunction;
        this.secondaryFunction = secondaryFunction;
    }
    
    @Override
    public IAddress getAddress(final ESide eSide) {
        if (this.getRawNode(eSide) == null) {
            return null;
        }
        return this.getRawNode(eSide).getAddress();
    }
    
    public EFunctionType getFunctionType() {
        if (this.primaryFunction == null) {
            return this.secondaryFunction.getFunctionType();
        }
        if (this.secondaryFunction == null) {
            return this.primaryFunction.getFunctionType();
        }
        if (this.primaryFunction.getFunctionType() == this.secondaryFunction.getFunctionType()) {
            return this.primaryFunction.getFunctionType();
        }
        return EFunctionType.MIXED;
    }
    
    @Override
    public RawFunction getRawNode(final ESide eSide) {
        if (eSide == ESide.PRIMARY) {
            return this.primaryFunction;
        }
        return this.secondaryFunction;
    }
    
    public boolean isChanged() {
        return this.primaryFunction != null && this.secondaryFunction != null && this.primaryFunction.isChanged();
    }
}
