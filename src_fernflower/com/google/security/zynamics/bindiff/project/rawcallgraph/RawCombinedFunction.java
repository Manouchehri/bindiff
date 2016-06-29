package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public class RawCombinedFunction extends CombinedViewNode {
   private final RawFunction primaryFunction;
   private final RawFunction secondaryFunction;

   public RawCombinedFunction(RawFunction var1, RawFunction var2) {
      Preconditions.checkArgument(var1 != null || var2 != null, "Primary function and seconday function cannot both be null");
      this.primaryFunction = var1;
      this.secondaryFunction = var2;
   }

   public IAddress getAddress(ESide var1) {
      return this.getRawNode(var1) == null?null:this.getRawNode(var1).getAddress();
   }

   public EFunctionType getFunctionType() {
      return this.primaryFunction == null?this.secondaryFunction.getFunctionType():(this.secondaryFunction == null?this.primaryFunction.getFunctionType():(this.primaryFunction.getFunctionType() == this.secondaryFunction.getFunctionType()?this.primaryFunction.getFunctionType():EFunctionType.MIXED));
   }

   public RawFunction getRawNode(ESide var1) {
      return var1 == ESide.PRIMARY?this.primaryFunction:this.secondaryFunction;
   }

   public boolean isChanged() {
      return this.primaryFunction != null && this.secondaryFunction != null?this.primaryFunction.isChanged():false;
   }
}
