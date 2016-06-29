package com.google.common.cache;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

public final class CacheBuilderSpec
{
    private static final Splitter KEYS_SPLITTER;
    private static final Splitter KEY_VALUE_SPLITTER;
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
    
    private CacheBuilderSpec(final String specification) {
        this.specification = specification;
    }
    
    public static CacheBuilderSpec parse(final String s) {
        final CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(s);
        if (!s.isEmpty()) {
            for (final String s2 : CacheBuilderSpec.KEYS_SPLITTER.split(s)) {
                final ImmutableList copy = ImmutableList.copyOf(CacheBuilderSpec.KEY_VALUE_SPLITTER.split(s2));
                Preconditions.checkArgument(!copy.isEmpty(), (Object)"blank key-value pair");
                Preconditions.checkArgument(copy.size() <= 2, "key-value pair %s with more than one equals sign", s2);
                final String s3 = copy.get(0);
                final CacheBuilderSpec$ValueParser cacheBuilderSpec$ValueParser = (CacheBuilderSpec$ValueParser)CacheBuilderSpec.VALUE_PARSERS.get(s3);
                Preconditions.checkArgument(cacheBuilderSpec$ValueParser != null, "unknown key %s", s3);
                cacheBuilderSpec$ValueParser.parse(cacheBuilderSpec, s3, (copy.size() == 1) ? null : copy.get(1));
            }
        }
        return cacheBuilderSpec;
    }
    
    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }
    
    CacheBuilder toCacheBuilder() {
        final CacheBuilder builder = CacheBuilder.newBuilder();
        if (this.initialCapacity != null) {
            builder.initialCapacity(this.initialCapacity);
        }
        if (this.maximumSize != null) {
            builder.maximumSize(this.maximumSize);
        }
        if (this.maximumWeight != null) {
            builder.maximumWeight(this.maximumWeight);
        }
        if (this.concurrencyLevel != null) {
            builder.concurrencyLevel(this.concurrencyLevel);
        }
        if (this.keyStrength != null) {
            switch (CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()]) {
                case 1: {
                    builder.weakKeys();
                    break;
                }
                default: {
                    throw new AssertionError();
                }
            }
        }
        if (this.valueStrength != null) {
            switch (CacheBuilderSpec$1.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.valueStrength.ordinal()]) {
                case 2: {
                    builder.softValues();
                    break;
                }
                case 1: {
                    builder.weakValues();
                    break;
                }
                default: {
                    throw new AssertionError();
                }
            }
        }
        if (this.recordStats != null && this.recordStats) {
            builder.recordStats();
        }
        if (this.writeExpirationTimeUnit != null) {
            builder.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
        }
        if (this.accessExpirationTimeUnit != null) {
            builder.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
        }
        if (this.refreshTimeUnit != null) {
            builder.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
        }
        return builder;
    }
    
    public String toParsableString() {
        return this.specification;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.toParsableString()).toString();
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CacheBuilderSpec)) {
            return false;
        }
        final CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec)o;
        return Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity) && Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize) && Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight) && Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel) && Objects.equal(this.keyStrength, cacheBuilderSpec.keyStrength) && Objects.equal(this.valueStrength, cacheBuilderSpec.valueStrength) && Objects.equal(this.recordStats, cacheBuilderSpec.recordStats) && Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit)) && Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit)) && Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit));
    }
    
    @Nullable
    private static Long durationInNanos(final long n, @Nullable final TimeUnit timeUnit) {
        return (timeUnit == null) ? null : timeUnit.toNanos(n);
    }
    
    private static String format(final String s, final Object... array) {
        return String.format(Locale.ROOT, s, array);
    }
    
    static {
        KEYS_SPLITTER = Splitter.on(',').trimResults();
        KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
        VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new CacheBuilderSpec$InitialCapacityParser()).put("maximumSize", new CacheBuilderSpec$MaximumSizeParser()).put("maximumWeight", new CacheBuilderSpec$MaximumWeightParser()).put("concurrencyLevel", new CacheBuilderSpec$ConcurrencyLevelParser()).put("weakKeys", new CacheBuilderSpec$KeyStrengthParser(LocalCache$Strength.WEAK)).put("softValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.SOFT)).put("weakValues", new CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength.WEAK)).put("recordStats", new CacheBuilderSpec$RecordStatsParser()).put("expireAfterAccess", new CacheBuilderSpec$AccessDurationParser()).put("expireAfterWrite", new CacheBuilderSpec$WriteDurationParser()).put("refreshAfterWrite", new CacheBuilderSpec$RefreshDurationParser()).put("refreshInterval", new CacheBuilderSpec$RefreshDurationParser()).build();
    }
}
