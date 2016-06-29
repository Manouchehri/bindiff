package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.Seekable;

public class Seekable$ByteArray extends Seekable {
   protected byte[] data;
   protected int pos;
   private final boolean writable;

   public Seekable$ByteArray(byte[] var1, boolean var2) {
      this.data = var1;
      this.pos = 0;
      this.writable = var2;
   }

   public int read(byte[] var1, int var2, int var3) {
      var3 = Math.min(var3, this.data.length - this.pos);
      if(var3 <= 0) {
         return -1;
      } else {
         System.arraycopy(this.data, this.pos, var1, var2, var3);
         this.pos += var3;
         return var3;
      }
   }

   public int write(byte[] var1, int var2, int var3) {
      if(!this.writable) {
         throw new IOException("read-only data");
      } else {
         var3 = Math.min(var3, this.data.length - this.pos);
         if(var3 <= 0) {
            throw new IOException("no space");
         } else {
            System.arraycopy(var1, var2, this.data, this.pos, var3);
            this.pos += var3;
            return var3;
         }
      }
   }

   public int length() {
      return this.data.length;
   }

   public int pos() {
      return this.pos;
   }

   public void seek(int var1) {
      this.pos = var1;
   }

   public void close() {
   }
}
