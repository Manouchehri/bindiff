/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.StatsAccumulator;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
public final class Stats
implements Serializable {
    private final long count;
    private final double mean;
    private final double sumOfSquaresOfDeltas;
    private final double min;
    private final double max;

    Stats(long l2, double d2, double d3, double d4, double d5) {
        this.count = l2;
        this.mean = d2;
        this.sumOfSquaresOfDeltas = d3;
        this.min = d4;
        this.max = d5;
    }

    public static Stats of(Iterable iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public static Stats of(Iterator iterator) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterator);
        return statsAccumulator.snapshot();
    }

    public static /* varargs */ Stats of(double ... arrd) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(arrd);
        return statsAccumulator.snapshot();
    }

    public static /* varargs */ Stats of(int ... arrn) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(arrn);
        return statsAccumulator.snapshot();
    }

    public static /* varargs */ Stats of(long ... arrl) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(arrl);
        return statsAccumulator.snapshot();
    }

    public long count() {
        return this.count;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double sum() {
        return this.mean * (double)this.count;
    }

    public double populationVariance() {
        Preconditions.checkState(this.count > 0);
        if (this.count != 1) return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)this.count();
        return 0.0;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }

    public double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)(this.count - 1);
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(this.sampleVariance());
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public boolean equals(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Stats stats = (Stats)object;
        if (this.count != stats.count) return false;
        if (Double.doubleToLongBits(this.mean) != Double.doubleToLongBits(stats.mean)) return false;
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) != Double.doubleToLongBits(stats.sumOfSquaresOfDeltas)) return false;
        if (Double.doubleToLongBits(this.min) != Double.doubleToLongBits(stats.min)) return false;
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(stats.max)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", this.populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }
}

