package org.ibex.nestedvm;

import java.io.IOException;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable;

public abstract class Runtime$SeekableFD extends Runtime$FD {
   private final int flags;
   private final Seekable data;

   Runtime$SeekableFD(Seekable var1, int var2) {
      this.data = var1;
      this.flags = var2;
   }

   protected abstract Runtime$FStat _fstat();

   public int flags() {
      return this.flags;
   }

   Seekable seekable() {
      return this.data;
   }

   public int seek(int var1, int var2) {
      try {
         switch(var2) {
         case 0:
            break;
         case 1:
            var1 += this.data.pos();
            break;
         case 2:
            var1 += this.data.length();
            break;
         default:
            return -1;
         }

         this.data.seek(var1);
         return var1;
      } catch (IOException var4) {
         throw new Runtime$ErrnoException(29);
      }
   }

   public int write(byte[] var1, int var2, int var3) {
      if((this.flags & 3) == 0) {
         throw new Runtime$ErrnoException(81);
      } else {
         if((this.flags & 8) != 0) {
            this.seek(0, 2);
         }

         try {
            return this.data.write(var1, var2, var3);
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      if((this.flags & 3) == 1) {
         throw new Runtime$ErrnoException(81);
      } else {
         try {
            int var4 = this.data.read(var1, var2, var3);
            return var4 < 0?0:var4;
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   protected void _close() {
      try {
         this.data.close();
      } catch (IOException var2) {
         ;
      }

   }
}
