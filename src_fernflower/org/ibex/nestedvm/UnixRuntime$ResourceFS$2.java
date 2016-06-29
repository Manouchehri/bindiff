package org.ibex.nestedvm;

import java.net.URLConnection;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SeekableFD;
import org.ibex.nestedvm.UnixRuntime$ResourceFS;
import org.ibex.nestedvm.util.Seekable;

class UnixRuntime$ResourceFS$2 extends Runtime$SeekableFD {
   private final URLConnection val$conn;
   private final UnixRuntime$ResourceFS this$0;

   UnixRuntime$ResourceFS$2(UnixRuntime$ResourceFS var1, Seekable var2, int var3, URLConnection var4) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$conn = var4;
   }

   protected Runtime$FStat _fstat() {
      return this.this$0.connFStat(this.val$conn);
   }
}
