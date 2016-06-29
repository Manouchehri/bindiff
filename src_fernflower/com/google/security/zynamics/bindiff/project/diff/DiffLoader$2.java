package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Function;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;

class DiffLoader$2 implements Function {
   // $FF: synthetic field
   final DiffLoader this$0;

   DiffLoader$2(DiffLoader var1) {
      this.this$0 = var1;
   }

   public AddressTriple apply(RawCall var1) {
      return new AddressTriple(((RawFunction)var1.getSource()).getAddress().toLong(), ((RawFunction)var1.getTarget()).getAddress().toLong(), var1.getSourceInstructionAddr().toLong());
   }
}
