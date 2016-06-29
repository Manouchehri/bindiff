package com.google.common.math;

import java.io.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;

@GoogleInternal
public final class Stats implements Serializable
{
    private final long count;
    private final double mean;
    private final double sumOfSquaresOfDeltas;
    private final double min;
    private final double max;
    
    Stats(final long count, final double mean, final double sumOfSquaresOfDeltas, final double min, final double max) {
        this.count = count;
        this.mean = mean;
        this.sumOfSquaresOfDeltas = sumOfSquaresOfDeltas;
        this.min = min;
        this.max = max;
    }
    
    public static Stats of(final Iterable iterable) {
        final StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }
    
    public static Stats of(final Iterator iterator) {
        final StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterator);
        return statsAccumulator.snapshot();
    }
    
    public static Stats of(final double... array) {
        final StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(array);
        return statsAccumulator.snapshot();
    }
    
    public static Stats of(final int... array) {
        final StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(array);
        return statsAccumulator.snapshot();
    }
    
    public static Stats of(final long... array) {
        final StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(array);
        return statsAccumulator.snapshot();
    }
    
    public long count() {
        return this.count;
    }
    
    public double mean() {
        Preconditions.checkState(this.count != 0L);
        return this.mean;
    }
    
    public double sum() {
        return this.mean * this.count;
    }
    
    public double populationVariance() {
        Preconditions.checkState(this.count > 0L);
        if (this.count == 1L) {
            return 0.0;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count();
    }
    
    public double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }
    
    public double sampleVariance() {
        Preconditions.checkState(this.count > 1L);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1L);
    }
    
    public double sampleStandardDeviation() {
        return Math.sqrt(this.sampleVariance());
    }
    
    public double min() {
        Preconditions.checkState(this.count != 0L);
        return this.min;
    }
    
    public double max() {
        Preconditions.checkState(this.count != 0L);
        return this.max;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        final Stats stats = (Stats)o;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", this.populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
    }
    
    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }
}
