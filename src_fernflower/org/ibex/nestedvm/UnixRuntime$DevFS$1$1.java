package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevFStat;

class UnixRuntime$DevFS$1$1 extends UnixRuntime$DevFS$DevFStat {
   private final UnixRuntime$DevFS$1 this$1;

   UnixRuntime$DevFS$1$1(UnixRuntime$DevFS$1 var1) {
      super(UnixRuntime$DevFS$1.access$700(var1), (UnixRuntime$1)null);
      this.this$1 = var1;
   }

   public int inode() {
      return 3;
   }
}
