package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DirFD;

abstract class UnixRuntime$DevFS$DevDirFD extends UnixRuntime$DirFD {
   private final UnixRuntime$DevFS this$0;

   private UnixRuntime$DevFS$DevDirFD(UnixRuntime$DevFS var1) {
      this.this$0 = var1;
   }

   public int myDev() {
      return this.this$0.devno;
   }

   UnixRuntime$DevFS$DevDirFD(UnixRuntime$DevFS var1, UnixRuntime$1 var2) {
      this(var1);
   }
}
