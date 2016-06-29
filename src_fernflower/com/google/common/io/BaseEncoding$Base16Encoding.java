package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.BaseEncoding$Alphabet;
import com.google.common.io.BaseEncoding$DecodingException;
import com.google.common.io.BaseEncoding$StandardBaseEncoding;
import javax.annotation.Nullable;

final class BaseEncoding$Base16Encoding extends BaseEncoding$StandardBaseEncoding {
   final char[] encoding;

   BaseEncoding$Base16Encoding(String var1, String var2) {
      this(new BaseEncoding$Alphabet(var1, var2.toCharArray()));
   }

   private BaseEncoding$Base16Encoding(BaseEncoding$Alphabet var1) {
      super(var1, (Character)null);
      this.encoding = new char[512];
      Preconditions.checkArgument(BaseEncoding$Alphabet.access$000(var1).length == 16);

      for(int var2 = 0; var2 < 256; ++var2) {
         this.encoding[var2] = var1.encode(var2 >>> 4);
         this.encoding[var2 | 256] = var1.encode(var2 & 15);
      }

   }

   void encodeTo(Appendable var1, byte[] var2, int var3, int var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkPositionIndexes(var3, var3 + var4, var2.length);

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var2[var3 + var5] & 255;
         var1.append(this.encoding[var6]);
         var1.append(this.encoding[var6 | 256]);
      }

   }

   int decodeTo(byte[] var1, CharSequence var2) {
      Preconditions.checkNotNull(var1);
      int var3;
      if(var2.length() % 2 == 1) {
         var3 = var2.length();
         throw new BaseEncoding$DecodingException((new StringBuilder(32)).append("Invalid input length ").append(var3).toString());
      } else {
         var3 = 0;

         for(int var4 = 0; var4 < var2.length(); var4 += 2) {
            int var5 = this.alphabet.decode(var2.charAt(var4)) << 4 | this.alphabet.decode(var2.charAt(var4 + 1));
            var1[var3++] = (byte)var5;
         }

         return var3;
      }
   }

   BaseEncoding newInstance(BaseEncoding$Alphabet var1, @Nullable Character var2) {
      return new BaseEncoding$Base16Encoding(var1);
   }
}
