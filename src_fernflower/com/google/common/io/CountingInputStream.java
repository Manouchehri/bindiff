package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class CountingInputStream extends FilterInputStream {
   private long count;
   private long mark = -1L;

   public CountingInputStream(InputStream var1) {
      super((InputStream)Preconditions.checkNotNull(var1));
   }

   public long getCount() {
      return this.count;
   }

   public int read() {
      int var1 = this.in.read();
      if(var1 != -1) {
         ++this.count;
      }

      return var1;
   }

   public int read(byte[] var1, int var2, int var3) {
      int var4 = this.in.read(var1, var2, var3);
      if(var4 != -1) {
         this.count += (long)var4;
      }

      return var4;
   }

   public long skip(long var1) {
      long var3 = this.in.skip(var1);
      this.count += var3;
      return var3;
   }

   public synchronized void mark(int var1) {
      this.in.mark(var1);
      this.mark = this.count;
   }

   public synchronized void reset() {
      if(!this.in.markSupported()) {
         throw new IOException("Mark not supported");
      } else if(this.mark == -1L) {
         throw new IOException("Mark not set");
      } else {
         this.in.reset();
         this.count = this.mark;
      }
   }
}
