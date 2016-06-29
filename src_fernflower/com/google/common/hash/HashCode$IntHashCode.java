package com.google.common.hash;

import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

final class HashCode$IntHashCode extends HashCode implements Serializable {
   final int hash;
   private static final long serialVersionUID = 0L;

   HashCode$IntHashCode(int var1) {
      this.hash = var1;
   }

   public int bits() {
      return 32;
   }

   public byte[] asBytes() {
      return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24)};
   }

   public int asInt() {
      return this.hash;
   }

   public long asLong() {
      throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
   }

   public long padToLong() {
      return UnsignedInts.toLong(this.hash);
   }

   void writeBytesToImpl(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var2 + var4] = (byte)(this.hash >> var4 * 8);
      }

   }

   boolean equalsSameBits(HashCode var1) {
      return this.hash == var1.asInt();
   }
}
