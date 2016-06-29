package org.ibex.nestedvm.util;

import java.io.IOException;
import java.io.InputStream;
import org.ibex.nestedvm.util.ELF;

class ELF$SectionInputStream extends InputStream {
   private int pos;
   private int maxpos;
   private final ELF this$0;

   ELF$SectionInputStream(ELF var1, int var2, int var3) {
      this.this$0 = var1;
      if(ELF.access$500(var1)) {
         throw new IOException("Section reader already active");
      } else {
         ELF.access$502(var1, true);
         this.pos = var2;
         ELF.access$600(var1).seek(this.pos);
         this.maxpos = var3;
      }
   }

   private int bytesLeft() {
      return this.maxpos - this.pos;
   }

   public int read() {
      byte[] var1 = new byte[1];
      return this.read(var1, 0, 1) == -1?-1:var1[0] & 255;
   }

   public int read(byte[] var1, int var2, int var3) {
      int var4 = ELF.access$600(this.this$0).read(var1, var2, Math.min(var3, this.bytesLeft()));
      if(var4 > 0) {
         this.pos += var4;
      }

      return var4;
   }

   public void close() {
      ELF.access$502(this.this$0, false);
   }
}
