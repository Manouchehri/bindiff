package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.Weigher;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

class LocalCache$ManualSerializationProxy extends ForwardingCache implements Serializable {
   private static final long serialVersionUID = 1L;
   final LocalCache$Strength keyStrength;
   final LocalCache$Strength valueStrength;
   final Equivalence keyEquivalence;
   final Equivalence valueEquivalence;
   final long expireAfterWriteNanos;
   final long expireAfterAccessNanos;
   final long maxWeight;
   final Weigher weigher;
   final int concurrencyLevel;
   final RemovalListener removalListener;
   final Ticker ticker;
   final CacheLoader loader;
   transient Cache delegate;

   LocalCache$ManualSerializationProxy(LocalCache var1) {
      this(var1.keyStrength, var1.valueStrength, var1.keyEquivalence, var1.valueEquivalence, var1.expireAfterWriteNanos, var1.expireAfterAccessNanos, var1.maxWeight, var1.weigher, var1.concurrencyLevel, var1.removalListener, var1.ticker, var1.defaultLoader);
   }

   private LocalCache$ManualSerializationProxy(LocalCache$Strength var1, LocalCache$Strength var2, Equivalence var3, Equivalence var4, long var5, long var7, long var9, Weigher var11, int var12, RemovalListener var13, Ticker var14, CacheLoader var15) {
      this.keyStrength = var1;
      this.valueStrength = var2;
      this.keyEquivalence = var3;
      this.valueEquivalence = var4;
      this.expireAfterWriteNanos = var5;
      this.expireAfterAccessNanos = var7;
      this.maxWeight = var9;
      this.weigher = var11;
      this.concurrencyLevel = var12;
      this.removalListener = var13;
      this.ticker = var14 != Ticker.systemTicker() && var14 != CacheBuilder.NULL_TICKER?var14:null;
      this.loader = var15;
   }

   CacheBuilder recreateCacheBuilder() {
      CacheBuilder var1 = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
      var1.strictParsing = false;
      if(this.expireAfterWriteNanos > 0L) {
         var1.expireAfterWrite(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
      }

      if(this.expireAfterAccessNanos > 0L) {
         var1.expireAfterAccess(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
      }

      if(this.weigher != CacheBuilder$OneWeigher.INSTANCE) {
         var1.weigher(this.weigher);
         if(this.maxWeight != -1L) {
            var1.maximumWeight(this.maxWeight);
         }
      } else if(this.maxWeight != -1L) {
         var1.maximumSize(this.maxWeight);
      }

      if(this.ticker != null) {
         var1.ticker(this.ticker);
      }

      return var1;
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      CacheBuilder var2 = this.recreateCacheBuilder();
      this.delegate = var2.build();
   }

   private Object readResolve() {
      return this.delegate;
   }

   protected Cache delegate() {
      return this.delegate;
   }
}
