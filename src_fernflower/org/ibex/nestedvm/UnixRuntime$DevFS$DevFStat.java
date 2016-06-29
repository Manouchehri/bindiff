package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;

abstract class UnixRuntime$DevFS$DevFStat extends Runtime$FStat {
   private final UnixRuntime$DevFS this$0;

   private UnixRuntime$DevFS$DevFStat(UnixRuntime$DevFS var1) {
      this.this$0 = var1;
   }

   public int dev() {
      return this.this$0.devno;
   }

   public int mode() {
      return 438;
   }

   public int type() {
      return 8192;
   }

   public int nlink() {
      return 1;
   }

   public abstract int inode();

   UnixRuntime$DevFS$DevFStat(UnixRuntime$DevFS var1, UnixRuntime$1 var2) {
      this(var1);
   }
}
