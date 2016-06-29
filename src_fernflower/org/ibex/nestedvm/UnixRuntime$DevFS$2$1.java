package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS$2;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevFStat;

class UnixRuntime$DevFS$2$1 extends UnixRuntime$DevFS$DevFStat {
   private final UnixRuntime$DevFS$2 this$1;

   UnixRuntime$DevFS$2$1(UnixRuntime$DevFS$2 var1) {
      super(UnixRuntime$DevFS$2.access$800(var1), (UnixRuntime$1)null);
      this.this$1 = var1;
   }

   public int inode() {
      return 2;
   }
}
