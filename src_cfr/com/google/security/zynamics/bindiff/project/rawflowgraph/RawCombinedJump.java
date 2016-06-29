/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;

public class RawCombinedJump
extends CombinedViewEdge {
    private final RawJump primaryJump;
    private final RawJump secondaryJump;

    public RawCombinedJump(RawCombinedBasicBlock rawCombinedBasicBlock, RawCombinedBasicBlock rawCombinedBasicBlock2, RawJump rawJump, RawJump rawJump2) {
        super(rawCombinedBasicBlock, rawCombinedBasicBlock2);
        if (rawJump == null && rawJump2 == null) {
            throw new IllegalArgumentException("Primary and secondary jump cannot both be null.");
        }
        this.primaryJump = rawJump;
        this.secondaryJump = rawJump2;
    }

    @Override
    public EMatchState getMatchState() {
        if (this.primaryJump == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.secondaryJump != null) return EMatchState.MATCHED;
        return EMatchState.PRIMARY_UNMATCHED;
    }

    @Override
    public RawJump getPrimaryEdge() {
        return this.primaryJump;
    }

    @Override
    public RawJump getSecondaryEdge() {
        return this.secondaryJump;
    }

    @Override
    public RawCombinedBasicBlock getSource() {
        return (RawCombinedBasicBlock)super.getSource();
    }

    @Override
    public RawCombinedBasicBlock getTarget() {
        return (RawCombinedBasicBlock)super.getTarget();
    }
}

