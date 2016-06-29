package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class Seekable {
   public abstract int read(byte[] var1, int var2, int var3);

   public abstract int write(byte[] var1, int var2, int var3);

   public abstract int length();

   public abstract void seek(int var1);

   public abstract void close();

   public abstract int pos();

   public void sync() {
      throw new IOException("sync not implemented for " + this.getClass());
   }

   public void resize(long var1) {
      throw new IOException("resize not implemented for " + this.getClass());
   }

   public Seekable$Lock lock(long var1, long var3, boolean var5) {
      throw new IOException("lock not implemented for " + this.getClass());
   }

   public int read() {
      byte[] var1 = new byte[1];
      int var2 = this.read(var1, 0, 1);
      return var2 == -1?-1:var1[0] & 255;
   }

   public int tryReadFully(byte[] var1, int var2, int var3) {
      int var4;
      int var5;
      for(var4 = 0; var3 > 0; var4 += var5) {
         var5 = this.read(var1, var2, var3);
         if(var5 == -1) {
            break;
         }

         var2 += var5;
         var3 -= var5;
      }

      return var4 == 0?-1:var4;
   }
}
