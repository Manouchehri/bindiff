package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import javax.annotation.Nullable;

final class BaseEncoding$Base64Encoding extends BaseEncoding$StandardBaseEncoding {
   BaseEncoding$Base64Encoding(String var1, String var2, @Nullable Character var3) {
      this(new BaseEncoding$Alphabet(var1, var2.toCharArray()), var3);
   }

   private BaseEncoding$Base64Encoding(BaseEncoding$Alphabet var1, @Nullable Character var2) {
      super(var1, var2);
      Preconditions.checkArgument(BaseEncoding$Alphabet.access$000(var1).length == 64);
   }

   void encodeTo(Appendable var1, byte[] var2, int var3, int var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkPositionIndexes(var3, var3 + var4, var2.length);
      int var5 = var3;

      for(int var6 = var4; var6 >= 3; var6 -= 3) {
         int var7 = (var2[var5++] & 255) << 16 | (var2[var5++] & 255) << 8 | var2[var5++] & 255;
         var1.append(this.alphabet.encode(var7 >>> 18));
         var1.append(this.alphabet.encode(var7 >>> 12 & 63));
         var1.append(this.alphabet.encode(var7 >>> 6 & 63));
         var1.append(this.alphabet.encode(var7 & 63));
      }

      if(var5 < var3 + var4) {
         this.encodeChunkTo(var1, var2, var5, var3 + var4 - var5);
      }

   }

   int decodeTo(byte[] var1, CharSequence var2) {
      Preconditions.checkNotNull(var1);
      String var6 = this.padding().trimTrailingFrom(var2);
      int var3;
      if(!this.alphabet.isValidPaddingStartPosition(var6.length())) {
         var3 = var6.length();
         throw new BaseEncoding$DecodingException((new StringBuilder(32)).append("Invalid input length ").append(var3).toString());
      } else {
         var3 = 0;
         int var4 = 0;

         while(var4 < var6.length()) {
            int var5 = this.alphabet.decode(var6.charAt(var4++)) << 18;
            var5 |= this.alphabet.decode(var6.charAt(var4++)) << 12;
            var1[var3++] = (byte)(var5 >>> 16);
            if(var4 < var6.length()) {
               var5 |= this.alphabet.decode(var6.charAt(var4++)) << 6;
               var1[var3++] = (byte)(var5 >>> 8 & 255);
               if(var4 < var6.length()) {
                  var5 |= this.alphabet.decode(var6.charAt(var4++));
                  var1[var3++] = (byte)(var5 & 255);
               }
            }
         }

         return var3;
      }
   }

   BaseEncoding newInstance(BaseEncoding$Alphabet var1, @Nullable Character var2) {
      return new BaseEncoding$Base64Encoding(var1, var2);
   }
}
