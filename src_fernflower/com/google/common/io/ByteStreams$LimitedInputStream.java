package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class ByteStreams$LimitedInputStream extends FilterInputStream {
   private long left;
   private long mark = -1L;

   ByteStreams$LimitedInputStream(InputStream var1, long var2) {
      super(var1);
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 >= 0L, "limit must be non-negative");
      this.left = var2;
   }

   public int available() {
      return (int)Math.min((long)this.in.available(), this.left);
   }

   public synchronized void mark(int var1) {
      this.in.mark(var1);
      this.mark = this.left;
   }

   public int read() {
      if(this.left == 0L) {
         return -1;
      } else {
         int var1 = this.in.read();
         if(var1 != -1) {
            --this.left;
         }

         return var1;
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.left == 0L) {
         return -1;
      } else {
         var3 = (int)Math.min((long)var3, this.left);
         int var4 = this.in.read(var1, var2, var3);
         if(var4 != -1) {
            this.left -= (long)var4;
         }

         return var4;
      }
   }

   public synchronized void reset() {
      if(!this.in.markSupported()) {
         throw new IOException("Mark not supported");
      } else if(this.mark == -1L) {
         throw new IOException("Mark not set");
      } else {
         this.in.reset();
         this.left = this.mark;
      }
   }

   public long skip(long var1) {
      var1 = Math.min(var1, this.left);
      long var3 = this.in.skip(var1);
      this.left -= var3;
      return var3;
   }
}
