package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Randoms$1;
import com.google.common.base.Randoms$ReadOnlyRandom;
import java.security.SecureRandom;
import java.util.Random;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class Randoms {
   private static final Random RANDOM = new Randoms$ReadOnlyRandom((Randoms$1)null);
   private static final SecureRandom SECURE_RANDOM = newDefaultSecureRandom();

   public static SecureRandom secureRandom() {
      return SECURE_RANDOM;
   }

   public static SecureRandom secureRandom(byte[] var0) {
      SecureRandom var1 = new SecureRandom(var0);
      var1.nextLong();
      return var1;
   }

   public static Random insecureRandom() {
      return RANDOM;
   }

   public static Random insecureRandom(long var0) {
      return new Random(var0);
   }

   private static SecureRandom newDefaultSecureRandom() {
      SecureRandom var0 = new SecureRandom();
      var0.nextLong();
      return var0;
   }
}
