package org.ibex.nestedvm;

import org.ibex.nestedvm.UnixRuntime$1;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$DevDirFD;

class UnixRuntime$DevFS$4 extends UnixRuntime$DevFS$DevDirFD {
   private final UnixRuntime$DevFS this$0;

   UnixRuntime$DevFS$4(UnixRuntime$DevFS var1) {
      super(var1, (UnixRuntime$1)null);
      this.this$0 = var1;
   }

   public int myInode() {
      return 1;
   }

   public int parentInode() {
      return 1;
   }

   public int inode(int var1) {
      switch(var1) {
      case 0:
         return 2;
      case 1:
         return 3;
      case 2:
         return 4;
      default:
         return -1;
      }
   }

   public String name(int var1) {
      switch(var1) {
      case 0:
         return "null";
      case 1:
         return "zero";
      case 2:
         return "fd";
      default:
         return null;
      }
   }

   public int size() {
      return 3;
   }
}
