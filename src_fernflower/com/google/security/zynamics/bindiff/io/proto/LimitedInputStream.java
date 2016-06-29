package com.google.security.zynamics.bindiff.io.proto;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class LimitedInputStream extends FilterInputStream {
   private int readLimit;

   public LimitedInputStream(InputStream var1, int var2) {
      super(var1);
      this.readLimit = var2;
   }

   public int available() {
      return Math.min(super.available(), this.readLimit);
   }

   public int read() {
      if(this.readLimit <= 0) {
         return -1;
      } else {
         int var1 = super.read();
         if(var1 >= 0) {
            --this.readLimit;
         }

         return var1;
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      if(this.readLimit <= 0) {
         return -1;
      } else {
         var3 = Math.min(var3, this.readLimit);
         int var4 = super.read(var1, var2, var3);
         if(var4 >= 0) {
            this.readLimit -= var4;
         }

         return var4;
      }
   }
}
