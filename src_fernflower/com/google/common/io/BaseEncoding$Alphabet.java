package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;

final class BaseEncoding$Alphabet extends CharMatcher {
   private final String name;
   private final char[] chars;
   final int mask;
   final int bitsPerChar;
   final int charsPerChunk;
   final int bytesPerChunk;
   private final byte[] decodabet;
   private final boolean[] validPadding;

   BaseEncoding$Alphabet(String var1, char[] var2) {
      this.name = (String)Preconditions.checkNotNull(var1);
      this.chars = (char[])Preconditions.checkNotNull(var2);

      try {
         this.bitsPerChar = IntMath.log2(var2.length, RoundingMode.UNNECESSARY);
      } catch (ArithmeticException var7) {
         int var4 = var2.length;
         throw new IllegalArgumentException((new StringBuilder(35)).append("Illegal alphabet length ").append(var4).toString(), var7);
      }

      int var3 = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
      this.charsPerChunk = 8 / var3;
      this.bytesPerChunk = this.bitsPerChar / var3;
      this.mask = var2.length - 1;
      byte[] var8 = new byte[128];
      Arrays.fill(var8, (byte)-1);

      for(int var5 = 0; var5 < var2.length; ++var5) {
         char var6 = var2[var5];
         Preconditions.checkArgument(CharMatcher.ASCII.matches(var6), "Non-ASCII character: %s", new Object[]{Character.valueOf(var6)});
         Preconditions.checkArgument(var8[var6] == -1, "Duplicate character: %s", new Object[]{Character.valueOf(var6)});
         var8[var6] = (byte)var5;
      }

      this.decodabet = var8;
      boolean[] var9 = new boolean[this.charsPerChunk];

      for(int var10 = 0; var10 < this.bytesPerChunk; ++var10) {
         var9[IntMath.divide(var10 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
      }

      this.validPadding = var9;
   }

   char encode(int var1) {
      return this.chars[var1];
   }

   boolean isValidPaddingStartPosition(int var1) {
      return this.validPadding[var1 % this.charsPerChunk];
   }

   int decode(char var1) {
      // $FF: Couldn't be decompiled
   }

   private boolean hasLowerCase() {
      char[] var1 = this.chars;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         if(Ascii.isLowerCase(var4)) {
            return true;
         }
      }

      return false;
   }

   private boolean hasUpperCase() {
      char[] var1 = this.chars;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         if(Ascii.isUpperCase(var4)) {
            return true;
         }
      }

      return false;
   }

   BaseEncoding$Alphabet upperCase() {
      if(!this.hasLowerCase()) {
         return this;
      } else {
         Preconditions.checkState(!this.hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
         char[] var1 = new char[this.chars.length];

         for(int var2 = 0; var2 < this.chars.length; ++var2) {
            var1[var2] = Ascii.toUpperCase(this.chars[var2]);
         }

         return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".upperCase()"), var1);
      }
   }

   BaseEncoding$Alphabet lowerCase() {
      if(!this.hasUpperCase()) {
         return this;
      } else {
         Preconditions.checkState(!this.hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
         char[] var1 = new char[this.chars.length];

         for(int var2 = 0; var2 < this.chars.length; ++var2) {
            var1[var2] = Ascii.toLowerCase(this.chars[var2]);
         }

         return new BaseEncoding$Alphabet(String.valueOf(this.name).concat(".lowerCase()"), var1);
      }
   }

   public boolean matches(char var1) {
      return CharMatcher.ASCII.matches(var1) && this.decodabet[var1] != -1;
   }

   public String toString() {
      return this.name;
   }

   // $FF: synthetic method
   static char[] access$000(BaseEncoding$Alphabet var0) {
      return var0.chars;
   }
}
