package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;
import java.math.BigInteger;

final class DiscreteDomain$BigIntegerDomain extends DiscreteDomain implements Serializable {
   private static final DiscreteDomain$BigIntegerDomain INSTANCE = new DiscreteDomain$BigIntegerDomain();
   private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
   private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
   private static final long serialVersionUID = 0L;

   public BigInteger next(BigInteger var1) {
      return var1.add(BigInteger.ONE);
   }

   public BigInteger previous(BigInteger var1) {
      return var1.subtract(BigInteger.ONE);
   }

   public long distance(BigInteger var1, BigInteger var2) {
      return var2.subtract(var1).max(MIN_LONG).min(MAX_LONG).longValue();
   }

   private Object readResolve() {
      return INSTANCE;
   }

   public String toString() {
      return "DiscreteDomain.bigIntegers()";
   }

   // $FF: synthetic method
   static DiscreteDomain$BigIntegerDomain access$200() {
      return INSTANCE;
   }
}
