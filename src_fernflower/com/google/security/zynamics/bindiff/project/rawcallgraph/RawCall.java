package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ECallType;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCall extends SingleViewEdge {
   private final IAddress sourceInstructionAddr;
   private final ECallType callType;
   private final ESide side;
   private EMatchState matchState;
   private RawCall matchedPartnerCall;

   public RawCall(RawFunction var1, RawFunction var2, IAddress var3, ESide var4) {
      super(var1, var2);
      this.sourceInstructionAddr = (IAddress)Preconditions.checkNotNull(var3);
      this.side = (ESide)Preconditions.checkNotNull(var4);
      this.callType = ECallType.getType(EFunctionType.getOrdinal(var2.getFunctionType()));
      this.matchState = var4 == ESide.PRIMARY?EMatchState.PRIMARY_UNMATCHED:EMatchState.SECONDRAY_UNMATCHED;
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
      if(this.matchState != EMatchState.MATCHED && this.matchedPartnerCall != null) {
         IAddress var1 = ((RawFunction)this.getTarget()).getMatchedFunctionAddress();
         IAddress var2 = ((RawFunction)this.matchedPartnerCall.getTarget()).getAddress();
         return var1 == null?true:!var1.equals(var2);
      } else {
         return false;
      }
   }

   public void setMatchState(boolean var1, RawCall var2) {
      this.matchState = var1?EMatchState.MATCHED:(this.side == ESide.PRIMARY?EMatchState.PRIMARY_UNMATCHED:EMatchState.SECONDRAY_UNMATCHED);
      this.matchedPartnerCall = var2;
   }

   public String toString() {
      return String.format("%s@%s→%s", new Object[]{((RawFunction)this.getSource()).getName(), this.getSourceInstructionAddr().toHexString(), ((RawFunction)this.getTarget()).getName()});
   }
}
