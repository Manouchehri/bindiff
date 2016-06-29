package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.UnixRuntime$DevFS;
import org.ibex.nestedvm.UnixRuntime$DevFS$1$1;

class UnixRuntime$DevFS$1 extends Runtime$FD {
   private final UnixRuntime$DevFS this$0;

   UnixRuntime$DevFS$1(UnixRuntime$DevFS var1) {
      this.this$0 = var1;
   }

   public int read(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = 0;
      }

      return var3;
   }

   public int write(byte[] var1, int var2, int var3) {
      return var3;
   }

   public int seek(int var1, int var2) {
      return 0;
   }

   public Runtime$FStat _fstat() {
      return new UnixRuntime$DevFS$1$1(this);
   }

   public int flags() {
      return 2;
   }

   static UnixRuntime$DevFS access$700(UnixRuntime$DevFS$1 var0) {
      return var0.this$0;
   }
}
