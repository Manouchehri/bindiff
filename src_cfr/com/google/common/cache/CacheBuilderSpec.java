/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
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
import com.google.common.collect.ImmutableMap$Builder;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new CacheBuilderSpec$InitialCapacityParser()).put("maximumSize", new CacheBuilderSpec$MaximumSizeParser()).put("maximumWeight", new CacheBuilderSpec$MaximumWeightParser()).put("concurrencyLevel", new CacheBuilderSpec$ConcurrencyLevelParser()).put("weakKeys", new CacheBuilderSpec$KeyStrengthParser(LocalCache$Strength.WEAK)).put("softValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.SOFT)).put("weakValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.WEAK)).put("recordStats", new CacheBuilderSpec$RecordStatsParser()).put("expireAfterAccess", new CacheBuilderSpec$AccessDurationParser()).put("expireAfterWrite", new CacheBuilderSpec$WriteDurationParser()).put("refreshAfterWrite", new CacheBuilderSpec$RefreshDurationParser()).put("refreshInterval", new CacheBuilderSpec$RefreshDurationParser()).build();
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

    private CacheBuilderSpec(String string) {
        this.specification = string;
    }

    public static CacheBuilderSpec parse(String string) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(string);
        if (string.isEmpty()) return cacheBuilderSpec;
        Iterator iterator = KEYS_SPLITTER.split(string).iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            ImmutableList immutableList = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(string2));
            Preconditions.checkArgument(!immutableList.isEmpty(), "blank key-value pair");
            Preconditions.checkArgument(immutableList.size() <= 2, "key-value pair %s with more than one equals sign", string2);
            String string3 = (String)immutableList.get(0);
            CacheBuilderSpec$ValueParser cacheBuilderSpec$ValueParser = (CacheBuilderSpec$ValueParser)VALUE_PARSERS.get(string3);
            Preconditions.checkArgument(cacheBuilderSpec$ValueParser != null, "unknown key %s", string3);
            String string4 = immutableList.size() == 1 ? null : (String)immutableList.get(1);
            cacheBuilderSpec$ValueParser.parse(cacheBuilderSpec, string3, string4);
        }
        return cacheBuilderSpec;
    }

    public static CacheBuilderSpec disableCaching() {
        return CacheBuilderSpec.parse("maximumSize=0");
    }

    /*
     * Unable to fully structure code
     */
    CacheBuilder toCacheBuilder() {
        var1_1 = CacheBuilder.newBuilder();
        if (this.initialCapacity != null) {
            var1_1.initialCapacity(this.initialCapacity);
        }
        if (this.maximumSize != null) {
            var1_1.maximumSize(this.maximumSize);
        }
        if (this.maximumWeight != null) {
            var1_1.maximumWeight(this.maximumWeight);
        }
        if (this.concurrencyLevel != null) {
            var1_1.concurrencyLevel(this.concurrencyLevel);
        }
        if (this.keyStrength != null) {
            switch (CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()]) {
                case 1: {
                    var1_1.weakKeys();
                    ** break;
                }
            }
            throw new AssertionError();
        }
lbl16: // 3 sources:
        if (this.valueStrength != null) {
            switch (CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.valueStrength.ordinal()]) {
                case 2: {
                    var1_1.softValues();
                    ** break;
                }
                case 1: {
                    var1_1.weakValues();
                    ** break;
                }
            }
            throw new AssertionError();
        }
lbl25: // 4 sources:
        if (this.recordStats != null && this.recordStats.booleanValue()) {
            var1_1.recordStats();
        }
        if (this.writeExpirationTimeUnit != null) {
            var1_1.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
        }
        if (this.accessExpirationTimeUnit != null) {
            var1_1.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
        }
        if (this.refreshTimeUnit == null) return var1_1;
        var1_1.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
        return var1_1;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.toParsableString()).toString();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, CacheBuilderSpec.durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), CacheBuilderSpec.durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), CacheBuilderSpec.durationInNanos(this.refreshDuration, this.refreshTimeUnit)});
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec)object;
        if (!Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity)) return false;
        if (!Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize)) return false;
        if (!Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight)) return false;
        if (!Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel)) return false;
        if (!Objects.equal((Object)this.keyStrength, (Object)cacheBuilderSpec.keyStrength)) return false;
        if (!Objects.equal((Object)this.valueStrength, (Object)cacheBuilderSpec.valueStrength)) return false;
        if (!Objects.equal(this.recordStats, cacheBuilderSpec.recordStats)) return false;
        if (!Objects.equal(CacheBuilderSpec.durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), CacheBuilderSpec.durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit))) return false;
        if (!Objects.equal(CacheBuilderSpec.durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), CacheBuilderSpec.durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit))) return false;
        if (!Objects.equal(CacheBuilderSpec.durationInNanos(this.refreshDuration, this.refreshTimeUnit), CacheBuilderSpec.durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit))) return false;
        return true;
    }

    @Nullable
    private static Long durationInNanos(long l2, @Nullable TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        Long l3 = timeUnit.toNanos(l2);
        return l3;
    }

    private static /* varargs */ String format(String string, Object ... arrobject) {
        return String.format(Locale.ROOT, string, arrobject);
    }

    static /* synthetic */ String access$000(String string, Object[] arrobject) {
        return CacheBuilderSpec.format(string, arrobject);
    }
}

