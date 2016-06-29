/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCombinedFunction
extends CombinedViewNode {
    private final RawFunction primaryFunction;
    private final RawFunction secondaryFunction;

    public RawCombinedFunction(RawFunction rawFunction, RawFunction rawFunction2) {
        Preconditions.checkArgument(rawFunction != null || rawFunction2 != null, "Primary function and seconday function cannot both be null");
        this.primaryFunction = rawFunction;
        this.secondaryFunction = rawFunction2;
    }

    @Override
    public IAddress getAddress(ESide eSide) {
        if (this.getRawNode(eSide) != null) return this.getRawNode(eSide).getAddress();
        return null;
    }

    public EFunctionType getFunctionType() {
        if (this.primaryFunction == null) {
            return this.secondaryFunction.getFunctionType();
        }
        if (this.secondaryFunction == null) {
            return this.primaryFunction.getFunctionType();
        }
        if (this.primaryFunction.getFunctionType() != this.secondaryFunction.getFunctionType()) return EFunctionType.MIXED;
        return this.primaryFunction.getFunctionType();
    }

    @Override
    public RawFunction getRawNode(ESide eSide) {
        if (eSide != ESide.PRIMARY) return this.secondaryFunction;
        return this.primaryFunction;
    }

    public boolean isChanged() {
        if (this.primaryFunction == null) return false;
        if (this.secondaryFunction == null) return false;
        return this.primaryFunction.isChanged();
    }
}

