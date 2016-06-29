package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MacHashFunction$1;
import com.google.common.hash.MacHashFunction$MacHasher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@GoogleInternal
final class MacHashFunction extends AbstractStreamingHashFunction {
   private final String algorithmName;
   private final Key key;
   private final String toString;
   private final int bits;

   MacHashFunction(String var1, Key var2, String var3) {
      this.algorithmName = (String)Preconditions.checkNotNull(var1);
      this.key = (Key)Preconditions.checkNotNull(var2);
      this.toString = (String)Preconditions.checkNotNull(var3);
      this.bits = getMac(var1, var2).getMacLength() * 8;
   }

   public int bits() {
      return this.bits;
   }

   private static Mac getMac(String var0, Key var1) {
      try {
         Mac var2 = Mac.getInstance(var0);
         var2.init(var1);
         return var2;
      } catch (NoSuchAlgorithmException var3) {
         throw new IllegalStateException(var3);
      } catch (InvalidKeyException var4) {
         throw new IllegalArgumentException(var4);
      }
   }

   public Hasher newHasher() {
      return new MacHashFunction$MacHasher(getMac(this.algorithmName, this.key), (MacHashFunction$1)null);
   }

   public String toString() {
      return this.toString;
   }
}
