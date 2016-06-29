/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;

public class RawCombinedCall
extends CombinedViewEdge {
    private final RawCall primaryCall;
    private final RawCall secondaryCall;

    public RawCombinedCall(RawCombinedFunction rawCombinedFunction, RawCombinedFunction rawCombinedFunction2, RawCall rawCall, RawCall rawCall2) {
        super(rawCombinedFunction, rawCombinedFunction2);
        this.primaryCall = rawCall;
        this.secondaryCall = rawCall2;
    }

    @Override
    public EMatchState getMatchState() {
        if (this.primaryCall == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.secondaryCall != null) return EMatchState.MATCHED;
        return EMatchState.PRIMARY_UNMATCHED;
    }

    @Override
    public RawCall getPrimaryEdge() {
        return this.primaryCall;
    }

    @Override
    public RawCall getSecondaryEdge() {
        return this.secondaryCall;
    }

    @Override
    public RawCombinedFunction getSource() {
        return (RawCombinedFunction)super.getSource();
    }

    @Override
    public RawCombinedFunction getTarget() {
        return (RawCombinedFunction)super.getTarget();
    }

    public boolean isChanged() {
        if (this.getMatchState() == EMatchState.MATCHED) return false;
        if (this.primaryCall != null) {
            return this.primaryCall.isChanged();
        }
        if (this.secondaryCall == null) return false;
        return this.secondaryCall.isChanged();
    }
}

