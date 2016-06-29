package com.google.common.cache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilderSpec$1;
import com.google.common.cache.CacheBuilderSpec$AccessDurationParser;
import com.google.common.cache.CacheBuilderSpec$ConcurrencyLevelParser;
import com.google.common.cache.CacheBuilderSpec$InitialCapacityParser;
import com.google.common.cache.CacheBuilderSpec$KeyStrengthParser;
import com.google.common.cache.CacheBuilderSpec$MaximumSizeParser;
import com.google.common.cache.CacheBuilderSpec$MaximumWeightParser;
import com.google.common.cache.CacheBuilderSpec$RecordStatsParser;
import com.google.common.cache.CacheBuilderSpec$RefreshDurationParser;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import com.google.common.cache.CacheBuilderSpec$ValueStrengthParser;
import com.google.common.cache.CacheBuilderSpec$WriteDurationParser;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheBuilderSpec {
   private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
   private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
   private static final ImmutableMap VALUE_PARSERS;
   @VisibleForTesting
   Integer initialCapacity;
   @VisibleForTesting
   Long maximumSize;
   @VisibleForTesting
   Long maximumWeight;
   @VisibleForTesting
   Integer concurrencyLevel;
   @VisibleForTesting
   LocalCache$Strength keyStrength;
   @VisibleForTesting
   LocalCache$Strength valueStrength;
   @VisibleForTesting
   Boolean recordStats;
   @VisibleForTesting
   long writeExpirationDuration;
   @VisibleForTesting
   TimeUnit writeExpirationTimeUnit;
   @VisibleForTesting
   long accessExpirationDuration;
   @VisibleForTesting
   TimeUnit accessExpirationTimeUnit;
   @VisibleForTesting
   long refreshDuration;
   @VisibleForTesting
   TimeUnit refreshTimeUnit;
   private final String specification;

   private CacheBuilderSpec(String var1) {
      this.specification = var1;
   }

   public static CacheBuilderSpec parse(String var0) {
      CacheBuilderSpec var1 = new CacheBuilderSpec(var0);
      if(!var0.isEmpty()) {
         Iterator var2 = KEYS_SPLITTER.split(var0).iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            ImmutableList var4 = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(var3));
            Preconditions.checkArgument(!var4.isEmpty(), "blank key-value pair");
            Preconditions.checkArgument(var4.size() <= 2, "key-value pair %s with more than one equals sign", new Object[]{var3});
            String var5 = (String)var4.get(0);
            CacheBuilderSpec$ValueParser var6 = (CacheBuilderSpec$ValueParser)VALUE_PARSERS.get(var5);
            Preconditions.checkArgument(var6 != null, "unknown key %s", new Object[]{var5});
            String var7 = var4.size() == 1?null:(String)var4.get(1);
            var6.parse(var1, var5, var7);
         }
      }

      return var1;
   }

   public static CacheBuilderSpec disableCaching() {
      return parse("maximumSize=0");
   }

   CacheBuilder toCacheBuilder() {
      CacheBuilder var1 = CacheBuilder.newBuilder();
      if(this.initialCapacity != null) {
         var1.initialCapacity(this.initialCapacity.intValue());
      }

      if(this.maximumSize != null) {
         var1.maximumSize(this.maximumSize.longValue());
      }

      if(this.maximumWeight != null) {
         var1.maximumWeight(this.maximumWeight.longValue());
      }

      if(this.concurrencyLevel != null) {
         var1.concurrencyLevel(this.concurrencyLevel.intValue());
      }

      if(this.keyStrength != null) {
         switch(CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()]) {
         case 1:
            var1.weakKeys();
            break;
         default:
            throw new AssertionError();
         }
      }

      if(this.valueStrength != null) {
         switch(CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.valueStrength.ordinal()]) {
         case 1:
            var1.weakValues();
            break;
         case 2:
            var1.softValues();
            break;
         default:
            throw new AssertionError();
         }
      }

      if(this.recordStats != null && this.recordStats.booleanValue()) {
         var1.recordStats();
      }

      if(this.writeExpirationTimeUnit != null) {
         var1.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
      }

      if(this.accessExpirationTimeUnit != null) {
         var1.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
      }

      if(this.refreshTimeUnit != null) {
         var1.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
      }

      return var1;
   }

   public String toParsableString() {
      return this.specification;
   }

   public String toString() {
      return MoreObjects.toStringHelper((Object)this).addValue(this.toParsableString()).toString();
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit)});
   }

   public boolean equals(@Nullable Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof CacheBuilderSpec)) {
         return false;
      } else {
         CacheBuilderSpec var2 = (CacheBuilderSpec)var1;
         return Objects.equal(this.initialCapacity, var2.initialCapacity) && Objects.equal(this.maximumSize, var2.maximumSize) && Objects.equal(this.maximumWeight, var2.maximumWeight) && Objects.equal(this.concurrencyLevel, var2.concurrencyLevel) && Objects.equal(this.keyStrength, var2.keyStrength) && Objects.equal(this.valueStrength, var2.valueStrength) && Objects.equal(this.recordStats, var2.recordStats) && Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(var2.writeExpirationDuration, var2.writeExpirationTimeUnit)) && Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(var2.accessExpirationDuration, var2.accessExpirationTimeUnit)) && Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(var2.refreshDuration, var2.refreshTimeUnit));
      }
   }

   @Nullable
   private static Long durationInNanos(long var0, @Nullable TimeUnit var2) {
      return var2 == null?null:Long.valueOf(var2.toNanos(var0));
   }

   private static String format(String var0, Object... var1) {
      return String.format(Locale.ROOT, var0, var1);
   }

   // $FF: synthetic method
   static String access$000(String var0, Object[] var1) {
      return format(var0, var1);
   }

   static {
      VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new CacheBuilderSpec$InitialCapacityParser()).put("maximumSize", new CacheBuilderSpec$MaximumSizeParser()).put("maximumWeight", new CacheBuilderSpec$MaximumWeightParser()).put("concurrencyLevel", new CacheBuilderSpec$ConcurrencyLevelParser()).put("weakKeys", new CacheBuilderSpec$KeyStrengthParser(LocalCache$Strength.WEAK)).put("softValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.SOFT)).put("weakValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.WEAK)).put("recordStats", new CacheBuilderSpec$RecordStatsParser()).put("expireAfterAccess", new CacheBuilderSpec$AccessDurationParser()).put("expireAfterWrite", new CacheBuilderSpec$WriteDurationParser()).put("refreshAfterWrite", new CacheBuilderSpec$RefreshDurationParser()).put("refreshInterval", new CacheBuilderSpec$RefreshDurationParser()).build();
   }
}
