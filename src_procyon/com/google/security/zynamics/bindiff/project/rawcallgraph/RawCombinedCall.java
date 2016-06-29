package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.edges.*;

public class RawCombinedCall extends CombinedViewEdge
{
    private final RawCall primaryCall;
    private final RawCall secondaryCall;
    
    public RawCombinedCall(final RawCombinedFunction rawCombinedFunction, final RawCombinedFunction rawCombinedFunction2, final RawCall primaryCall, final RawCall secondaryCall) {
        super(rawCombinedFunction, rawCombinedFunction2);
        this.primaryCall = primaryCall;
        this.secondaryCall = secondaryCall;
    }
    
    @Override
    public EMatchState getMatchState() {
        if (this.primaryCall == null) {
            return EMatchState.SECONDRAY_UNMATCHED;
        }
        if (this.secondaryCall == null) {
            return EMatchState.PRIMARY_UNMATCHED;
        }
        return EMatchState.MATCHED;
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
        if (this.getMatchState() != EMatchState.MATCHED) {
            if (this.primaryCall != null) {
                return this.primaryCall.isChanged();
            }
            if (this.secondaryCall != null) {
                return this.secondaryCall.isChanged();
            }
        }
        return false;
    }
}
