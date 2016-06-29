package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DevFS;

class UnixRuntime$DevFS$5 extends Runtime$FStat {
   private final UnixRuntime$DevFS this$0;

   UnixRuntime$DevFS$5(UnixRuntime$DevFS var1) {
      this.this$0 = var1;
   }

   public int inode() {
      return 4;
   }

   public int dev() {
      return this.this$0.devno;
   }

   public int type() {
      return 16384;
   }

   public int mode() {
      return 292;
   }
}
