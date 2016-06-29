package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.Runtime;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SeekableFD;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

class Runtime$1 extends Runtime$SeekableFD {
   private final File val$f;
   private final Seekable$File val$sf;
   private final Object val$data;
   private final Runtime this$0;

   Runtime$1(Runtime var1, Seekable var2, int var3, File var4, Seekable$File var5, Object var6) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$f = var4;
      this.val$sf = var5;
      this.val$data = var6;
   }

   protected Runtime$FStat _fstat() {
      return this.this$0.hostFStat(this.val$f, this.val$sf, this.val$data);
   }
}
