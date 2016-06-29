package com.google.common.hash;

import com.google.common.hash.HashCode;
import java.io.Serializable;

final class HashCode$LongHashCode extends HashCode implements Serializable {
   final long hash;
   private static final long serialVersionUID = 0L;

   HashCode$LongHashCode(long var1) {
      this.hash = var1;
   }

   public int bits() {
      return 64;
   }

   public byte[] asBytes() {
      return new byte[]{(byte)((int)this.hash), (byte)((int)(this.hash >> 8)), (byte)((int)(this.hash >> 16)), (byte)((int)(this.hash >> 24)), (byte)((int)(this.hash >> 32)), (byte)((int)(this.hash >> 40)), (byte)((int)(this.hash >> 48)), (byte)((int)(this.hash >> 56))};
   }

   public int asInt() {
      return (int)this.hash;
   }

   public long asLong() {
      return this.hash;
   }

   public long padToLong() {
      return this.hash;
   }

   void writeBytesToImpl(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var2 + var4] = (byte)((int)(this.hash >> var4 * 8));
      }

   }

   boolean equalsSameBits(HashCode var1) {
      return this.hash == var1.asLong();
   }
}
