package com.google.common.math;

import com.google.common.annotations.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.util.*;

@GoogleInternal
public final class StatsAccumulator
{
    private long count;
    private double mean;
    private double sumOfSquaresOfDeltas;
    private double min;
    private double max;
    
    public StatsAccumulator() {
        this.count = 0L;
        this.mean = 0.0;
        this.sumOfSquaresOfDeltas = 0.0;
        this.min = Double.NaN;
        this.max = Double.NaN;
    }
    
    public void add(final double max) {
        Preconditions.checkArgument(Doubles.isFinite(max));
        ++this.count;
        if (this.count == 1L) {
            this.mean = max;
            this.min = max;
            this.max = max;
        }
        else {
            final double mean = this.mean + (max - this.mean) / this.count;
            this.sumOfSquaresOfDeltas += (max - this.mean) * (max - mean);
            this.mean = mean;
            if (max < this.min) {
                this.min = max;
            }
            if (max > this.max) {
                this.max = max;
            }
        }
    }
    
    public void addAll(final Iterable iterable) {
        final Iterator<Number> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next().doubleValue());
        }
    }
    
    public void addAll(final Iterator iterator) {
        while (iterator.hasNext()) {
            this.add(iterator.next().doubleValue());
        }
    }
    
    public void addAll(final double... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(array[i]);
        }
    }
    
    public void addAll(final int... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(array[i]);
        }
    }
    
    public void addAll(final long... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(array[i]);
        }
    }
    
    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }
    
    public long count() {
        return this.count;
    }
    
    public double mean() {
        Preconditions.checkState(this.count != 0L);
        return this.mean;
    }
    
    public final double sum() {
        return this.mean * this.count;
    }
    
    public final double populationVariance() {
        Preconditions.checkState(this.count != 0L);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
    }
    
    public final double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }
    
    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1L);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1L);
    }
    
    public final double sampleStandardDeviation() {
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
    
    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }
}
