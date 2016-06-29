package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilter$1;
import com.google.common.hash.BloomFilter$SerialForm;
import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.hash.BloomFilterStrategies$BitArray;
import com.google.common.hash.Funnel;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter implements Predicate, Serializable {
   private final BloomFilterStrategies$BitArray bits;
   private final int numHashFunctions;
   private final Funnel funnel;
   private final BloomFilter$Strategy strategy;

   private BloomFilter(BloomFilterStrategies$BitArray var1, int var2, Funnel var3, BloomFilter$Strategy var4) {
      Preconditions.checkArgument(var2 > 0, "numHashFunctions (%s) must be > 0", new Object[]{Integer.valueOf(var2)});
      Preconditions.checkArgument(var2 <= 255, "numHashFunctions (%s) must be <= 255", new Object[]{Integer.valueOf(var2)});
      this.bits = (BloomFilterStrategies$BitArray)Preconditions.checkNotNull(var1);
      this.numHashFunctions = var2;
      this.funnel = (Funnel)Preconditions.checkNotNull(var3);
      this.strategy = (BloomFilter$Strategy)Preconditions.checkNotNull(var4);
   }

   @CheckReturnValue
   public BloomFilter copy() {
      return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
   }

   @CheckReturnValue
   public boolean mightContain(Object var1) {
      return this.strategy.mightContain(var1, this.funnel, this.numHashFunctions, this.bits);
   }

   @Deprecated
   @CheckReturnValue
   public boolean apply(Object var1) {
      return this.mightContain(var1);
   }

   public boolean put(Object var1) {
      return this.strategy.put(var1, this.funnel, this.numHashFunctions, this.bits);
   }

   @CheckReturnValue
   public double expectedFpp() {
      return Math.pow((double)this.bits.bitCount() / (double)this.bitSize(), (double)this.numHashFunctions);
   }

   @VisibleForTesting
   long bitSize() {
      return this.bits.bitSize();
   }

   @CheckReturnValue
   public boolean isCompatible(BloomFilter var1) {
      Preconditions.checkNotNull(var1);
      return this != var1 && this.numHashFunctions == var1.numHashFunctions && this.bitSize() == var1.bitSize() && this.strategy.equals(var1.strategy) && this.funnel.equals(var1.funnel);
   }

   public void putAll(BloomFilter var1) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(this != var1, "Cannot combine a BloomFilter with itself.");
      Preconditions.checkArgument(this.numHashFunctions == var1.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", new Object[]{Integer.valueOf(this.numHashFunctions), Integer.valueOf(var1.numHashFunctions)});
      Preconditions.checkArgument(this.bitSize() == var1.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", new Object[]{Long.valueOf(this.bitSize()), Long.valueOf(var1.bitSize())});
      Preconditions.checkArgument(this.strategy.equals(var1.strategy), "BloomFilters must have equal strategies (%s != %s)", new Object[]{this.strategy, var1.strategy});
      Preconditions.checkArgument(this.funnel.equals(var1.funnel), "BloomFilters must have equal funnels (%s != %s)", new Object[]{this.funnel, var1.funnel});
      this.bits.putAll(var1.bits);
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BloomFilter)) {
         return false;
      } else {
         BloomFilter var2 = (BloomFilter)var1;
         return this.numHashFunctions == var2.numHashFunctions && this.funnel.equals(var2.funnel) && this.bits.equals(var2.bits) && this.strategy.equals(var2.strategy);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
   }

   @CheckReturnValue
   public static BloomFilter create(Funnel var0, int var1, double var2) {
      return create(var0, (long)var1, var2);
   }

   @CheckReturnValue
   public static BloomFilter create(Funnel var0, long var1, double var3) {
      return create(var0, var1, var3, BloomFilterStrategies.MURMUR128_MITZ_64);
   }

   @VisibleForTesting
   static BloomFilter create(Funnel var0, long var1, double var3, BloomFilter$Strategy var5) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(var1 >= 0L, "Expected insertions (%s) must be >= 0", new Object[]{Long.valueOf(var1)});
      Preconditions.checkArgument(var3 > 0.0D, "False positive probability (%s) must be > 0.0", new Object[]{Double.valueOf(var3)});
      Preconditions.checkArgument(var3 < 1.0D, "False positive probability (%s) must be < 1.0", new Object[]{Double.valueOf(var3)});
      Preconditions.checkNotNull(var5);
      if(var1 == 0L) {
         var1 = 1L;
      }

      long var6 = optimalNumOfBits(var1, var3);
      int var8 = optimalNumOfHashFunctions(var1, var6);

      try {
         return new BloomFilter(new BloomFilterStrategies$BitArray(var6), var8, var0, var5);
      } catch (IllegalArgumentException var10) {
         throw new IllegalArgumentException((new StringBuilder(57)).append("Could not create BloomFilter of ").append(var6).append(" bits").toString(), var10);
      }
   }

   @CheckReturnValue
   public static BloomFilter create(Funnel var0, int var1) {
      return create(var0, (long)var1);
   }

   @CheckReturnValue
   public static BloomFilter create(Funnel var0, long var1) {
      return create(var0, var1, 0.03D);
   }

   @VisibleForTesting
   static int optimalNumOfHashFunctions(long var0, long var2) {
      return Math.max(1, (int)Math.round((double)var2 / (double)var0 * Math.log(2.0D)));
   }

   @VisibleForTesting
   static long optimalNumOfBits(long var0, double var2) {
      if(var2 == 0.0D) {
         var2 = Double.MIN_VALUE;
      }

      return (long)((double)(-var0) * Math.log(var2) / (Math.log(2.0D) * Math.log(2.0D)));
   }

   private Object writeReplace() {
      return new BloomFilter$SerialForm(this);
   }

   public void writeTo(OutputStream var1) {
      DataOutputStream var2 = new DataOutputStream(var1);
      var2.writeByte(SignedBytes.checkedCast((long)this.strategy.ordinal()));
      var2.writeByte(UnsignedBytes.checkedCast((long)this.numHashFunctions));
      var2.writeInt(this.bits.data.length);
      long[] var3 = this.bits.data;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long var6 = var3[var5];
         var2.writeLong(var6);
      }

   }

   @CheckReturnValue
   public static BloomFilter readFrom(InputStream var0, Funnel var1) {
      Preconditions.checkNotNull(var0, "InputStream");
      Preconditions.checkNotNull(var1, "Funnel");
      byte var2 = -1;
      byte var3 = -1;
      byte var4 = -1;

      try {
         DataInputStream var5 = new DataInputStream(var0);
         var2 = var5.readByte();
         int var12 = UnsignedBytes.toInt(var5.readByte());
         int var13 = var5.readInt();
         BloomFilterStrategies var14 = BloomFilterStrategies.values()[var2];
         long[] var15 = new long[var13];

         for(int var8 = 0; var8 < var15.length; ++var8) {
            var15[var8] = var5.readLong();
         }

         return new BloomFilter(new BloomFilterStrategies$BitArray(var15), var12, var1, var14);
      } catch (RuntimeException var11) {
         String var7 = String.valueOf("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
         IOException var6 = new IOException((new StringBuilder(65 + String.valueOf(var7).length())).append(var7).append(var2).append(" numHashFunctions: ").append(var3).append(" dataLength: ").append(var4).toString());
         var6.initCause(var11);
         throw var6;
      }
   }

   // $FF: synthetic method
   static BloomFilterStrategies$BitArray access$000(BloomFilter var0) {
      return var0.bits;
   }

   // $FF: synthetic method
   static int access$100(BloomFilter var0) {
      return var0.numHashFunctions;
   }

   // $FF: synthetic method
   static Funnel access$200(BloomFilter var0) {
      return var0.funnel;
   }

   // $FF: synthetic method
   static BloomFilter$Strategy access$300(BloomFilter var0) {
      return var0.strategy;
   }

   // $FF: synthetic method
   BloomFilter(BloomFilterStrategies$BitArray var1, int var2, Funnel var3, BloomFilter$Strategy var4, BloomFilter$1 var5) {
      this(var1, var2, var3, var4);
   }
}
