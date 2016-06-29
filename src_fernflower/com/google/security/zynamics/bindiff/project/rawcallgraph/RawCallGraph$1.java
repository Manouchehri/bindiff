package com.google.security.zynamics.bindiff.project.rawcallgraph;

import com.google.common.base.Function;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;

class RawCallGraph$1 implements Function {
   // $FF: synthetic field
   final RawCallGraph this$0;

   RawCallGraph$1(RawCallGraph var1) {
      this.this$0 = var1;
   }

   public IAddress apply(RawFunction var1) {
      return var1.getAddress();
   }
}
