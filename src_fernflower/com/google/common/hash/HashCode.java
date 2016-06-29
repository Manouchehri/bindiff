package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode$BytesHashCode;
import com.google.common.hash.HashCode$IntHashCode;
import com.google.common.hash.HashCode$LongHashCode;
import com.google.common.primitives.Ints;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode {
   private static final char[] hexDigits = "0123456789abcdef".toCharArray();

   @CheckReturnValue
   public abstract int bits();

   @CheckReturnValue
   public abstract int asInt();

   @CheckReturnValue
   public abstract long asLong();

   @CheckReturnValue
   public abstract long padToLong();

   @CheckReturnValue
   public abstract byte[] asBytes();

   public int writeBytesTo(byte[] var1, int var2, int var3) {
      var3 = Ints.min(new int[]{var3, this.bits() / 8});
      Preconditions.checkPositionIndexes(var2, var2 + var3, var1.length);
      this.writeBytesToImpl(var1, var2, var3);
      return var3;
   }

   abstract void writeBytesToImpl(byte[] var1, int var2, int var3);

   byte[] getBytesInternal() {
      return this.asBytes();
   }

   abstract boolean equalsSameBits(HashCode var1);

   @CheckReturnValue
   public static HashCode fromInt(int var0) {
      return new HashCode$IntHashCode(var0);
   }

   @CheckReturnValue
   public static HashCode fromLong(long var0) {
      return new HashCode$LongHashCode(var0);
   }

   @CheckReturnValue
   public static HashCode fromBytes(byte[] var0) {
      Preconditions.checkArgument(var0.length >= 1, "A HashCode must contain at least 1 byte.");
      return fromBytesNoCopy((byte[])var0.clone());
   }

   static HashCode fromBytesNoCopy(byte[] var0) {
      return new HashCode$BytesHashCode(var0);
   }

   @CheckReturnValue
   public static HashCode fromString(String var0) {
      Preconditions.checkArgument(var0.length() >= 2, "input string (%s) must have at least 2 characters", new Object[]{var0});
      Preconditions.checkArgument(var0.length() % 2 == 0, "input string (%s) must have an even number of characters", new Object[]{var0});
      byte[] var1 = new byte[var0.length() / 2];

      for(int var2 = 0; var2 < var0.length(); var2 += 2) {
         int var3 = decode(var0.charAt(var2)) << 4;
         int var4 = decode(var0.charAt(var2 + 1));
         var1[var2 / 2] = (byte)(var3 + var4);
      }

      return fromBytesNoCopy(var1);
   }

   private static int decode(char var0) {
      if(var0 >= 48 && var0 <= 57) {
         return var0 - 48;
      } else if(var0 >= 97 && var0 <= 102) {
         return var0 - 97 + 10;
      } else {
         throw new IllegalArgumentException((new StringBuilder(32)).append("Illegal hexadecimal character: ").append(var0).toString());
      }
   }

   public final boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof HashCode)) {
         return false;
      } else {
         HashCode var2 = (HashCode)var1;
         return this.bits() == var2.bits() && this.equalsSameBits(var2);
      }
   }

   public final int hashCode() {
      if(this.bits() >= 32) {
         return this.asInt();
      } else {
         byte[] var1 = this.getBytesInternal();
         int var2 = var1[0] & 255;

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2 |= (var1[var3] & 255) << var3 * 8;
         }

         return var2;
      }
   }

   public final String toString() {
      byte[] var1 = this.getBytesInternal();
      StringBuilder var2 = new StringBuilder(2 * var1.length);
      byte[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte var6 = var3[var5];
         var2.append(hexDigits[var6 >> 4 & 15]).append(hexDigits[var6 & 15]);
      }

      return var2.toString();
   }
}
