/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ECallType;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCall
extends SingleViewEdge {
    private final IAddress sourceInstructionAddr;
    private final ECallType callType;
    private final ESide side;
    private EMatchState matchState;
    private RawCall matchedPartnerCall;

    public RawCall(RawFunction rawFunction, RawFunction rawFunction2, IAddress iAddress, ESide eSide) {
        super(rawFunction, rawFunction2);
        this.sourceInstructionAddr = (IAddress)Preconditions.checkNotNull(iAddress);
        this.side = (ESide)((Object)Preconditions.checkNotNull((Object)eSide));
        this.callType = ECallType.getType(EFunctionType.getOrdinal(rawFunction2.getFunctionType()));
        this.matchState = eSide == ESide.PRIMARY ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED;
        this.matchedPartnerCall = null;
    }

    public ECallType getCallType() {
        return this.callType;
    }

    public RawCall getMatchedCall() {
        return this.matchedPartnerCall;
    }

    public EMatchState getMatchState() {
        Preconditions.checkNotNull((Object)this.matchState);
        return this.matchState;
    }

    public ESide getSide() {
        return this.side;
    }

    public IAddress getSourceInstructionAddr() {
        return this.sourceInstructionAddr;
    }

    public boolean isChanged() {
        if (this.matchState == EMatchState.MATCHED) return false;
        if (this.matchedPartnerCall == null) return false;
        IAddress iAddress = ((RawFunction)this.getTarget()).getMatchedFunctionAddress();
        IAddress iAddress2 = ((RawFunction)this.matchedPartnerCall.getTarget()).getAddress();
        if (iAddress == null) {
            return true;
        }
        if (iAddress.equals(iAddress2)) return false;
        return true;
    }

    public void setMatchState(boolean bl2, RawCall rawCall) {
        this.matchState = bl2 ? EMatchState.MATCHED : (this.side == ESide.PRIMARY ? EMatchState.PRIMARY_UNMATCHED : EMatchState.SECONDRAY_UNMATCHED);
        this.matchedPartnerCall = rawCall;
    }

    public String toString() {
        return String.format("%s@%s\u2192%s", ((RawFunction)this.getSource()).getName(), this.getSourceInstructionAddr().toHexString(), ((RawFunction)this.getTarget()).getName());
    }
}

