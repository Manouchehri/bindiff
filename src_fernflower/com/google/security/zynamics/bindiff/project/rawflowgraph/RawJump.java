package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawJump extends SingleViewEdge {
   final EJumpType jumpType;

   public RawJump(RawBasicBlock var1, RawBasicBlock var2, EJumpType var3) {
      super(var1, var2);
      this.jumpType = var3;
   }

   public EJumpType getJumpType() {
      return this.jumpType;
   }

   public RawBasicBlock getSource() {
      return (RawBasicBlock)super.getSource();
   }

   public IAddress getSourceBasicblockAddress() {
      return this.getSource().getAddress();
   }

   public RawBasicBlock getTarget() {
      return (RawBasicBlock)super.getTarget();
   }

   public IAddress getTargetBasicblockAddress() {
      return this.getTarget().getAddress();
   }
}
