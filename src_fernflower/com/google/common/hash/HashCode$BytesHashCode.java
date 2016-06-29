package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.io.Serializable;

final class HashCode$BytesHashCode extends HashCode implements Serializable {
   final byte[] bytes;
   private static final long serialVersionUID = 0L;

   HashCode$BytesHashCode(byte[] var1) {
      this.bytes = (byte[])Preconditions.checkNotNull(var1);
   }

   public int bits() {
      return this.bytes.length * 8;
   }

   public byte[] asBytes() {
      return (byte[])this.bytes.clone();
   }

   public int asInt() {
      Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[]{Integer.valueOf(this.bytes.length)});
      return this.bytes[0] & 255 | (this.bytes[1] & 255) << 8 | (this.bytes[2] & 255) << 16 | (this.bytes[3] & 255) << 24;
   }

   public long asLong() {
      Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", new Object[]{Integer.valueOf(this.bytes.length)});
      return this.padToLong();
   }

   public long padToLong() {
      long var1 = (long)(this.bytes[0] & 255);

      for(int var3 = 1; var3 < Math.min(this.bytes.length, 8); ++var3) {
         var1 |= ((long)this.bytes[var3] & 255L) << var3 * 8;
      }

      return var1;
   }

   void writeBytesToImpl(byte[] var1, int var2, int var3) {
      System.arraycopy(this.bytes, 0, var1, var2, var3);
   }

   byte[] getBytesInternal() {
      return this.bytes;
   }

   boolean equalsSameBits(HashCode var1) {
      if(this.bytes.length != var1.getBytesInternal().length) {
         return false;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.bytes.length; ++var3) {
            var2 &= this.bytes[var3] == var1.getBytesInternal()[var3];
         }

         return var2;
      }
   }
}
