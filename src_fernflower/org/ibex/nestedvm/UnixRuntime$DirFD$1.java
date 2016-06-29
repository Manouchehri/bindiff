package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DirFD;

class UnixRuntime$DirFD$1 extends Runtime$FStat {
   private final UnixRuntime$DirFD this$0;

   UnixRuntime$DirFD$1(UnixRuntime$DirFD var1) {
      this.this$0 = var1;
   }

   public int type() {
      return 16384;
   }

   public int inode() {
      return this.this$0.myInode();
   }

   public int dev() {
      return this.this$0.myDev();
   }
}
