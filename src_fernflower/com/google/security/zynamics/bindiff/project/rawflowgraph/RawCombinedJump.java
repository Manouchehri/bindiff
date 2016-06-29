package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;

public class RawCombinedJump extends CombinedViewEdge {
   private final RawJump primaryJump;
   private final RawJump secondaryJump;

   public RawCombinedJump(RawCombinedBasicBlock var1, RawCombinedBasicBlock var2, RawJump var3, RawJump var4) {
      super(var1, var2);
      if(var3 == null && var4 == null) {
         throw new IllegalArgumentException("Primary and secondary jump cannot both be null.");
      } else {
         this.primaryJump = var3;
         this.secondaryJump = var4;
      }
   }

   public EMatchState getMatchState() {
      return this.primaryJump == null?EMatchState.SECONDRAY_UNMATCHED:(this.secondaryJump == null?EMatchState.PRIMARY_UNMATCHED:EMatchState.MATCHED);
   }

   public RawJump getPrimaryEdge() {
      return this.primaryJump;
   }

   public RawJump getSecondaryEdge() {
      return this.secondaryJump;
   }

   public RawCombinedBasicBlock getSource() {
      return (RawCombinedBasicBlock)super.getSource();
   }

   public RawCombinedBasicBlock getTarget() {
      return (RawCombinedBasicBlock)super.getTarget();
   }
}
