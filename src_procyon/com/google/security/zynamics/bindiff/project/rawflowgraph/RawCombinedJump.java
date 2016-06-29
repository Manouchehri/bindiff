package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.edges.*;

public class RawCombinedJump extends CombinedViewEdge
{
    private final RawJump primaryJump;
    private final RawJump secondaryJump;
    
    public RawCombinedJump(final RawCombinedBasicBlock rawCombinedBasicBlock, final RawCombinedBasicBlock rawCombinedBasicBlock2, final RawJump primaryJump, final RawJump secondaryJump) {
        super(rawCombinedBasicBlock, rawCombinedBasicBlock2);
        if (primaryJump == null && secondaryJump == null) {
            throw new IllegalArgumentException("Primary and secondary jump cannot both be null.");
        }
        this.primaryJump = primaryJump;
        this.secondaryJump = secondaryJump;
    }
    
    @Override
    public EMatchState getMatchState() {
        if (this.primaryJump == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.secondaryJump == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        return EMatchState.MATCHED;
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
