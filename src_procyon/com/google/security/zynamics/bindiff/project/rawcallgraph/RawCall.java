package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;

public class RawCall extends SingleViewEdge
{
    private final IAddress sourceInstructionAddr;
    private final ECallType callType;
    private final ESide side;
    private EMatchState matchState;
    private RawCall matchedPartnerCall;
    
    public RawCall(final RawFunction rawFunction, final RawFunction rawFunction2, final IAddress address, final ESide eSide) {
        super(rawFunction, rawFunction2);
        this.sourceInstructionAddr = (IAddress)Preconditions.checkNotNull(address);
        this.side = (ESide)Preconditions.checkNotNull(eSide);
        this.callType = ECallType.getType(EFunctionType.getOrdinal(rawFunction2.getFunctionType()));
        this.matchState = ((eSide == ESide.PRIMARY) ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED);
        this.matchedPartnerCall = null;
    }
    
    public ECallType getCallType() {
        return this.callType;
    }
    
    public RawCall getMatchedCall() {
        return this.matchedPartnerCall;
    }
    
    public EMatchState getMatchState() {
        Preconditions.checkNotNull(this.matchState);
        return this.matchState;
    }
    
    public ESide getSide() {
        return this.side;
    }
    
    public IAddress getSourceInstructionAddr() {
        return this.sourceInstructionAddr;
    }
    
    public boolean isChanged() {
        if (this.matchState != EMatchState.MATCHED && this.matchedPartnerCall != null) {
            final IAddress matchedFunctionAddress = ((RawFunction)this.getTarget()).getMatchedFunctionAddress();
            final IAddress address = ((RawFunction)this.matchedPartnerCall.getTarget()).getAddress();
            return matchedFunctionAddress == null || !matchedFunctionAddress.equals(address);
        }
        return false;
    }
    
    public void setMatchState(final boolean b, final RawCall matchedPartnerCall) {
        this.matchState = (b ? EMatchState.MATCHED : ((this.side == ESide.PRIMARY) ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED));
        this.matchedPartnerCall = matchedPartnerCall;
    }
    
    @Override
    public String toString() {
        return String.format("%s@%s\u2192%s", ((RawFunction)this.getSource()).getName(), this.getSourceInstructionAddr().toHexString(), ((RawFunction)this.getTarget()).getName());
    }
}
