package org.ibex.nestedvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;

public class Runtime$InputOutputStreamFD extends Runtime$FD {
   private final InputStream is;
   private final OutputStream os;

   public Runtime$InputOutputStreamFD(InputStream var1) {
      this(var1, (OutputStream)null);
   }

   public Runtime$InputOutputStreamFD(OutputStream var1) {
      this((InputStream)null, var1);
   }

   public Runtime$InputOutputStreamFD(InputStream var1, OutputStream var2) {
      this.is = var1;
      this.os = var2;
      if(var1 == null && var2 == null) {
         throw new IllegalArgumentException("at least one stream must be supplied");
      }
   }

   public int flags() {
      if(this.is != null && this.os != null) {
         return 2;
      } else if(this.is != null) {
         return 0;
      } else if(this.os != null) {
         return 1;
      } else {
         throw new Error("should never happen");
      }
   }

   public void _close() {
      if(this.is != null) {
         try {
            this.is.close();
         } catch (IOException var3) {
            ;
         }
      }

      if(this.os != null) {
         try {
            this.os.close();
         } catch (IOException var2) {
            ;
         }
      }

   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.is == null) {
         return super.read(var1, var2, var3);
      } else {
         try {
            int var4 = this.is.read(var1, var2, var3);
            return var4 < 0?0:var4;
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public int write(byte[] var1, int var2, int var3) {
      if(this.os == null) {
         return super.write(var1, var2, var3);
      } else {
         try {
            this.os.write(var1, var2, var3);
            return var3;
         } catch (IOException var5) {
            throw new Runtime$ErrnoException(5);
         }
      }
   }

   public Runtime$FStat _fstat() {
      return new Runtime$SocketFStat();
   }
}
