package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevDirFD;

class UnixRuntime$DevFS$3 extends UnixRuntime$DevFS$DevDirFD {
   private final int[] val$files;
   private final UnixRuntime$DevFS this$0;

   UnixRuntime$DevFS$3(UnixRuntime$DevFS var1, int[] var2) {
      super(var1, (UnixRuntime$1)null);
      this.this$0 = var1;
      this.val$files = var2;
   }

   public int myInode() {
      return 4;
   }

   public int parentInode() {
      return 1;
   }

   public int inode(int var1) {
      return 32 + var1;
   }

   public String name(int var1) {
      return Integer.toString(this.val$files[var1]);
   }

   public int size() {
      return this.val$files.length;
   }
}
