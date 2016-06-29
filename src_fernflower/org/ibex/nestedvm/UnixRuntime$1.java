package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime$HostFStat;
import org.ibex.nestedvm.UnixRuntime;

class UnixRuntime$1 extends Runtime$HostFStat {
   private final int val$inode;
   private final int val$devno;
   private final UnixRuntime this$0;

   UnixRuntime$1(UnixRuntime var1, File var2, boolean var3, int var4, int var5) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$inode = var4;
      this.val$devno = var5;
   }

   public int inode() {
      return this.val$inode;
   }

   public int dev() {
      return this.val$devno;
   }
}
