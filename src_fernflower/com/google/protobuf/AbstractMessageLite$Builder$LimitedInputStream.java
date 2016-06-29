package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

final class AbstractMessageLite$Builder$LimitedInputStream extends FilterInputStream {
   private int limit;

   AbstractMessageLite$Builder$LimitedInputStream(InputStream var1, int var2) {
      super(var1);
      this.limit = var2;
   }

   public int available() {
      return Math.min(super.available(), this.limit);
   }

   public int read() {
      if(this.limit <= 0) {
         return -1;
      } else {
         int var1 = super.read();
         if(var1 >= 0) {
            --this.limit;
         }

         return var1;
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.limit <= 0) {
         return -1;
      } else {
         var3 = Math.min(var3, this.limit);
         int var4 = super.read(var1, var2, var3);
         if(var4 >= 0) {
            this.limit -= var4;
         }

         return var4;
      }
   }

   public long skip(long var1) {
      long var3 = super.skip(Math.min(var1, (long)this.limit));
      if(var3 >= 0L) {
         this.limit = (int)((long)this.limit - var3);
      }

      return var3;
   }
}
