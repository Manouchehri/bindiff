package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.primitives.UnsignedLong;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class WeightedConsistentHash {
   private final HashFunction hashFunction;
   private final Funnel bucketFunnel;
   private final Funnel inputFunnel;
   private final Map bucketWeights = new HashMap();

   private WeightedConsistentHash(HashFunction var1, Funnel var2, Funnel var3) {
      this.hashFunction = (HashFunction)Preconditions.checkNotNull(var1);
      this.bucketFunnel = (Funnel)Preconditions.checkNotNull(var2);
      this.inputFunnel = (Funnel)Preconditions.checkNotNull(var3);
   }

   public static WeightedConsistentHash create(Funnel var0, Funnel var1) {
      return new WeightedConsistentHash(Hashing.fingerprint2011(), var0, var1);
   }

   public void setBucketWeight(Object var1, double var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var2 >= 0.0D, "Weight (%s) must be non-negative.", new Object[]{Double.valueOf(var2)});
      if(var2 == 0.0D) {
         this.bucketWeights.remove(var1);
      } else {
         this.bucketWeights.put(var1, Double.valueOf(var2));
      }

   }

   public Object hash(Object var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkState(!this.bucketWeights.isEmpty(), "No positive weight.");
      Object var2 = null;
      double var3 = Double.NEGATIVE_INFINITY;
      Iterator var5 = this.bucketWeights.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         double var7 = Math.log(this.affinity(var1, var6.getKey())) / ((Double)var6.getValue()).doubleValue();
         if(var7 > var3) {
            var3 = var7;
            var2 = var6.getKey();
         }
      }

      return var2;
   }

   @VisibleForTesting
   double affinity(Object var1, Object var2) {
      long var3 = this.hashFunction.newHasher().putObject(var1, this.inputFunnel).putObject(var2, this.bucketFunnel).hash().asLong();
      return UnsignedLong.fromLongBits(var3).doubleValue() / UnsignedLong.MAX_VALUE.doubleValue();
   }
}
