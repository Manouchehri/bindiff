package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$SeparatedBaseEncoding;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$1;
import com.google.common.io.BaseEncoding$StandardBaseEncoding$2;
import com.google.common.math.IntMath;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import javax.annotation.Nullable;

class BaseEncoding$StandardBaseEncoding extends BaseEncoding {
   final BaseEncoding$Alphabet alphabet;
   @Nullable
   final Character paddingChar;
   private transient BaseEncoding upperCase;
   private transient BaseEncoding lowerCase;

   BaseEncoding$StandardBaseEncoding(String var1, String var2, @Nullable Character var3) {
      this(new BaseEncoding$Alphabet(var1, var2.toCharArray()), var3);
   }

   BaseEncoding$StandardBaseEncoding(BaseEncoding$Alphabet var1, @Nullable Character var2) {
      this.alphabet = (BaseEncoding$Alphabet)Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 == null || !var1.matches(var2.charValue()), "Padding character %s was already in alphabet", new Object[]{var2});
      this.paddingChar = var2;
   }

   CharMatcher padding() {
      return this.paddingChar == null?CharMatcher.NONE:CharMatcher.is(this.paddingChar.charValue());
   }

   int maxEncodedSize(int var1) {
      return this.alphabet.charsPerChunk * IntMath.divide(var1, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
   }

   @GwtIncompatible("Writer,OutputStream")
   public OutputStream encodingStream(Writer var1) {
      Preconditions.checkNotNull(var1);
      return new BaseEncoding$StandardBaseEncoding$1(this, var1);
   }

   void encodeTo(Appendable var1, byte[] var2, int var3, int var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkPositionIndexes(var3, var3 + var4, var2.length);

      for(int var5 = 0; var5 < var4; var5 += this.alphabet.bytesPerChunk) {
         this.encodeChunkTo(var1, var2, var3 + var5, Math.min(this.alphabet.bytesPerChunk, var4 - var5));
      }

   }

   void encodeChunkTo(Appendable var1, byte[] var2, int var3, int var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkPositionIndexes(var3, var3 + var4, var2.length);
      Preconditions.checkArgument(var4 <= this.alphabet.bytesPerChunk);
      long var5 = 0L;

      int var7;
      for(var7 = 0; var7 < var4; ++var7) {
         var5 |= (long)(var2[var3 + var7] & 255);
         var5 <<= 8;
      }

      var7 = (var4 + 1) * 8 - this.alphabet.bitsPerChar;

      int var8;
      for(var8 = 0; var8 < var4 * 8; var8 += this.alphabet.bitsPerChar) {
         int var9 = (int)(var5 >>> var7 - var8) & this.alphabet.mask;
         var1.append(this.alphabet.encode(var9));
      }

      if(this.paddingChar != null) {
         while(var8 < this.alphabet.bytesPerChunk * 8) {
            var1.append(this.paddingChar.charValue());
            var8 += this.alphabet.bitsPerChar;
         }
      }

   }

   int maxDecodedSize(int var1) {
      return (int)(((long)this.alphabet.bitsPerChar * (long)var1 + 7L) / 8L);
   }

   int decodeTo(byte[] var1, CharSequence var2) {
      Preconditions.checkNotNull(var1);
      String var10 = this.padding().trimTrailingFrom(var2);
      int var3;
      if(!this.alphabet.isValidPaddingStartPosition(var10.length())) {
         var3 = var10.length();
         throw new BaseEncoding$DecodingException((new StringBuilder(32)).append("Invalid input length ").append(var3).toString());
      } else {
         var3 = 0;

         for(int var4 = 0; var4 < var10.length(); var4 += this.alphabet.charsPerChunk) {
            long var5 = 0L;
            int var7 = 0;

            int var8;
            for(var8 = 0; var8 < this.alphabet.charsPerChunk; ++var8) {
               var5 <<= this.alphabet.bitsPerChar;
               if(var4 + var8 < var10.length()) {
                  var5 |= (long)this.alphabet.decode(var10.charAt(var4 + var7++));
               }
            }

            var8 = this.alphabet.bytesPerChunk * 8 - var7 * this.alphabet.bitsPerChar;

            for(int var9 = (this.alphabet.bytesPerChunk - 1) * 8; var9 >= var8; var9 -= 8) {
               var1[var3++] = (byte)((int)(var5 >>> var9 & 255L));
            }
         }

         return var3;
      }
   }

   @GwtIncompatible("Reader,InputStream")
   public InputStream decodingStream(Reader var1) {
      Preconditions.checkNotNull(var1);
      return new BaseEncoding$StandardBaseEncoding$2(this, var1);
   }

   public BaseEncoding omitPadding() {
      return (BaseEncoding)(this.paddingChar == null?this:this.newInstance(this.alphabet, (Character)null));
   }

   public BaseEncoding withPadChar(char var1) {
      return (BaseEncoding)(8 % this.alphabet.bitsPerChar != 0 && (this.paddingChar == null || this.paddingChar.charValue() != var1)?this.newInstance(this.alphabet, Character.valueOf(var1)):this);
   }

   public BaseEncoding withSeparator(String var1, int var2) {
      Preconditions.checkArgument(this.padding().or(this.alphabet).matchesNoneOf(var1), "Separator (%s) cannot contain alphabet or padding characters", new Object[]{var1});
      return new BaseEncoding$SeparatedBaseEncoding(this, var1, var2);
   }

   public BaseEncoding upperCase() {
      BaseEncoding var1 = this.upperCase;
      if(var1 == null) {
         BaseEncoding$Alphabet var2 = this.alphabet.upperCase();
         var1 = this.upperCase = (BaseEncoding)(var2 == this.alphabet?this:this.newInstance(var2, this.paddingChar));
      }

      return var1;
   }

   public BaseEncoding lowerCase() {
      BaseEncoding var1 = this.lowerCase;
      if(var1 == null) {
         BaseEncoding$Alphabet var2 = this.alphabet.lowerCase();
         var1 = this.lowerCase = (BaseEncoding)(var2 == this.alphabet?this:this.newInstance(var2, this.paddingChar));
      }

      return var1;
   }

   BaseEncoding newInstance(BaseEncoding$Alphabet var1, @Nullable Character var2) {
      return new BaseEncoding$StandardBaseEncoding(var1, var2);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BaseEncoding.");
      var1.append(this.alphabet.toString());
      if(8 % this.alphabet.bitsPerChar != 0) {
         if(this.paddingChar == null) {
            var1.append(".omitPadding()");
         } else {
            var1.append(".withPadChar(").append(this.paddingChar).append(')');
         }
      }

      return var1.toString();
   }
}
