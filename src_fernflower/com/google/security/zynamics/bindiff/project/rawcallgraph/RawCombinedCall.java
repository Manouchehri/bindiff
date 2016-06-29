package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;

public class RawCombinedCall extends CombinedViewEdge {
   private final RawCall primaryCall;
   private final RawCall secondaryCall;

   public RawCombinedCall(RawCombinedFunction var1, RawCombinedFunction var2, RawCall var3, RawCall var4) {
      super(var1, var2);
      this.primaryCall = var3;
      this.secondaryCall = var4;
   }

   public EMatchState getMatchState() {
      return this.primaryCall == null?EMatchState.SECONDRAY_UNMATCHED:(this.secondaryCall == null?EMatchState.PRIMARY_UNMATCHED:EMatchState.MATCHED);
   }

   public RawCall getPrimaryEdge() {
      return this.primaryCall;
   }

   public RawCall getSecondaryEdge() {
      return this.secondaryCall;
   }

   public RawCombinedFunction getSource() {
      return (RawCombinedFunction)super.getSource();
   }

   public RawCombinedFunction getTarget() {
      return (RawCombinedFunction)super.getTarget();
   }

   public boolean isChanged() {
      if(this.getMatchState() != EMatchState.MATCHED) {
         if(this.primaryCall != null) {
            return this.primaryCall.isChanged();
         }

         if(this.secondaryCall != null) {
            return this.secondaryCall.isChanged();
         }
      }

      return false;
   }
}
