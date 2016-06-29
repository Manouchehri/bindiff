package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCombinedBasicBlock extends CombinedViewNode {
   private final BasicBlockMatchData basicblockMatch;
   private final RawBasicBlock primaryBasicblock;
   private final RawBasicBlock secondaryBasicblock;
   private final IAddress primaryFunctionAddr;
   private final IAddress secondaryFunctionAddr;

   public RawCombinedBasicBlock(RawBasicBlock var1, RawBasicBlock var2, BasicBlockMatchData var3, IAddress var4, IAddress var5) {
      if(var1 == null && var2 == null) {
         throw new IllegalArgumentException("Primary basic block and seconday basic block cannot both be null.");
      } else if(var4 == null && var5 == null) {
         throw new IllegalArgumentException("Primary and secondary function address cannot both be null.");
      } else {
         this.primaryBasicblock = var1;
         this.secondaryBasicblock = var2;
         this.basicblockMatch = var3;
         this.primaryFunctionAddr = var4;
         this.secondaryFunctionAddr = var5;
      }
   }

   public IAddress getAddress(ESide var1) {
      return this.getRawNode(var1) == null?null:this.getRawNode(var1).getAddress();
   }

   public BasicBlockMatchData getBasicblockMatch() {
      return this.basicblockMatch;
   }

   public IAddress getPrimaryFunctionAddress() {
      return this.primaryFunctionAddr;
   }

   public RawBasicBlock getRawNode(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryBasicblock:this.secondaryBasicblock;
   }

   public IAddress getSecondaryFunctionAddress() {
      return this.secondaryFunctionAddr;
   }
}
