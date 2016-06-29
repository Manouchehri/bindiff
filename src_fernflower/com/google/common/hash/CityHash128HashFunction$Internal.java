package com.google.common.hash;

import com.google.common.hash.CityHash128HashFunction$1;
import com.google.common.hash.CityHash128HashFunction$InternalImplementation;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import javax.annotation.Nullable;

enum CityHash128HashFunction$Internal implements CityHash128HashFunction$InternalImplementation {
   UsingUnsafe,
   UsingByteBuffer;

   private CityHash128HashFunction$Internal() {
   }

   protected abstract HashCode fingerprint(byte[] var1, int var2, int var3, long var4, long var6);

   public HashCode fingerprint(byte[] var1, int var2, int var3, @Nullable long[] var4) {
      long var5;
      long var7;
      if(var4 == null) {
         if(var3 >= 16) {
            var7 = LittleEndianByteArray.load64(var1, var2) ^ -4102945252841444853L;
            var5 = LittleEndianByteArray.load64(var1, var2 + 8);
            var2 += 16;
            var3 -= 16;
         } else if(var3 >= 8) {
            var7 = LittleEndianByteArray.load64(var1, var2) ^ (long)var3 * -6505348102511208375L;
            var5 = LittleEndianByteArray.load64(var1, var3 - 8) ^ -8261664234251669945L;
            var3 = 0;
         } else {
            var7 = -6505348102511208375L;
            var5 = -8261664234251669945L;
         }
      } else {
         var7 = var4[0];
         var5 = var4[1];
      }

      return this.fingerprint(var1, var2, var3, var5, var7);
   }

   // $FF: synthetic method
   CityHash128HashFunction$Internal(CityHash128HashFunction$1 var3) {
      this();
   }
}
