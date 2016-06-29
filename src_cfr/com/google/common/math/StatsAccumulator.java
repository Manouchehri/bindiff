/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GoogleInternal
public final class StatsAccumulator {
    private long count = 0;
    private double mean = 0.0;
    private double sumOfSquaresOfDeltas = 0.0;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public void add(double d2) {
        Preconditions.checkArgument(Doubles.isFinite(d2));
        ++this.count;
        if (this.count == 1) {
            this.mean = d2;
            this.min = d2;
            this.max = d2;
            return;
        }
        double d3 = this.mean + (d2 - this.mean) / (double)this.count;
        this.sumOfSquaresOfDeltas += (d2 - this.mean) * (d2 - d3);
        this.mean = d3;
        if (d2 < this.min) {
            this.min = d2;
        }
        if (d2 <= this.max) return;
        this.max = d2;
    }

    public void addAll(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Number number = (Number)iterator.next();
            this.add(number.doubleValue());
        }
    }

    public void addAll(Iterator iterator) {
        while (iterator.hasNext()) {
            this.add(((Number)iterator.next()).doubleValue());
        }
    }

    public /* varargs */ void addAll(double ... arrd) {
        double[] arrd2 = arrd;
        int n2 = arrd2.length;
        int n3 = 0;
        while (n3 < n2) {
            double d2 = arrd2[n3];
            this.add(d2);
            ++n3;
        }
    }

    public /* varargs */ void addAll(int ... arrn) {
        int[] arrn2 = arrn;
        int n2 = arrn2.length;
        int n3 = 0;
        while (n3 < n2) {
            int n4 = arrn2[n3];
            this.add(n4);
            ++n3;
        }
    }

    public /* varargs */ void addAll(long ... arrl) {
        long[] arrl2 = arrl;
        int n2 = arrl2.length;
        int n3 = 0;
        while (n3 < n2) {
            long l2 = arrl2[n3];
            this.add(l2);
            ++n3;
        }
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public long count() {
        return this.count;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public final double sum() {
        return this.mean * (double)this.count;
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)this.count;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(this.populationVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)(this.count - 1);
    }

    public final double sampleStandardDeviation() {
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

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }
}

